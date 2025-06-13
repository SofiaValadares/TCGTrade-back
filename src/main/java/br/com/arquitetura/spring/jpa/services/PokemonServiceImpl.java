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

        if (pokemonModel.getNumPokemon() == null || pokemonModel.getNumPokemon() <= 0) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.number.mandatory",
                    new Object[] {},
                    locale
            );
        } else {
            Optional<PokemonModel> pokemonOptional = pokemonRepository.findByNumPokemon(pokemonModel.getNumPokemon());

            if (pokemonOptional.isPresent()) {
                throw ResourceFoundException.withMessage(
                        messageSource, "error.pokemon.id.exists",
                        new Object[] {pokemonModel.getNumPokemon()},
                        locale
                );
            }
        }

        if (pokemonModel.getPrimaryType() == null) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.primarytype.mandatory",
                    new Object[] {},
                    locale
            );
        } else if (pokemonModel.getSecondaryType() != null || pokemonModel.getSecondaryType() == pokemonModel.getPrimaryType()) {
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

        if (pokemon.getNumPokemon() == null || pokemon.getNumPokemon() <= 0) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.number.mandatory",
                    new Object[] {},
                    locale
            );
        }

        if (pokemon.getPrimaryType() == null) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.pokemon.primarytype.mandatory",
                    new Object[] {},
                    locale
            );
        } else if (pokemon.getSecondaryType() != null || pokemon.getSecondaryType() == pokemon.getPrimaryType()) {
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
        return pokemonRepository.findAll();
    }

    @Override
    public Page<PokemonModel> getAllPagePokemons(Specification<PokemonModel> spec, Pageable pageable) {
        return pokemonRepository.findAll(spec, pageable);
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
