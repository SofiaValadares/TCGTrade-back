package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.CollectionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface CollectionService {
    List<CollectionModel> getAllCollections();

    CollectionModel getOneCollection(Long id, Locale locale);

    CollectionModel saveCollection(CollectionModel collectionModel, Locale locale);

    CollectionModel updateCollection(CollectionModel collectionModel);

    void deleteCollection(CollectionModel collectionModel);

    Page<CollectionModel> getAllPageCollections(Specification<CollectionModel> spec, Pageable pageable);
}
