package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceFoundException;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.repositories.GenerationRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class GenerationServiceImpl  implements GenerationService{
    private final GenerationRepository generationRepository;
    private final MessageSource messageSource;

    public GenerationServiceImpl(GenerationRepository generationRepository, MessageSource messageSource) {
        this.generationRepository = generationRepository;
        this.messageSource = messageSource;
    }

    @Override
    public GenerationModel saveGeneration(GenerationModel generation, Locale locale) {
        return generationRepository.save(generation);
    }

    @Override
    public GenerationModel updateGeneration(GenerationModel generation, Locale locale) {
        return generationRepository.save(generation);
    }

    @Override
    public void deleteGeneration(Long idGeneration, Locale locale) {
        generationRepository.deleteById(idGeneration);
    }


    @Override
    public GenerationModel getOneGeneration(Long idGeneration, Locale locale) {
        Optional<GenerationModel> generationOptional = generationRepository.findByIdGeneration(idGeneration);

        if(generationOptional.isEmpty()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.generation.id.notfound",
                    new Object[] {idGeneration},
                    locale
            );
        }

        GenerationModel generation = generationOptional.get();
        return generation;
    }

    @Override
    public GenerationModel getOneGenerationByNumber(Integer number, Locale locale) {
        Optional<GenerationModel> generationOptional = generationRepository.findByNumber(number);

        if(generationOptional.isEmpty()) {
            throw ResourceFoundException.withMessage(
                    messageSource, "error.generation.id.notfound",
                    new Object[] {number},
                    locale
            );
        }

        GenerationModel generation = generationOptional.get();
        return generation;
    }

    @Override
    public List<GenerationModel> getAllGenerations() {
        return generationRepository.findAllByOrderByNumberAsc();
    }
}
