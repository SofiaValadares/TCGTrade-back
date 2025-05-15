package br.com.arquitetura.spring.jpa.models;

import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "TB_ROLES", indexes = {@Index(name = "idx_role_name", columnList = "roleName")})
public class RoleModel extends AuditModel implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    @Enumerated(EnumType.STRING)
    @Column(length = 200, nullable = false, unique = true, columnDefinition = "varchar(200)")
    private RoleNameEnum roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public RoleNameEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleNameEnum roleName) {
        this.roleName = roleName;
    }
}

