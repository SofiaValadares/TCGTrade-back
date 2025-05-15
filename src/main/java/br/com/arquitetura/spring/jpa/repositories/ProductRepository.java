package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    Page<ProductModel> findAll(Specification<ProductModel> spec, Pageable pageable);
}
