package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import br.com.arquitetura.spring.jpa.repositories.DomainItemsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomainItemsServiceImpl implements DomainItemsService {

    private final DomainItemsRepository domainItemsRepository;

    public DomainItemsServiceImpl(DomainItemsRepository domainItemsRepository) {
        this.domainItemsRepository = domainItemsRepository;
    }

    @Override
    public List<DomainItemsModel> findByDomainModelIdDomain(Long idDomain) {
        return domainItemsRepository.findByDomainModelIdDomain(idDomain);
    }

    @Override
    public List<DomainItemsModel> getAllDomainItems() {
        return domainItemsRepository.findAll();
    }

    @Override
    public Optional<DomainItemsModel> getOneDomainItems(Long id) {
        return domainItemsRepository.findById(id);
    }

    @Override
    public DomainItemsModel saveDomainItems(DomainItemsModel domainItemsModel) {
        return domainItemsRepository.save(domainItemsModel);
    }

    @Override
    public DomainItemsModel updateDomainItems(DomainItemsModel domainItemsModel) {
        return domainItemsRepository.save(domainItemsModel);
    }

    @Override
    public void deleteDomainItems(DomainItemsModel domainItemsModel) {
        domainItemsRepository.delete(domainItemsModel);
    }

    @Override
    public Page<DomainItemsModel> getAllPageDomainItems(Specification<DomainItemsModel> spec, Pageable pageable) {
        return domainItemsRepository.findAll(spec, pageable);
    }
}
