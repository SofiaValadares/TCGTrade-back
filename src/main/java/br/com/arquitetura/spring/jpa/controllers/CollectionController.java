package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.*;
import br.com.arquitetura.spring.jpa.models.CollectionModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.services.CollectionService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(
            CollectionService collectionService
    ) {
        this.collectionService = collectionService;
    }

    @GetMapping("/collections/list/{idCollection}")
    public ResponseEntity<CollectionListResponseDto> getAllCollectionsList(@PathVariable(value = "idCollection") Long idCollection, Locale locale) {
        CollectionModel collection = collectionService.getOneCollection(idCollection, locale);

        return ResponseEntity.status(HttpStatus.OK).body(mapToCollectionListResponseDto(collection));
    }

    @GetMapping("/collections")
    public ResponseEntity<List<CollectionResponseDto>> getAllCollections() {
        List<CollectionModel> collectionsList = collectionService.getAllCollections();
        List<CollectionResponseDto> responseList = collectionsList.stream()
                .map(this::mapToCollectionResponseDto)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/collections/{id}")
    public ResponseEntity<CollectionResponseDto> getOneCollection(@PathVariable(value = "id") Long id, Locale locale) {
        CollectionModel collection = collectionService.getOneCollection(id, locale);

        return ResponseEntity.status(HttpStatus.OK).body(mapToCollectionResponseDto(collection));
    }

    @PostMapping("/collections")
    public ResponseEntity<CollectionResponseDto> saveCollection(@RequestBody @Valid CollectionRecordDto collectionRecordDto, Locale locale) {
        var collectionModel = new CollectionModel();
        BeanUtils.copyProperties(collectionRecordDto, collectionModel);
        CollectionModel saveCollection = collectionService.saveCollection(collectionModel, locale);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToCollectionResponseDto(saveCollection));
    }

    @PutMapping("/collections/{id}")
    public ResponseEntity<CollectionResponseDto> updateCollection(@PathVariable(value = "id") Long id,
                                                          @RequestBody @Valid CollectionRecordDto collectionRecordDto, Locale locale) {
        CollectionModel collection = collectionService.getOneCollection(id, locale);

        BeanUtils.copyProperties(collectionRecordDto, collection);
        CollectionModel updateCollection = collectionService.updateCollection(collection);

        return ResponseEntity.status(HttpStatus.OK).body(mapToCollectionResponseDto(updateCollection));
    }

    @DeleteMapping("/collections/{id}")
    public ResponseEntity<Object> deleteCollection(@PathVariable(value = "id") Long id, Locale locale) {
        CollectionModel collection = collectionService.getOneCollection(id, locale);

        collectionService.deleteCollection(collection);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Collection deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/collections/page")
    public Page<CollectionResponseDto> getAllPageCollections(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "releaseDate") String sort,
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String series) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<CollectionModel> spec = Specification.where(nameContains(name).and(seriesContains(series)));
        Page<CollectionModel> collectionPage = collectionService.getAllPageCollections(spec, pageable);

        return collectionPage.map(this::mapToCollectionResponseDto);
    }

    Specification<CollectionModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    Specification<CollectionModel> seriesContains(String series) {
        return (root, query, criteriaBuilder) -> {
            if (series == null || series.isEmpty()) return null;
            return criteriaBuilder.like(root.get("series"), "%" + series + "%");
        };
    }

    private CollectionResponseDto mapToCollectionResponseDto(CollectionModel collectionModel) {
        return new CollectionResponseDto(
                collectionModel.getIdCollection(),
                collectionModel.getName(),
                collectionModel.getSeries(),
                collectionModel.getLanguage(),
                collectionModel.getCode(),
                collectionModel.getPtcgoCode(),
                collectionModel.getReleaseDate(),
                collectionModel.getTotalCards(),
                collectionModel.getSymbolUrl(),
                collectionModel.getLogoUrl(),
                collectionModel.getDefaultRotationLetter(),
                collectionModel.getDateRegistered(),
                collectionModel.getUserRegistered(),
                collectionModel.getDateChanged(),
                collectionModel.getUserChanged()
        );
    }

    private CollectionListResponseDto mapToCollectionListResponseDto(CollectionModel collectionModel) {

        List<CardListResponseDto> cards = collectionModel.getCards().stream()
                .map(item -> {
                    PokemonModel pokemonModel = item.getPokemonModel();
                    PokemonSummaryDto pokemonSummary = null;
                    if (pokemonModel != null) {
                        pokemonSummary = new PokemonSummaryDto(
                                pokemonModel.getIdPokemon(),
                                pokemonModel.getName(),
                                pokemonModel.getNumber()
                        );
                    }

                    CollectionModel coll = item.getCollection();
                    CollectionSummaryDto collectionSummary = null;
                    if (coll != null) {
                        collectionSummary = new CollectionSummaryDto(
                                coll.getIdCollection(),
                                coll.getName()
                        );
                    }

                    return new CardListResponseDto(
                            item.getIdCard(),
                            item.getName(),
                            collectionSummary,
                            item.getNumber(),
                            item.getType(),
                            item.getRotationLetter(),
                            item.getRarity(),
                            item.getVariants(),
                            item.getImageUrl(),
                            pokemonSummary
                    );
                })
                .toList();

        return new CollectionListResponseDto(
                collectionModel.getIdCollection(),
                collectionModel.getName(),
                collectionModel.getSeries(),
                collectionModel.getLanguage(),
                collectionModel.getCode(),
                collectionModel.getPtcgoCode(),
                collectionModel.getReleaseDate(),
                collectionModel.getTotalCards(),
                collectionModel.getSymbolUrl(),
                collectionModel.getLogoUrl(),
                collectionModel.getDefaultRotationLetter(),
                cards
        );
    }

}
