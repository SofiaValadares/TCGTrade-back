package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.PieceRecordDto;
import br.com.arquitetura.spring.jpa.dtos.PieceResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.PieceModel;
import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.services.PieceService;
import br.com.arquitetura.spring.jpa.services.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Path;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PieceControllerTest {
    @Mock
    private PieceService pieceService;

    @Mock
    private ProductService productService;

    @Mock
    private Root<PieceModel> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private Path<Object> productModelPath;

    @Mock
    private Path<Object> idProductPath;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private PieceController pieceController;

    Validator validator;
    private Locale locale;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        locale = Locale.getDefault();
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllPiecesIdProduct_NoIdProduct() {
        when(messageSource.getMessage(eq("error.peice.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");

        // Act
        pieceController.getAllPiecesIdProduct(null, locale);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllPiecesIdProduct_ProductNotFound() {
        // Arrange
        String idProduct = "1";
        when(productService.getOneProduct(Long.valueOf(idProduct))).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.peice.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");

        // Act
        pieceController.getAllPiecesIdProduct(idProduct, locale);
    }

    @Test
    public void testGetAllPieces_Success() {
        // Arrange
        String idProduct = "1";
        ProductModel productModel  = new ProductModel();
        productModel.setIdProduct(1L);
        productModel.setName("Product 1");
        productModel.setValue(BigDecimal.valueOf(100.0));

        PieceModel piece1 = new PieceModel();
        PieceModel piece2 = new PieceModel();
        piece1.setIdPiece(1L);
        piece1.setName("Piece 1");
        piece1.setProductModel(productModel);

        piece2.setIdPiece(2L);
        piece2.setName("Piece 2");
        piece2.setProductModel(productModel);

        List<PieceModel> piecesList = Arrays.asList(piece1, piece2);

        when(productService.getOneProduct(Long.valueOf(idProduct))).thenReturn(Optional.of(productModel));
        when(pieceService.findByProductModelIdProduct(Long.valueOf(idProduct))).thenReturn(piecesList);

        // Act
        ResponseEntity<List<PieceResponseDto>> response = pieceController.getAllPiecesIdProduct(idProduct, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals("Piece 1", response.getBody().get(0).name());
        assertEquals("Piece 2", response.getBody().get(1).name());

        verify(productService, times(1)).getOneProduct(Long.valueOf(idProduct));
        verify(pieceService, times(1)).findByProductModelIdProduct(Long.valueOf(idProduct));
    }

    @Test
    public void testGetOnePiece_Found() {
        // Arrange
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        product.setName("Product 1");
        product.setValue(BigDecimal.valueOf(100.0));

        PieceModel piece = new PieceModel();
        piece.setIdPiece(1L);
        piece.setName("Piece 1");
        piece.setProductModel(product);

        when(pieceService.getOnePiece(1L)).thenReturn(Optional.of(piece));

        // Act
        ResponseEntity<PieceResponseDto> response = pieceController.getOnePiece(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Piece 1", Objects.requireNonNull(response.getBody()).name());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetOnePiece_NotFound() {
        // Arrange
        when(messageSource.getMessage(eq("error.piece.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");
        when(pieceService.getOnePiece(1L)).thenReturn(Optional.empty());

        // Act
        pieceController.getOnePiece(1L, locale);
    }

    @Test
    public void testSavePiece_Success() {
        // Arrange
        ProductModel productModel  = new ProductModel();
        productModel .setIdProduct(1L);
        productModel .setName("Product 1");
        productModel .setValue(BigDecimal.valueOf(100.0));

        PieceRecordDto pieceRecordDto  = new PieceRecordDto(1L,"Piece 1");

        PieceModel pieceModel  = new PieceModel();
        pieceModel .setIdPiece(1L);
        pieceModel .setName("Piece 1");
        pieceModel .setProductModel(productModel);

        BeanUtils.copyProperties(pieceRecordDto, pieceModel);

        when(productService.getOneProduct(1L)).thenReturn(Optional.of(productModel));
        when(pieceService.savePiece(any(PieceModel.class))).thenReturn(pieceModel);

        // Act
        ResponseEntity<PieceResponseDto> response = pieceController.savePiece(pieceRecordDto, locale);

        // Assert
        assertEquals(201, response.getStatusCode().value());
        verify(productService, times(1)).getOneProduct(1L);
        verify(pieceService, times(1)).savePiece(any(PieceModel.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSavePiece_ProductNotFound() {
        // Arrange
        PieceRecordDto pieceRecordDto = new PieceRecordDto(1L, "Piece Name");
        when(productService.getOneProduct(1L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.piece.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");

        // Act
        pieceController.savePiece(pieceRecordDto, locale);
    }

    @Test
    public void testUpdatePiece_Success() {
        // Arrange
        Long pieceId = 1L;
        Long productId = 1L;
        PieceRecordDto pieceRecordDto = new PieceRecordDto(productId, "Updated Piece Name");
        PieceModel pieceModel = new PieceModel();
        ProductModel productModel = new ProductModel();
        productModel.setIdProduct(productId);
        productModel.setName("Product Name");
        productModel.setValue(BigDecimal.valueOf(100.0));

        when(pieceService.getOnePiece(pieceId)).thenReturn(Optional.of(pieceModel));
        when(productService.getOneProduct(productId)).thenReturn(Optional.of(productModel));
        when(pieceService.updatePiece(any(PieceModel.class))).thenReturn(pieceModel);

        // Act
        ResponseEntity<PieceResponseDto> response = pieceController.updatePiece(pieceId, pieceRecordDto, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        verify(pieceService, times(1)).getOnePiece(pieceId);
        verify(productService, times(1)).getOneProduct(productId);
        verify(pieceService, times(1)).updatePiece(any(PieceModel.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdatePiece_ProductNotFound() {
        // Arrange
        Long pieceId = 1L;
        PieceRecordDto pieceRecordDto = new PieceRecordDto(2L, "Updated Piece");
        PieceModel pieceModel = new PieceModel();

        when(pieceService.getOnePiece(pieceId)).thenReturn(Optional.of(pieceModel));
        when(productService.getOneProduct(2L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.piece.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");

        // Act
        pieceController.updatePiece(pieceId, pieceRecordDto, locale);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdatePiece_NotFound() {
        // Arrange
        Long nonExistentPieceId = 1L;
        PieceRecordDto pieceDto = new PieceRecordDto(1L, "New Piece");

        when(pieceService.getOnePiece(nonExistentPieceId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.piece.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");

        // Act
        pieceController.updatePiece(nonExistentPieceId, pieceDto, locale);
    }

    @Test
    public void testUpdatePiece_NotFound_Response() {
        // Arrange
        Long nonExistentPieceId = 1L;
        PieceRecordDto pieceDto = new PieceRecordDto(1L, "New Piece");
        when(pieceService.getOnePiece(nonExistentPieceId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.piece.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Piece not found with id 1");

        try {
            // Act
            pieceController.updatePiece(nonExistentPieceId, pieceDto, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Piece not found with id " + nonExistentPieceId, ex.getMessage());
        }
    }

    @Test
    public void testDeletePiece_Success() {
        // Arrange
        PieceModel piece = new PieceModel();
        piece.setIdPiece(1L);
        when(pieceService.getOnePiece(1L)).thenReturn(Optional.of(piece));
        doNothing().when(pieceService).deletePiece(piece);

        // Act
        ResponseEntity<Object> response = pieceController.deletePiece(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeletePiece_NotFound() {
        // Arrange
        Long nonExistentPieceId = 1L;
        when(pieceService.getOnePiece(nonExistentPieceId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.piece.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");

        // Act
        pieceController.deletePiece(nonExistentPieceId, locale);
    }

    @Test
    public void testDeletePiece_NotFound_Response() {
        // Arrange
        Long nonExistentPieceId = 1L;
        when(messageSource.getMessage(eq("error.piece.id.notfound"), eq(new Object[]{nonExistentPieceId}), eq(locale)))
                .thenReturn("Peça não encontrada com o id " + nonExistentPieceId);

        when(pieceService.getOnePiece(nonExistentPieceId)).thenReturn(Optional.empty());

        try {
            // Act
            pieceController.deletePiece(nonExistentPieceId, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Peça não encontrada com o id 1", ex.getMessage());
        }
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllPagePieces_NoIdProduct() {
        // Arrange
        when(messageSource.getMessage(eq("error.piece.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Peça não encontrado.");
        // Act
        pieceController.getAllPagePieces(0, 10, "id", "asc", null, null, locale);
    }

    @Test
    public void testGetAllPagePieces_Success() {
        // Arrange
        int page = 0;
        int size = 10;
        String sort = "id";
        String order = "asc";
        Long idProduct = 1L;
        String name = "Piece Name";

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        ProductModel productModel = new ProductModel();
        productModel.setIdProduct(1L);
        productModel.setName("Product 1");
        productModel.setValue(BigDecimal.valueOf(100.0));

        PieceModel pieceModel = new PieceModel();
        pieceModel.setIdPiece(1L);
        pieceModel.setName("Piece 1");
        pieceModel.setProductModel(productModel);


        Page<PieceModel> piecesPage = new PageImpl<>(Collections.singletonList(pieceModel));

        when(pieceService.getAllPagePieces(any(Specification.class), eq(pageable))).thenReturn(piecesPage);

        // Act
        Page<PieceResponseDto> responsePage = pieceController.getAllPagePieces(page, size, sort, order, idProduct, name, locale);

        // Assert
        assertEquals(1, responsePage.getTotalElements());
        assertEquals("Piece 1", responsePage.getContent().get(0).name());
        verify(pieceService, times(1)).getAllPagePieces(any(Specification.class), eq(pageable));
    }

    @Test
    public void testNameContains_Success() {
        // Arrange
        String name = "TestPiece";
        when(criteriaBuilder.like(root.get("name"), "%" + name + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<PieceModel> spec = pieceController.nameContains(name);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testNameContains_NullOrEmpty() {
        // Act
        Specification<PieceModel> specNull = pieceController.nameContains(null);
        Specification<PieceModel> specEmpty = pieceController.nameContains("");

        // Assert
        assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testIdProductEquals() {
        // Arrange
        Long idProduct = 1L;

        when(root.get("productModel")).thenReturn(productModelPath);
        when(productModelPath.get("idProduct")).thenReturn(idProductPath);
        when(criteriaBuilder.equal(idProductPath, idProduct)).thenReturn(mock(Predicate.class));

        // Act
        Specification<PieceModel> spec = pieceController.idProductEquals(idProduct);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testIdProductEquals_Null() {
        // Act
        Specification<PieceModel> spec = pieceController.idProductEquals(null);

        // Assert
        assertNull(spec.toPredicate(root, query, criteriaBuilder));
    }
}
