package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Locale;

public interface GenerationService {
    GenerationModel saveGeneration(GenerationModel generation, Locale locale);

    GenerationModel updateGeneration(GenerationModel generation, Locale locale);

    void deleteGeneration(Long idGeneration, Locale locale);

    GenerationModel getOneGeneration(Long idGeneration, Locale locale);

    GenerationModel getOneGenerationByNumber(Integer number, Locale locale);

    List<GenerationModel> getAllGenerations();
}
