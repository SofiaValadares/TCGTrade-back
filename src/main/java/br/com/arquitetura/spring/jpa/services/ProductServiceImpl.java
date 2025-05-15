package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private static final BigDecimal TAX_RATE_5_PERCENT = BigDecimal.valueOf(0.05);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> getOneProduct(Long id) {
        return productRepository.findById(id);
    }


    @Override
    public ProductModel saveProductCalcTax(ProductModel productModel) {
        return calculateTaxAndSave(productModel);
    }

    @Override
    public ProductModel updateProductCalcTax(ProductModel productModel) {
        return calculateTaxAndSave(productModel);
    }

    @Override
    public void deleteProduct(ProductModel productModel) {
        productRepository.delete(productModel);
    }

    @Override
    public Page<ProductModel> getAllPageProducts(Specification<ProductModel> spec, Pageable pageable) {
        return productRepository.findAll(spec, pageable);
    }

    private ProductModel calculateTaxAndSave(ProductModel productModel) {
        productModel.setTax(calcTax(productModel));
        return productRepository.save(productModel);
    }

    private BigDecimal calcTax(ProductModel productModel) {
        return productModel.getValue().multiply(new BigDecimal(String.valueOf(ProductServiceImpl.TAX_RATE_5_PERCENT)));
    }
}
