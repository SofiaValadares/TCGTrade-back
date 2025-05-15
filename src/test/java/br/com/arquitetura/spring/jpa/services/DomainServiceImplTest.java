package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.models.ProductModel;
import br.com.arquitetura.spring.jpa.repositories.DomainRepository;
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

class DomainServiceImplTest {

    @InjectMocks
    private DomainServiceImpl domainService;

    @Mock
    private DomainRepository domainRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDomains() {
        // Given
        DomainModel domain1 = new DomainModel();
        domain1.setIdDomain(1L);
        domain1.setName("Domain 1");

        DomainModel domain2 = new DomainModel();
        domain2.setIdDomain(2L);
        domain2.setName("Domain 2");

        List<DomainModel> domainList = List.of(domain1, domain2);
        when(domainRepository.findAll()).thenReturn(domainList);

        // When
        List<DomainModel> result = domainService.getAllDomains();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Domain 1", result.get(0).getName());
        verify(domainRepository, times(1)).findAll();
    }

    @Test
    void testGetOneDomain_Found() {
        // Given
        Long id = 1L;
        DomainModel domain = new DomainModel();
        domain.setIdDomain(id);
        domain.setName("Test Domain");

        when(domainRepository.findById(id)).thenReturn(Optional.of(domain));

        // When
        Optional<DomainModel> result = domainService.getOneDomain(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals("Test Domain", result.get().getName());
        verify(domainRepository, times(1)).findById(id);
    }

    @Test
    void testGetOneDomain_NotFound() {
        // Given
        Long id = 1L;

        when(domainRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<DomainModel> result = domainService.getOneDomain(id);

        // Then
        assertFalse(result.isPresent());
        verify(domainRepository, times(1)).findById(id);
    }

    @Test
    void testSaveDomain() {
        // Given
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);
        domain.setName("New Domain");

        when(domainRepository.save(domain)).thenReturn(domain);

        // When
        DomainModel result = domainService.saveDomain(domain);

        // Then
        assertNotNull(result);
        assertEquals("New Domain", result.getName());
        verify(domainRepository, times(1)).save(domain);
    }

    @Test
    void testUpdateDomain() {
        // Given
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);
        domain.setName("Updated Domain");

        when(domainRepository.save(domain)).thenReturn(domain);

        // When
        DomainModel result = domainService.updateDomain(domain);

        // Then
        assertNotNull(result);
        assertEquals("Updated Domain", result.getName());
        verify(domainRepository, times(1)).save(domain);
    }

    @Test
    void testDeleteDomain() {
        // Given
        DomainModel domain = new DomainModel();
        domain.setIdDomain(1L);

        doNothing().when(domainRepository).delete(domain);

        // When
        domainService.deleteDomain(domain);

        // Then
        verify(domainRepository, times(1)).delete(domain);
    }

    @Test
    void testGetAllPageProducts() {
        DomainModel domain1 = new DomainModel();
        domain1.setIdDomain(1L);
        domain1.setName("Domain 1");
        domain1.setDescription("Domain description 1");

        DomainModel domain2 = new DomainModel();
        domain2.setIdDomain(2L);
        domain2.setName("Domain 2");
        domain2.setDescription("Domain description 2");

        Page<DomainModel> page = new PageImpl<>(Arrays.asList(domain1, domain2));

        Pageable pageable = PageRequest.of(0, 10);
        Specification<DomainModel> spec = mock(Specification.class);

        when(domainRepository.findAll(spec, pageable)).thenReturn(page);

        Page<DomainModel> result = domainService.getAllPageDomains(spec, pageable);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals("Domain 1", result.getContent().get(0).getName());
        assertEquals("Domain 2", result.getContent().get(1).getName());

        verify(domainRepository, times(1)).findAll(spec, pageable);
    }

}
