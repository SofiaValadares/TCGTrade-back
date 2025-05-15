package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.RoleRecordDto;
import br.com.arquitetura.spring.jpa.dtos.RoleResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.services.RoleService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static br.com.arquitetura.spring.jpa.enums.RoleNameEnum.ROLE_GUEST;
import static br.com.arquitetura.spring.jpa.enums.RoleNameEnum.ROLE_USER;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RoleControllerTest {
    @Mock
    private RoleService roleService;

    @Mock
    private Root<RoleModel> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private RoleController roleController;

    Validator validator;
    private Locale locale;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        locale = Locale.getDefault();
    }

    @Test
    public void testGetAllRoles_Success() {
        // Arrange
        RoleModel role1 = new RoleModel();
        RoleModel role2 = new RoleModel();
        role1.setIdRole(1L);
        role1.setRoleName(ROLE_USER);

        role2.setIdRole(2L);
        role2.setRoleName(ROLE_GUEST);

        when(roleService.getAllRoles()).thenReturn(Arrays.asList(role1, role2));

        // Act
        ResponseEntity<List<RoleResponseDto>> response = roleController.getAllRoles();

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals(ROLE_USER, response.getBody().get(0).roleName());
    }

    @Test
    public void testGetOneRole_Found() {
        // Arrange
        RoleModel role = new RoleModel();
        role.setIdRole(1L);
        role.setRoleName(ROLE_USER);

        when(roleService.getRoleById(1L)).thenReturn(Optional.of(role));

        // Act
        ResponseEntity<RoleResponseDto> response = roleController.getOneRole(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(ROLE_USER, Objects.requireNonNull(response.getBody()).roleName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetOneRole_NotFound() {
        // Arrange
        when(roleService.getRoleById(1L)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.role.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Role not found with id 1");

        // Act
        roleController.getOneRole(1L, locale);
    }

    @Test
    public void testSaveRole_Success() {
        // Arrange
        RoleRecordDto roleDto = new RoleRecordDto(ROLE_USER);

        RoleModel savedRole = new RoleModel();
        savedRole.setIdRole(1L);
        savedRole.setRoleName(ROLE_USER);

        when(roleService.saveRole(any(RoleModel.class))).thenReturn(savedRole);

        // Act
        ResponseEntity<RoleResponseDto> response = roleController.saveRole(roleDto);

        // Assert
        assertEquals(201, response.getStatusCode().value());
        assertEquals(ROLE_USER, Objects.requireNonNull(response.getBody()).roleName());
    }

    @Test
    public void testUpdateRole_Success() {
        // Arrange
        Long roleId = 1L;
        RoleRecordDto roleDto = new RoleRecordDto(ROLE_GUEST);
        RoleModel existingRole = new RoleModel();
        existingRole.setIdRole(1L);
        existingRole.setRoleName(ROLE_USER);

        when(roleService.getRoleById(roleId)).thenReturn(Optional.of(existingRole));
        when(roleService.updateRole(any(RoleModel.class))).thenReturn(existingRole);

        // Act
        ResponseEntity<RoleResponseDto> response = roleController.updateRole(roleId, roleDto, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(ROLE_GUEST, Objects.requireNonNull(response.getBody()).roleName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateRole_NotFound() {
        // Arrange
        Long nonExistentRoleId = 1L;
        RoleRecordDto roleDto = new RoleRecordDto(ROLE_USER);

        when(roleService.getRoleById(nonExistentRoleId)).thenReturn(Optional.empty());

        // Act
        roleController.updateRole(nonExistentRoleId, roleDto, locale);
    }

    @Test
    public void testUpdateRole_NotFound_Response() {
        // Arrange
        Long nonExistentRoleId = 1L;
        RoleRecordDto roleDto = new RoleRecordDto(ROLE_USER);
        when(roleService.getRoleById(nonExistentRoleId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.role.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Role not found with id 1");

        try {
            // Act
            roleController.updateRole(nonExistentRoleId, roleDto, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Role not found with id " + nonExistentRoleId, ex.getMessage());
        }
    }

    @Test
    public void testDeleteRole_Success() {
        // Arrange
        RoleModel role = new RoleModel();
        role.setIdRole(1L);
        when(roleService.getRoleById(1L)).thenReturn(Optional.of(role));
        doNothing().when(roleService).deleteRole(role.getIdRole());

        // Act
        ResponseEntity<Object> response = roleController.deleteRole(1L, locale);

        // Assert
        assertEquals(200, response.getStatusCode().value());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteRole_NotFound() {
        // Arrange
        Long nonExistentRoleId = 1L;
        when(roleService.getRoleById(nonExistentRoleId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.role.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Role not found with id 1");

        // Act
        roleController.deleteRole(nonExistentRoleId, locale);
    }

    @Test
    public void testDeleteRole_NotFound_Response() {
        // Arrange
        Long nonExistentRoleId = 1L;
        when(roleService.getRoleById(nonExistentRoleId)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.role.id.notfound"), any(Object[].class), eq(locale)))
                .thenReturn("Role not found with id 1");

        try {
            // Act
            roleController.deleteRole(nonExistentRoleId, locale);
        } catch (ResourceNotFoundException ex) {
            // Assert
            assertEquals("Role not found with id " + nonExistentRoleId, ex.getMessage());
        }
    }

}
