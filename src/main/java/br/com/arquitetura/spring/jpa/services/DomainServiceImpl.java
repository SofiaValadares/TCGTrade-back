package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.repositories.DomainRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    public DomainServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @Override
    public List<DomainModel> getAllDomains() {
        return domainRepository.findAll();
    }

    @Override
    public Optional<DomainModel> getOneDomain(Long id) {
        return domainRepository.findById(id);
    }

    @Override
    public DomainModel saveDomain(DomainModel domainModel) {
        return domainRepository.save(domainModel);
    }

    @Override
    public DomainModel updateDomain(DomainModel domainModel) {
        return domainRepository.save(domainModel);
    }

    @Override
    public void deleteDomain(DomainModel domainModel) {
        domainRepository.delete(domainModel);
    }

    @Override
    public Page<DomainModel> getAllPageDomains(Specification<DomainModel> spec, Pageable pageable) {

        return domainRepository.findAll(spec, pageable);
    }
}
