package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.DomainItemsRecordDto;
import br.com.arquitetura.spring.jpa.dtos.DomainItemsResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.services.DomainItemsService;
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
public class DomainItemsControllers {
    private static final String ERROR_DOMAINITEMS_ID_NOTFOUND = "error.domainitems.id.notfound";

    private final DomainItemsService domainItemsService;
    private final DomainService domainService;
    private final MessageSource messageSource;

    public DomainItemsControllers(
            DomainItemsService domainItemsService,
            DomainService domainService,
            MessageSource messageSource
    ) {
        this.domainItemsService = domainItemsService;
        this.domainService = domainService;
        this.messageSource = messageSource;
    }

    @GetMapping("/domain-items")
    public ResponseEntity<List<DomainItemsResponseDto>> getAllDomainItems(@RequestParam(required = false) Long idDomain, Locale locale) {
        if (idDomain == null) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.domain.id.mandatory",
                    new Object[]{idDomain},
                    locale
            );
        } else {
            Optional<DomainModel> domainOptional = domainService.getOneDomain(idDomain);
            if (domainOptional.isEmpty()) {
                throw ResourceNotFoundException.withMessage(
                        messageSource, ERROR_DOMAINITEMS_ID_NOTFOUND,
                        new Object[]{idDomain},
                        locale
                );
            } else {
                List<DomainItemsModel> domainItemssList = domainItemsService.findByDomainModelIdDomain(idDomain);
                List<DomainItemsResponseDto> responseList = domainItemssList.stream()
                        .map(this::mapToDomainItemsResponseDto)
                        .toList();

                return ResponseEntity.status(HttpStatus.OK).body(responseList);
            }
        }
    }

    @GetMapping("/domain-items/{id}")
    public ResponseEntity<DomainItemsResponseDto> getOneDomainItems(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<DomainItemsModel> domainItemsOptional = domainItemsService.getOneDomainItems(id);
        if (domainItemsOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAINITEMS_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToDomainItemsResponseDto(domainItemsOptional.get()));
    }

    @PostMapping("/domain-items")
    public ResponseEntity<DomainItemsResponseDto> saveDomainItems(@RequestBody @Valid DomainItemsRecordDto domainItemsRecordDto, Locale locale) {
        var domainItemsModel = new DomainItemsModel();
        var idDomain = domainItemsRecordDto.idDomain();
        Optional<DomainModel> domainOptional = domainService.getOneDomain(idDomain);
        if (domainOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.domain.id.notfound",
                    new Object[]{idDomain},
                    locale
            );
        } else {
            BeanUtils.copyProperties(domainItemsRecordDto, domainItemsModel);

            domainItemsModel.setDomainModel(domainOptional.get());
            DomainItemsModel saveDomainItems = domainItemsService.saveDomainItems(domainItemsModel);

            return ResponseEntity.status(HttpStatus.CREATED).body(mapToDomainItemsResponseDto(saveDomainItems));
        }
    }

    @PutMapping("/domain-items/{id}")
    public ResponseEntity<DomainItemsResponseDto> updateDomainItems(@PathVariable(value = "id") Long id,
                                                                    @RequestBody @Valid DomainItemsRecordDto domainItemsRecordDto, Locale locale) {

        Optional<DomainItemsModel> domainItemsOptional = domainItemsService.getOneDomainItems(id);
        if (domainItemsOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAINITEMS_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        var idDomain = domainItemsRecordDto.idDomain();
        Optional<DomainModel> domainOptional = domainService.getOneDomain(idDomain);
        if (domainOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.domain.id.notfound",
                    new Object[]{idDomain},
                    locale
            );
        } else {
            var domainItemsModel = domainItemsOptional.get();
            BeanUtils.copyProperties(domainItemsRecordDto, domainItemsModel);
            DomainItemsModel updateDomainItems = domainItemsService.updateDomainItems(domainItemsModel);

            return ResponseEntity.status(HttpStatus.OK).body(mapToDomainItemsResponseDto(updateDomainItems));
        }
    }

    @DeleteMapping("/domain-items/{id}")
    public ResponseEntity<Object> deleteDomainItems(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<DomainItemsModel> domainItemsOptional = domainItemsService.getOneDomainItems(id);
        if (domainItemsOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_DOMAINITEMS_ID_NOTFOUND,
                    new Object[]{id},
                    locale
            );
        }
        domainItemsService.deleteDomainItems(domainItemsOptional.get());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Domain Items deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/domain-items/page")
    public Page<DomainItemsResponseDto> getAllPageDomainItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) Long idDomain,
            @RequestParam(required = false) Long idDomainItems,
            @RequestParam(required = false) String codDomainItems,
            @RequestParam(required = false) String name,
            Locale locale) {

        if (idDomain == null) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, "error.domain.id.mandatory",
                    new Object[]{idDomain},
                    locale
            );
        } else {
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
            Specification<DomainItemsModel> spec = Specification.where(idDomainEquals(idDomain)).and(idDomainItemsEquals(idDomainItems)).and(codDomainItemsContains(codDomainItems)).and(nameContains(name));
            Page<DomainItemsModel> piecesPage = domainItemsService.getAllPageDomainItems(spec, pageable);

            return piecesPage.map(this::mapToDomainItemsResponseDto);
        }
    }

    Specification<DomainItemsModel> idDomainEquals(Long idDomain) {
        return (root, query, criteriaBuilder) -> {
            if (idDomain == null) return null;
            return criteriaBuilder.equal(root.get("domainModel").get("idDomain"), idDomain);
        };
    }

    Specification<DomainItemsModel> idDomainItemsEquals(Long idDomainItems) {
        return (root, query, criteriaBuilder) -> {
            if (idDomainItems == null) return null;
            return criteriaBuilder.equal(root.get("idDomainItems"), idDomainItems);
        };
    }

    Specification<DomainItemsModel> codDomainItemsContains(String codDomainItems) {
        return (root, query, criteriaBuilder) -> {
            if (codDomainItems == null || codDomainItems.isEmpty()) return null;
            return criteriaBuilder.like(root.get("codDomainItems"), "%" + codDomainItems + "%");
        };
    }

    Specification<DomainItemsModel> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }


    private DomainItemsResponseDto mapToDomainItemsResponseDto(DomainItemsModel domainItemsModel) {
        return new DomainItemsResponseDto(
                domainItemsModel.getIdDomainItems(),
                domainItemsModel.getDomainModel().getIdDomain(),
                domainItemsModel.getCodDomainItems(),
                domainItemsModel.getName(),
                domainItemsModel.getEnabled(),
                domainItemsModel.getDateRegistered(),
                domainItemsModel.getUserRegistered(),
                domainItemsModel.getDateChanged(),
                domainItemsModel.getUserChanged()
        );
    }
}
