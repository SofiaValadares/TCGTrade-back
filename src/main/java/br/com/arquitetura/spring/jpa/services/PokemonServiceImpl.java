package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.dtos.PokemonResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceFoundException;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.proxies.services.PokeApiProxyService;
import br.com.arquitetura.spring.jpa.repositories.PokemonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
    public PokemonModel savePokemon(PokemonModel pokemonModel, Locale locale) {
        if (pokemonModel.getName() == null || pokemonModel.getName().isEmpty()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.name.mandatory",
                    new Object[] {},
                    locale
            );
        }

        pokemonModel.setName(pokemonModel.getName().toUpperCase(locale));

        if (pokemonModel.getNumber() == null || pokemonModel.getNumber() <= 0) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.number.mandatory",
                    new Object[] {},
                    locale
            );
        } else {
            Optional<PokemonModel> pokemonOptional = pokemonRepository.findByNumber(pokemonModel.getNumber());

            if (pokemonOptional.isPresent()) {
                throw ResourceFoundException.withMessage(
                        messageSource, "error.pokemon.number.exists",
                        new Object[] {pokemonModel.getNumber()},
                        locale
                );
            }
        }

        if (pokemonModel.getGeneration() == null) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.generation.mandatory",
                    new Object[]{},
                    locale
            );
        }

        if (pokemonModel.getPrimaryType() == null) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.primarytype.mandatory",
                    new Object[] {},
                    locale
            );
        } else if (pokemonModel.getSecondaryType() != null && pokemonModel.getSecondaryType() == pokemonModel.getPrimaryType()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.types.equals",
                    new Object[] {},
                    locale
            );
        }

        return pokemonRepository.save(pokemonModel);
    }

    @Override
    public PokemonModel updatePokemon(PokemonModel pokemon, Locale locale) {
        if (pokemon.getName() == null || pokemon.getName().isEmpty()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.name.mandatory",
                    new Object[] {},
                    locale
            );
        }

        pokemon.setName(pokemon.getName().toUpperCase(locale));

        if (pokemon.getNumber() == null || pokemon.getNumber() <= 0) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.number.mandatory",
                    new Object[] {},
                    locale
            );
        }

        // TO-DO: erro de geracao vazia ou negativa

        if (pokemon.getPrimaryType() == null) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.primarytype.mandatory",
                    new Object[] {},
                    locale
            );
        } else if (pokemon.getSecondaryType() != null && pokemon.getSecondaryType() == pokemon.getPrimaryType()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.types.equals",
                    new Object[] {},
                    locale
            );
        }

        return pokemonRepository.save(pokemon);
    }


    @Override
    public void deletePokemon(Long idPokemon, Locale locale) {
        PokemonModel pokemonModel = this.getOnePokemon(idPokemon, locale);

        pokemonRepository.deleteById(pokemonModel.getIdPokemon());
    }


    @Override
    public PokemonModel getOnePokemon(Long id, Locale locale) {
        Optional<PokemonModel> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.pokemon.id.notfound",
                    new Object[]{id},
                    locale
            );
        }

        return pokemonOptional.get();
    }

    @Override
    public List<PokemonModel> getAllPokemons() {
        return pokemonRepository.findAllByOrderByNumberAsc();
    }

    @Override
    public Page<PokemonModel> getAllPagePokemons(Specification<PokemonModel> spec, Pageable pageable) {
        return pokemonRepository.findAll(spec, pageable);
    }

    @Override
    public boolean existsByNumber(Integer number) {
        return pokemonRepository.existsByNumber(number);
    }


}
