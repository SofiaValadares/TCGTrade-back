package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.DomainItemsListResponseDto;
import br.com.arquitetura.spring.jpa.dtos.DomainListResponseDto;
import br.com.arquitetura.spring.jpa.dtos.DomainRecordDto;
import br.com.arquitetura.spring.jpa.dtos.DomainResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.services.DomainService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class DomainControllerTest {
    @Mock
    private DomainService domainService;

    @Mock
    private Root<DomainModel> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private DomainController domainController;

    Validator validator;
    private Locale locale;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        locale = Locale.getDefault();
    }

private DomainListResponseDto mapToDomainListResponseDto(DomainModel domainModel) {
    List<DomainItemsListResponseDto> items = domainModel.getDomainItems().stream()
            .map(item -> new DomainItemsListResponseDto(
                    item.getIdDomainItems(),
                    item.getCodDomainItems(),
                    item.getName(),
                    item.getEnabled()
            ))
            .collect(Collectors.toList());

    return new DomainListResponseDto(
            domainModel.getIdDomain(),
            domainModel.getName(),
            domainModel.getDescription(),
            domainModel.getEnabled(),
            items
    );
}

    @Test
    public void testGetAllDomainsList_Success() {
        // Given
        Long idDomain = 1L;

        // Criando itens de domínio
        DomainItemsModel item1 = new DomainItemsModel();
        item1.setIdDomainItems(100L);
        item1.setCodDomainItems("ITEM1");
        item1.setName("Item 1");
        item1.setEnabled(true);

        DomainItemsModel item2 = new DomainItemsModel();
        item2.setIdDomainItems(101L);
        item2.setCodDomainItems("ITEM2");
        item2.setName("Item 2");
        item2.setEnabled(true);

        List<DomainItemsModel> domainItems = List.of(item1, item2);

        // Criando domínio com a lista de itens
        DomainModel domainModel = new DomainModel();
        domainModel.setIdDomain(idDomain);
        domainModel.setName("Test Domain");
        domainModel.setDescription("This is a test domain");
        domainModel.setEnabled(true);
        domainModel.setDomainItems(new ArrayList<>());
        domainModel.getDomainItems().addAll(domainItems);
        //domainModel.setDomainItems( domainItems);

        // Esperado DTO de resposta
        DomainListResponseDto expectedDto = mapToDomainListResponseDto(domainModel);

        // Mock do serviço retornando o domínio encontrado
        when(domainService.getOneDomain(idDomain)).thenReturn(Optional.of(domainModel));

        // When
        ResponseEntity<DomainListResponseDto> response = domainController.getAllDomainsList(idDomain, locale);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());

        // Verificar o mapeamento correto do DTO
        DomainListResponseDto actualDto = response.getBody();
        assertEquals(expectedDto.idDomain(), actualDto.idDomain());
        assertEquals(expectedDto.name(), actualDto.name());
        assertEquals(expectedDto.description(), actualDto.description());
        assertEquals(expectedDto.enabled(), actualDto.enabled());

        // Verificar o mapeamento correto dos itens de domínio
        List<DomainItemsListResponseDto> expectedItems = expectedDto.domainItems();
        List<DomainItemsListResponseDto> actualItems = actualDto.domainItems();

        assertEquals(expectedItems.size(), actualItems.size());
        for (int i = 0; i < expectedItems.size(); i++) {
            assertEquals(expectedItems.get(i).idDomainItems(), actualItems.get(i).idDomainItems());
            assertEquals(expectedItems.get(i).codDomainItems(), actualItems.get(i).codDomainItems());
            assertEquals(expectedItems.get(i).name(), actualItems.get(i).name());
            assertEquals(expectedItems.get(i).enabled(), actualItems.get(i).enabled());
        }

        // Verifica se o serviço foi chamado corretamente
        verify(domainService, times(1)).getOneDomain(idDomain);
    }

    @Test
    public void testGetAllDomainsList_DomainNotFound() {
        // Given
        Long idDomain = 1L;

        // Simulando que o domínio não foi encontrado
        when(domainService.getOneDomain(idDomain)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domain.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Domain not found with id 1");

        // When / Then
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            domainController.getAllDomainsList(idDomain, locale);
        });

        assertEquals("Domain not found with id " + idDomain, exception.getMessage());
        verify(domainService, times(1)).getOneDomain(idDomain);
    }

    // Teste para domínio encontrado, mas desabilitado
    @Test
    public void testGetAllDomainsList_DomainDisabled() {
        // Given
        Long idDomain = 1L;
        DomainModel domainModel = new DomainModel();
        domainModel.setIdDomain(idDomain);
        domainModel.setEnabled(false); // Domínio desabilitado

        when(domainService.getOneDomain(idDomain)).thenReturn(Optional.of(domainModel));
        when(messageSource.getMessage(eq("error.domain.id.diseble"), any(Object[].class), eq(locale)))
                .thenReturn("Domain disabled with id 1");

        // When / Then
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            domainController.getAllDomainsList(idDomain, locale);
        });

        assertEquals("Domain disabled with id " + idDomain, exception.getMessage());
        verify(domainService, times(1)).getOneDomain(idDomain);
    }




    @Test
    public void testGetAllDomains_Success() {
        // Arrange
        DomainModel domain1 = new DomainModel();
        DomainModel domain2 = new DomainModel();
        domain1.setIdDomain(1L);
        domain1.setName("Domain 1");
        domain1.setDescription("description 1");
        domain1.setEnabled(true);

        domain2.setIdDomain(2L);
        domain2.setName("Domain 2");
        domain2.setDescription("description 2");
        domain2.setEnabled(true);

        when(domainService.getAllDomains()).thenReturn(Arrays.asList(domain1, domain2));

        // Act
        ResponseEntity<List<DomainResponseDto>> response = domainController.getAllDomains();

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals("Domain 1", response.getBody().get(0).name());
    }

    @Test
    public void testGetOneDomain_Found() {
        // Arrange
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);
        domain.setName("Domain 1");
        domain.setDescription("description 1");
        domain.setEnabled(true);

        when(domainService.getOneDomain(1L)).thenReturn(Optional.of(domain));

        // Act
        ResponseEntity<DomainResponseDto> response = domainController.getOneDomain(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Domain 1", Objects.requireNonNull(response.getBody()).name());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetOneDomain_NotFound() {
        // Arrange
        when(domainService.getOneDomain(1L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domain.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Domain not found with id 1");

        // Act
        domainController.getOneDomain(1L, locale);
    }

    @Test
    public void testSaveDomain_Success() {
        // Arrange
        DomainRecordDto domainDto = new DomainRecordDto("Domain 1","description 1", true );

        DomainModel savedDomain = new DomainModel();
        savedDomain.setIdDomain(1L);
        savedDomain.setName("Domain 1");
        savedDomain.setDescription("description 1");
        savedDomain.setEnabled(true);

        when(domainService.saveDomain(any(DomainModel.class))).thenReturn(savedDomain);

        // Act
        ResponseEntity<DomainResponseDto> response = domainController.saveDomain(domainDto);

        // Assert
        assertEquals(201, response.getStatusCode().value());
        assertEquals("Domain 1", Objects.requireNonNull(response.getBody()).name());
    }

    @Test
    public void testUpdateDomain_Success() {
        // Arrange
        Long domainId = 1L;
        DomainRecordDto domainDto = new DomainRecordDto("Updated Domain", "Updated description", true);
        DomainModel existingDomain = new DomainModel();
        existingDomain.setIdDomain(1L);
        existingDomain.setName("Old Domain");
        existingDomain.setDescription("Old description");
        existingDomain.setEnabled(true);

        when(domainService.getOneDomain(domainId)).thenReturn(Optional.of(existingDomain));
        when(domainService.updateDomain(any(DomainModel.class))).thenReturn(existingDomain);

        // Act
        ResponseEntity<DomainResponseDto> response = domainController.updateDomain(domainId, domainDto, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Updated Domain", Objects.requireNonNull(response.getBody()).name());
        assertEquals("Updated description", Objects.requireNonNull(response.getBody()).description());
        assertEquals(true, response.getBody().enabled());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateDomain_NotFound() {
        // Arrange
        Long nonExistentDomainId = 1L;
        DomainRecordDto domainDto = new DomainRecordDto("New Domain", "New description", true);

        when(domainService.getOneDomain(nonExistentDomainId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domain.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Domain not found with id 1");

        // Act
        domainController.updateDomain(nonExistentDomainId, domainDto, locale);
    }

    @Test
    public void testUpdateDomain_NotFound_Response() {
        // Arrange
        Long nonExistentDomainId = 1L;
        DomainRecordDto domainDto = new DomainRecordDto("New Domain", "New description", true);
        when(domainService.getOneDomain(nonExistentDomainId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domain.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Domain not found with id 1");

        try {
            // Act
            domainController.updateDomain(nonExistentDomainId, domainDto, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Domain not found with id " + nonExistentDomainId, ex.getMessage());
        }
    }

    @Test
    public void testDeleteDomain_Success() {
        // Arrange
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);
        when(domainService.getOneDomain(1L)).thenReturn(Optional.of(domain));
        doNothing().when(domainService).deleteDomain(domain);

        // Act
        ResponseEntity<Object> response = domainController.deleteDomain(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteDomain_NotFound() {
        // Arrange
        Long nonExistentDomainId = 1L;
        when(domainService.getOneDomain(nonExistentDomainId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domain.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Domain not found with id 1");

        // Act
        domainController.deleteDomain(nonExistentDomainId, locale);
    }

    @Test
    public void testDeleteDomain_NotFound_Response() {
        // Arrange
        Long nonExistentDomainId = 1L;
        when(domainService.getOneDomain(nonExistentDomainId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domain.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Domain not found with id 1");
        try {
            // Act
            domainController.deleteDomain(nonExistentDomainId, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Domain not found with id " + nonExistentDomainId, ex.getMessage());
        }
    }

    @Test
    public void testGetAllPageDomains_Success() {
        // Arrange
        int page = 0;
        int size = 10;
        String sort = "id";
        String order = "asc";
        String name = "TestDomain";
        String description = "TestDescription";

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);
        domain.setName(name);
        domain.setDescription(description);

        Page<DomainModel> domainPage = new PageImpl<>(Collections.singletonList(domain));
        when(domainService.getAllPageDomains(any(Specification.class), eq(pageable))).thenReturn(domainPage);

        // Act
        Page<DomainResponseDto> responsePage = domainController.getAllPageDomains(page, size, sort, order, name, description);

        // Assert
        assertEquals(1, responsePage.getTotalElements());
        assertEquals(name, responsePage.getContent().get(0).name());
        assertEquals(description, responsePage.getContent().get(0).description());

        verify(domainService, times(1)).getAllPageDomains(any(Specification.class), any(Pageable.class));
    }

    @Test
    public void testNameContains_Success() {
        // Arrange
        String name = "TestDomain";
        when(criteriaBuilder.like(root.get("name"), "%" + name + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<DomainModel> spec = domainController.nameContains(name);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testNameContains_NullOrEmpty() {
        // Act
        Specification<DomainModel> specNull = domainController.nameContains(null);
        Specification<DomainModel> specEmpty = domainController.nameContains("");

        // Assert
        assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testDescriptionEquals_Success() {
        // Arrange
        String description = "TestDomain";
        when(criteriaBuilder.like(root.get("description"), "%" + description + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<DomainModel> spec = domainController.descriptionContains(description);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testDescriptionEquals_Null() {
        // Act
        Specification<DomainModel> specNull = domainController.descriptionContains(null);
        Specification<DomainModel> specEmpty = domainController.descriptionContains("");

        // Assert
        assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

}
