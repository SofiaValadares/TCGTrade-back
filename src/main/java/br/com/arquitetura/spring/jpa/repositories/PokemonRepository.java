package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.PokemonModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {
    Page<PokemonModel> findPokemonModelByNameContainingIgnoreCase(Pageable pageable, String name);
    Page<PokemonModel> findByNumPokemon(Pageable pageable, Integer numPokemon);
    Optional<PokemonModel> getPokemonModelByName(String name);
    Optional<PokemonModel> getPokemonModelByNumPokemon(Integer numPokemon);
}
