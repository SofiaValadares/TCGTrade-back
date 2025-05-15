package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface DomainItemsService {

    List<DomainItemsModel> findByDomainModelIdDomain(Long idDomain);

    List<DomainItemsModel> getAllDomainItems();

    Optional<DomainItemsModel> getOneDomainItems(Long id);

    DomainItemsModel saveDomainItems(DomainItemsModel domainItemsModel);

    DomainItemsModel updateDomainItems(DomainItemsModel domainItemsModel);

    void deleteDomainItems(DomainItemsModel domainItemsModel);

    Page<DomainItemsModel> getAllPageDomainItems(Specification<DomainItemsModel> spec, Pageable pageable);
}
