package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.repositories.DomainItemsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DomainItemsServiceImplTest {

    @InjectMocks
    private DomainItemsServiceImpl domainItemsService;

    @Mock
    private DomainItemsRepository domainItemsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByDomainModelIdDomain() {
        // Given
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);
        domain.setName("Domain");
        domain.setDescription("Domain Description");

        DomainItemsModel domainItems1 = new DomainItemsModel();
        domainItems1.setIdDomainItems(1L);
        domainItems1.setName("DomainItems 1");
        domainItems1.setDomainModel(domain);

        DomainItemsModel domainItems2 = new DomainItemsModel();
        domainItems2.setIdDomainItems(2L);
        domainItems2.setName("DomainItems 2");
        domainItems2.setDomainModel(domain);

        List<DomainItemsModel> domainItemsList = List.of(domainItems1, domainItems2);
        when(domainItemsRepository.findAll()).thenReturn(domainItemsList);

        // When
        List<DomainItemsModel> result = domainItemsService.findByDomainModelIdDomain(1L);

        // Then
        assertNotNull(result);
        assertEquals(2, domainItemsList.size());
        assertEquals("DomainItems 1", domainItemsList.get(0).getName());
    }

    @Test
    void testGetAllDomainItemss() {
        // Given
        DomainItemsModel domainItems1 = new DomainItemsModel();
        domainItems1.setIdDomainItems(1L);
        domainItems1.setName("DomainItems 1");

        DomainItemsModel domainItems2 = new DomainItemsModel();
        domainItems2.setIdDomainItems(2L);
        domainItems2.setName("DomainItems 2");

        List<DomainItemsModel> domainItemsList = List.of(domainItems1, domainItems2);
        when(domainItemsRepository.findAll()).thenReturn(domainItemsList);

        // When
        List<DomainItemsModel> result = domainItemsService.getAllDomainItems();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("DomainItems 1", result.get(0).getName());
        verify(domainItemsRepository, times(1)).findAll();
    }

    @Test
    void testGetOneDomainItems_Found() {
        // Given
        Long id = 1L;
        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(id);
        domainItems.setName("Test DomainItems");

        when(domainItemsRepository.findById(id)).thenReturn(Optional.of(domainItems));

        // When
        Optional<DomainItemsModel> result = domainItemsService.getOneDomainItems(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Test DomainItems", result.get().getName());
        verify(domainItemsRepository, times(1)).findById(id);
    }

    @Test
    void testGetOneDomainItems_NotFound() {
        // Given
        Long id = 1L;

        when(domainItemsRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<DomainItemsModel> result = domainItemsService.getOneDomainItems(id);

        // Then
        assertFalse(result.isPresent());
        verify(domainItemsRepository, times(1)).findById(id);
    }

    @Test
    void testSaveDomainItems() {
        // Given
        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(1L);
        domainItems.setName("New DomainItems");

        when(domainItemsRepository.save(domainItems)).thenReturn(domainItems);

        // When
        DomainItemsModel result = domainItemsService.saveDomainItems(domainItems);

        // Then
        assertNotNull(result);
        assertEquals("New DomainItems", result.getName());
        verify(domainItemsRepository, times(1)).save(domainItems);
    }

    @Test
    void testUpdateDomainItems() {
        // Given
        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(1L);
        domainItems.setName("Updated DomainItems");

        when(domainItemsRepository.save(domainItems)).thenReturn(domainItems);

        // When
        DomainItemsModel result = domainItemsService.updateDomainItems(domainItems);

        // Then
        assertNotNull(result);
        assertEquals("Updated DomainItems", result.getName());
        verify(domainItemsRepository, times(1)).save(domainItems);
    }

    @Test
    void testDeleteDomainItems() {
        // Given
        DomainItemsModel domainItems = new DomainItemsModel();
        domainItems.setIdDomainItems(1L);

        doNothing().when(domainItemsRepository).delete(domainItems);

        // When
        domainItemsService.deleteDomainItems(domainItems);

        // Then
        verify(domainItemsRepository, times(1)).delete(domainItems);
    }

    @Test
    void testGetAllPageDomainItemss() {
        // Given
        DomainItemsModel domainItems1 = new DomainItemsModel();
        domainItems1.setIdDomainItems(1L);
        domainItems1.setName("DomainItems 1");

        DomainItemsModel domainItems2 = new DomainItemsModel();
        domainItems2.setIdDomainItems(2L);
        domainItems2.setName("DomainItems 2");

         Page<DomainItemsModel> page = new PageImpl<>(Arrays.asList(domainItems1, domainItems2));

        Pageable pageable = PageRequest.of(0, 10);
        Specification<DomainItemsModel> spec = mock(Specification.class);

        when(domainItemsRepository.findAll(spec, pageable)).thenReturn(page);
        Page<DomainItemsModel> result = domainItemsService.getAllPageDomainItems(spec, pageable);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals("DomainItems 1", result.getContent().get(0).getName());
        assertEquals("DomainItems 2", result.getContent().get(1).getName());

        verify(domainItemsRepository, times(1)).findAll(spec, pageable);
    }
}
