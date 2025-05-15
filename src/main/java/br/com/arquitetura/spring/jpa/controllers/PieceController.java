package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.PieceRecordDto;
import br.com.arquitetura.spring.jpa.dtos.PieceResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.models.PieceModel;
import br.com.arquitetura.spring.jpa.services.PieceService;
import br.com.arquitetura.spring.jpa.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class PieceController {
    private static final String ERROR_PIECE_ID_NOTFOUND = "error.piece.id.notfound";

    private final PieceService pieceService;
    private final ProductService productService;
    private final MessageSource messageSource;

    public PieceController(
            PieceService pieceService,
            ProductService productService,
            MessageSource messageSource
    ) {
        this.pieceService = pieceService;
        this.productService = productService;
        this.messageSource = messageSource;
    }

    @GetMapping("/pieces")
    public ResponseEntity<List<PieceResponseDto>> getAllPiecesIdProduct(@RequestParam(required = false) String idProduct, Locale locale) {
        if (idProduct == null) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,"error.product.id.mandatory",
                    new Object[]{idProduct},
                    locale
            );
        } else {
            Optional<ProductModel> productOptional = productService.getOneProduct(Long.valueOf(idProduct));
            if (productOptional.isEmpty()) {
                throw ResourceNotFoundException.withMessage(
                        messageSource,ERROR_PIECE_ID_NOTFOUND,
                        new Object[]{idProduct},
                        locale
                );
            } else {
                List<PieceModel> piecesList = pieceService.findByProductModelIdProduct(Long.valueOf(idProduct));
                List<PieceResponseDto> responseList = piecesList.stream()
                        .map(this::mapToPieceResponseDto)
                        .toList();

                return ResponseEntity.status(HttpStatus.OK).body(responseList);
            }
        }
    }

    @GetMapping("/pieces/{id}")
    public ResponseEntity<PieceResponseDto> getOnePiece(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<PieceModel> pieceOption = pieceService.getOnePiece(id);
        if (pieceOption.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,ERROR_PIECE_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToPieceResponseDto(pieceOption.get()));
    }

    @PostMapping("/pieces")
    public ResponseEntity<PieceResponseDto> savePiece(@RequestBody @Valid PieceRecordDto pieceRecordDto, Locale locale) {
        var pieceModel = new PieceModel();
        BeanUtils.copyProperties(pieceRecordDto, pieceModel);
        var id = pieceRecordDto.idProduct();

        Optional<ProductModel> productOptional = productService.getOneProduct(id);
        if (productOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,"error.product.id.notfound",
                    new Object[]{id},
                    locale
            );
        } else {
            pieceModel.setProductModel(productOptional.get());
            PieceModel savedPiece = pieceService.savePiece(pieceModel);

            return ResponseEntity.status(HttpStatus.CREATED).body(mapToPieceResponseDto(savedPiece));
        }
    }

    @PutMapping("/pieces/{id}")
    public ResponseEntity<PieceResponseDto> updatePiece(@PathVariable(value = "id") Long id,
                                              @RequestBody @Valid PieceRecordDto pieceRecordDto, Locale locale) {
        Optional<PieceModel> piece = pieceService.getOnePiece(id);
        if (piece.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,ERROR_PIECE_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var idProduct = pieceRecordDto.idProduct();
        Optional<ProductModel> productOptional = productService.getOneProduct(idProduct);
        if (productOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,"error.product.id.notfound",
                    new Object[]{id},
                    locale
            );
        } else {
            var pieceModel = piece.get();
            pieceModel.setProductModel(productOptional.get());
            BeanUtils.copyProperties(pieceRecordDto, pieceModel);
            PieceModel updatePiece = pieceService.updatePiece(pieceModel);

            return ResponseEntity.status(HttpStatus.OK).body(mapToPieceResponseDto(updatePiece));
        }
    }

    @DeleteMapping("/pieces/{id}")
    public ResponseEntity<Object> deletePiece(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<PieceModel> piece = pieceService.getOnePiece(id);
        if (piece.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,ERROR_PIECE_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        pieceService.deletePiece(piece.get());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Piece deleted successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/pieces/page")
    public Page<PieceResponseDto> getAllPagePieces(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) Long idProduct,
            @RequestParam(required = false) String name, Locale locale) {

        if (idProduct == null) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,"error.product.id.mandatory",
                    new Object[]{idProduct},
                    locale
            );
        } else {
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
            Specification<PieceModel> spec = Specification.where(idProductEquals(idProduct)).and(nameContains(name));
            Page<PieceModel> piecesPage = pieceService.getAllPagePieces(spec, pageable);

            return piecesPage.map(this::mapToPieceResponseDto);
        }
    }

    Specification<PieceModel> idProductEquals(Long idProduct) {
        return (root, query, criteriaBuilder) -> {
            if (idProduct == null) return null;
            return criteriaBuilder.equal(root.get("productModel").get("idProduct"), idProduct);
        };
    }

    Specification<PieceModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    private PieceResponseDto mapToPieceResponseDto(PieceModel pieceModel) {
        return new PieceResponseDto(
                pieceModel.getIdPiece(),
                pieceModel.getName(),
                pieceModel.getProductModel().getIdProduct(),
                pieceModel.getProductModel().getName(),
                pieceModel.getDateRegistered(),
                pieceModel.getUserRegistered(),
                pieceModel.getDateChanged(),
                pieceModel.getUserChanged()
        );
    }
}
