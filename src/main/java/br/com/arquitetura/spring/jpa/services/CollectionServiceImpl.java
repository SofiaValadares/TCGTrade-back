package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceFoundException;
import br.com.arquitetura.spring.jpa.models.CollectionModel;
import br.com.arquitetura.spring.jpa.repositories.CollectionRepository;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository collectionRepository;
    private final MessageSource messageSource;

    public CollectionServiceImpl(CollectionRepository collectionRepository, MessageSource messageSource) {
        this.collectionRepository = collectionRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<CollectionModel> getAllCollections() {
        return collectionRepository.findAll();
    }

    @Override
    public CollectionModel getOneCollection(Long id, Locale locale) {
        Optional<CollectionModel> collection = collectionRepository.findById(id);

        if (collection.isEmpty()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.collection.id.notfound",
                    new Object[] {id},
                    locale
            );
        }

        return collection.get();
    }

    @Override
    public CollectionModel saveCollection(CollectionModel collectionModel, Locale locale) {
        if (collectionRepository.existsByCodeAndLanguage(collectionModel.getCode(), collectionModel.getLanguage())) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.collection.codeandlanguage.exists",
                    new Object[]{collectionModel.getCode(), collectionModel.getLanguage()},
                    locale
            );
        }
        return collectionRepository.save(collectionModel);
    }

    @Override
    public CollectionModel updateCollection(CollectionModel collectionModel) {
        return collectionRepository.save(collectionModel);
    }

    @Override
    public void deleteCollection(CollectionModel collectionModel) {
       collectionRepository.delete(collectionModel);
    }

    @Override
    public Page<CollectionModel> getAllPageCollections(Specification<CollectionModel> spec, Pageable pageable) {
        return collectionRepository.findAll(spec, pageable);
    }
}
