package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.DomainItemsRecordDto;
import br.com.arquitetura.spring.jpa.dtos.DomainItemsResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.services.DomainItemsService;
import br.com.arquitetura.spring.jpa.services.DomainService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Path;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DomainItemsControllersTest {
    @Mock
    private DomainItemsService domainItemsService;

    @Mock
    private DomainService domainService;

    @Mock
    private Root<DomainItemsModel> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private Path<Object> domainItemsModelPath;

    @Mock
    private Path<Object> idDomainItemsPath;

    @Mock
    private Path<Object> domainModelPath;

    @Mock
    private Path<Object> idDomainPath;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private DomainItemsControllers domainItemsController;

    Validator validator;
    private Locale locale;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        locale = Locale.getDefault();
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllDomainItemssIdDomain_NoIdDomain() {
        // Act
        domainItemsController.getAllDomainItems(null, locale);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllDomainItemssIdDomain_DomainNotFound() {
        // Arrange

        Long idDomain = 1L;
        when(messageSource.getMessage(eq("error.domainitems.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Itens do Domínio não encontrado com o id 1");
        when(domainService.getOneDomain(idDomain)).thenReturn(Optional.empty());

        // Act
        domainItemsController.getAllDomainItems(idDomain, locale);
    }

    @Test
    public void testGetAllDomainItemss_Success() {
        // Arrange
        Long idDomain = 3L;
        DomainModel domainModel  = new DomainModel();
        domainModel.setIdDomain(idDomain);
        domainModel.setName("Domain 1");

        DomainItemsModel domainItems1 = new DomainItemsModel();
        domainItems1.setIdDomainItems(1L);
        domainItems1.setCodDomainItems("1");
        domainItems1.setName("DomainItems 1");
        domainItems1.setDomainModel(domainModel);

        DomainItemsModel domainItems2 = new DomainItemsModel();
        domainItems2.setIdDomainItems(2L);
        domainItems2.setCodDomainItems("2");
        domainItems2.setName("DomainItems 2");
        domainItems2.setDomainModel(domainModel);

        List<DomainItemsModel> domainItemssList = Arrays.asList(domainItems1, domainItems2);

        when(domainService.getOneDomain(idDomain)).thenReturn(Optional.of(domainModel));
        when(domainItemsService.findByDomainModelIdDomain(idDomain)).thenReturn(domainItemssList);

        // Act
        ResponseEntity<List<DomainItemsResponseDto>> response;
        response = domainItemsController.getAllDomainItems(idDomain, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals("DomainItems 1", response.getBody().get(0).name());
        assertEquals("DomainItems 2", response.getBody().get(1).name());

        verify(domainService, times(1)).getOneDomain(idDomain);
        verify(domainItemsService, times(1)).findByDomainModelIdDomain(idDomain);
    }

    @Test
    public void testGetOneDomainItems_Found() {
        // Arrange
        Long idDomain = 1L;
        DomainModel domainModel  = new DomainModel();
        domainModel .setIdDomain(idDomain);
        domainModel .setName("Domain 1");

        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(1L);
        domainItems.setCodDomainItems("1");
        domainItems.setName("DomainItems 1");
        domainItems.setDomainModel(domainModel);

        when(domainItemsService.getOneDomainItems(1L)).thenReturn(Optional.of(domainItems));

        // Act
        ResponseEntity<DomainItemsResponseDto> response = domainItemsController.getOneDomainItems(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals("DomainItems 1", Objects.requireNonNull(response.getBody()).name());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetOneDomainItems_NotFound() {
        // Arrange
        when(domainItemsService.getOneDomainItems(1L)).thenReturn(Optional.empty());

        // Act
        domainItemsController.getOneDomainItems(1L, locale);
    }

    @Test
    public void testSaveDomainItems_Success() {
        // Arrange
        Long idDomain = 1L;
        DomainModel domainModel  = new DomainModel();
        domainModel .setIdDomain(idDomain);
        domainModel .setName("Domain 1");

        DomainItemsModel saveDdomainItems = new DomainItemsModel();
        saveDdomainItems.setIdDomainItems(1L);
        saveDdomainItems.setCodDomainItems("1");
        saveDdomainItems.setName("DomainItems 1");
        saveDdomainItems.setDomainModel(domainModel);

        DomainItemsRecordDto domainItemsRecordDto  = new DomainItemsRecordDto(1L,"1","DomainItems 1", true);

        BeanUtils.copyProperties(domainItemsRecordDto, saveDdomainItems);

        when(domainService.getOneDomain(1L)).thenReturn(Optional.of(domainModel));
        when(domainItemsService.saveDomainItems(any(DomainItemsModel.class))).thenReturn(saveDdomainItems);

        // Act
        ResponseEntity<DomainItemsResponseDto> response = domainItemsController.saveDomainItems(domainItemsRecordDto, locale);

        // Assert
        assertEquals(201, response.getStatusCode().value());
        verify(domainService, times(1)).getOneDomain(1L);
        verify(domainItemsService, times(1)).saveDomainItems(any(DomainItemsModel.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSaveDomainItems_DomainNotFound() {
        // Arrange
        DomainItemsRecordDto domainItemsRecordDto = new DomainItemsRecordDto(1L,"1","DomainItems Name", true);
        when(domainService.getOneDomain(1L)).thenReturn(Optional.empty());

        // Act
        domainItemsController.saveDomainItems(domainItemsRecordDto, locale);
    }

    @Test
    public void testUpdateDomainItems_Success() {
        // Arrange
        Long domainItemsId = 1L;
        Long domainId = 1L;
        DomainItemsRecordDto domainItemsRecordDto = new DomainItemsRecordDto(domainId,"1", "Updated DomainItems Name", true);

        DomainModel domainModel = new DomainModel();
        domainModel.setIdDomain(domainId);
        domainModel.setName("Domain 1");

        DomainItemsModel domainItemsModel = new DomainItemsModel();
        domainItemsModel.setIdDomainItems(1L);
        domainItemsModel.setCodDomainItems("1");
        domainItemsModel.setName("DomainItems 1");
        domainItemsModel.setDomainModel(domainModel);

        when(domainItemsService.getOneDomainItems(domainItemsId)).thenReturn(Optional.of(domainItemsModel));
        when(domainService.getOneDomain(domainId)).thenReturn(Optional.of(domainModel));
        when(domainItemsService.updateDomainItems(any(DomainItemsModel.class))).thenReturn(domainItemsModel);

        // Act
        ResponseEntity<DomainItemsResponseDto> response = domainItemsController.updateDomainItems(domainItemsId, domainItemsRecordDto, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        verify(domainItemsService, times(1)).getOneDomainItems(domainItemsId);
        verify(domainService, times(1)).getOneDomain(domainId);
        verify(domainItemsService, times(1)).updateDomainItems(any(DomainItemsModel.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateDomainItems_DomainNotFound() {
        // Arrange
        Long domainItemsId = 1L;
        DomainItemsRecordDto domainItemsRecordDto = new DomainItemsRecordDto(2L, "2","Updated DomainItems", true);
        DomainItemsModel domainItemsModel = new DomainItemsModel();

        when(domainItemsService.getOneDomainItems(domainItemsId)).thenReturn(Optional.of(domainItemsModel));
        when(domainService.getOneDomain(2L)).thenReturn(Optional.empty());

        // Act
        domainItemsController.updateDomainItems(domainItemsId, domainItemsRecordDto, locale);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateDomainItems_NotFound() {
        // Arrange
        Long nonExistentDomainItemsId = 1L;
        DomainItemsRecordDto domainItemsDto = new DomainItemsRecordDto(1L, "1","New DomainItems", true);

        when(domainItemsService.getOneDomainItems(nonExistentDomainItemsId)).thenReturn(Optional.empty());

        // Act
        domainItemsController.updateDomainItems(nonExistentDomainItemsId, domainItemsDto, locale);
    }

    @Test
    public void testUpdateDomainItems_NotFound_Response() {
        // Arrange
        Long nonExistentDomainItemsId = 1L;
        DomainItemsRecordDto domainItemsDto = new DomainItemsRecordDto(1L, "1","New DomainItems", true);
        when(domainItemsService.getOneDomainItems(nonExistentDomainItemsId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domainitems.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Itens do Domínio não encontrado com o id 1");

        try {
            // Act
            domainItemsController.updateDomainItems(nonExistentDomainItemsId, domainItemsDto, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Itens do Domínio não encontrado com o id " + nonExistentDomainItemsId, ex.getMessage());
        }
    }

    @Test
    public void testDeleteDomainItems_Success() {
        // Arrange
        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(1L);
        domainItems.setCodDomainItems("1");
        domainItems.setName("DomainItems 1");
        when(domainItemsService.getOneDomainItems(1L)).thenReturn(Optional.of(domainItems));
        doNothing().when(domainItemsService).deleteDomainItems(domainItems);

        // Act
        ResponseEntity<Object> response = domainItemsController.deleteDomainItems(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteDomainItems_NotFound() {
        // Arrange
        Long nonExistentDomainItemsId = 1L;
        when(domainItemsService.getOneDomainItems(nonExistentDomainItemsId)).thenReturn(Optional.empty());

        // Act
        domainItemsController.deleteDomainItems(nonExistentDomainItemsId, locale);
    }

    @Test
    public void testDeleteDomainItems_NotFound_Response() {
        // Arrange
        Long nonExistentDomainItemsId = 1L;
        when(domainItemsService.getOneDomainItems(nonExistentDomainItemsId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.domainitems.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Itens do Domínio não encontrado com o id 1");

        try {
            // Act
            domainItemsController.deleteDomainItems(nonExistentDomainItemsId, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Itens do Domínio não encontrado com o id " + nonExistentDomainItemsId, ex.getMessage());
        }
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllPageDomainItemss_NoIdDomain() {
        // Act
        domainItemsController.getAllPageDomainItems(0, 10, "id", "asc", null, null, null,null, locale);
    }

    @Test
    public void testGetAllPageDomainItemss_Success() {
        // Arrange
        int page = 0;
        int size = 10;
        String sort = "id";
        String order = "asc";
        Long idDomain = 1L;
        String codDomainItems = "1";

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sort));

        DomainModel domainModel  = new DomainModel();
        domainModel.setIdDomain(idDomain);
        domainModel.setName("Domain 1");

        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(1L);
        domainItems.setCodDomainItems("1");
        domainItems.setName("DomainItems 1");
        domainItems.setDomainModel(domainModel);

        Page<DomainItemsModel> domainItemssPage = new PageImpl<>(Collections.singletonList(domainItems));
        when(domainItemsService.getAllPageDomainItems(any(Specification.class), eq(pageable))).thenReturn(domainItemssPage);

        // Act
        Page<DomainItemsResponseDto> responsePage = domainItemsController.getAllPageDomainItems(page, size, sort, order, idDomain, domainItems.getIdDomainItems(), codDomainItems,domainItems.getName(), locale);

        // Assert
        assertEquals(1, responsePage.getTotalElements());
        assertEquals("DomainItems 1", responsePage.getContent().get(0).name());
        verify(domainItemsService, times(1)).getAllPageDomainItems(any(Specification.class), eq(pageable));
    }

    @Test
    public void testNameContains_Success() {
        // Arrange
        String name = "TestDomainItems";
        when(criteriaBuilder.like(root.get("name"), "%" + name + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<DomainItemsModel> spec = domainItemsController.nameContains(name);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testCodDomainItemsContains_NullOrEmpty() {
        // Act
        Specification<DomainItemsModel> specNull = domainItemsController.codDomainItemsContains(null);
        Specification<DomainItemsModel> specEmpty = domainItemsController.codDomainItemsContains("");

        // Assert
        assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testCodDomainItemsContains_Success() {
        // Arrange
        String codDomainItems = "1";
        when(criteriaBuilder.like(root.get("codDomainItems"), "%" + codDomainItems + "%")).thenReturn(mock(Predicate.class));

        // Act
        Specification<DomainItemsModel> spec = domainItemsController.codDomainItemsContains(codDomainItems);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testNameContains_NullOrEmpty() {
        // Act
        Specification<DomainItemsModel> specNull = domainItemsController.nameContains(null);
        Specification<DomainItemsModel> specEmpty = domainItemsController.nameContains("");

        // Assert
        assertNull(specNull.toPredicate(root, query, criteriaBuilder));
        assertNull(specEmpty.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testIdDomainEquals() {
        // Arrange
        Long idDomain = 1L;

        when(root.get("domainModel")).thenReturn(domainModelPath);
        when(domainModelPath.get("idDomain")).thenReturn(idDomainPath);
        when(criteriaBuilder.equal(idDomainPath, idDomain)).thenReturn(mock(Predicate.class));

        // Act
        Specification<DomainItemsModel> spec = domainItemsController.idDomainEquals(idDomain);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testIdDomainEquals_Null() {
        // Act
        Specification<DomainItemsModel> spec = domainItemsController.idDomainEquals(null);

        // Assert
        assertNull(spec.toPredicate(root, query, criteriaBuilder));
    }

    @Test
    public void testIdDomainItemsEquals() {
        // Arrange
        Long idDomainItems = 1L;
        when(criteriaBuilder.equal(root.get("idDomainItems"), idDomainItems)).thenReturn(mock(Predicate.class));

        // Act
        Specification<DomainItemsModel> spec = domainItemsController.idDomainItemsEquals(idDomainItems);
        Predicate predicate = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(predicate);
    }

    @Test
    public void testIdDomainItemsEquals_Null() {
        // Act
        Specification<DomainItemsModel> spec = domainItemsController.idDomainItemsEquals(null);

        // Assert
        assertNull(spec.toPredicate(root, query, criteriaBuilder));
    }
}
