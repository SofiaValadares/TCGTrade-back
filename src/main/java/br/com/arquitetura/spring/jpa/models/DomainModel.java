package br.com.arquitetura.spring.jpa.models;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_DOMAIN")
public class DomainModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDomain;

    @Size(max = 100)
    @Column(length = 100, nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Size(max = 250)
    @Column(length = 250, nullable = true, columnDefinition = "varchar(250)")
    private String description;

    @Column(nullable = false)
    private Boolean enabled = Boolean.TRUE;


    @OneToMany(mappedBy = "domainModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<DomainItemsModel> domainItems = new ArrayList<>();

    public void setDomainItems(List<DomainItemsModel> domainItems) {
        this.domainItems.clear();
        if (domainItems != null) {
            this.domainItems.addAll(domainItems);
        }
    }

    public List<DomainItemsModel> getDomainItems() {
        return domainItems;
    }

    public Long getIdDomain() {
        return idDomain;
    }

    public void setIdDomain(Long idDomain) {
        this.idDomain = idDomain;
    }

    public @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@Size(max = 100) String name) {
        this.name = name;
    }

    public @Size(max = 250) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 250) String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
