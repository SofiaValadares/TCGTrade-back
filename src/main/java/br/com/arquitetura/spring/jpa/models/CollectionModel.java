package br.com.arquitetura.spring.jpa.models;

import br.com.arquitetura.spring.jpa.enums.CardLanguageEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "TB_COLLECTION",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"code", "language"})
            }
)
public class CollectionModel extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCollection;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String series;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CardLanguageEnum language;
    @Column(nullable = false)
    private String code;
    private String ptcgoCode;
    @Column(nullable = false)
    private Date releaseDate;
    @Column(nullable = false)
    private Integer totalCards;
    @Column(nullable = false)
    private String symbolUrl;
    @Column(nullable = false)
    private String logoUrl;
    private String defaultRotationLetter;
    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardModel> cards;

    public CollectionModel() {
    }

    public CollectionModel(String name, String series, CardLanguageEnum language, String code, String ptcgoCode, Date releaseDate, Integer totalCards, String symbolUrl, String logoUrl, String defaultRotationLetter) {
        this.name = name;
        this.series = series;
        this.language = language;
        this.code = code;
        this.ptcgoCode = ptcgoCode;
        this.releaseDate = releaseDate;
        this.totalCards = totalCards;
        this.symbolUrl = symbolUrl;
        this.logoUrl = logoUrl;
        this.defaultRotationLetter = defaultRotationLetter;
    }

    public CollectionModel(String name, String series, CardLanguageEnum language, String code, String ptcgoCode, Date releaseDate, Integer totalCards, String symbolUrl, String logoUrl) {
        this.name = name;
        this.series = series;
        this.language = language;
        this.code = code;
        this.ptcgoCode = ptcgoCode;
        this.releaseDate = releaseDate;
        this.totalCards = totalCards;
        this.symbolUrl = symbolUrl;
        this.logoUrl = logoUrl;
    }

    public CollectionModel(String name, String series, CardLanguageEnum language, String code, Date releaseDate, Integer totalCards, String symbolUrl, String logoUrl) {
        this.name = name;
        this.series = series;
        this.language = language;
        this.code = code;
        this.ptcgoCode = ptcgoCode;
        this.releaseDate = releaseDate;
        this.totalCards = totalCards;
        this.symbolUrl = symbolUrl;
        this.logoUrl = logoUrl;
    }

    public Long getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(Long idCollection) {
        this.idCollection = idCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public CardLanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(CardLanguageEnum language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPtcgoCode() {
        return ptcgoCode;
    }

    public void setPtcgoCode(String ptcgoCode) {
        this.ptcgoCode = ptcgoCode;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(Integer totalCards) {
        this.totalCards = totalCards;
    }

    public String getSymbolUrl() {
        return symbolUrl;
    }

    public void setSymbolUrl(String symbolUrl) {
        this.symbolUrl = symbolUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDefaultRotationLetter() {
        return defaultRotationLetter;
    }

    public void setDefaultRotationLetter(String defaultRotationLetter) {
        this.defaultRotationLetter = defaultRotationLetter;
    }

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }
}
