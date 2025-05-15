package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface DomainService {

    List<DomainModel> getAllDomains();

    Optional<DomainModel> getOneDomain(Long id);

    DomainModel saveDomain(DomainModel domainModel);

    DomainModel updateDomain(DomainModel domainModel);

    void deleteDomain(DomainModel domainModel);

    Page<DomainModel> getAllPageDomains(Specification<DomainModel> spec, Pageable pageable);
}
