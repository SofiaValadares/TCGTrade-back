package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.enums.CardLanguageEnum;
import br.com.arquitetura.spring.jpa.models.CollectionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollectionRepository extends JpaRepository<CollectionModel, Long> {
    Optional<CollectionModel> findById(Long id);
    Page<CollectionModel> findAll(Specification<CollectionModel> spec, Pageable pageable);
    boolean existsByCodeAndLanguage(String code, CardLanguageEnum language);

    Optional<CollectionModel> findByCodeAndLanguage(String code, CardLanguageEnum language);
}
