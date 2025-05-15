package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.ProductResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.services.ProductService;
import br.com.arquitetura.spring.jpa.dtos.ProductRecordDto;
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

import java.util.Locale;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private static final String ERROR_PRODUCT_ID_NOTFOUND = "error.product.id.notfound";

    private final ProductService productService;
    private final MessageSource messageSource;

    public ProductController (
            ProductService productService,
            MessageSource messageSource
    ){
        this.productService = productService;
        this.messageSource = messageSource;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> responseList = productService.getAllProducts().stream()
                .map(this::mapToProductResponseDto)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getOneProduct(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<ProductModel> productOptional = productService.getOneProduct(id);
        if (productOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,ERROR_PRODUCT_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToProductResponseDto(productOptional.get()));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        ProductModel saveProduct = productService.saveProductCalcTax(productModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToProductResponseDto(saveProduct));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable(value = "id") Long id, Locale locale,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> productOptional = productService.getOneProduct(id);
        if (productOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource,ERROR_PRODUCT_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var productModel = productOptional.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        ProductModel updateProduct = productService.updateProductCalcTax(productModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToProductResponseDto(updateProduct));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<ProductModel> productOptional = productService.getOneProduct(id);
        if (productOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_PRODUCT_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        productService.deleteProduct(productOptional.get());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/products/page")
    public Page<ProductResponseDto> getAllPageProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double value,
            @RequestParam(required = false) Double tax) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<ProductModel> spec = Specification.where(nameContains(name)).and(valueEquals(value)).and(taxEquals(tax));
        Page<ProductModel> productPage = productService.getAllPageProducts(spec, pageable);

        return productPage.map(this::mapToProductResponseDto);
    }

    Specification<ProductModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    Specification<ProductModel> valueEquals(Double value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) return null;
            return criteriaBuilder.equal(root.get("value"), value);
        };
    }

    Specification<ProductModel> taxEquals(Double tax) {
        return (root, query, criteriaBuilder) -> {
            if (tax == null) return null;
            return criteriaBuilder.equal(root.get("tax"), tax);
        };
    }

    private ProductResponseDto mapToProductResponseDto(ProductModel productModel) {
        return new ProductResponseDto(
                productModel.getIdProduct(),
                productModel.getName(),
                productModel.getValue(),
                productModel.getTax(),
                productModel.getDateRegistered(),
                productModel.getUserRegistered(),
                productModel.getDateChanged(),
                productModel.getUserChanged()
        );
    }
}
