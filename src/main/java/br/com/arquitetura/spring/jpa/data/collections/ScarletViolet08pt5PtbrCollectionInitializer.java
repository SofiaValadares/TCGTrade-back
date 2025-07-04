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

public class ScarletViolet08pt5PtbrCollectionInitializer implements CollectionInitializer {

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
                    "Evoluções Prismáticas",
                    "Escarlate e Violeta",
                    CardLanguageEnum.PT_BR,
                    "sv8pt5",
                    "PRE",
                    sdf.parse("2025-01-17"),
                    180,
                    "https://images.pokemontcg.io/sv8pt5/symbol.png",
                    "https://images.pokemontcg.io/sv8pt5/logo.png",
                    "H"
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
                    "Exeggcute", 1, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_1.png",
                        102
                ));

        cards.add(buildCard(
                    "Exeggutor", 2, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_2.png",
                        103
                ));

        cards.add(buildCard(
                    "Pinsir", 3, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_3.png",
                        127
                ));

        cards.add(buildCard(
                    "Budew", 4, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_4.png",
                        406
                ));

        cards.add(buildCard(
                    "Leafeon", 5, CardTypeEnum.GRASS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_5.png",
                        470
                ));

        cards.add(buildCard(
                    "Leafeon ex", 6, CardTypeEnum.GRASS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_6.png",
                        470
                ));

        cards.add(buildCard(
                    "Cottonee", 7, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_7.png",
                        546
                ));

        cards.add(buildCard(
                    "Whimsicott", 8, CardTypeEnum.GRASS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_8.png",
                        547
                ));

        cards.add(buildCard(
                    "Applin", 9, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_9.png",
                        840
                ));

        cards.add(buildCard(
                    "Dipplin", 10, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_10.png",
                        1011
                ));

        cards.add(buildCard(
                    "Hydrapple ex", 11, CardTypeEnum.GRASS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_11.png",
                        1019
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Turquesa ex", 12, CardTypeEnum.GRASS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_12.png",
                        1017
                ));

        cards.add(buildCard(
                    "Flareon", 13, CardTypeEnum.FIRE, "G",
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_13.png",
                        136
                ));

        cards.add(buildCard(
                    "Flareon ex", 14, CardTypeEnum.FIRE, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_14.png",
                        136
                ));

        cards.add(buildCard(
                    "Litleo", 15, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_15.png",
                        667
                ));

        cards.add(buildCard(
                    "Pyroar", 16, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_16.png",
                        668
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Fornalha ex", 17, CardTypeEnum.FIRE, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_17.png",
                        1017
                ));

        cards.add(buildCard(
                    "Slowpoke", 18, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_18.png",
                        79
                ));

        cards.add(buildCard(
                    "Slowking", 19, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_19.png",
                        199
                ));

        cards.add(buildCard(
                    "Goldeen", 20, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_20.png",
                        118
                ));

        cards.add(buildCard(
                    "Seaking", 21, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_21.png",
                        119
                ));

        cards.add(buildCard(
                    "Vaporeon", 22, CardTypeEnum.WATER, "G",
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_22.png",
                        134
                ));

        cards.add(buildCard(
                    "Vaporeon ex", 23, CardTypeEnum.WATER, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_23.png",
                        134
                ));

        cards.add(buildCard(
                    "Suicune", 24, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_24.png",
                        245
                ));

        cards.add(buildCard(
                    "Glaceon", 25, CardTypeEnum.WATER, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_25.png",
                        471
                ));

        cards.add(buildCard(
                    "Glaceon ex", 26, CardTypeEnum.WATER, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_26.png",
                        471
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Nascente ex", 27, CardTypeEnum.WATER, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_27.png",
                        1017
                ));

        cards.add(buildCard(
                    "Pikachu ex", 28, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_28.png",
                        25
                ));

        cards.add(buildCard(
                    "Jolteon", 29, CardTypeEnum.ELECTRIC, "G",
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_29.png",
                        135
                ));

        cards.add(buildCard(
                    "Jolteon ex", 30, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_30.png",
                        135
                ));

        cards.add(buildCard(
                    "Mãos Férreas ex", 31, CardTypeEnum.ELECTRIC, "G",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_31.png"
                ));

        cards.add(buildCard(
                    "Espinhos Férreos ex", 32, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_32.png"
                ));

        cards.add(buildCard(
                    "Espeon", 33, CardTypeEnum.PSYCHIC, "G",
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_33.png",
                        196
                ));

        cards.add(buildCard(
                    "Espeon ex", 34, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_34.png",
                        196
                ));

        cards.add(buildCard(
                    "Duskull", 35, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_35.png",
                        355
                ));

        cards.add(buildCard(
                    "Dusclops", 36, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_36.png",
                        356
                ));

        cards.add(buildCard(
                    "Dusknoir", 37, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_37.png",
                        477
                ));

        cards.add(buildCard(
                    "Spritzee", 38, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_38.png",
                        682
                ));

        cards.add(buildCard(
                    "Aromatisse", 39, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_39.png",
                        683
                ));

        cards.add(buildCard(
                    "Sylveon", 40, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_40.png",
                        700
                ));

        cards.add(buildCard(
                    "Sylveon ex", 41, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_41.png",
                        700
                ));

        cards.add(buildCard(
                    "Cauda Brado", 42, CardTypeEnum.PSYCHIC, "G",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_42.png"
                ));

        cards.add(buildCard(
                    "Juba Sopro", 43, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_43.png"
                ));

        cards.add(buildCard(
                    "Munkidori", 44, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_44.png",
                        1015
                ));

        cards.add(buildCard(
                    "Fezandipiti", 45, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_45.png",
                        1016
                ));

        cards.add(buildCard(
                    "Rocha Férrea", 46, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_46.png"
                ));

        cards.add(buildCard(
                    "Larvitar", 47, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_47.png",
                        246
                ));

        cards.add(buildCard(
                    "Pupitar", 48, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_48.png",
                        247
                ));

        cards.add(buildCard(
                    "Groudon", 49, CardTypeEnum.FIGHTING, "G",
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_49.png",
                        383
                ));

        cards.add(buildCard(
                    "Riolu", 50, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_50.png",
                        447
                ));

        cards.add(buildCard(
                    "Lucario ex", 51, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_51.png",
                        448
                ));

        cards.add(buildCard(
                    "Hippopotas", 52, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_52.png",
                        449
                ));

        cards.add(buildCard(
                    "Hippowdon", 53, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_53.png",
                        450
                ));

        cards.add(buildCard(
                    "Ursaluna Lua Sangrenta", 54, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_54.png",
                        901
                ));

        cards.add(buildCard(
                    "Presa Grande", 55, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_55.png"
                ));

        cards.add(buildCard(
                    "Choque Areia ex", 56, CardTypeEnum.FIGHTING, "G",
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_56.png"
                ));

        cards.add(buildCard(
                    "Okidogi", 57, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_57.png"
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Alicerce ex", 58, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_58.png",
                        1017
                ));

        cards.add(buildCard(
                    "Umbreon", 59, CardTypeEnum.DARK, "G",
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_59.png",
                        197
                ));

        cards.add(buildCard(
                    "Umbreon ex", 60, CardTypeEnum.DARK, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_60.png",
                        197
                ));

        cards.add(buildCard(
                    "Sneasel", 61, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_61.png",
                        215
                ));

        cards.add(buildCard(
                    "Houndour", 62, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_62.png",
                        228
                ));

        cards.add(buildCard(
                    "Houndoom", 63, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_63.png",
                        229
                ));

        cards.add(buildCard(
                    "Tyranitar ex", 64, CardTypeEnum.DARK, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_64.png",
                        248
                ));

        cards.add(buildCard(
                    "Lua Estrondo", 65, CardTypeEnum.DARK, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_65.png"
                ));

        cards.add(buildCard(
                    "Bronzor", 66, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_66.png",
                        436
                ));

        cards.add(buildCard(
                    "Bronzong", 67, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_67.png",
                        437
                ));

        cards.add(buildCard(
                    "Heatran", 68, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_68.png",
                        485
                ));

        cards.add(buildCard(
                    "Duraludon", 69, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_69.png",
                        884
                ));

        cards.add(buildCard(
                    "Archaludon", 70, CardTypeEnum.STEEL, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_70.png",
                        1018
                ));

        cards.add(buildCard(
                    "Dreepy", 71, CardTypeEnum.DRAGON, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_71.png",
                        885
                ));

        cards.add(buildCard(
                    "Drakloak", 72, CardTypeEnum.DRAGON, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_72.png",
                        886
                ));

        cards.add(buildCard(
                    "Dragapult ex", 73, CardTypeEnum.DRAGON, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_73.png",
                        887
                ));

        cards.add(buildCard(
                    "Eevee", 74, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_74.png",
                        133
                ));

        cards.add(buildCard(
                    "Eevee ex", 75, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_75.png",
                        133
                ));

        cards.add(buildCard(
                    "Snorlax ex", 76, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_76.png",
                        143
                ));

        cards.add(buildCard(
                    "Hoothoot", 77, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_77.png",
                        163
                ));

        cards.add(buildCard(
                    "Noctowl", 78, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_78.png",
                        164
                ));

        cards.add(buildCard(
                    "Dunsparce", 79, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_79.png",
                        206
                ));

        cards.add(buildCard(
                    "Dudunsparce", 80, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_80.png",
                        982
                ));

        cards.add(buildCard(
                    "Miltank", 81, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_81.png",
                        241
                ));

        cards.add(buildCard(
                    "Lugia ex", 82, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_82.png",
                        249
                ));

        cards.add(buildCard(
                    "Buneary", 83, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_83.png",
                        427
                ));

        cards.add(buildCard(
                    "Lopunny", 84, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_84.png",
                        428
                ));

        cards.add(buildCard(
                    "Rotom Ventilador", 85, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_85.png",
                        479
                ));

        cards.add(buildCard(
                    "Regigigas", 86, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_86.png",
                        486
                ));

        cards.add(buildCard(
                    "Shaymin", 87, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_87.png",
                        492
                ));

        cards.add(buildCard(
                    "Furfrou", 88, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_88.png",
                        676
                ));

        cards.add(buildCard(
                    "Hawlucha", 89, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_89.png",
                        701
                ));

        cards.add(buildCard(
                    "Noibat", 90, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_90.png",
                        714
                ));

        cards.add(buildCard(
                    "Noivern ex", 91, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_91.png",
                        715
                ));

        cards.add(buildCard(
                    "Terapagos ex", 92, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_92.png",
                        1024
                ));

        cards.add(buildCard(
                    "Amarílis", 93, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_93.png"
                ));

        cards.add(buildCard(
                    "Abismo da Área Zero", 94, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_94.png"
                ));

        cards.add(buildCard(
                    "Moti Vinculante", 95, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_95.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 96, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_96.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 97, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_97.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 98, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_98.png"
                ));

        cards.add(buildCard(
                    "Treino de Faixa Preta", 99, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_99.png"
                ));

        cards.add(buildCard(
                    "Urzy", 100, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_100.png"
                ));

        cards.add(buildCard(
                    "Poffin de Colega", 101, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_101.png"
                ));

        cards.add(buildCard(
                    "Kit Caça-inseto", 102, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_102.png"
                ));

        cards.add(buildCard(
                    "Carmine", 103, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_103.png"
                ));

        cards.add(buildCard(
                    "Decodificação da Criptomaníaca", 104, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_104.png"
                ));

        cards.add(buildCard(
                    "Plínio", 105, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_105.png"
                ));

        cards.add(buildCard(
                    "Recipiente Terrestre", 106, CardTypeEnum.ITEM, "G",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_106.png"
                ));

        cards.add(buildCard(
                    "Liderança do Explorador", 107, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_107.png"
                ));

        cards.add(buildCard(
                    "Praça de Festas", 108, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_108.png"
                ));

        cards.add(buildCard(
                    "Amigos em Paldea", 109, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_109.png"
                ));

        cards.add(buildCard(
                    "Trompete de Vidro", 110, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_110.png"
                ));

        cards.add(buildCard(
                    "Fruta Meraçá", 111, CardTypeEnum.TOOL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_111.png"
                ));

        cards.add(buildCard(
                    "Dom Secreto da Janine", 112, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_112.png"
                ));

        cards.add(buildCard(
                    "Kiran", 113, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_113.png"
                ));

        cards.add(buildCard(
                    "Tarsila", 114, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_114.png"
                ));

        cards.add(buildCard(
                    "Talento do Lauro", 115, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_115.png"
                ));

        cards.add(buildCard(
                    "Vara de Pescar Max", 116, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_116.png"
                ));

        cards.add(buildCard(
                    "Cinturão Máximo", 117, CardTypeEnum.TOOL, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_117.png"
                ));

        cards.add(buildCard(
                    "Máscara do Ogro", 118, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_118.png"
                ));

        cards.add(buildCard(
                    "Pegador Superior", 119, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_119.png"
                ));

        cards.add(buildCard(
                    "Vitalidade da Professora Arka", 120, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_120.png"
                ));

        cards.add(buildCard(
                    "Hipótese do Professor Turo", 121, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_121.png"
                ));

        cards.add(buildCard(
                    "Pesquisa de Professores", 122, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_122.png"
                ));

        cards.add(buildCard(
                    "Pesquisa de Professores", 123, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_123.png"
                ));

        cards.add(buildCard(
                    "Pesquisa de Professores", 124, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_124.png"
                ));

        cards.add(buildCard(
                    "Pesquisa de Professores", 125, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_125.png"
                ));

        cards.add(buildCard(
                    "Skate de Resgate", 126, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_126.png"
                ));

        cards.add(buildCard(
                    "Roto-bastão", 127, CardTypeEnum.ITEM, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_127.png"
                ));

        cards.add(buildCard(
                    "Recolhida Ciclone", 128, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_128.png"
                ));

        cards.add(buildCard(
                    "Cristal Cintilante", 129, CardTypeEnum.TOOL, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_129.png"
                ));

        cards.add(buildCard(
                    "Radar Tecnológico", 130, CardTypeEnum.ITEM, "G",
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO, CardVariantEnum.POKEBALL_HOLO, CardVariantEnum.MASTERBALL_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_130.png"
                ));

        cards.add(buildCard(
                    "Rastreador de Tesouros", 131, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_131.png"
                ));

        cards.add(buildCard(
                    "Amarílis", 132, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_132.png"
                ));

        cards.add(buildCard(
                    "Érico", 133, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_133.png"
                ));

        cards.add(buildCard(
                    "Érico", 134, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_134.png"
                ));

        cards.add(buildCard(
                    "Brás", 135, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_135.png"
                ));

        cards.add(buildCard(
                    "Êri", 136, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_136.png"
                ));

        cards.add(buildCard(
                    "Amigos em Paldea", 137, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_137.png"
                ));

        cards.add(buildCard(
                    "Giacomo", 138, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_138.png"
                ));

        cards.add(buildCard(
                    "Talento do Lauro", 139, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_139.png"
                ));

        cards.add(buildCard(
                    "Mélia", 140, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_140.png"
                ));

        cards.add(buildCard(
                    "Ortega", 141, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_141.png"
                ));

        cards.add(buildCard(
                    "Moira", 142, CardTypeEnum.SUPPORTER, "G",
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_142.png"
                ));

        cards.add(buildCard(
                    "Tomila", 143, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_143.png"
                ));

        cards.add(buildCard(
                    "Leafeon ex", 144, CardTypeEnum.GRASS, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_144.png",
                        470
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Turquesa ex", 145, CardTypeEnum.GRASS, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_145.png",
                        1017
                ));

        cards.add(buildCard(
                    "Flareon ex", 146, CardTypeEnum.FIRE, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_146.png",
                        136
                ));

        cards.add(buildCard(
                    "Ceruledge ex", 147, CardTypeEnum.FIRE, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_147.png",
                        937
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Fornalha ex", 148, CardTypeEnum.FIRE, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_148.png",
                        1017
                ));

        cards.add(buildCard(
                    "Vaporeon ex", 149, CardTypeEnum.WATER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_149.png",
                        134
                ));

        cards.add(buildCard(
                    "Glaceon ex", 150, CardTypeEnum.WATER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_150.png",
                        471
                ));

        cards.add(buildCard(
                    "Palafin ex", 151, CardTypeEnum.WATER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_151.png",
                        964
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Nascente ex", 152, CardTypeEnum.WATER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_152.png",
                        1017
                ));

        cards.add(buildCard(
                    "Jolteon ex", 153, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_153.png",
                        135
                ));

        cards.add(buildCard(
                    "Mãos Férreas ex", 154, CardTypeEnum.ELECTRIC, "G",
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_154.png"
                ));

        cards.add(buildCard(
                    "Espeon ex", 155, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_155.png",
                        196
                ));

        cards.add(buildCard(
                    "Sylveon ex", 156, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_156.png",
                        700
                ));

        cards.add(buildCard(
                    "Valentia Férrea ex", 157, CardTypeEnum.PSYCHIC, "G",
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_157.png"
                ));

        cards.add(buildCard(
                    "Chifres Férreos ex", 158, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_158.png"
                ));

        cards.add(buildCard(
                    "Choque Areia ex", 159, CardTypeEnum.FIGHTING, "G",
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_159.png"
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Alicerce ex", 160, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_160.png",
                        1017
                ));

        cards.add(buildCard(
                    "Umbreon ex", 161, CardTypeEnum.DARK, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_161.png",
                        197
                ));

        cards.add(buildCard(
                    "Lua Estrondo ex", 162, CardTypeEnum.DARK, "G",
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_162.png"
                ));

        cards.add(buildCard(
                    "Pecharunt ex", 163, CardTypeEnum.DARK, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_163.png",
                        1025
                ));

        cards.add(buildCard(
                    "Gholdengo ex", 164, CardTypeEnum.STEEL, "G",
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_164.png",
                        1000
                ));

        cards.add(buildCard(
                    "Dragapult ex", 165, CardTypeEnum.DRAGON, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_165.png",
                        887
                ));

        cards.add(buildCard(
                    "Raio Fúria ex", 166, CardTypeEnum.DRAGON, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_166.png"
                ));

        cards.add(buildCard(
                    "Eevee ex", 167, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_167.png",
                        133
                ));

        cards.add(buildCard(
                    "Ursaluna Lua Sangrenta ex", 168, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_168.png",
                        901
                ));

        cards.add(buildCard(
                    "Terapagos ex", 169, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_169.png",
                        1024
                ));

        cards.add(buildCard(
                    "Amarílis", 170, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_170.png"
                ));

        cards.add(buildCard(
                    "Plínio", 171, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_171.png"
                ));

        cards.add(buildCard(
                    "Drayton", 172, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_172.png"
                ));

        cards.add(buildCard(
                    "Dom Secreto da Janine", 173, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_173.png"
                ));

        cards.add(buildCard(
                    "Kiran", 174, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_174.png"
                ));

        cards.add(buildCard(
                    "Tarsila", 175, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_175.png"
                ));

        cards.add(buildCard(
                    "Folhas Férreas ex", 176, CardTypeEnum.GRASS, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_176.png"
                ));

        cards.add(buildCard(
                    "Ogerpon Máscara Turquesa ex", 177, CardTypeEnum.GRASS, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_177.png",
                        1017
                ));

        cards.add(buildCard(
                    "Onda Ando ex", 178, CardTypeEnum.WATER, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_178.png"
                ));

        cards.add(buildCard(
                    "Pikachu ex", 179, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_179.png",
                        25
                ));

        cards.add(buildCard(
                    "Terapagos ex", 180, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV8PT5/SV8PT5_PT-BR_180.png",
                        1024
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
