package br.com.arquitetura.spring.jpa.data.collections;

import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.models.CollectionModel;
import br.com.arquitetura.spring.jpa.repositories.PokemonRepository;

import java.util.List;

public interface CollectionInitializer {
    void setPokemonRepository(PokemonRepository pokemonRepository);
    CollectionModel getCollection();
    List<CardModel> getCards();
}
