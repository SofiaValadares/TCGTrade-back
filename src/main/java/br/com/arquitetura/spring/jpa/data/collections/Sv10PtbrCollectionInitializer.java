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

public class Sv10PtbrCollectionInitializer {

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
                        "Rivais Predestinados",
                        "Escarlate e Violeta",
                        CardLanguageEnum.PT_BR,
                        "sv2",
                        "DRI",
                        sdf.parse("2025-05-30"),
                        244,
                        "https://images.pokemontcg.io/sv10/symbol.png",
                        "https://images.pokemontcg.io/sv10/logo.png",
                        "I"
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
            "Pinsir do Ethan", 1, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_1.png",
                127
        ));

        cards.add(buildCard(
                "Yanma", 2, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_2.png",
                193
        ));

        cards.add(buildCard(
                "Yanmega EX", 3, CardTypeEnum.GRASS,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_3.png",
                469
        ));

        cards.add(buildCard(
                "Pineco", 4, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_4.png",
                204
        ));

        cards.add(buildCard(
                "Shroomish", 5, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_5.png",
                285
        ));

        cards.add(buildCard(
                "Breloom", 6, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_6.png",
                286
        ));

        cards.add(buildCard(
                "Roselia da Cíntia", 7, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_7.png",
                315
        ));

        cards.add(buildCard(
                "Roserade da Cíntia", 8, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_8.png",
                407
        ));

        cards.add(buildCard(
                "Rotom Corte", 9, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_9.png",
                479
        ));

        cards.add(buildCard(
                "Shaymin", 10, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_10.png",
                492
        ));

        cards.add(buildCard(
                "Dwebble", 11, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_11.png",
                557
        ));

        cards.add(buildCard(
                "Crustle", 12, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_12.png",
                558
        ));

        cards.add(buildCard(
                "Fomantis", 13, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_13.png",
                753
        ));

        cards.add(buildCard(
                "Lurantis", 14, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_14.png",
                754
        ));

        cards.add(buildCard(
                "Blipbug da Equipe Rocket", 15, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_15.png",
                824
        ));

        cards.add(buildCard(
                "Applin", 16, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_16.png",
                840
        ));

        cards.add(buildCard(
                "Dipplin", 17, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_17.png",
                1011
        ));

        cards.add(buildCard(
                "Hydrapple", 18, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_18.png",
                1019
        ));

        cards.add(buildCard(
                "Tarountula da Equipe Rocket", 19, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_19.png",
                917
        ));

        cards.add(buildCard(
                "Spidops da Equipe Rocket", 20, CardTypeEnum.GRASS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_20.png",
                918
        ));

        cards.add(buildCard(
                "Smoliv", 21, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_21.png",
                928
        ));

        cards.add(buildCard(
                "Dolliv", 22, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_22.png",
                929
        ));

        cards.add(buildCard(
                "Arboliva EX", 23, CardTypeEnum.GRASS,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_23.png",
                930
        ));

        cards.add(buildCard(
                "Rellor", 24, CardTypeEnum.GRASS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_24.png",
                953
        ));

        cards.add(buildCard(
                "Rabsca EX", 25, CardTypeEnum.GRASS,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_25.png",
                954
        ));

        cards.add(buildCard(
                "Ogerpon Máscara Turquesa", 26, CardTypeEnum.GRASS,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_26.png",
                1017
        ));

        cards.add(buildCard(
                "Growlithe", 27, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_27.png",
                58
        ));

        cards.add(buildCard(
                "Arcanine", 28, CardTypeEnum.FIRE,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_28.png",
                59
        ));

        cards.add(buildCard(
                "Ponyta", 29, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_29.png",
                77
        ));

        cards.add(buildCard(
                "Rapidash", 30, CardTypeEnum.FIRE,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_30.png",
                78
        ));

        cards.add(buildCard(
                "Moltres EX da Equipe Rocket", 31, CardTypeEnum.FIRE,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_31.png",
                146
        ));

        cards.add(buildCard(
                "Cyndaquil do Ethan", 32, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_32.png",
                155
        ));

        cards.add(buildCard(
                "Quilava do Ethan", 33, CardTypeEnum.FIRE,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_33.png",
                156
        ));

        cards.add(buildCard(
                "Typhlosion do Ethan", 34, CardTypeEnum.FIRE,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_34.png",
                157
        ));

        cards.add(buildCard(
                "Slugma do Ethan", 35, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_35.png",
                218
        ));

        cards.add(buildCard(
                "Magcargo do Ethan", 36, CardTypeEnum.FIRE,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_36.png",
                219
        ));

        cards.add(buildCard(
                "Houndour da Equipe Rocket", 37, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_37.png",
                228
        ));

        cards.add(buildCard(
                "Houndoom da Equipe Rocket", 38, CardTypeEnum.FIRE,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_38.png",
                229
        ));

        cards.add(buildCard(
                "Ho-Oh EX do Ethan", 39, CardTypeEnum.FIRE,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_39.png",
                250
        ));

        cards.add(buildCard(
                "Torchic", 40, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_40.png",
                255
        ));

        cards.add(buildCard(
                "Combusken", 41, CardTypeEnum.FIRE,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_41.png",
                256
        ));

        cards.add(buildCard(
                "Blaziken", 42, CardTypeEnum.FIRE,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_42.png",
                257
        ));

        cards.add(buildCard(
                "Rotom Calor", 43, CardTypeEnum.FIRE,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_43.png",
                479
        ));

        cards.add(buildCard(
                "Ogerpon Máscara Fornalha", 44, CardTypeEnum.FIRE,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_44.png",
                1017
        ));

        cards.add(buildCard(
                "Psyduck da Misty", 45, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_45.png",
                54
        ));

        cards.add(buildCard(
                "Staryu da Misty", 46, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_46.png",
                120
        ));

        cards.add(buildCard(
                "Starmie da Misty", 47, CardTypeEnum.WATER,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_47.png",
                121
        ));

        cards.add(buildCard(
                "Magikarp da Misty", 48, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_48.png",
                129
        ));

        cards.add(buildCard(
                "Gyarados da Misty", 49, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_49.png",
                130
        ));

        cards.add(buildCard(
                "Lapras da Misty", 50, CardTypeEnum.WATER,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_50.png",
                131
        ));

        cards.add(buildCard(
                "Articuno do Team Rocket", 51, CardTypeEnum.WATER,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_51.png",
                144
        ));

        cards.add(buildCard(
                "Feebas da Cíntia", 52, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_52.png",
                349
        ));

        cards.add(buildCard(
                "Milotic da Cíntia", 53, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_53.png",
                350
        ));

        cards.add(buildCard(
                "Clamperl", 54, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_54.png",
                366
        ));

        cards.add(buildCard(
                "Huntail", 55, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_55.png",
                367
        ));

        cards.add(buildCard(
                "Gorebyss", 56, CardTypeEnum.WATER,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_56.png",
                368
        ));

        cards.add(buildCard(
                "Buizel", 57, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_57.png",
                419
        ));

        cards.add(buildCard(
                "Floatzel", 58, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_58.png",
                419
        ));

        cards.add(buildCard(
                "Snover", 59, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_59.png",
                459
        ));

        cards.add(buildCard(
                "Abomasnow", 60, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_60.png",
                460
        ));

        cards.add(buildCard(
                "Rotom Lavado", 61, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_61.png",
                479
        ));

        cards.add(buildCard(
                "Arrokuda", 62, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_62.png",
                846
        ));

        cards.add(buildCard(
                "Barraskewda", 63, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_63.png",
                847
        ));

        cards.add(buildCard(
                "Cetoddle", 64, CardTypeEnum.WATER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_64.png",
                906
        ));

        cards.add(buildCard(
                "Cetitan EX", 65, CardTypeEnum.WATER,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_65.png",
                907
        ));

        cards.add(buildCard(
                "Dondozo EX", 66, CardTypeEnum.WATER,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_66.png",
                977
        ));

        cards.add(buildCard(
                "Ogerpon Máscara Nascente", 67, CardTypeEnum.WATER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_67.png",
                1017
        ));

        cards.add(buildCard(
                "Electabuzz", 68, CardTypeEnum.ELECTRIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_68.png",
                125
        ));

        cards.add(buildCard(
                "Electivire EX", 69, CardTypeEnum.ELECTRIC,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_69.png",
                466
        ));

        cards.add(buildCard(
                "Zapdos da Equipe Rocket", 70, CardTypeEnum.ELECTRIC,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_70.png",
                145
        ));

        cards.add(buildCard(
                "Pichu do Ethan", 71, CardTypeEnum.ELECTRIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_71.png",
                172
        ));

        cards.add(buildCard(
                "Mareep da Equipe Rocket", 72, CardTypeEnum.ELECTRIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_72.png",
                179
        ));

        cards.add(buildCard(
                "Flaaffy da Equipe Rocket", 73, CardTypeEnum.ELECTRIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_73.png",
                180
        ));

        cards.add(buildCard(
                "Ampharos da Equipe Rocket", 74, CardTypeEnum.ELECTRIC,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_74.png",
                181
        ));

        cards.add(buildCard(
                "Electrike", 75, CardTypeEnum.ELECTRIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_75.png",
                309
        ));

        cards.add(buildCard(
                "Manectric", 76, CardTypeEnum.ELECTRIC,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_76.png",
                310
        ));

        cards.add(buildCard(
                "Rotom", 77, CardTypeEnum.ELECTRIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_77.png",
                479
        ));

        cards.add(buildCard(
                "Zeraora", 78, CardTypeEnum.ELECTRIC,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_78.png",
                807
        ));

        cards.add(buildCard(
                "Drowzee da Equipe Rocket", 79, CardTypeEnum.PSYCHIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_79.png",
                96
        ));

        cards.add(buildCard(
                "Hypno da Equipe Rocket", 80, CardTypeEnum.PSYCHIC,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_80.png",
                97
        ));

        cards.add(buildCard(
                "Mewtwo EX da Equipe Rocket", 81, CardTypeEnum.PSYCHIC,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_81.png",
                150
        ));

        cards.add(buildCard(
                "Wobbuffet da Equipe Rocket", 82, CardTypeEnum.PSYCHIC,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_82.png",
                202
        ));

        cards.add(buildCard(
                "Baltoy do Steven", 83, CardTypeEnum.PSYCHIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_83.png",
                343
        ));

        cards.add(buildCard(
                "Claydol do Steven", 84, CardTypeEnum.PSYCHIC,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_84.png",
                344
        ));

        cards.add(buildCard(
                "Chingling da Equipe Rocket", 85, CardTypeEnum.PSYCHIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_85.png",
                433
        ));

        cards.add(buildCard(
                "Carbink do Steven", 86, CardTypeEnum.PSYCHIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_86.png",
                703
        ));

        cards.add(buildCard(
                "Mimikyu da Equipe Rocket", 87, CardTypeEnum.PSYCHIC,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_87.png",
                778
        ));

        cards.add(buildCard(
                "Dottler da Equipe Rocket", 88, CardTypeEnum.PSYCHIC,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_88.png",
                825
        ));

        cards.add(buildCard(
                "Orbeetle da Equipe Rocket", 89, CardTypeEnum.PSYCHIC,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_89.png",
                826
        ));

        cards.add(buildCard(
                "Mankey", 90, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_90.png",
                56
        ));

        cards.add(buildCard(
                "Primeape", 91, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_91.png",
                57
        ));

        cards.add(buildCard(
                "Annihilape", 92, CardTypeEnum.FIGHTING,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_92.png",
                979
        ));

        cards.add(buildCard(
                "Sudowoodo do Ethan", 93, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_93.png",
                185
        ));

        cards.add(buildCard(
                "Larvitar da Equipe Rocket", 94, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_94.png",
                246
        ));

        cards.add(buildCard(
                "Pupitar da Equipe Rocket", 95, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_95.png",
                247
        ));

        cards.add(buildCard(
                "Tyranitar da Equipe Rocket", 96, CardTypeEnum.FIGHTING,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_96.png",
                248
        ));

        cards.add(buildCard(
                "Nosepass", 97, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_97.png",
                299
        ));

        cards.add(buildCard(
                "Probopass", 98, CardTypeEnum.FIGHTING,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_98.png",
                476
        ));

        cards.add(buildCard(
                "Meditite", 99, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_99.png",
                307
        ));

        cards.add(buildCard(
                "Medicham", 100, CardTypeEnum.FIGHTING,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_100.png",
                308
        ));

        cards.add(buildCard(
                "Regirock EX", 101, CardTypeEnum.FIGHTING,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_101.png",
                377
        ));

        cards.add(buildCard(
                "Gible da Cíntia", 102, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_102.png",
                443
        ));

        cards.add(buildCard(
                "Gabite da Cíntia", 103, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_103.png",
                444
        ));

        cards.add(buildCard(
                "Garchomp EX da Cíntia", 104, CardTypeEnum.FIGHTING,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_104.png",
                445
        ));

        cards.add(buildCard(
                "Hippopotas", 105, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_105.png",
                449
        ));

        cards.add(buildCard(
                "Hippowdon", 106, CardTypeEnum.FIGHTING,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_106.png",
                450
        ));

        cards.add(buildCard(
                "Mudbray", 107, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_107.png",
                749
        ));

        cards.add(buildCard(
                "Mudsdale", 108, CardTypeEnum.FIGHTING,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_108.png",
                750
        ));

        cards.add(buildCard(
                "Toedscool do Arven", 109, CardTypeEnum.FIGHTING,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_109.png",
                948
        ));

        cards.add(buildCard(
                "Toedscruel do Arven", 110, CardTypeEnum.FIGHTING,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_110.png",
                949
        ));

        cards.add(buildCard(
                "Ogerpon Máscara Alicerce", 111, CardTypeEnum.FIGHTING,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_111.png",
                1017
        ));

        cards.add(buildCard(
                "Ekans da Equipe Rocket", 112, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_112.png",
                23
        ));

        cards.add(buildCard(
                "Arbok da Equipe Rocket", 113, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_113.png",
                24
        ));

        cards.add(buildCard(
                "Nidoran da Equipe Rocket", 114, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_114.png",
                29
        ));

        cards.add(buildCard(
                "Nidorina da Equipe Rocket", 115, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_115.png",
                30
        ));

        cards.add(buildCard(
                "Nidoqueen da Equipe Rocket", 116, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_116.png",
                31
        ));

        cards.add(buildCard(
                "Nidoran da Equipe Rocket", 117, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_117.png",
                32
        ));

        cards.add(buildCard(
                "Nidorino da Equipe Rocket", 118, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_118.png",
                33
        ));

        cards.add(buildCard(
                "Nidoking EX da Equipe Rocket", 119, CardTypeEnum.DARK,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_119.png",
                34
        ));

        cards.add(buildCard(
                "Zubat da Equipe Rocket", 120, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_120.png",
                41
        ));

        cards.add(buildCard(
                "Golbat da Equipe Rocket", 121, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_121.png",
                42
        ));

        cards.add(buildCard(
                "Crobat EX da Equipe Rocket", 122, CardTypeEnum.DARK,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_122.png",
                169
        ));

        cards.add(buildCard(
                "Grimer da Equipe Rocket", 123, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_123.png",
                88
        ));

        cards.add(buildCard(
                "Muk da Equipe Rocket", 124, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_124.png",
                89
        ));

        cards.add(buildCard(
                "Koffing da Equipe Rocket", 125, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_125.png",
                109
        ));

        cards.add(buildCard(
                "Weezing da Equipe Rocket", 126, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_126.png",
                110
        ));

        cards.add(buildCard(
                "Murkrow da Equipe Rocket", 127, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_127.png",
                198
        ));

        cards.add(buildCard(
                "Sneasel da Equipe Rocket", 128, CardTypeEnum.DARK,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_128.png",
                215
        ));

        cards.add(buildCard(
                "Spiritomb da Cíntia", 129, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_129.png",
                442
        ));

        cards.add(buildCard(
                "Purrloin da Marine", 130, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_130.png",
                509
        ));

        cards.add(buildCard(
                "Liepard da Marine", 131, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_131.png",
                510
        ));

        cards.add(buildCard(
                "Scraggy da Marine", 132, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_132.png",
                559
        ));

        cards.add(buildCard(
                "Scrafty da Marine", 133, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_133.png",
                560
        ));

        cards.add(buildCard(
                "Impidimp da Marine", 134, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_134.png",
                859
        ));

        cards.add(buildCard(
                "Morgrem da Marine", 135, CardTypeEnum.DARK,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_135.png",
                860
        ));

        cards.add(buildCard(
                "Grimmsnarl EX da Marine", 136, CardTypeEnum.DARK,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_136.png",
                861
        ));

        cards.add(buildCard(
                "Morpeko da Marine", 137, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_137.png",
                877
        ));

        cards.add(buildCard(
                "Maschiff do Arven", 138, CardTypeEnum.DARK,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_138.png",
                942
        ));

        cards.add(buildCard(
                "Mabosstiff EX do Arven", 139, CardTypeEnum.DARK,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_139.png",
                943
        ));

        cards.add(buildCard(
                "Forretress", 140, CardTypeEnum.STEEL,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_140.png",
                205
        ));


        cards.add(buildCard(
                "Skarmory", 141, CardTypeEnum.STEEL,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_141.png",
                227
        ));

        cards.add(buildCard(
                "Skarmory do Steven", 142, CardTypeEnum.STEEL,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_142.png",
                227
        ));

        cards.add(buildCard(
                "Beldum do Steven", 143, CardTypeEnum.STEEL,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_143.png",
                374
        ));

        cards.add(buildCard(
                "Metang do Steven", 144, CardTypeEnum.STEEL,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_144.png",
                375
        ));

        cards.add(buildCard(
                "Metagross ex do Steven", 145, CardTypeEnum.STEEL,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_145.png",
                376
        ));

        cards.add(buildCard(
                "Zamazenta", 146, CardTypeEnum.STEEL,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_146.png",
                889
        ));

        cards.add(buildCard(
                "Rattata da Equipe Rocket", 147, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_147.png",
                19
        ));

        cards.add(buildCard(
                "Raticate da Equipe Rocket", 148, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_148.png",
                20
        ));

        cards.add(buildCard(
                "Meowth da Equipe Rocket", 149, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_149.png",
                52
        ));

        cards.add(buildCard(
                "Persian EX da Equipe Rocket", 150, CardTypeEnum.COLORLESS,
                CardRarityEnum.DOUBLE_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_150.png",
                53
        ));

        cards.add(buildCard(
                "Kangaskhan", 151, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_151.png",
                115
        ));

        cards.add(buildCard(
                "Tauros", 152, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_152.png",
                128
        ));

        cards.add(buildCard(
                "Porygon da Equipe Rocket", 153, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_153.png",
                137
        ));

        cards.add(buildCard(
                "Porygon2 da Equipe Rocket", 154, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_154.png",
                233
        ));

        cards.add(buildCard(
                "Porygon-Z da Equipe Rocket", 155, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_155.png",
                474
        ));

        cards.add(buildCard(
                "Taillow", 156, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_156.png",
                276
        ));

        cards.add(buildCard(
                "Swellow", 157, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_157.png",
                277
        ));

        cards.add(buildCard(
                "Skwovet do Arven", 158, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_158.png",
                819
        ));

        cards.add(buildCard(
                "Greedent do Arven", 159, CardTypeEnum.COLORLESS,
                CardRarityEnum.RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_159.png",
                820
        ));

        cards.add(buildCard(
                "Squawkabilly", 160, CardTypeEnum.COLORLESS,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_160.png",
                931
        ));

        cards.add(buildCard(
                "Sanduíche do Arven", 161, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_161.png"
        ));

        cards.add(buildCard(
                "Peso de Poder da Cíntia", 162, CardTypeEnum.TOOL,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_162.png"
        ));

        cards.add(buildCard(
                "Hype da Emcee", 163, CardTypeEnum.SUPPORTER,
                CardRarityEnum.COMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_163.png"
        ));

        cards.add(buildCard(
                "Reciclador de Energia", 164, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_164.png"
        ));

        cards.add(buildCard(
                "Aventura do Ethan", 165, CardTypeEnum.SUPPORTER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_165.png"
        ));

        cards.add(buildCard(
                "Caverna de Granito", 166, CardTypeEnum.STADIUM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_166.png"
        ));

        cards.add(buildCard(
                "Juiz", 167, CardTypeEnum.SUPPORTER, "G",
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_167.png"
        ));

        cards.add(buildCard(
                "Cinza Sagrada", 168, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_168.png"
        ));

        cards.add(buildCard(
                "Ginásio de Spikemuth", 169, CardTypeEnum.STADIUM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_169.png"
        ));

        cards.add(buildCard(
                "Apollo da Equipe Rocket", 170, CardTypeEnum.SUPPORTER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_170.png"
        ));

        cards.add(buildCard(
                "Athena da Equipe Rocket", 171, CardTypeEnum.SUPPORTER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_171.png"
        ));

        cards.add(buildCard(
                "Azucrinabot da Equipe Rocket", 172, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_172.png"
        ));

        cards.add(buildCard(
                "Fábrica da Equipe Rocket", 173, CardTypeEnum.STADIUM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_173.png"
        ));

        cards.add(buildCard(
                "Giovanni da Equipe Rocket", 174, CardTypeEnum.SUPPORTER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_174.png"
        ));

        cards.add(buildCard(
                "Grande Bola da Equipe Rocket", 175, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_175.png"
        ));

        cards.add(buildCard(
                "Petrel da Equipe Rocket", 176, CardTypeEnum.SUPPORTER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_176.png"
        ));

        cards.add(buildCard(
                "Próton da Equipe Rocket", 177, CardTypeEnum.SUPPORTER,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_177.png"
        ));

        cards.add(buildCard(
                "Transmissor da Equipe Rocket", 178, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_178.png"
        ));

        cards.add(buildCard(
                "Bomba de Risco da Equipe Rocket", 179, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_179.png"
        ));

        cards.add(buildCard(
                "Torre de Vigia da Equipe Rocket", 180, CardTypeEnum.STADIUM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_180.png"
        ));

        cards.add(buildCard(
                "Máquina de MT", 181, CardTypeEnum.ITEM,
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_181.png"
        ));

        cards.add(buildCard(
                "Máquina de MT", 182, CardTypeEnum.SPECIAL_ENERGY, "H",
                CardRarityEnum.UNCOMMON,
                List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_182.png"
        ));

        cards.add(buildCard(
                "Yanma", 183, CardTypeEnum.GRASS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_183.png",
                193
        ));

        cards.add(buildCard(
                "Roserade da Cíntia", 184, CardTypeEnum.GRASS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_184.png",
                407
        ));

        cards.add(buildCard(
                "Shaymin", 185, CardTypeEnum.GRASS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_185.png",
                492
        ));

        cards.add(buildCard(
                "Crustle", 186, CardTypeEnum.GRASS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_186.png",
                558
        ));

        cards.add(buildCard(
                "Spidops da Equipe Rocket", 187, CardTypeEnum.GRASS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_187.png",
                918
        ));

        cards.add(buildCard(
                "Hydrapple", 188, CardTypeEnum.GRASS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_188.png",
                1019
        ));

        cards.add(buildCard(
                "Rapidash", 189, CardTypeEnum.FIRE,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_189.png",
                78
        ));

        cards.add(buildCard(
                "Typhlosion do Ethan", 190, CardTypeEnum.FIRE,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_190.png",
                157
        ));

        cards.add(buildCard(
                "Houndour da Equipe Rocket", 191, CardTypeEnum.FIRE,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_191.png",
                228
        ));

        cards.add(buildCard(
                "Blaziken", 192, CardTypeEnum.FIRE,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_192.png",
                257
        ));

        cards.add(buildCard(
                "Psyduck da Misty", 193, CardTypeEnum.WATER,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_193.png",
                54
        ));

        cards.add(buildCard(
                "Lapras da Misty", 194, CardTypeEnum.WATER,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_194.png",
                131
        ));

        cards.add(buildCard(
                "Clamperl", 195, CardTypeEnum.WATER,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_195.png",
                366
        ));

        cards.add(buildCard(
                "Electrike", 196, CardTypeEnum.ELECTRIC,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_196.png",
                309
        ));

        cards.add(buildCard(
                "Rotom", 197, CardTypeEnum.ELECTRIC,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_197.png",
                479
        ));

        cards.add(buildCard(
                "Orbeetle da Equipe Rocket", 198, CardTypeEnum.PSYCHIC,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_198.png",
                826
        ));

        cards.add(buildCard(
                "Weezing da Equipe Rocket", 199, CardTypeEnum.DARK,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_199.png",
                110
        ));

        cards.add(buildCard(
                "Murkrow da Equipe Rocket", 200, CardTypeEnum.DARK,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_200.png",
                198
        ));

        cards.add(buildCard(
                "Zamazenta", 201, CardTypeEnum.STEEL,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_201.png",
                889
        ));

        cards.add(buildCard(
                "Raticate da Equipe Rocket", 202, CardTypeEnum.COLORLESS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_202.png",
                20
        ));

        cards.add(buildCard(
                "Meowth da Equipe Rocket", 203, CardTypeEnum.COLORLESS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_203.png",
                52
        ));

        cards.add(buildCard(
                "Kangaskhan", 204, CardTypeEnum.COLORLESS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_204.png",
                115
        ));

        cards.add(buildCard(
                "Greedent do Arven", 205, CardTypeEnum.COLORLESS,
                CardRarityEnum.ILLUSTRATION_RARE,
                List.of(CardVariantEnum.HOLO, CardVariantEnum.NORMAL),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_205.png",
                820
        ));

        cards.add(buildCard(
                "Yanmega EX", 206, CardTypeEnum.GRASS,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_206.png",
                469
        ));

        cards.add(buildCard(
                "Arboliva EX", 207, CardTypeEnum.GRASS,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_207.png",
                930
        ));

        cards.add(buildCard(
                "Moltres EX da Equipe Rocket", 208, CardTypeEnum.FIRE,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_208.png",
                146
        ));

        cards.add(buildCard(
                "Ho-Oh EX do Ethan", 209, CardTypeEnum.FIRE,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_209.png",
                250
        ));

        cards.add(buildCard(
                "Cetitan EX", 210, CardTypeEnum.WATER,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_210.png",
                907
        ));

        cards.add(buildCard(
                "Dondozo EX", 211, CardTypeEnum.WATER,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_211.png",
                977
        ));

        cards.add(buildCard(
                "Electivire EX", 212, CardTypeEnum.ELECTRIC,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_212.png",
                466
        ));

        cards.add(buildCard(
                "Mewtwo EX da Equipe Rocket", 213, CardTypeEnum.PSYCHIC,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_213.png",
                150
        ));

        cards.add(buildCard(
                "Regirock EX", 214, CardTypeEnum.FIGHTING,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_214.png",
                377
        ));

        cards.add(buildCard(
                "Garchomp EX da Cíntia", 215, CardTypeEnum.FIGHTING,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_215.png",
                445
        ));

        cards.add(buildCard(
                "Nidoking EX da Equipe Rocket", 216, CardTypeEnum.DARK,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_216.png",
                34
        ));

        cards.add(buildCard(
                "Crobat EX da Equipe Rocket", 217, CardTypeEnum.DARK,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_217.png",
                169
        ));

        cards.add(buildCard(
                "Mabosstiff EX do Arven", 218, CardTypeEnum.DARK,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_218.png",
                943
        ));

        cards.add(buildCard(
                "Persian EX da Equipe Rocket", 219, CardTypeEnum.COLORLESS,
                CardRarityEnum.ULTRA_RARE,
                List.of(CardVariantEnum.HOLO),
                "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV10/SV10_PT-BR_219.png",
                53
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
