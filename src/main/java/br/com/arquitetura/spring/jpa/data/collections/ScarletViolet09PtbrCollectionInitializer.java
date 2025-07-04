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

public class ScarletViolet09PtbrCollectionInitializer implements CollectionInitializer {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static CollectionModel collection;

    private static PokemonRepository pokemonRepository;

    @Override
    public void setPokemonRepository(PokemonRepository repo) {
        pokemonRepository = repo;
    }

    @Override
    public CollectionModel getCollection() {
        try {
            if (collection == null) {
                collection = new CollectionModel(
                    "Amigos de Jornada",
                    "Escarlate e Violeta",
                    CardLanguageEnum.PT_BR,
                    "sv9",
                    "JGT",
                    sdf.parse("2025-03-28"),
                    190,
                    "https://images.pokemontcg.io/sv9/symbol.png",
                    "https://images.pokemontcg.io/sv9/logo.png",
                    "I"
                );
            }
            return collection;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<CardModel> getCards() {
        List<CardModel> cards = new ArrayList<>();

        cards.add(buildCard(
                    "Caterpie", 1, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_1.png",
                        10
                ));

        cards.add(buildCard(
                    "Metapod", 2, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_2.png",
                        11
                ));

        cards.add(buildCard(
                    "Butterfree", 3, CardTypeEnum.GRASS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_3.png",
                        12
                ));

        cards.add(buildCard(
                    "Paras", 4, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_4.png",
                        46
                ));

        cards.add(buildCard(
                    "Parasect", 5, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_5.png",
                        47
                ));

        cards.add(buildCard(
                    "Petilil", 6, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_6.png",
                        548
                ));

        cards.add(buildCard(
                    "Lilligant", 7, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_7.png",
                        549
                ));

        cards.add(buildCard(
                    "Maractus", 8, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_8.png",
                        556
                ));

        cards.add(buildCard(
                    "Karrablast", 9, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_9.png",
                        588
                ));

        cards.add(buildCard(
                    "Foongus", 10, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_10.png",
                        590
                ));

        cards.add(buildCard(
                    "Amoonguss ex", 11, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_11.png",
                        591
                ));

        cards.add(buildCard(
                    "Shelmet", 12, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_12.png",
                        616
                ));

        cards.add(buildCard(
                    "Accelgor", 13, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_13.png",
                        617
                ));

        cards.add(buildCard(
                    "Durant", 14, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_14.png",
                        632
                ));

        cards.add(buildCard(
                    "Virizion", 15, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_15.png",
                        640
                ));

        cards.add(buildCard(
                    "Sprigatito", 16, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_16.png",
                        906
                ));

        cards.add(buildCard(
                    "Floragato", 17, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_17.png",
                        907
                ));

        cards.add(buildCard(
                    "Meowscarada", 18, CardTypeEnum.GRASS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_18.png",
                        908
                ));

        cards.add(buildCard(
                    "Nymble", 19, CardTypeEnum.GRASS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_19.png",
                        919
                ));

        cards.add(buildCard(
                    "Magmar", 20, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_20.png",
                        126
                ));

        cards.add(buildCard(
                    "Magmortar", 21, CardTypeEnum.FIRE, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_21.png",
                        467
                ));

        cards.add(buildCard(
                    "Torchic", 22, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_22.png",
                        255
                ));

        cards.add(buildCard(
                    "Combusken", 23, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_23.png",
                        256
                ));

        cards.add(buildCard(
                    "Blaziken ex", 24, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_24.png",
                        257
                ));

        cards.add(buildCard(
                    "Torkoal", 25, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_25.png",
                        324
                ));

        cards.add(buildCard(
                    "Darumaka do N", 26, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_26.png",
                        554
                ));

        cards.add(buildCard(
                    "Darmanitan do N", 27, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_27.png",
                        555
                ));

        cards.add(buildCard(
                    "Larvesta", 28, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_28.png",
                        636
                ));

        cards.add(buildCard(
                    "Volcarona", 29, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_29.png",
                        637
                ));

        cards.add(buildCard(
                    "Reshiram ex", 30, CardTypeEnum.FIRE, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_30.png",
                        643
                ));

        cards.add(buildCard(
                    "Volcanion ex", 31, CardTypeEnum.FIRE, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_31.png",
                        721
                ));

        cards.add(buildCard(
                    "Articuno", 32, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_32.png",
                        144
                ));

        cards.add(buildCard(
                    "Remoraid", 33, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_33.png",
                        223
                ));

        cards.add(buildCard(
                    "Octillery", 34, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_34.png",
                        224
                ));

        cards.add(buildCard(
                    "Lotad", 35, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_35.png",
                        270
                ));

        cards.add(buildCard(
                    "Lombre", 36, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_36.png",
                        271
                ));

        cards.add(buildCard(
                    "Ludicolo", 37, CardTypeEnum.WATER, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_37.png",
                        272
                ));

        cards.add(buildCard(
                    "Wingull", 38, CardTypeEnum.WATER, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_38.png",
                        278
                ));

        cards.add(buildCard(
                    "Pelipper", 39, CardTypeEnum.WATER, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_39.png",
                        279
                ));

        cards.add(buildCard(
                    "Wailmer", 40, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_40.png",
                        320
                ));

        cards.add(buildCard(
                    "Wailord", 41, CardTypeEnum.WATER, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_41.png",
                        321
                ));

        cards.add(buildCard(
                    "Regice", 42, CardTypeEnum.WATER, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_42.png",
                        378
                ));

        cards.add(buildCard(
                    "Veluza ex", 43, CardTypeEnum.WATER, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_43.png",
                        976
                ));

        cards.add(buildCard(
                    "Geodude de Alola", 44, CardTypeEnum.ELECTRIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_44.png",
                        74
                ));

        cards.add(buildCard(
                    "Graveler de Alola", 45, CardTypeEnum.ELECTRIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_45.png",
                        75
                ));

        cards.add(buildCard(
                    "Golem de Alola", 46, CardTypeEnum.ELECTRIC, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_46.png",
                        76
                ));

        cards.add(buildCard(
                    "Voltorb da Kissera", 47, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_47.png",
                        100
                ));

        cards.add(buildCard(
                    "Electrode da Kissera", 48, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_48.png",
                        101
                ));

        cards.add(buildCard(
                    "Joltik do N", 49, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_49.png",
                        595
                ));

        cards.add(buildCard(
                    "Togedemaru", 50, CardTypeEnum.ELECTRIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_50.png",
                        777
                ));

        cards.add(buildCard(
                    "Tapu Koko ex", 51, CardTypeEnum.ELECTRIC, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_51.png",
                        785
                ));

        cards.add(buildCard(
                    "Tadbulb da Kissera", 52, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_52.png",
                        938
                ));

        cards.add(buildCard(
                    "Bellibolt ex da Kissera", 53, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_53.png",
                        939
                ));

        cards.add(buildCard(
                    "Wattrel da Kissera", 54, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_54.png",
                        940
                ));

        cards.add(buildCard(
                    "Kilowattrel da Kissera", 55, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_55.png",
                        941
                ));

        cards.add(buildCard(
                    "Clefairy ex da Lílian", 56, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_56.png",
                        35
                ));

        cards.add(buildCard(
                    "Marowak de Alola", 57, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_57.png",
                        105
                ));

        cards.add(buildCard(
                    "Mr. Mime", 58, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_58.png",
                        122
                ));

        cards.add(buildCard(
                    "Shuppet", 59, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_59.png",
                        353
                ));

        cards.add(buildCard(
                    "Banette", 60, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_60.png",
                        354
                ));

        cards.add(buildCard(
                    "Beldum", 61, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_61.png",
                        374
                ));

        cards.add(buildCard(
                    "Metang", 62, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_62.png",
                        375
                ));

        cards.add(buildCard(
                    "Metagross", 63, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_63.png",
                        376
                ));

        cards.add(buildCard(
                    "Sigilyph do N", 64, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_64.png",
                        561
                ));

        cards.add(buildCard(
                    "Oricorio", 65, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_65.png",
                        741
                ));

        cards.add(buildCard(
                    "Cutiefly da Lílian", 66, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_66.png",
                        742
                ));

        cards.add(buildCard(
                    "Ribombee da Lílian", 67, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_67.png",
                        743
                ));

        cards.add(buildCard(
                    "Comfey da Lílian", 68, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_68.png",
                        764
                ));

        cards.add(buildCard(
                    "Mimikyu ex", 69, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_69.png",
                        778
                ));

        cards.add(buildCard(
                    "Dhelmise", 70, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_70.png",
                        781
                ));

        cards.add(buildCard(
                    "Impidimp", 71, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_71.png",
                        859
                ));

        cards.add(buildCard(
                    "Morgrem", 72, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_72.png",
                        860
                ));

        cards.add(buildCard(
                    "Grimmsnarl", 73, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_73.png",
                        861
                ));

        cards.add(buildCard(
                    "Milcery", 74, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_74.png",
                        868
                ));

        cards.add(buildCard(
                    "Alcremie ex", 75, CardTypeEnum.PSYCHIC, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_75.png",
                        869
                ));

        cards.add(buildCard(
                    "Cubone", 76, CardTypeEnum.FIGHTING, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_76.png",
                        104
                ));

        cards.add(buildCard(
                    "Swinub", 77, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_77.png",
                        220
                ));

        cards.add(buildCard(
                    "Piloswine", 78, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_78.png",
                        221
                ));

        cards.add(buildCard(
                    "Mamoswine ex", 79, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_79.png",
                        473
                ));

        cards.add(buildCard(
                    "Larvitar", 80, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_80.png",
                        246
                ));

        cards.add(buildCard(
                    "Pupitar", 81, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_81.png",
                        247
                ));

        cards.add(buildCard(
                    "Regirock", 82, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_82.png",
                        377
                ));

        cards.add(buildCard(
                    "Pancham", 83, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_83.png",
                        674
                ));

        cards.add(buildCard(
                    "Rockruff", 84, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_84.png",
                        744
                ));

        cards.add(buildCard(
                    "Lycanroc", 85, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_85.png",
                        745
                ));

        cards.add(buildCard(
                    "Silicobra do Lupo", 86, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_86.png",
                        843
                ));

        cards.add(buildCard(
                    "Sandaconda do Lupo", 87, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_87.png",
                        844
                ));

        cards.add(buildCard(
                    "Toedscool", 88, CardTypeEnum.FIGHTING, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_88.png",
                        948
                ));

        cards.add(buildCard(
                    "Toedscruel", 89, CardTypeEnum.FIGHTING, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_89.png",
                        949
                ));

        cards.add(buildCard(
                    "Klawf", 90, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_90.png",
                        950
                ));

        cards.add(buildCard(
                    "Koffing", 91, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_91.png",
                        109
                ));

        cards.add(buildCard(
                    "Weezing", 92, CardTypeEnum.DARK, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_92.png",
                        110
                ));

        cards.add(buildCard(
                    "Wooper de Paldea", 93, CardTypeEnum.DARK, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_93.png",
                        194
                ));

        cards.add(buildCard(
                    "Clodsire de Paldea ex", 94, CardTypeEnum.DARK, "H",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_94.png",
                        980
                ));

        cards.add(buildCard(
                    "Tyranitar", 95, CardTypeEnum.DARK, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_95.png",
                        248
                ));

        cards.add(buildCard(
                    "Purrloin do N", 96, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_96.png",
                        509
                ));

        cards.add(buildCard(
                    "Zorua do N", 97, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_97.png",
                        570
                ));

        cards.add(buildCard(
                    "Zoroark ex do N", 98, CardTypeEnum.DARK, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_98.png",
                        571
                ));

        cards.add(buildCard(
                    "Pangoro", 99, CardTypeEnum.DARK, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_99.png",
                        675
                ));

        cards.add(buildCard(
                    "Lokix", 100, CardTypeEnum.DARK, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_100.png",
                        920
                ));

        cards.add(buildCard(
                    "Bombirdier", 101, CardTypeEnum.DARK, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_101.png",
                        962
                ));

        cards.add(buildCard(
                    "Escavalier", 102, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_102.png",
                        589
                ));

        cards.add(buildCard(
                    "Klink do N", 103, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_103.png",
                        599
                ));

        cards.add(buildCard(
                    "Klang do N", 104, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_104.png",
                        600
                ));

        cards.add(buildCard(
                    "Klinklang do N", 105, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_105.png",
                        601
                ));

        cards.add(buildCard(
                    "Stunfisk de Galar", 106, CardTypeEnum.STEEL, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_106.png",
                        618
                ));

        cards.add(buildCard(
                    "Magearna", 107, CardTypeEnum.STEEL, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_107.png",
                        801
                ));

        cards.add(buildCard(
                    "Corviknight do Lupo", 108, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_108.png",
                        823
                ));

        cards.add(buildCard(
                    "Cufant", 109, CardTypeEnum.STEEL, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_109.png",
                        878
                ));

        cards.add(buildCard(
                    "Copperajah", 110, CardTypeEnum.STEEL, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_110.png",
                        879
                ));

        cards.add(buildCard(
                    "Zacian ex do Lupo", 111, CardTypeEnum.STEEL, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_111.png",
                        888
                ));

        cards.add(buildCard(
                    "Bagon", 112, CardTypeEnum.DRAGON, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_112.png",
                        371
                ));

        cards.add(buildCard(
                    "Shelgon", 113, CardTypeEnum.DRAGON, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_113.png",
                        372
                ));

        cards.add(buildCard(
                    "Salamence ex", 114, CardTypeEnum.DRAGON, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_114.png",
                        373
                ));

        cards.add(buildCard(
                    "Druddigon", 115, CardTypeEnum.DRAGON, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_115.png",
                        621
                ));

        cards.add(buildCard(
                    "Reshiram do N", 116, CardTypeEnum.DRAGON, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_116.png",
                        643
                ));

        cards.add(buildCard(
                    "Snorlax do Lupo", 117, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_117.png",
                        143
                ));

        cards.add(buildCard(
                    "Sentret", 118, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_118.png",
                        161
                ));

        cards.add(buildCard(
                    "Furret", 119, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_119.png",
                        162
                ));

        cards.add(buildCard(
                    "Dunsparce", 120, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_120.png",
                        206
                ));

        cards.add(buildCard(
                    "Dudunsparce ex", 121, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_121.png",
                        982
                ));

        cards.add(buildCard(
                    "Kecleon", 122, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_122.png",
                        352
                ));

        cards.add(buildCard(
                    "Tropius", 123, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_123.png",
                        357
                ));

        cards.add(buildCard(
                    "Audino", 124, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_124.png",
                        531
                ));

        cards.add(buildCard(
                    "Minccino", 125, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_125.png",
                        572
                ));

        cards.add(buildCard(
                    "Cinccino", 126, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_126.png",
                        573
                ));

        cards.add(buildCard(
                    "Noibat", 127, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_127.png",
                        714
                ));

        cards.add(buildCard(
                    "Noivern", 128, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_128.png",
                        715
                ));

        cards.add(buildCard(
                    "Komala", 129, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_129.png",
                        775
                ));

        cards.add(buildCard(
                    "Drampa", 130, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_130.png",
                        780
                ));

        cards.add(buildCard(
                    "Skwovet", 131, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_131.png",
                        819
                ));

        cards.add(buildCard(
                    "Greedent", 132, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_132.png",
                        820
                ));

        cards.add(buildCard(
                    "Rookidee do Lupo", 133, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_133.png",
                        821
                ));

        cards.add(buildCard(
                    "Corvisquire do Lupo", 134, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_134.png",
                        822
                ));

        cards.add(buildCard(
                    "Wooloo do Lupo", 135, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_135.png",
                        831
                ));

        cards.add(buildCard(
                    "Dubwool do Lupo", 136, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_136.png",
                        832
                ));

        cards.add(buildCard(
                    "Cramorant", 137, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_137.png",
                        845
                ));

        cards.add(buildCard(
                    "Cramorant do Lupo", 138, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_138.png",
                        845
                ));

        cards.add(buildCard(
                    "Lechonk", 139, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_139.png",
                        915
                ));

        cards.add(buildCard(
                    "Oinkologne", 140, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_140.png",
                        916
                ));

        cards.add(buildCard(
                    "Squawkabilly", 141, CardTypeEnum.COLORLESS, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_141.png",
                        931
                ));

        cards.add(buildCard(
                    "Abílio e Onara", 142, CardTypeEnum.SUPPORTER, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_142.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 143, CardTypeEnum.SUPPORTER, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_143.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 144, CardTypeEnum.SUPPORTER, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_144.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 145, CardTypeEnum.SUPPORTER, "H",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_145.png"
                ));

        cards.add(buildCard(
                    "Busca do Brock", 146, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_146.png"
                ));

        cards.add(buildCard(
                    "Bolsa do Lupo", 147, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_147.png"
                ));

        cards.add(buildCard(
                    "Faixa da Escolha do Lupo", 148, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_148.png"
                ));

        cards.add(buildCard(
                    "Espírito de Luta da Iris", 149, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_149.png"
                ));

        cards.add(buildCard(
                    "Levincia", 150, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_150.png"
                ));

        cards.add(buildCard(
                    "Pérola da Lílian", 151, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_151.png"
                ));

        cards.add(buildCard(
                    "Castelo do N", 152, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_152.png"
                ));

        cards.add(buildCard(
                    "PP Up do N", 153, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_153.png"
                ));

        cards.add(buildCard(
                    "Postwick", 154, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_154.png"
                ));

        cards.add(buildCard(
                    "Pesquisa de Professores", 155, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_155.png"
                ));

        cards.add(buildCard(
                    "Ingresso Resgatável", 156, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_156.png"
                ));

        cards.add(buildCard(
                    "Baderneiro", 157, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_157.png"
                ));

        cards.add(buildCard(
                    "Superpoção", 158, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_158.png"
                ));

        cards.add(buildCard(
                    "Energia Espinhosa", 159, CardTypeEnum.SPECIAL_ENERGY, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_159.png"
                ));

        cards.add(buildCard(
                    "Maractus", 160, CardTypeEnum.GRASS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_160.png",
                        556
                ));

        cards.add(buildCard(
                    "Articuno", 161, CardTypeEnum.WATER, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_161.png",
                        144
                ));

        cards.add(buildCard(
                    "Wailord", 162, CardTypeEnum.WATER, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_162.png",
                        321
                ));

        cards.add(buildCard(
                    "Kilowattrel da Kissera", 163, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_163.png",
                        941
                ));

        cards.add(buildCard(
                    "Ribombee da Lílian", 164, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_164.png",
                        743
                ));

        cards.add(buildCard(
                    "Swinub", 165, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_165.png",
                        220
                ));

        cards.add(buildCard(
                    "Lycanroc", 166, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_166.png",
                        745
                ));

        cards.add(buildCard(
                    "Reshiram do N", 167, CardTypeEnum.DRAGON, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_167.png",
                        643
                ));

        cards.add(buildCard(
                    "Furret", 168, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_168.png",
                        162
                ));

        cards.add(buildCard(
                    "Noibat", 169, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_169.png",
                        714
                ));

        cards.add(buildCard(
                    "Wooloo do Lupo", 170, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_170.png",
                        831
                ));

        cards.add(buildCard(
                    "Volcanion ex", 171, CardTypeEnum.FIRE, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_171.png",
                        721
                ));

        cards.add(buildCard(
                    "Bellibolt ex da Kissera", 172, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_172.png",
                        939
                ));

        cards.add(buildCard(
                    "Clefairy ex da Lílian", 173, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_173.png",
                        35
                ));

        cards.add(buildCard(
                    "Mamoswine ex", 174, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_174.png",
                        473
                ));

        cards.add(buildCard(
                    "Zoroark ex do N", 175, CardTypeEnum.DARK, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_175.png",
                        571
                ));

        cards.add(buildCard(
                    "Zacian ex do Lupo", 176, CardTypeEnum.STEEL, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_176.png",
                        888
                ));

        cards.add(buildCard(
                    "Salamence ex", 177, CardTypeEnum.DRAGON, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_177.png",
                        373
                ));

        cards.add(buildCard(
                    "Dudunsparce ex", 178, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_178.png",
                        982
                ));

        cards.add(buildCard(
                    "Busca do Brock", 179, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_179.png"
                ));

        cards.add(buildCard(
                    "Espírito de Luta da Iris", 180, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_180.png"
                ));

        cards.add(buildCard(
                    "Baderneiro", 181, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_181.png"
                ));

        cards.add(buildCard(
                    "Volcanion ex", 182, CardTypeEnum.FIRE, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_182.png",
                        721
                ));

        cards.add(buildCard(
                    "Bellibolt ex da Kissera", 183, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_183.png",
                        939
                ));

        cards.add(buildCard(
                    "Clefairy ex da Lílian", 184, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_184.png",
                        35
                ));

        cards.add(buildCard(
                    "Zoroark ex do N", 185, CardTypeEnum.DARK, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_185.png",
                        571
                ));

        cards.add(buildCard(
                    "Zacian ex do Lupo", 186, CardTypeEnum.STEEL, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_186.png",
                        888
                ));

        cards.add(buildCard(
                    "Salamence ex", 187, CardTypeEnum.DRAGON, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_187.png",
                        373
                ));

        cards.add(buildCard(
                    "Bellibolt ex da Kissera", 188, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_188.png",
                        939
                ));

        cards.add(buildCard(
                    "Zoroark ex do N", 189, CardTypeEnum.DARK, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_189.png",
                        571
                ));

        cards.add(buildCard(
                    "Energia Espinhosa", 190, CardTypeEnum.SPECIAL_ENERGY, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV09/SV09_PT-BR_190.png"
                ));

        return cards;
    }

    private CardModel buildCard(
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
