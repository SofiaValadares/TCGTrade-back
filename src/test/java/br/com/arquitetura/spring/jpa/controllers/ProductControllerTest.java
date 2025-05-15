package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.ProductRecordDto;
import br.com.arquitetura.spring.jpa.dtos.ProductResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.services.ProductService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.math.BigDecimal;
import java.util.*;

public class ProductControllerTest {
    @Mock
    private ProductService productService;

    @Mock
    private Root<ProductModel> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private ProductController productController;

    private Validator validator;
    private Locale locale;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        locale = Locale.getDefault();
    }

    @Test
    public void testGetAllProducts_Success() {
        // Arrange
        ProductModel product1 = new ProductModel();
        ProductModel product2 = new ProductModel();
        product1.setIdProduct(1L);
        product1.setName("Product 1");
        product1.setValue(BigDecimal.valueOf(100.0));

        product2.setIdProduct(2L);
        product2.setName("Product 2");
        product2.setValue(BigDecimal.valueOf(200.0));

        when(productService.getAllProducts()).thenReturn(Arrays.asList(product1, product2));

        // Act
        ResponseEntity<List<ProductResponseDto>> response = productController.getAllProducts();

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals("Product 1", response.getBody().get(0).name());
    }

    @Test
    public void testGetOneProduct_Found() {
        // Arrange
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        product.setName("Product 1");
        product.setValue(BigDecimal.valueOf(100.0));

        when(productService.getOneProduct(1L)).thenReturn(Optional.of(product));

        // Act
        ResponseEntity<ProductResponseDto> response = productController.getOneProduct(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Product 1", Objects.requireNonNull(response.getBody()).name());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetOneProduct_NotFound() {
        // Arrange
        when(productService.getOneProduct(1L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.product.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Produto não encontrado.");

        // Act
        productController.getOneProduct(1L, locale);
    }

    @Test
    public void testSaveProduct_Success() {
        // Arrange
        ProductRecordDto productDto = new ProductRecordDto("Product 1", BigDecimal.valueOf(100.0));

        ProductModel savedProduct = new ProductModel();
        savedProduct.setIdProduct(1L);
        savedProduct.setName("Product 1");
        savedProduct.setValue(BigDecimal.valueOf(100.0));

        when(productService.saveProductCalcTax(any(ProductModel.class))).thenReturn(savedProduct);

        // Act
        ResponseEntity<ProductResponseDto> response = productController.saveProduct(productDto);

        // Assert
        assertEquals(201, response.getStatusCode().value());
        assertEquals("Product 1", Objects.requireNonNull(response.getBody()).name());
    }

    @Test
    public void testUpdateProduct_Success() {
        // Arrange
        Long productId = 1L;
        ProductRecordDto productDto = new ProductRecordDto("Updated Product", BigDecimal.valueOf(150.0));
        ProductModel existingProduct = new ProductModel();
        existingProduct.setIdProduct(productId);
        existingProduct.setName("Old Product");
        existingProduct.setValue(BigDecimal.valueOf(100.0));

        when(productService.getOneProduct(productId)).thenReturn(Optional.of(existingProduct));
        when(productService.updateProductCalcTax(any(ProductModel.class))).thenReturn(existingProduct);

        // Act
        ResponseEntity<ProductResponseDto> response = productController.updateProduct(productId,locale, productDto);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Updated Product", Objects.requireNonNull(response.getBody()).name());
        assertEquals(BigDecimal.valueOf(150.0), response.getBody().value());
        assertEquals(BigDecimal.valueOf(0), response.getBody().tax());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateProduct_NotFound() {
        // Arrange
        Long nonExistentProductId = 1L;
        ProductRecordDto productDto = new ProductRecordDto("New Product", BigDecimal.valueOf(150.0));
        when(messageSource.getMessage(eq("error.product.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Produto não encontrado.");

        when(productService.getOneProduct(nonExistentProductId)).thenReturn(Optional.empty());

        // Act
        productController.updateProduct(nonExistentProductId, locale, productDto);
    }

    @Test
    public void testUpdateProduct_NotFound_Response() {
        // Arrange
        Long nonExistentProductId = 1L;
        ProductRecordDto productDto = new ProductRecordDto("New Product", BigDecimal.valueOf(150.0));
        when(productService.getOneProduct(nonExistentProductId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.product.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Product not found with id 1");

        try {
            // Act
            productController.updateProduct(nonExistentProductId, locale, productDto);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Product not found with id " + nonExistentProductId, ex.getMessage());
        }
    }

    @Test
    public void testDeleteProduct_Success() {
        // Arrange
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        when(productService.getOneProduct(1L)).thenReturn(Optional.of(product));
        doNothing().when(productService).deleteProduct(product);

        // Act
        ResponseEntity<Object> response = productController.deleteProduct(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteProduct_NotFound() {
        // Arrange
        Long nonExistentProductId = 1L;
        when(productService.getOneProduct(nonExistentProductId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.product.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Produto não encontrado.");

        // Act
        productController.deleteProduct(nonExistentProductId, locale);
    }

    @Test
    public void testDeleteProduct_NotFound_Response() {
        // Arrange
        Long nonExistentProductId = 1L;
        when(productService.getOneProduct(nonExistentProductId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.product.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Product not found with id 1");

        try {
            // Act
            productController.deleteProduct(nonExistentProductId, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Product not found with id " + nonExistentProductId, ex.getMessage());
        }
    }

    @Test
    public void testGetAllPageProducts_Success() {
        // Arrange
        int page = 0;
        int size = 10;
        String sort = "id";
        String order = "asc";
        String name = "TestProduct";
        double value = 100.0;
        double tax = 10.0;

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        product.setName(name);
        product.setValue(BigDecimal.valueOf(value));
        product.setTax(BigDecimal.valueOf(tax));

        Page<ProductModel> productPage = new PageImpl<>(Collections.singletonList(product));

        when(productService.getAllPageProducts(any(Specification.class), eq(pageable))).thenReturn(productPage);

        // Act
        Page<ProductResponseDto> responsePage = productController.getAllPageProducts(page, size, sort, order, name, value, tax);

        // Assert
        assertEquals(1, responsePage.getTotalElements());
        assertEquals(name, responsePage.getContent().get(0).name());
        assertEquals(BigDecimal.valueOf(value), responsePage.getContent().get(0).value());
        assertEquals(BigDecimal.valueOf(tax), responsePage.getContent().get(0).tax());

        verify(productService, times(1)).getAllPageProducts(any(Specification.class), any(Pageable.class));
    }

    @Test
    public void testNameContains_Success() {
        // Arrange
        String name = "TestProduct";
        when(criteriaBuilder.like(root.get("name"), "%" + name + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<ProductModel> spec = productController.nameContains(name);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testNameContains_NullOrEmpty() {
        // Act
        Specification<ProductModel> specNull = productController.nameContains(null);
        Specification<ProductModel> specEmpty = productController.nameContains("");

        // Assert
        assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testValueEquals_Success() {
        // Arrange
        Double value = 100.0;
        when(criteriaBuilder.equal(root.get("value"), value)).thenReturn(mock(Predicate.class));

        // Act
        Specification<ProductModel> spec = productController.valueEquals(value);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testValueEquals_Null() {
        // Act
        Specification<ProductModel> spec = productController.valueEquals(null);

        // Assert
        assertNull(spec.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testTaxEquals_Success() {
        // Arrange
        Double tax = 10.0;
        when(criteriaBuilder.equal(root.get("tax"), tax)).thenReturn(mock(Predicate.class));

        // Act
        Specification<ProductModel> spec = productController.taxEquals(tax);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testTaxEquals_Null() {
        // Act
        Specification<ProductModel> spec = productController.taxEquals(null);

        // Assert
        assertNull(spec.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void ProductRecordDto_Validation() {
        // Arrange
        ProductRecordDto invalidProductDto = new ProductRecordDto("", null);

        // Act
        Set<ConstraintViolation<ProductRecordDto>> violations = validator.validate(invalidProductDto);

        // Assert
        assertEquals(2, violations.size());
        violations.forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            if (propertyPath.equals("name")) {
                assertEquals("Product name cannot be blank.", message);
            } else if (propertyPath.equals("value")) {
                assertEquals("Product value cannot be null.", message);
            }
        });
    }
}
