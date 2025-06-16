package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.GenerationRecordDto;
import br.com.arquitetura.spring.jpa.dtos.GenerationResponseDto;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.services.GenerationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GenerationController {
    private final GenerationService generationService;

    public GenerationController(GenerationService generationService) {
        this.generationService = generationService;
    }

    @GetMapping("/generation")
    public ResponseEntity<List<GenerationResponseDto>> getAllGenerations() {
        List<GenerationModel> generations = generationService.getAllGenerations();
        List<GenerationResponseDto> generationsDto = generations.stream()
                .map(this::mapToGenerationResponseDto)
                .toList();

        return new ResponseEntity<>(generationsDto, HttpStatus.OK);
    }

    @GetMapping("/generation/{id}")
    public ResponseEntity<GenerationResponseDto> getOneGeneration(@PathVariable(value = "id") Long id, Locale locale) {
        GenerationModel generation = generationService.getOneGeneration(id, locale);

        return ResponseEntity.ok(mapToGenerationResponseDto(generation));
    }

    @GetMapping("/generation/{number}")
    public ResponseEntity<GenerationResponseDto> getOneGenerationByNumber(@PathVariable(value = "number") Integer number, Locale locale) {
        GenerationModel generation = generationService.getOneGenerationByNumber(number, locale);

        return ResponseEntity.ok(mapToGenerationResponseDto(generation));
    }

    @PostMapping("/generation")
    public ResponseEntity<GenerationResponseDto> saveGeneration(@RequestBody @Valid GenerationRecordDto generationRecordDto, Locale locale) {
        var generationModel = new GenerationModel();
        BeanUtils.copyProperties(generationRecordDto, generationModel);
        GenerationModel saveGeneration = generationService.saveGeneration(generationModel, locale);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToGenerationResponseDto(saveGeneration));
    }

    @PutMapping("/generation/{id}")
    public ResponseEntity<GenerationResponseDto> updateGeneration(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid GenerationRecordDto generationRecordDto,
            Locale locale) {
        GenerationModel generationModel = generationService.getOneGeneration(id, locale);
        BeanUtils.copyProperties(generationRecordDto, generationModel);
        GenerationModel updateGeneration = generationService.updateGeneration(generationModel, locale);

        return ResponseEntity.status(HttpStatus.OK).body(mapToGenerationResponseDto(updateGeneration));
    }


    @DeleteMapping("/generation/{id}")
    public ResponseEntity<Object> deleteGeneration(@PathVariable(value = "id") Long id, Locale locale) {
        generationService.deleteGeneration(id, locale);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Generation deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    private GenerationResponseDto mapToGenerationResponseDto(GenerationModel generationModel) {
        return new GenerationResponseDto(
                generationModel.getIdGeneration(),
                generationModel.getNumber(),
                generationModel.getRegion(),
                generationModel.getDateRegistered(),
                generationModel.getUserRegistered(),
                generationModel.getDateChanged(),
                generationModel.getUserChanged()
        );
    }
}
