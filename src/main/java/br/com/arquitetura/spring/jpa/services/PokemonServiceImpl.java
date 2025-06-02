package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.repositories.PokemonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
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
        Page<PokemonModel> pokemon;

        Pageable pageable = PageRequest.of(0, 10);

        try {
            numPokemon = Integer.parseInt(search);
            pokemon = pokemonRepository.findByNumPokemon(pageable, numPokemon);

        } catch (Exception e) {
            pokemon = pokemonRepository.findPokemonModelByNameContainingIgnoreCase(pageable, search);
        }

        if (pokemon != null) {
            return pokemon;
        }

        /// TO-DO: CADASTES SE NÃO EXISTIR
        return pokemon;
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
