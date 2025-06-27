package br.com.arquitetura.spring.jpa.data.collections;

import br.com.arquitetura.spring.jpa.enums.CardLanguageEnum;
import br.com.arquitetura.spring.jpa.enums.CardRarityEnum;
import br.com.arquitetura.spring.jpa.enums.CardVariantEnum;
import br.com.arquitetura.spring.jpa.enums.CardTypeEnum;
import br.com.arquitetura.spring.jpa.models.CardModel;
import br.com.arquitetura.spring.jpa.models.CollectionModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;
import br.com.arquitetura.spring.jpa.repositories.PokemonRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Swsh12PtbrCollectionInitializer {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static CollectionModel collection;

    private static PokemonRepository pokemonRepository;

    public static void setPokemonRepository(PokemonRepository repo) {
        pokemonRepository = repo;
    }

    public static CollectionModel getCollection() {
        try {
            if (collection == null) {
                collection = new CollectionModel(
                        "Tempestade Prateada",
                        "Espada e Escudo",
                        CardLanguageEnum.PT_BR,
                        "swsh12",
                        "SIT",
                        sdf.parse("2022-11-11"),
                        215,
                        "https://images.pokemontcg.io/swsh12/symbol.png",
                        "https://images.pokemontcg.io/swsh12/logo.png",
                        "F"
                );
            }
            return collection;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<CardModel> getCards() {
        List<CardModel> cards = new ArrayList<>();

        cards.add(buildCard(
            "Venonat", 1, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_1.png",
                48
        ));

        cards.add(buildCard(
                "Venomoth", 2, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_2.png",
                49
        ));

        cards.add(buildCard(
                "Spinarak", 3, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_3.png",
                167
        ));

        cards.add(buildCard(
                "Ariados", 4, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_4.png",
                168
        ));

        cards.add(buildCard(
                "Sunkern", 5, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_5.png",
                191
        ));

        cards.add(buildCard(
                "Sunflora", 6, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_6.png",
                192
        ));

        cards.add(buildCard(
                "Serperior V", 7, CardTypeEnum.GRASS,
                CardRarityEnum.V,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_7.png",
                497
        ));

        cards.add(buildCard(
                "Serperior VASTRO", 8, CardTypeEnum.GRASS,
                CardRarityEnum.VASTRO,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_8.png",
                497
        ));

        cards.add(buildCard(
                "Petilil", 9, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_9.png",
                548
        ));

        cards.add(buildCard(
                "Liligant de Hisui", 10, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_10.png",
                549
        ));

        cards.add(buildCard(
                "Foongus", 11, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_11.png",
                590
        ));

        cards.add(buildCard(
                "Amoonguss", 12, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_12.png",
                591
        ));

        cards.add(buildCard(
                "Durant", 13, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_13.png",
                632
        ));

        cards.add(buildCard(
                "Virizion", 14, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_14.png",
                640
        ));

        cards.add(buildCard(
                "Chesnaught V", 15, CardTypeEnum.GRASS,
                CardRarityEnum.V,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_15.png",
                652
        ));

        cards.add(buildCard(
                "Tsareena Radiante", 16, CardTypeEnum.GRASS,
                CardRarityEnum.RADIANT,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH12/SWSH12_PT-BR_16.png",
                763
        ));

        return cards;
    }

    private static CardModel buildCard(
            String name,
            Integer number,
            CardTypeEnum type,
            CardRarityEnum rarity,
            List<CardVariantEnum> variants,
            String imageUrl
    ) {
        return new CardModel(name, collection, number, type, rarity, variants, imageUrl);
    }

    private static CardModel buildCard(
            String name,
            Integer number,
            CardTypeEnum type,
            String overrideRotationLetter,
            CardRarityEnum rarity,
            List<CardVariantEnum> variants,
            String imageUrl
    ) {
        return new CardModel(name, collection, number, type, overrideRotationLetter, rarity, variants, imageUrl);
    }

    private static CardModel buildCard(
            String name,
            Integer number,
            CardTypeEnum type,
            CardRarityEnum rarity,
            List<CardVariantEnum> variants,
            String imageUrl,
            int dexNumber
    ) {
        PokemonModel pokemon = pokemonRepository.findByNumber(dexNumber).orElse(null);
        return new CardModel(name, collection, number, type, rarity, variants, imageUrl, pokemon);
    }

    private static CardModel buildCard(
            String name,
            Integer number,
            CardTypeEnum type,
            String overrideRotationLetter,
            CardRarityEnum rarity,
            List<CardVariantEnum> variants,
            String imageUrl,
            int dexNumber
    ) {
        PokemonModel pokemon = pokemonRepository.findByNumber(dexNumber).orElse(null);
        return new CardModel(name, collection, number, type, overrideRotationLetter, rarity, variants, imageUrl, pokemon);
    }
}
