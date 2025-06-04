package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.proxies.services.PokeApiProxyService;
import br.com.arquitetura.spring.jpa.repositories.PokemonRepository;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;
    private final PokeApiProxyService pokeApiProxyService;
    private final MessageSource messageSource;


    public PokemonServiceImpl(PokemonRepository pokemonRepository, PokeApiProxyService pokeApiProxyService, MessageSource messageSource) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiProxyService = pokeApiProxyService;
        this.messageSource = messageSource;
    }

    @Override
    public PokemonModel savePokemon(PokemonModel pokemonModel) {
        return pokemonRepository.save(pokemonModel);
    }

    @Override
    public PokemonModel updatePokemon(PokemonModel pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Page<PokemonModel> searchPokemon(String search, Pageable pageable, Locale locale) {
        List<PokemonModel> pokemons = new ArrayList<>();

        pokemons.addAll(pokemonRepository.findPokemonModelByNameContainingIgnoreCase(search));

        try {
            Integer numPokemon = Integer.parseInt(search);
            pokemons.addAll(pokemonRepository.findByNumPokemon(numPokemon));
        } catch (NumberFormatException e) {}


        Set<PokemonModel> uniqueSet = new LinkedHashSet<>(pokemons);
        List<PokemonModel> finalList = new ArrayList<>(uniqueSet);

        if (!finalList.isEmpty()) {
            return new PageImpl<>(finalList, pageable, finalList.size());
        }

        PokemonModel newPokemon = pokeApiUse(search, locale);

        if (newPokemon != null) {
            return new PageImpl<>(List.of(newPokemon), pageable, 1);
        }

        return Page.empty(pageable);
    }


    @Override
    public void deletePokemon(Long idPokemon) { pokemonRepository.deleteById(idPokemon); }


    @Override
    public Optional<PokemonModel> getOnePokemon(Long id) {
        return pokemonRepository.findById(id);
    }

    @Override
    public List<PokemonModel> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Page<PokemonModel> getAllPagePokemons(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    private PokemonModel pokeApiUse(String search, Locale locale) {
        try {
            PokemonResponseDto dto = pokeApiProxyService.getPokemon(search)
                    .onErrorResume(WebClientResponseException.NotFound.class, ex ->
                            Mono.error(ResourceNotFoundException.withMessage(
                                    messageSource,
                                    "error.pokemon.search.notfound",
                                    new Object[]{search},
                                    locale
                            ))
                    )
                    .block(); // uso controlado


            if (dto == null) {
                return null;
            }

            PokemonModel pokemon = new PokemonModel();
            pokemon.setName(dto.name());
            pokemon.setNumPokemon(dto.numPokemon());
            pokemon.setPrimaryType(dto.primaryType());
            pokemon.setSecondaryType(dto.secondaryType());

            return pokemonRepository.save(pokemon);
        } catch (ResourceNotFoundException e) {
            return null;
        }

    }
}
