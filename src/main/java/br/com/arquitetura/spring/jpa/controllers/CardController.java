package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.CardRecordDto;
import br.com.arquitetura.spring.jpa.dtos.CardResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.services.CardService;
import br.com.arquitetura.spring.jpa.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CardController {
    private static final String ERROR_CARD_ID_NOTFOUND = "error.card.id.notfound";

    private final CardService cardService;
    private final PokemonService pokemonService;
    private final MessageSource messageSource;

    public CardController(
            CardService cardService,
            PokemonService pokemonService,
            MessageSource messageSource
    ) {
        this.cardService = cardService;
        this.pokemonService = pokemonService;
        this.messageSource = messageSource;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardResponseDto>> getAllCards(@RequestParam(required = false) Long idPokemon, Locale locale) {
        if (idPokemon == null) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.pokemon.id.mandatory",
                    new Object[]{idPokemon},
                    locale
            );
        } else {
            PokemonModel pokemonModel = pokemonService.getOnePokemon(idPokemon, locale);
            List<CardModel> cardList = cardService.findByPokemonModelIdPokemon(pokemonModel.getIdPokemon());
            List<CardResponseDto> responseList = cardList.stream()
                    .map(this::mapToCardResponseDto)
                    .toList();

            return ResponseEntity.status(HttpStatus.OK).body(responseList);

        }
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<CardResponseDto> getOneCard(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<CardModel> cardOptional = cardService.getOneCard(id);
        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_CARD_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDto(cardOptional.get()));
    }


    @PostMapping("/cards")
    public ResponseEntity<CardResponseDto> saveCard(@RequestBody @Valid CardRecordDto cardRecordDto, Locale locale) {
        var cardModel = new CardModel();
        var idPokemon = cardRecordDto.idPokemon();
        PokemonModel pokemonModel = pokemonService.getOnePokemon(idPokemon, locale);

        BeanUtils.copyProperties(cardRecordDto, cardModel);

        cardModel.setPokemonModel(pokemonModel);
        CardModel saveCard = cardService.saveCard(cardModel, locale);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToCardResponseDto(saveCard));

    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<CardResponseDto> updateCard(@PathVariable(value = "id") Long id,
                                                      @RequestBody @Valid CardRecordDto cardRecordDto, Locale locale) {
        Optional<CardModel> cardOptional = cardService.getOneCard(id);
        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_CARD_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        var idPokemon = cardRecordDto.idPokemon();
        PokemonModel pokemonModel = pokemonService.getOnePokemon(idPokemon, locale);

        var cardModel = cardOptional.get();
        BeanUtils.copyProperties(cardRecordDto, cardModel);
        CardModel updateCard = cardService.updateCard(cardModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDto(updateCard));
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<CardModel> cardOptional = cardService.getOneCard(id);
        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_CARD_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        cardService.deleteCard(cardOptional.get().getIdCard());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Card deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/cards/page")
    public Page<CardResponseDto> getAllPageCards(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) Long idPokemon,
            @RequestParam(required = false) Long idCard,
            @RequestParam(required = false) String nameCard,
            @RequestParam(required = false) Long collection,
            @RequestParam(required = false) Integer numberCard,
            Locale locale
    ) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<CardModel> spec = Specification.where(idPokemonEquals(idPokemon).and(idCardEquals(idCard)).and(nameContains(nameCard)).and(collectionEquals(collection)).and(numberEquals(numberCard)));
        Page<CardModel> cardPage = cardService.getAllPageCards(spec, pageable);

        return cardPage.map(this::mapToCardResponseDto);

    }

    Specification<CardModel> idPokemonEquals(Long idPokemon) {
        return (root, query, criteriaBuilder) -> {
            if (idPokemon == null) return null;
            return criteriaBuilder.equal(root.get("pokemonModel").get("idPokemon"), idPokemon);
        };
    }

    Specification<CardModel> idCardEquals(Long idCard) {
        return (root, query, criteriaBuilder) -> {
            if (idCard == null) return null;
            return criteriaBuilder.equal(root.get("idCard"), idCard);
        };
    }

    Specification<CardModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("nameCard"), "%" + name + "%");
        };
    }

    Specification<CardModel> collectionEquals(Long collection) {
        return (root, query, criteriaBuilder) -> {
            if (collection == null) return null;
            return criteriaBuilder.equal(root.get("collection"), collection);
        };
    }

    Specification<CardModel> numberEquals(Integer numberCard) {
        return (root, query, criteriaBuilder) -> {
            if (numberCard == null) return null;
            return criteriaBuilder.equal(root.get("numberCard"), numberCard);
        };
    }

    private CardResponseDto mapToCardResponseDto(CardModel cardModel) {
        return new CardResponseDto(
                cardModel.getIdCard(),
                cardModel.getPokemonModel().getIdPokemon(),
                cardModel.getNameCard(),
                cardModel.getCollection(),
                cardModel.getNumberCard(),
                cardModel.getDateRegistered(),
                cardModel.getUserRegistered(),
                cardModel.getDateChanged(),
                cardModel.getUserChanged()
        );
    }

}
