package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.DomainItemsListResponseDto;
import br.com.arquitetura.spring.jpa.dtos.DomainListResponseDto;
import br.com.arquitetura.spring.jpa.dtos.DomainRecordDto;
import br.com.arquitetura.spring.jpa.dtos.DomainResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.services.DomainService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class DomainController {
    private static final String ERROR_DOMAIND_ID_NOTFOUND = "error.domain.id.notfound";

    private final DomainService domainService;
    private final MessageSource messageSource;

    public DomainController(
            DomainService domainService,
            MessageSource messageSource
    ) {
        this.domainService = domainService;
        this.messageSource = messageSource;
    }

    @GetMapping("/domains/list/{idDomain}")
    public ResponseEntity<DomainListResponseDto> getAllDomainsList(@PathVariable(value = "idDomain") Long idDomain, Locale locale) {
        Optional<DomainModel> domainOptional = domainService.getOneDomain(idDomain);
        if (domainOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{idDomain},
                    locale
            );
        }
        if (!Boolean.TRUE.equals(domainOptional.get().getEnabled())) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.domain.id.diseble",
                    new Object[]{idDomain},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToDomainListResponseDto(domainOptional.get()));
    }

    @GetMapping("/domains")
    public ResponseEntity<List<DomainResponseDto>> getAllDomains() {
        List<DomainModel> domainsList = domainService.getAllDomains();
        List<DomainResponseDto> responseList = domainsList.stream()
                .map(this::mapToDomainResponseDto)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/domains/{id}")
    public ResponseEntity<DomainResponseDto> getOneDomain(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<DomainModel> domainOptional = domainService.getOneDomain(id);
        if (domainOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToDomainResponseDto(domainOptional.get()));
    }

    @PostMapping("/domains")
    public ResponseEntity<DomainResponseDto> saveDomain(@RequestBody @Valid DomainRecordDto domainRecordDto) {
        var domainModel = new DomainModel();
        BeanUtils.copyProperties(domainRecordDto, domainModel);
        DomainModel saveDomain = domainService.saveDomain(domainModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDomainResponseDto(saveDomain));
    }

    @PutMapping("/domains/{id}")
    public ResponseEntity<DomainResponseDto> updateDomain(@PathVariable(value = "id") Long id,
                                                          @RequestBody @Valid DomainRecordDto domainRecordDto, Locale locale) {
        Optional<DomainModel> domainOptional = domainService.getOneDomain(id);
        if (domainOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var domainModel = domainOptional.get();
        BeanUtils.copyProperties(domainRecordDto, domainModel);
        DomainModel updateDomain = domainService.updateDomain(domainModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToDomainResponseDto(updateDomain));
    }

    @DeleteMapping("/domains/{id}")
    public ResponseEntity<Object> deleteDomain(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<DomainModel> domainOptional = domainService.getOneDomain(id);
        if (domainOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAIND_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        domainService.deleteDomain(domainOptional.get());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Domain deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/domains/page")
    public Page<DomainResponseDto> getAllPageDomains(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        Specification<DomainModel> spec = Specification.where(nameContains(name)).and(descriptionContains(description));
        Page<DomainModel> domainPage = domainService.getAllPageDomains(spec, pageable);

        return domainPage.map(this::mapToDomainResponseDto);
    }

    Specification<DomainModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    Specification<DomainModel> descriptionContains(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null || description.isEmpty()) return null;
            return criteriaBuilder.like(root.get("description"), "%" + description + "%");
        };
    }

    private DomainResponseDto mapToDomainResponseDto(DomainModel domainModel) {
        return new DomainResponseDto(
                domainModel.getIdDomain(),
                domainModel.getName(),
                domainModel.getDescription(),
                domainModel.getEnabled(),
                domainModel.getDateRegistered(),
                domainModel.getUserRegistered(),
                domainModel.getDateChanged(),
                domainModel.getUserChanged()
        );
    }

    private DomainListResponseDto mapToDomainListResponseDto(DomainModel domainModel) {
        List<DomainItemsListResponseDto> items = domainModel.getDomainItems().stream()
                .map(item -> new DomainItemsListResponseDto(
                        item.getIdDomainItems(),
                        item.getCodDomainItems(),
                        item.getName(),
                        item.getEnabled()
                ))
                .toList();

        return new DomainListResponseDto(
                domainModel.getIdDomain(),
                domainModel.getName(),
                domainModel.getDescription(),
                domainModel.getEnabled(),
                items
        );
    }
}
