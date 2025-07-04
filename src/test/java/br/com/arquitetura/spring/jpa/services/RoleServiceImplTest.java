package br.com.arquitetura.spring.jpa.services;

import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.repositories.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static br.com.arquitetura.spring.jpa.enums.RoleNameEnum.ROLE_USER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRoles() {
        // Given
        RoleModel role1 = new RoleModel();
        role1.setIdRole(1L);
        role1.setRoleName(ROLE_USER);


        List<RoleModel> roleList = List.of(role1);
        when(roleRepository.findAll()).thenReturn(roleList);

        // When
        List<RoleModel> result = roleService.getAllRoles();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(ROLE_USER, result.get(0).getRoleName());
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    void testGetRoleByIdRole_Found() {
        // Given
        Long id = 1L;
        RoleModel role = new RoleModel();
        role.setIdRole(id);
        role.setRoleName(ROLE_USER);
        when(roleRepository.findById(id)).thenReturn(Optional.of(role));

        // When
        Optional<RoleModel> result = roleService.getRoleById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals(ROLE_USER, result.get().getRoleName());
        verify(roleRepository, times(1)).findById(id);
    }

    @Test
    void testGetRoleByIdRole_NotFound() {
        // Given
        Long id = 1L;
        when(roleRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<RoleModel> result = roleService.getRoleById(id);

        // Then
        assertFalse(result.isPresent());
        verify(roleRepository, times(1)).findById(id);
    }

    @Test
    void testGetRoleByNameRole_Found() {
        // Given
        RoleModel role = new RoleModel();
        role.setIdRole(1L);
        role.setRoleName(ROLE_USER);
        when(roleRepository.findByRoleName(ROLE_USER)).thenReturn(Optional.of(role));

        // When
        Optional<RoleModel> result = roleService.getRoleByRoleName(ROLE_USER);

        // Then
        assertTrue(result.isPresent());
        assertEquals(ROLE_USER, result.get().getRoleName());
        verify(roleRepository, times(1)).findByRoleName(ROLE_USER);
    }

    @Test
    void testGetRoleByNameRole_NotFound() {
        // Given
        Long id = 1L;
        when(roleRepository.findByRoleName(ROLE_USER)).thenReturn(Optional.empty());

        // When
        Optional<RoleModel> result = roleService.getRoleByRoleName(ROLE_USER);

        // Then
        assertFalse(result.isPresent());
        verify(roleRepository, times(1)).findByRoleName(ROLE_USER);
    }

    @Test
    void testSaveRole() {
        // Given
        RoleModel role = new RoleModel();
        role.setIdRole(1L);
        role.setRoleName(ROLE_USER);
        when(roleRepository.save(role)).thenReturn(role);

        // When
        RoleModel result = roleService.saveRole(role);

        // Then
        assertNotNull(result);
        assertEquals(ROLE_USER, result.getRoleName());
        verify(roleRepository, times(1)).save(role);
    }

    @Test
    void testUpdateRole() {
        // Given
        RoleModel role = new RoleModel();
        role.setIdRole(1L);
        role.setRoleName(ROLE_USER);

        when(roleRepository.save(role)).thenReturn(role);

        // When
        RoleModel result = roleService.updateRole(role);

        // Then
        assertNotNull(result);
        assertEquals(ROLE_USER, result.getRoleName());
        verify(roleRepository, times(1)).save(role);
    }

    @Test
    void testDeleteRole() {
        // Given
        Long roleId = 1L;

        // When
        roleService.deleteRole(roleId);

        // Then
        verify(roleRepository, times(1)).deleteById(roleId);
    }
}
