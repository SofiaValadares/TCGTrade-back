package br.com.arquitetura.spring.jpa.models;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_POKEMON")
public class PokemonModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPokemon;

    @Column(nullable = false, unique = true)
    private Integer numPokemon;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PokemonTypeEnum primaryType;

    @Enumerated(EnumType.STRING)
    private PokemonTypeEnum secondaryType;

    public Long getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Integer getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(Integer numPokemon) {
        this.numPokemon = numPokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonTypeEnum getPrimaryType() { return primaryType; }

    public void setPrimaryType(PokemonTypeEnum primaryType) { this.primaryType = primaryType; }

    public PokemonTypeEnum getSecondaryType() { return secondaryType; }

    public void setSecondaryType(PokemonTypeEnum secondaryType) { this.secondaryType = secondaryType; }

    public PokemonModel() {}

    public PokemonModel(Long idPokemon, Integer numPokemon, String name, PokemonTypeEnum primaryType, PokemonTypeEnum secondaryType) {
        this.idPokemon = idPokemon;
        this.numPokemon = numPokemon;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }
}
