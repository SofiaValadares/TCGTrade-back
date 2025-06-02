package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.PokemonModel;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PokemonService {
    PokemonModel savePokemon(PokemonModel pokemon);
    PokemonModel updatePokemon(PokemonModel pokemon);
    Page<PokemonModel> searchPokemon(String search);
    void deletePokemon(Long idPokemon);
    Optional<PokemonModel> getPokemonByName(String name);
    Optional<PokemonModel> getPokemonByNumPokemon(int numPokemon);
    Optional<PokemonModel> findPokemonById(Long id);
}
