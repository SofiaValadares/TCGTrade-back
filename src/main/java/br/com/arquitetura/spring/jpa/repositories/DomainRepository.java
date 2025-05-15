package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.DomainModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DomainRepository extends JpaRepository<DomainModel, Long> {

    public Page<DomainModel> findAll(Specification<DomainModel> spec, Pageable pageable);

    Optional<DomainModel> findByName(String nomePesqusia);
}
