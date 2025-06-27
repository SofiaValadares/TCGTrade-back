package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.models.CollectionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    Page<CardModel> findAll(Specification<CardModel> spec, Pageable pageable);
    List<CardModel> findByPokemonModel_IdPokemon(Long id);

    Optional<CardModel> findByCollectionAndNumber(CollectionModel collection, Integer number);

    List<CardModel> findByCollection_IdCollectionOrderByNumberAsc(Long idCollection);
}
