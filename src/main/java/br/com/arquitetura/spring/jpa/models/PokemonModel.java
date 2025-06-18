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
    private Integer number;

    @Column(nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "idGeneration", nullable = false)
    private GenerationModel generation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PokemonTypeEnum primaryType;

    @Enumerated(EnumType.STRING)
    private PokemonTypeEnum secondaryType;

    private String imageUrl;

    @OneToMany(mappedBy = "pokemonModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardModel> cardModels;

    public Long getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public GenerationModel getGeneration() {
        return generation;
    }

    public void setGeneration(GenerationModel generation) {
        this.generation = generation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PokemonTypeEnum getPrimaryType() { return primaryType; }

    public void setPrimaryType(PokemonTypeEnum primaryType) { this.primaryType = primaryType; }

    public PokemonTypeEnum getSecondaryType() { return secondaryType; }

    public void setSecondaryType(PokemonTypeEnum secondaryType) { this.secondaryType = secondaryType; }

    public List<CardModel> getCardModels() {
        return cardModels;
    }

    public void setCardModels(List<CardModel> cardModels) {
        this.cardModels = cardModels;
    }

    public PokemonModel() {}

    public PokemonModel(Long idPokemon, Integer number, String name, PokemonTypeEnum primaryType, PokemonTypeEnum secondaryType, String imageUrl) {
        this.idPokemon = idPokemon;
        this.number = number;
        this.name = name.toUpperCase();
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.imageUrl = imageUrl;
    }

    public PokemonModel(Integer number, String name, GenerationModel generation, PokemonTypeEnum primaryType, PokemonTypeEnum secondaryType, String imageUrl) {
        this.number = number;
        this.name = name.toUpperCase();
        this.generation = generation;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.imageUrl = imageUrl;
    }
}
