package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.controllers.ProductController;
import br.com.arquitetura.spring.jpa.dtos.ProductResponseDto;
import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Given
        ProductModel product1 = new ProductModel();
        product1.setIdProduct(1L);
        product1.setName("Product 1");

        ProductModel product2 = new ProductModel();
        product2.setIdProduct(2L);
        product2.setName("Product 2");

        List<ProductModel> productList = List.of(product1, product2);
        when(productRepository.findAll()).thenReturn(productList);

        // When
        List<ProductModel> result = productService.getAllProducts();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetOneProduct_Found() {
        // Given
        Long id = 1L;
        ProductModel product = new ProductModel();
        product.setIdProduct(id);
        product.setName("Test Product");

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        // When
        Optional<ProductModel> result = productService.getOneProduct(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Test Product", result.get().getName());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void testGetOneProduct_NotFound() {
        // Given
        Long id = 1L;

        when(productRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<ProductModel> result = productService.getOneProduct(id);

        // Then
        assertFalse(result.isPresent());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void testSaveProduct_CalcTax_WithTaxCalculation() {
        // Given
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        product.setName("New Product");
        product.setValue(BigDecimal.valueOf(100));  // Valor do produto

        // Simulando o repositório para salvar o produto
        when(productRepository.save(product)).thenReturn(product);

        // When
        ProductModel result = productService.saveProductCalcTax(product);

        // Then
        assertNotNull(result);
        assertEquals("New Product", result.getName());
        assertEquals(new BigDecimal("5.00"), result.getTax(), "A taxa de 5% deve ser calculada corretamente");
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testUpdateProduct_CalcTax_WithTaxCalculation() {
        // Given
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        product.setName("Updated Product");
        product.setValue(BigDecimal.valueOf(200));  // Valor do produto

        // Simulando o repositório para atualizar o produto
        when(productRepository.save(product)).thenReturn(product);

        // When
        ProductModel result = productService.updateProductCalcTax(product);

        // Then
        assertNotNull(result);
        assertEquals("Updated Product", result.getName());
        assertEquals(new BigDecimal("10.00"), result.getTax(), "A taxa de 5% deve ser calculada corretamente");
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testDeleteProduct() {
        // Given
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);

        doNothing().when(productRepository).delete(product);

        // When
        productService.deleteProduct(product);

        // Then
        verify(productRepository, times(1)).delete(product);
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

    @Test
    void testGetAllPageProducts() {
        ProductModel product1 = new ProductModel();
        product1.setIdProduct(1L);
        product1.setName("Produto 1");

        ProductModel product2 = new ProductModel();
        product2.setIdProduct(2L);
        product2.setName("Produto 2");

        Page<ProductModel> page = new PageImpl<>(Arrays.asList(product1, product2));

        Pageable pageable = PageRequest.of(0, 10);
        Specification<ProductModel> spec = mock(Specification.class);

        when(productRepository.findAll(spec, pageable)).thenReturn(page);

        Page<ProductModel> result = productService.getAllPageProducts(spec, pageable);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals("Produto 1", result.getContent().get(0).getName());
        assertEquals("Produto 2", result.getContent().get(1).getName());

        verify(productRepository, times(1)).findAll(spec, pageable);
    }

    @Test
    void testCalcTax() {
        // Given
        ProductModel product = new ProductModel();
        product.setIdProduct(1L);
        product.setName("Product 1");
        product.setValue(BigDecimal.valueOf(100));

        // When
        productService.saveProductCalcTax(product);
        BigDecimal tax = product.getTax();

        // Then
        assertNotNull(tax);
        assertEquals(new BigDecimal("5.00"), tax, "A taxa de 5% deve ser calculada corretamente");
    }
}
