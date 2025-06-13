package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceFoundException;
import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.repositories.CardRepository;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final MessageSource messageSource;

    public CardServiceImpl(CardRepository cardRepository, MessageSource messageSource) {
        this.cardRepository = cardRepository;
        this.messageSource = messageSource;
    }

    @Override
    public CardModel saveCard(CardModel card, Locale locale) {
        Optional<CardModel> cardOptional = cardRepository.findCardModelByCollectionAndNumberCard(card.getCollection(), card.getNumberCard());

        if (cardOptional.isPresent()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.card.save.exists",
                    new Object[] {card.getCollection(), card.getNumberCard()},
                    locale
                    );
        }
        return cardRepository.save(card);
    }

    @Override
    public CardModel updateCard(CardModel card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long idCard) {
        cardRepository.deleteById(idCard);
    }

    @Override
    public Page<CardModel> getAllPageCards(Specification<CardModel> spec, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<CardModel> getOneCard(Long id) {
        return cardRepository.findById(id);
    }


    @Override
    public List<CardModel> findByPokemonModelIdPokemon(Long idPokemon) {
        return cardRepository.findByPokemonModel_IdPokemon(idPokemon);
    }

    @Override
    public List<CardModel> getAllCards() {
        return cardRepository.findAll();
    }



}
