package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.CardModel;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface CardService {
    CardModel saveCard(CardModel card, Locale locale);
    CardModel updateCard(CardModel card);
    void deleteCard(Long idCard);
    Optional<CardModel> findCardById(Long id);
    Optional<CardModel> findCardByNumberAndCollection(Integer number, Long collection);
    List<CardModel> getAllCards();
    List<CardModel> findCardsByName(String name);
    List<CardModel> findCardsByCollection(Long collection);


}
