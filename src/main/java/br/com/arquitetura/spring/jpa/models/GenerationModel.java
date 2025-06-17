package br.com.arquitetura.spring.jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_GENERATION")
public class GenerationModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGeneration;

    @Column(nullable = false, unique = true)
    private Integer number;

    @Column(nullable = false)
    private String region;

    @OneToMany(mappedBy = "generation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PokemonModel> pokemonModels;

    public GenerationModel() {
    }

    public GenerationModel(Long idGeneration, Integer number, String region) {
        this.idGeneration = idGeneration;
        this.number = number;
        this.region = region;
    }

    public Long getIdGeneration() {
        return idGeneration;
    }

    public void setIdGeneration(Long idPokemon) {
        this.idGeneration= idPokemon;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<PokemonModel> getPokemonModels() {
        return pokemonModels;
    }

    public void setPokemonModels(List<PokemonModel> pokemonModels) {
        this.pokemonModels = pokemonModels;
    }
}
