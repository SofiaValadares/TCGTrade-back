package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface PokemonService {
    PokemonModel savePokemon(PokemonModel pokemon);
    PokemonModel updatePokemon(PokemonModel pokemon);
    Page<PokemonModel> searchPokemon(String search, Pageable pageable, Locale locale);
    void deletePokemon(Long idPokemon);
    Optional<PokemonModel> getOnePokemon(Long id);
    List<PokemonModel> getAllPokemons();
    Page<PokemonModel> getAllPagePokemons(Specification<PokemonModel> spec, Pageable pageable);
}
