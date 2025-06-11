package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.PokemonRecordDto;
import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.dtos.SearchRecordDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
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

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PokemonController {
    private static final String ERROR_POKEMON_ID_NOTFOUND = "error.pokemon.id.notfound";
    private final PokemonService pokemonService;
    private final MessageSource messageSource;

    public PokemonController(PokemonService pokemonService, MessageSource messageSource) {
        this.pokemonService = pokemonService;
        this.messageSource = messageSource;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<PokemonResponseDto>> getAllPokemons() {
        List<PokemonModel> pokemons = pokemonService.getAllPokemons();
        return ResponseEntity.ok(mapToPokemonListResponseDto(pokemons));
    }

    @GetMapping ("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDto> getOnePokemon(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<PokemonModel> pokemonOptional = pokemonService.getOnePokemon(id);
        if (pokemonOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_POKEMON_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        PokemonModel pokemon = pokemonOptional.get();

        return ResponseEntity.ok(mapToPokemonResponseDto(pokemon));
    }

    @GetMapping("/pokemon/page")
    public ResponseEntity<Page<PokemonResponseDto>> getAllPokemonPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "numPokemon") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer number
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<PokemonModel> spec = Specification.where(nameContains(name)).and(numberEquals(number));
        Page<PokemonModel> pokemonModels = pokemonService.getAllPagePokemons(spec, pageable);

        return ResponseEntity.ok(pokemonModels.map(this::mapToPokemonResponseDto));
    }

    @PostMapping("/pokemon")
    public ResponseEntity<PokemonResponseDto> savePokemon(@RequestBody @Valid PokemonRecordDto pokemonRecordDto) {
        var pokemonModel = new PokemonModel();
        BeanUtils.copyProperties(pokemonRecordDto, pokemonModel);
        PokemonModel savePokemon = pokemonService.savePokemon(pokemonModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToPokemonResponseDto(savePokemon));
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDto> updatePokemon(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid PokemonRecordDto pokemonRecordDto,
            Locale locale) {
        Optional<PokemonModel> pokemonOptional = pokemonService.getOnePokemon(id);
        if (pokemonOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_POKEMON_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var pokemonModel = pokemonOptional.get();
        BeanUtils.copyProperties(pokemonRecordDto, pokemonModel);
        PokemonModel updatePokemon = pokemonService.updatePokemon(pokemonModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToPokemonResponseDto(updatePokemon));
    }

    @GetMapping("/pokemon/{search}")
    public ResponseEntity<Page<PokemonResponseDto>> searchPokemon(
            @PathVariable(value = "search") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "numPokemon") String sort,
            @RequestParam(defaultValue = "asc") String order,
            Locale locale) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Page<PokemonModel> pokemonModels = pokemonService.searchPokemon(search, pageable, locale);

        return ResponseEntity.ok(pokemonModels.map(this::mapToPokemonResponseDto));
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<Object> deletePokemon(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<PokemonModel> pokemonOptional = pokemonService.getOnePokemon(id);
        if (pokemonOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_POKEMON_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        pokemonService.deletePokemon(pokemonOptional.get().getIdPokemon());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Pokemon deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    Specification<PokemonModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    Specification<PokemonModel> numberEquals(Integer number) {
        return (root, query, criteriaBuilder) -> {
            if (number == null) return null;
            return criteriaBuilder.equal(root.get("numPokemon"), number);
        };
    }

    private PokemonResponseDto mapToPokemonResponseDto(PokemonModel pokemonModel) {
        return new PokemonResponseDto(
                pokemonModel.getIdPokemon(),
                pokemonModel.getName(),
                pokemonModel.getNumPokemon(),
                pokemonModel.getPrimaryType(),
                pokemonModel.getSecondaryType(),
                pokemonModel.getDateRegistered(),
                pokemonModel.getUserRegistered(),
                pokemonModel.getDateChanged(),
                pokemonModel.getUserChanged()
        );
    }

    private List<PokemonResponseDto> mapToPokemonListResponseDto(List<PokemonModel> pokemonModels) {
        return pokemonModels.stream()
                .map(this::mapToPokemonResponseDto)
                .collect(Collectors.toList());
    }
}
