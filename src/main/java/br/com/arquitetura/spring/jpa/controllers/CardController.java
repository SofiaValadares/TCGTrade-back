package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.CardRecordDto;
import br.com.arquitetura.spring.jpa.dtos.CardResponseDto;
import br.com.arquitetura.spring.jpa.dtos.CardSearchRecordCollectionNumberDto;
import br.com.arquitetura.spring.jpa.dtos.SearchRecordDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.services.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CardController {
    private static final String ERROR_DOMAIND_ID_NOTFOUND = "error.card.id.notfound";

    private final CardService cardService;
    private final MessageSource messageSource;

    public CardController(
            CardService cardService,
            MessageSource messageSource
    ) {
        this.cardService = cardService;
        this.messageSource = messageSource;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardResponseDto>> getAllCards() {
        List<CardModel> cardsList = cardService.getAllCards();
        List<CardResponseDto> responseList = cardsList.stream()
                .map(this::mapToCardResponseDto)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<CardResponseDto> getOneCard(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<CardModel> cardOptional = cardService.findCardById(id);
        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDto(cardOptional.get()));
    }

    @GetMapping("/cards/name")
    public ResponseEntity<List<CardResponseDto>> getCardsByName(@Valid SearchRecordDto searchRecordDto, Locale locale) {
        List<CardModel> cardsList = cardService.findCardsByName(searchRecordDto.search());

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDtoList(cardsList));
    }

    @GetMapping("/cards/collections/{collection}")
    public ResponseEntity<List<CardResponseDto>> getCardsByCollection(@PathVariable(value = "collection") Long collectionId, Locale locale) {
        List<CardModel> cardsList = cardService.findCardsByCollection(collectionId);

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDtoList(cardsList));
    }

    @GetMapping("/cards/collections/{collection}/{number}")
    public ResponseEntity<CardResponseDto> getCardByNumberAndCollection(@ModelAttribute @Valid CardSearchRecordCollectionNumberDto cardSearch, Locale locale) {
        Optional<CardModel> cardOptional = cardService.findCardByNumberAndCollection(cardSearch.number(), cardSearch.collection());

        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{cardSearch.number(), cardSearch.collection()},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDto(cardOptional.get()));
    }

    @PostMapping("/cards")
    public ResponseEntity<CardResponseDto> saveCard(@RequestBody @Valid CardRecordDto cardRecordDto, Locale locale) {
        var cardModel = new CardModel();
        BeanUtils.copyProperties(cardRecordDto, cardModel);
        CardModel saveCard = cardService.saveCard(cardModel, locale);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToCardResponseDto(saveCard));
    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<CardResponseDto> updateCard(@PathVariable(value = "id") Long id,
                                                          @RequestBody @Valid CardRecordDto cardRecordDto, Locale locale) {
        Optional<CardModel> cardOptional = cardService.findCardById(id);
        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var cardModel = cardOptional.get();
        BeanUtils.copyProperties(cardRecordDto, cardModel);
        CardModel updateCard = cardService.updateCard(cardModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToCardResponseDto(updateCard));
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<CardModel> cardOptional = cardService.findCardById(id);
        if (cardOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        cardService.deleteCard(cardOptional.get().getIdCard());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Card deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private CardResponseDto mapToCardResponseDto(CardModel cardModel) {
        return new CardResponseDto(
                cardModel.getIdCard(),
                cardModel.getNameCard(),
                cardModel.getCollection(),
                cardModel.getNumberCard()
        );
    }

    private List<CardResponseDto> mapToCardResponseDtoList(List<CardModel> cardModelList) {
        return cardModelList.stream()
                .map(this::mapToCardResponseDto)
                .toList();
    }
}
