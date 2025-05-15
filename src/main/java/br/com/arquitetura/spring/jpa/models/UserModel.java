package br.com.arquitetura.spring.jpa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_USERS", indexes = {@Index(name = "idx_user_name", columnList = "name")},
        uniqueConstraints = {@UniqueConstraint(name = "idx_user_username", columnNames = "username")})
public class UserModel extends AuditModel implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Size(max = 100)
    @Column(length = 100, nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Size(max = 200)
    @Column(length = 200, nullable = true,unique = true, columnDefinition = "varchar(200)")
    private String email;

    @Size(max = 15)
    @Column(length = 15, nullable = true, unique = true, columnDefinition = "varchar(15)")
    private String telefone;

    @Size(max = 20)
    @Column(length = 20, nullable = false, unique = true, columnDefinition = "varchar(20)")
    private String username;

    @Size(max = 200)
    @Column(length = 200, nullable = false, columnDefinition = "varchar(200)")
    private String password;

    @Column(nullable = false)
    private Boolean accountNonExpired = Boolean.TRUE;

    @Column(nullable = false)
    private Boolean accountNonLocked = Boolean.TRUE;

    @Column(nullable = false)
    private Boolean credentialsNonExpired = Boolean.TRUE;

    @Column(nullable = false)
    private Boolean enabled = Boolean.TRUE;

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<RoleModel> roles = new HashSet<>();

    public void setRoles(Set<RoleModel> roles) {
        this.roles.clear();
        if (roles != null) {
            this.roles.addAll(roles);
        }
    }

    public @Size(max = 15) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Size(max = 15) String telefone) {
        this.telefone = telefone;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@Size(max = 100) String name) {
        this.name = name;
    }

    public @Size(max = 200) String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 200) String email) {
        this.email = email;
    }

    public @Size(max = 20) String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setUsername(@Size(max = 20) String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    public @Size(max = 200) String getPassword() {
        return password;
    }

    public void setPassword(@Size(max = 200) String password) {
        this.password = password;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public static class LoginRequest {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
