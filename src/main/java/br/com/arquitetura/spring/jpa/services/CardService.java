package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.CardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface CardService {
    List<CardModel> findByPokemonModelIdPokemon(Long idPokemon);

    List<CardModel> findByCollectionModelIdCollection(Long idCollection);

    List<CardModel> getAllCards();

    Optional<CardModel> getOneCard(Long id);

    CardModel saveCard(CardModel card, Locale locale);

    CardModel updateCard(CardModel card);

    void deleteCard(Long idCard);

    Page<CardModel> getAllPageCards(Specification<CardModel> spec, Pageable pageable);


}
