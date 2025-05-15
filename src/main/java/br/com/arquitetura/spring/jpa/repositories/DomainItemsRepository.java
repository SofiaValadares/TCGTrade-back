package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomainItemsRepository extends JpaRepository<DomainItemsModel, Long> {


    Page<DomainItemsModel> findAll(Specification<DomainItemsModel> spec, Pageable pageable);

    List<DomainItemsModel> findByDomainModelIdDomain(Long idDomain);
}
