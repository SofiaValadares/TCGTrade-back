package br.com.arquitetura.spring.jpa.repositories;

import br.com.arquitetura.spring.jpa.models.PokemonModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {
    Page<PokemonModel> findAll(Specification<PokemonModel> spec, Pageable pageable);
    List<PokemonModel> findAllByOrderByNumberAsc();

    Optional<PokemonModel> findByNumber(Integer number);
}
