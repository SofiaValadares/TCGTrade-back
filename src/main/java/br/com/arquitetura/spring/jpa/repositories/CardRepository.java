package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    List<CardModel> findCardModelByNameCardContainsIgnoreCase(String name);
    List<CardModel> findCardModelByCollection(Long collection);
    Optional<CardModel> findCardModelByCollectionAndNumberCard(Long collection, Integer numberCard);
}
