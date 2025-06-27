package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.*;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.services.GenerationService;
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
    private final GenerationService generationService;

    public PokemonController(PokemonService pokemonService, GenerationService generationService) {
        this.pokemonService = pokemonService;
        this.generationService = generationService;
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
            @RequestParam(defaultValue = "number") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer generation
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<PokemonModel> spec = Specification.where(nameContains(name)).and(numberLike(number).and(generationEquals(generation)));
        Page<PokemonModel> pokemonModels = pokemonService.getAllPagePokemons(spec, pageable);

        return ResponseEntity.ok(pokemonModels.map(this::mapToPokemonResponseDto));
    }

    @PostMapping("/pokemon")
    public ResponseEntity<PokemonResponseDto> savePokemon(@RequestBody @Valid PokemonRecordDto pokemonRecordDto, Locale locale) {
        var pokemonModel = new PokemonModel();
        BeanUtils.copyProperties(pokemonRecordDto, pokemonModel);

        GenerationModel generationModel = generationService.getOneGenerationByNumber(pokemonRecordDto.generation(), locale);

        pokemonModel.setGeneration(generationModel);
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

        GenerationModel generationModel = generationService.getOneGenerationByNumber(pokemonRecordDto.generation(), locale);

        pokemonModel.setGeneration(generationModel);
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

    @GetMapping("/pokemon/exists")
    public ResponseEntity<Map<String, Boolean>> existsPokemon(
            @RequestParam Integer number
    ) {
        boolean exists = pokemonService.existsByNumber(number);

        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);

        return ResponseEntity.ok(response);
    }


    Specification<PokemonModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    Specification<PokemonModel> numberLike(Integer number) {
        return (root, query, criteriaBuilder) -> {
            if (number == null) return null;

            return criteriaBuilder.like(
                    criteriaBuilder.concat(
                            criteriaBuilder.literal(""),
                            root.get("number").as(String.class)
                    ),
                    "%" + number + "%"
            );
        };
    }

    Specification<PokemonModel> generationEquals(Integer generation) {
        return (root, query, criteriaBuilder) -> {
            if (generation == null) return null;
            return criteriaBuilder.equal(root.get("generation").get("number"), generation);
        };
    }


    private PokemonResponseDto mapToPokemonResponseDto(PokemonModel pokemonModel) {
        return new PokemonResponseDto(
                pokemonModel.getIdPokemon(),
                pokemonModel.getName(),
                pokemonModel.getNumber(),
                pokemonModel.getGeneration().getNumber(),
                pokemonModel.getPrimaryType(),
                pokemonModel.getSecondaryType(),
                pokemonModel.getImageUrl(),
                pokemonModel.getDateRegistered(),
                pokemonModel.getUserRegistered(),
                pokemonModel.getDateChanged(),
                pokemonModel.getUserChanged()
        );
    }
}
