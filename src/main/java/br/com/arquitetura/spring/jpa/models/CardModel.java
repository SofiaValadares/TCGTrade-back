package br.com.arquitetura.spring.jpa.models;

import br.com.arquitetura.spring.jpa.enums.CardRarityEnum;
import br.com.arquitetura.spring.jpa.enums.CardTypeEnum;
import br.com.arquitetura.spring.jpa.enums.CardVariantEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_CARDS")
public class CardModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCard;

    @Column(nullable = false)
    private String name;
    @ManyToOne()
    @JoinColumn(name = "idCollection", nullable = false)
    private CollectionModel collection;
    @Column(nullable = false)
    private Integer number;
    @Column(nullable = false)
    private CardTypeEnum type;
    private String overrideRotationLetter;
    @Column(nullable = false)
    private CardRarityEnum rarity;
    @ElementCollection(targetClass = CardVariantEnum.class)
    @CollectionTable(name = "TB_CARD_VARIANTS", joinColumns = @JoinColumn(name = "id_card"))
    @Column(name = "variant")
    @Enumerated(EnumType.STRING)
    private List<CardVariantEnum> variants;
    @Column(nullable = false)
    private String imageUrl;
    @ManyToOne()
    @JoinColumn(name = "idPokemon")
    private PokemonModel pokemonModel;

    public CardModel() {
    }

    public CardModel(String name, CollectionModel collection, Integer number, CardTypeEnum type, String overrideRotationLetter, CardRarityEnum rarity, List<CardVariantEnum> variants, String imageUrl) {
        this.name = name;
        this.collection = collection;
        this.number = number;
        this.type = type;
        this.overrideRotationLetter = overrideRotationLetter;
        this.rarity = rarity;
        this.variants = variants;
        this.imageUrl = imageUrl;
    }

    public CardModel(String name, CollectionModel collection, Integer number, CardTypeEnum type, CardRarityEnum rarity, List<CardVariantEnum> variants, String imageUrl) {
        this.name = name;
        this.collection = collection;
        this.number = number;
        this.type = type;
        this.rarity = rarity;
        this.variants = variants;
        this.imageUrl = imageUrl;
    }

    public CardModel(String name, CollectionModel collection, Integer number, CardTypeEnum type, String overrideRotationLetter, CardRarityEnum rarity, List<CardVariantEnum> variants, String imageUrl, PokemonModel pokemonModel) {
        this.name = name;
        this.collection = collection;
        this.number = number;
        this.type = type;
        this.overrideRotationLetter = overrideRotationLetter;
        this.rarity = rarity;
        this.variants = variants;
        this.imageUrl = imageUrl;
        this.pokemonModel = pokemonModel;
    }

    public CardModel(String name, CollectionModel collection, Integer number, CardTypeEnum type, CardRarityEnum rarity, List<CardVariantEnum> variants, String imageUrl, PokemonModel pokemonModel) {
        this.name = name;
        this.collection = collection;
        this.number = number;
        this.type = type;
        this.rarity = rarity;
        this.variants = variants;
        this.imageUrl = imageUrl;
        this.pokemonModel = pokemonModel;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollectionModel getCollection() {
        return collection;
    }

    public void setCollection(CollectionModel collection) {
        this.collection = collection;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public CardTypeEnum getType() {
        return type;
    }

    public void setType(CardTypeEnum type) {
        this.type = type;
    }

    public String getRotationLetter() {
        if (overrideRotationLetter != null) {
            return overrideRotationLetter;
        } else {
            return collection.getDefaultRotationLetter();
        }
    }

    public void setRotationLetter(String overrideRotationLetter) {
        this.overrideRotationLetter = overrideRotationLetter;
    }

    public CardRarityEnum getRarity() {
        return rarity;
    }

    public void setRarity(CardRarityEnum rarity) {
        this.rarity = rarity;
    }

    public List<CardVariantEnum> getVariants() {
        return variants;
    }

    public void setVariants(List<CardVariantEnum> variants) {
        this.variants = variants;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PokemonModel getPokemonModel() {
        return pokemonModel;
    }

    public void setPokemonModel(PokemonModel pokemonModel) {
        this.pokemonModel = pokemonModel;
    }
}
