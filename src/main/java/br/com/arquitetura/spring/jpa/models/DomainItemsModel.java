package br.com.arquitetura.spring.jpa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "TB_DOMAIN_ITEMS", indexes = {@Index(name = "idx_domain_items_name", columnList = "name")})
public class DomainItemsModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDomainItems;

    @ManyToOne
    @JoinColumn(name = "idDomain", nullable = false)
    private DomainModel domainModel;

    @Size(max = 15)
    @Column(length = 15, nullable = false, columnDefinition = "varchar(15)")
    private String codDomainItems;

    @Size(max = 200)
    @Column(length = 200, nullable = false, columnDefinition = "varchar(200)")
    private String name;

    @Column(nullable = false)
    private Boolean enabled = Boolean.TRUE;


    public Long getIdDomainItems() {
        return idDomainItems;
    }

    public void setIdDomainItems(Long idDomainItems) {
        this.idDomainItems = idDomainItems;
    }

    public @Size(max = 15) String getCodDomainItems() {
        return codDomainItems;
    }

    public void setCodDomainItems(@Size(max = 15) String codDomainItems) {
        this.codDomainItems = codDomainItems;
    }

    public @Size(max = 200) String getName() {
        return name;
    }

    public void setName(@Size(max = 200) String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public DomainModel getDomainModel() {
        return domainModel;
    }

    public void setDomainModel(DomainModel domainModel) {
        this.domainModel = domainModel;
    }
}
