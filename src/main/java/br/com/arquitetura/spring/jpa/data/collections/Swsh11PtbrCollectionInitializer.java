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

public class Swsh11PtbrCollectionInitializer {

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
                        "Origem Perdida",
                        "Espada e Escudo",
                        CardLanguageEnum.PT_BR,
                        "swsh11",
                        "LOR",
                        sdf.parse("2022-09-09"),
                        247,
                        "https://images.pokemontcg.io/swsh11/symbol.png",
                        "https://images.pokemontcg.io/swsh11/logo.png",
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
            "Oddish", 1, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_1.png",
                43
        ));

        cards.add(buildCard(
                "Gloom", 2, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_2.png",
                44
        ));

        cards.add(buildCard(
                "Vileplume", 3, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_3.png",
                45
        ));

        cards.add(buildCard(
                "Paras", 4, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_4.png",
                46
        ));

        cards.add(buildCard(
                "Parasect", 5, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_5.png",
                47
        ));

        cards.add(buildCard(
                "Wurmple", 6, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_6.png",
                265
        ));

        cards.add(buildCard(
                "Silcoon", 7, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_7.png",
                266
        ));

        cards.add(buildCard(
                "Beautifly", 8, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_8.png",
                267
        ));

        cards.add(buildCard(
                "Cascoon", 9, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_9.png",
                268
        ));

        cards.add(buildCard(
                "Dustox", 10, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_10.png",
                269
        ));

        cards.add(buildCard(
                "Seedot", 11, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_11.png",
                273
        ));

        cards.add(buildCard(
                "Nuzleaf", 12, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_12.png",
                274
        ));

        cards.add(buildCard(
                "Shiftry", 13, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_13.png",
                274
        ));

        cards.add(buildCard(
                "Roselia", 14, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_14.png",
                315
        ));

        cards.add(buildCard(
                "Roserade", 15, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_15.png",
                407
        ));

        cards.add(buildCard(
                "Phantump", 16, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_16.png",
                708
        ));


        cards.add(buildCard(
                "Trevenant", 17, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_17.png",
                709
        ));

        cards.add(buildCard(
                "Blipbug", 18, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_18.png",
                824
        ));

        cards.add(buildCard(
                "Dottler", 19, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_19.png",
                825
        ));

        cards.add(buildCard(
                "Orbeetle", 20, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SWSH11/SWSH11_PT-BR_20.png",
                826
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
