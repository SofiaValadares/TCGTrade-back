package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.CardListResponseDto;
import br.com.arquitetura.spring.jpa.dtos.PokemonListResponseDto;
import br.com.arquitetura.spring.jpa.dtos.PokemonRecordDto;
import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
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

import java.util.*;

@RestController
@RequestMapping("/api")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<PokemonResponseDto>> getAllPokemons() {
        List<PokemonModel> pokemons = pokemonService.getAllPokemons();
        List<PokemonResponseDto> pokemonsDto = pokemons.stream()
                .map(this::mapToPokemonResponseDto)
                .toList();

        return new ResponseEntity<>(pokemonsDto, HttpStatus.OK);
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDto> getOnePokemon(@PathVariable(value = "id") Long id, Locale locale) {
        PokemonModel pokemon = pokemonService.getOnePokemon(id, locale);

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
    public ResponseEntity<PokemonResponseDto> savePokemon(@RequestBody @Valid PokemonRecordDto pokemonRecordDto, Locale locale) {
        var pokemonModel = new PokemonModel();
        BeanUtils.copyProperties(pokemonRecordDto, pokemonModel);
        PokemonModel savePokemon = pokemonService.savePokemon(pokemonModel, locale);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToPokemonResponseDto(savePokemon));
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDto> updatePokemon(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid PokemonRecordDto pokemonRecordDto,
            Locale locale) {
        PokemonModel pokemonModel = pokemonService.getOnePokemon(id, locale);
        BeanUtils.copyProperties(pokemonRecordDto, pokemonModel);
        PokemonModel updatePokemon = pokemonService.updatePokemon(pokemonModel, locale);

        return ResponseEntity.status(HttpStatus.OK).body(mapToPokemonResponseDto(updatePokemon));
    }


    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<Object> deletePokemon(@PathVariable(value = "id") Long id, Locale locale) {
        pokemonService.deletePokemon(id, locale);

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

    private PokemonListResponseDto mapToPokemonListResponseDto(PokemonModel pokemonModel) {
        List<CardListResponseDto> cards = pokemonModel.getCardModels().stream()
                .map(item -> new CardListResponseDto(
                        item.getIdCard(),
                        item.getNameCard(),
                        item.getCollection(),
                        item.getNumberCard()
                ))
                .toList();

        return new PokemonListResponseDto(
                pokemonModel.getIdPokemon(),
                pokemonModel.getName(),
                pokemonModel.getNumPokemon(),
                pokemonModel.getPrimaryType(),
                pokemonModel.getSecondaryType(),
                cards
        );
    }
}
