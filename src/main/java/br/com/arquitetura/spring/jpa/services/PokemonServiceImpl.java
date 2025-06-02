package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.proxies.controllers.PokeApiProxyController;
import br.com.arquitetura.spring.jpa.proxies.services.PokeApiProxyService;
import br.com.arquitetura.spring.jpa.repositories.PokemonRepository;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<PokemonModel> searchPokemon(String search) {
        Integer numPokemon;
        List<PokemonModel> pokemons = new ArrayList<>();

        pokemons.addAll(pokemonRepository.findPokemonModelByNameContainingIgnoreCase(search));

        try {
            numPokemon = Integer.parseInt(search);
            pokemons.addAll(pokemonRepository.findByNumPokemon(numPokemon));
        } catch (NumberFormatException e) {}


        Set<PokemonModel> uniqueSet = new LinkedHashSet<>(pokemons);
        List<PokemonModel> finalList = new ArrayList<>(uniqueSet);

        Pageable pageable = PageRequest.of(0, 10);

        if (!finalList.isEmpty()) {
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), finalList.size());
            List<PokemonModel> paginatedList = finalList.subList(start, end);
            return new PageImpl<>(paginatedList, pageable, finalList.size());
        }


        try {
            PokemonResponseDto dto = pokeApiProxyService.getPokemon(search).block();

            if (dto != null) {
                PokemonModel newPokemon = new PokemonModel();
                newPokemon.setName(dto.name());
                newPokemon.setNumPokemon(dto.numPokemon());
                newPokemon.setPrimaryType(dto.primaryType());
                newPokemon.setSecondaryType(dto.secondaryType());

                pokemonRepository.save(newPokemon);

                return new PageImpl<>(List.of(newPokemon), pageable, 1);
            }
        } catch (Exception e) { }


        return Page.empty(pageable);
    }


    @Override
    public void deletePokemon(Long idPokemon) { pokemonRepository.deleteById(idPokemon); }

    @Override
    public Optional<PokemonModel> getPokemonByName(String name) {
        return pokemonRepository.getPokemonModelByName(name);
    }

    @Override
    public Optional<PokemonModel> getPokemonByNumPokemon(int numPokemon) {
        return pokemonRepository.getPokemonModelByNumPokemon(numPokemon);
    }

    @Override
    public Optional<PokemonModel> findPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }


}
