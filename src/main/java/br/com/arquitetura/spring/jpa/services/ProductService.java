package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> getAllProducts();

    Optional<ProductModel> getOneProduct(Long id);

    ProductModel saveProductCalcTax(ProductModel productModel);

    ProductModel updateProductCalcTax(ProductModel productModel);

    void deleteProduct(ProductModel productModel);

    Page<ProductModel> getAllPageProducts(Specification<ProductModel> spec, Pageable pageable);
}
