package br.com.arquitetura.spring.jpa.controllers;

import br.com.arquitetura.spring.jpa.dtos.RoleRecordDto;
import br.com.arquitetura.spring.jpa.dtos.RoleResponseDto;
import br.com.arquitetura.spring.jpa.globals.exceptionhandler.ResourceNotFoundException;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class RoleController {
    private static final String ERROR_ROLE_ID_NOTFOUND = "error.role.id.notfound";

    private final RoleService roleService;
    private final MessageSource messageSource;

    public RoleController(RoleService roleService, MessageSource messageSource) {
        this.roleService = roleService;
        this.messageSource = messageSource;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        List<RoleModel> rolesList = roleService.getAllRoles();
        List<RoleResponseDto> responseList = rolesList.stream()
                .map(this::mapToRoleResponseDto)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleResponseDto> getOneRole(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<RoleModel> roleOptional = roleService.getRoleById(id);
        if (roleOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_ROLE_ID_NOTFOUND ,
                    new Object[]{id},
                    locale
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapToRoleResponseDto(roleOptional.get()));
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleResponseDto> saveRole(@RequestBody @Valid RoleRecordDto roleRecordDto) {
        var roleModel = new RoleModel();
        BeanUtils.copyProperties(roleRecordDto, roleModel);
        RoleModel saveRole = roleService.saveRole(roleModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapToRoleResponseDto(saveRole));
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<RoleResponseDto> updateRole(@PathVariable(value = "id") Long id,
                                                      @RequestBody @Valid RoleRecordDto roleRecordDto, Locale locale) {
        Optional<RoleModel> roleOptional = roleService.getRoleById(id);
        if (roleOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_ROLE_ID_NOTFOUND ,
                    new Object[]{id},
                    locale
            );
        }
        var roleModel = roleOptional.get();
        BeanUtils.copyProperties(roleRecordDto, roleModel);
        RoleModel updateRole = roleService.updateRole(roleModel);

        return ResponseEntity.status(HttpStatus.OK).body(mapToRoleResponseDto(updateRole));
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") Long id, Locale locale) {
        Optional<RoleModel> roleOptional = roleService.getRoleById(id);
        if (roleOptional.isEmpty()) {
            throw ResourceNotFoundException.withMessage(
                    messageSource, ERROR_ROLE_ID_NOTFOUND ,
                    new Object[]{id},
                    locale
            );
        }
        roleService.deleteRole(roleOptional.get().getIdRole());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Role deleted successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private RoleResponseDto mapToRoleResponseDto(RoleModel roleModel) {
        return new RoleResponseDto(
                roleModel.getIdRole(),
                roleModel.getRoleName()
        );
    }
}
