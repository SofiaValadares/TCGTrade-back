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

public class ScarletViolet08PtbrCollectionInitializer implements CollectionInitializer {

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
                    "Fagulhas Impetudsas",
                    "Escarlate e Violeta",
                    CardLanguageEnum.PT_BR,
                    "sv8",
                    "SSP",
                    sdf.parse("2024-11-08"),
                    252,
                    "https://images.pokemontcg.io/sv8/symbol.png",
                    "https://images.pokemontcg.io/sv8/logo.png",
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
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_1.png",
                        102
                ));

        cards.add(buildCard(
                    "Exeggcute", 2, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_2.png",
                        102
                ));

        cards.add(buildCard(
                    "Exeggutor", 3, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_3.png",
                        103
                ));

        cards.add(buildCard(
                    "Durant ex", 4, CardTypeEnum.GRASS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_4.png",
                        632
                ));

        cards.add(buildCard(
                    "Scatterbug", 5, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_5.png",
                        664
                ));

        cards.add(buildCard(
                    "Spewpa", 6, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_6.png",
                        665
                ));

        cards.add(buildCard(
                    "Vivillon", 7, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_7.png",
                        666
                ));

        cards.add(buildCard(
                    "Morelull", 8, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_8.png",
                        755
                ));

        cards.add(buildCard(
                    "Shiinotic", 9, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_9.png",
                        756
                ));

        cards.add(buildCard(
                    "Dhelmise", 10, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_10.png",
                        781
                ));

        cards.add(buildCard(
                    "Zarude", 11, CardTypeEnum.GRASS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_11.png",
                        893
                ));

        cards.add(buildCard(
                    "Capsakid", 12, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_12.png",
                        951
                ));

        cards.add(buildCard(
                    "Rellor", 13, CardTypeEnum.GRASS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_13.png",
                        953
                ));

        cards.add(buildCard(
                    "Rabsca", 14, CardTypeEnum.GRASS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_14.png",
                        954
                ));

        cards.add(buildCard(
                    "Wo-Chien", 15, CardTypeEnum.GRASS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_15.png",
                        1001
                ));

        cards.add(buildCard(
                    "Vulpix", 16, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_16.png",
                        37
                ));

        cards.add(buildCard(
                    "Ninetales", 17, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_17.png",
                        38
                ));

        cards.add(buildCard(
                    "Tauros de Paldea", 18, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_18.png",
                        128
                ));

        cards.add(buildCard(
                    "Ho-Oh", 19, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_19.png",
                        250
                ));

        cards.add(buildCard(
                    "Castform Forma Ensolarada", 20, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_20.png",
                        351
                ));

        cards.add(buildCard(
                    "Victini", 21, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_21.png",
                        494
                ));

        cards.add(buildCard(
                    "Pansear", 22, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_22.png",
                        513
                ));

        cards.add(buildCard(
                    "Simisear", 23, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_23.png",
                        514
                ));

        cards.add(buildCard(
                    "Larvesta", 24, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_24.png",
                        636
                ));

        cards.add(buildCard(
                    "Volcarona", 25, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_25.png",
                        637
                ));

        cards.add(buildCard(
                    "Oricorio", 26, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_26.png",
                        741
                ));

        cards.add(buildCard(
                    "Sizzlipede", 27, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_27.png",
                        850
                ));

        cards.add(buildCard(
                    "Centiskorch", 28, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_28.png",
                        851
                ));

        cards.add(buildCard(
                    "Fuecoco", 29, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_29.png",
                        909
                ));

        cards.add(buildCard(
                    "Crocalor", 30, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_30.png",
                        910
                ));

        cards.add(buildCard(
                    "Skeledirge", 31, CardTypeEnum.FIRE, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_31.png",
                        911
                ));

        cards.add(buildCard(
                    "Charcadet", 32, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_32.png",
                        935
                ));

        cards.add(buildCard(
                    "Charcadet", 33, CardTypeEnum.FIRE, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_33.png",
                        935
                ));

        cards.add(buildCard(
                    "Armarouge", 34, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_34.png",
                        936
                ));

        cards.add(buildCard(
                    "Ceruledge", 35, CardTypeEnum.FIRE, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_35.png",
                        937
                ));

        cards.add(buildCard(
                    "Ceruledge ex", 36, CardTypeEnum.FIRE, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_36.png",
                        937
                ));

        cards.add(buildCard(
                    "Scovillain ex", 37, CardTypeEnum.FIRE, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_37.png",
                        952
                ));

        cards.add(buildCard(
                    "Fogo Corrosão", 38, CardTypeEnum.FIRE, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_38.png",
                        1020
                ));

        cards.add(buildCard(
                    "Tauros de Paldea", 39, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_39.png",
                        128
                ));

        cards.add(buildCard(
                    "Mantine", 40, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_40.png",
                        226
                ));

        cards.add(buildCard(
                    "Feebas", 41, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_41.png",
                        349
                ));

        cards.add(buildCard(
                    "Milotic ex", 42, CardTypeEnum.WATER, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_42.png",
                        350
                ));

        cards.add(buildCard(
                    "Spheal", 43, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_43.png",
                        363
                ));

        cards.add(buildCard(
                    "Sealeo", 44, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_44.png",
                        364
                ));

        cards.add(buildCard(
                    "Walrein", 45, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_45.png",
                        365
                ));

        cards.add(buildCard(
                    "Shellos", 46, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_46.png",
                        422
                ));

        cards.add(buildCard(
                    "Cryogonal", 47, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_47.png",
                        615
                ));

        cards.add(buildCard(
                    "Kyurem Preto ex", 48, CardTypeEnum.WATER, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_48.png",
                        646
                ));

        cards.add(buildCard(
                    "Bruxish", 49, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_49.png",
                        779
                ));

        cards.add(buildCard(
                    "Quaxly", 50, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_50.png",
                        912
                ));

        cards.add(buildCard(
                    "Quaxwell", 51, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_51.png",
                        913
                ));

        cards.add(buildCard(
                    "Quaquaval", 52, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_52.png",
                        914
                ));

        cards.add(buildCard(
                    "Cetoddle", 53, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_53.png",
                        974
                ));

        cards.add(buildCard(
                    "Cetitan", 54, CardTypeEnum.WATER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_54.png",
                        975
                ));

        cards.add(buildCard(
                    "Pacote Férreo", 55, CardTypeEnum.WATER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_55.png",
                        991
                ));

        cards.add(buildCard(
                    "Chien-Pao", 56, CardTypeEnum.WATER, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_56.png",
                        1002
                ));

        cards.add(buildCard(
                    "Pikachu ex", 57, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_57.png",
                        25
                ));

        cards.add(buildCard(
                    "Magnemite", 58, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_58.png",
                        81
                ));

        cards.add(buildCard(
                    "Magneton", 59, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_59.png",
                        82
                ));

        cards.add(buildCard(
                    "Magnezone", 60, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_60.png",
                        462
                ));

        cards.add(buildCard(
                    "Rotom", 61, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_61.png",
                        479
                ));

        cards.add(buildCard(
                    "Blitzle", 62, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_62.png",
                        522
                ));

        cards.add(buildCard(
                    "Zebstrika", 63, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_63.png",
                        523
                ));

        cards.add(buildCard(
                    "Stunfisk", 64, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_64.png",
                        618
                ));

        cards.add(buildCard(
                    "Tapu Koko", 65, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_65.png",
                        785
                ));

        cards.add(buildCard(
                    "Wattrel", 66, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_66.png",
                        940
                ));

        cards.add(buildCard(
                    "Kilowattrel", 67, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_67.png",
                        941
                ));

        cards.add(buildCard(
                    "Kilowattrel ex", 68, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_68.png",
                        941
                ));

        cards.add(buildCard(
                    "Miraidon", 69, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_69.png",
                        1008
                ));

        cards.add(buildCard(
                    "Togepi", 70, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_70.png",
                        175
                ));

        cards.add(buildCard(
                    "Togetic", 71, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_71.png",
                        176
                ));

        cards.add(buildCard(
                    "Togekiss", 72, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_72.png",
                        468
                ));

        cards.add(buildCard(
                    "Marill", 73, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_73.png",
                        183
                ));

        cards.add(buildCard(
                    "Azumarill", 74, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_74.png",
                        184
                ));

        cards.add(buildCard(
                    "Smoochum", 75, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_75.png",
                        238
                ));

        cards.add(buildCard(
                    "Latias ex", 76, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_76.png",
                        380
                ));

        cards.add(buildCard(
                    "Latios", 77, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_77.png",
                        381
                ));

        cards.add(buildCard(
                    "Uxie", 78, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_78.png",
                        480
                ));

        cards.add(buildCard(
                    "Mesprit", 79, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_79.png",
                        481
                ));

        cards.add(buildCard(
                    "Azelf", 80, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_80.png",
                        482
                ));

        cards.add(buildCard(
                    "Sigilyph", 81, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_81.png",
                        561
                ));

        cards.add(buildCard(
                    "Yamask", 82, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_82.png",
                        562
                ));

        cards.add(buildCard(
                    "Cofagrigus", 83, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_83.png",
                        563
                ));

        cards.add(buildCard(
                    "Espurr", 84, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_84.png",
                        677
                ));

        cards.add(buildCard(
                    "Meowstic", 85, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_85.png",
                        678
                ));

        cards.add(buildCard(
                    "Sylveon ex", 86, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_86.png",
                        700
                ));

        cards.add(buildCard(
                    "Dedenne", 87, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_87.png",
                        702
                ));

        cards.add(buildCard(
                    "Xerneas", 88, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_88.png",
                        716
                ));

        cards.add(buildCard(
                    "Oricorio", 89, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_89.png",
                        741
                ));

        cards.add(buildCard(
                    "Sandygast", 90, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_90.png",
                        769
                ));

        cards.add(buildCard(
                    "Palossand ex", 91, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_91.png",
                        770
                ));

        cards.add(buildCard(
                    "Tapu Lele", 92, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_92.png",
                        786
                ));

        cards.add(buildCard(
                    "Indeedee", 93, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_93.png",
                        876
                ));

        cards.add(buildCard(
                    "Flittle", 94, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_94.png",
                        955
                ));

        cards.add(buildCard(
                    "Espathra", 95, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_95.png",
                        956
                ));

        cards.add(buildCard(
                    "Juba Sopro", 96, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_96.png",
                        987
                ));

        cards.add(buildCard(
                    "Gimmighoul", 97, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_97.png",
                        999
                ));

        cards.add(buildCard(
                    "Mankey", 98, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_98.png",
                        56
                ));

        cards.add(buildCard(
                    "Primeape", 99, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_99.png",
                        57
                ));

        cards.add(buildCard(
                    "Annihilape", 100, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_100.png",
                        979
                ));

        cards.add(buildCard(
                    "Tauros de Paldea", 101, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_101.png",
                        128
                ));

        cards.add(buildCard(
                    "Phanpy", 102, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_102.png",
                        231
                ));

        cards.add(buildCard(
                    "Donphan", 103, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_103.png",
                        232
                ));

        cards.add(buildCard(
                    "Trapinch", 104, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_104.png",
                        328
                ));

        cards.add(buildCard(
                    "Vibrava", 105, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_105.png",
                        329
                ));

        cards.add(buildCard(
                    "Flygon ex", 106, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_106.png",
                        330
                ));

        cards.add(buildCard(
                    "Gastrodon", 107, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_107.png",
                        423
                ));

        cards.add(buildCard(
                    "Drilbur", 108, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_108.png",
                        529
                ));

        cards.add(buildCard(
                    "Excadrill", 109, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_109.png",
                        530
                ));

        cards.add(buildCard(
                    "Landorus", 110, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_110.png",
                        645
                ));

        cards.add(buildCard(
                    "Passimian", 111, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_111.png",
                        766
                ));

        cards.add(buildCard(
                    "Clobbopus", 112, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_112.png",
                        852
                ));

        cards.add(buildCard(
                    "Grapploct", 113, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_113.png",
                        853
                ));

        cards.add(buildCard(
                    "Glimmet", 114, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_114.png",
                        969
                ));

        cards.add(buildCard(
                    "Glimmora", 115, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_115.png",
                        970
                ));

        cards.add(buildCard(
                    "Koraidon", 116, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_116.png",
                        1007
                ));

        cards.add(buildCard(
                    "Deino", 117, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_117.png",
                        633
                ));

        cards.add(buildCard(
                    "Zweilous", 118, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_118.png",
                        634
                ));

        cards.add(buildCard(
                    "Hydreigon ex", 119, CardTypeEnum.DARK, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_119.png",
                        635
                ));

        cards.add(buildCard(
                    "Shroodle", 120, CardTypeEnum.DARK, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_120.png",
                        944
                ));

        cards.add(buildCard(
                    "Grafaiai", 121, CardTypeEnum.DARK, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_121.png",
                        945
                ));

        cards.add(buildCard(
                    "Diglett de Alola", 122, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_122.png",
                        50
                ));

        cards.add(buildCard(
                    "Dugtrio de Alola", 123, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_123.png",
                        51
                ));

        cards.add(buildCard(
                    "Skarmory", 124, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_124.png",
                        227
                ));

        cards.add(buildCard(
                    "Registeel", 125, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_125.png",
                        379
                ));

        cards.add(buildCard(
                    "Bronzor", 126, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_126.png",
                        436
                ));

        cards.add(buildCard(
                    "Bronzong", 127, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_127.png",
                        437
                ));

        cards.add(buildCard(
                    "Klefki", 128, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_128.png",
                        707
                ));

        cards.add(buildCard(
                    "Duraludon", 129, CardTypeEnum.STEEL, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_129.png",
                        884
                ));

        cards.add(buildCard(
                    "Archaludon ex", 130, CardTypeEnum.STEEL, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_130.png",
                        1018
                ));

        cards.add(buildCard(
                    "Gholdengo", 131, CardTypeEnum.STEEL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_131.png",
                        1000
                ));

        cards.add(buildCard(
                    "Chifres Férreos", 132, CardTypeEnum.STEEL, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_132.png",
                        1023
                ));

        cards.add(buildCard(
                    "Exeggutor de Alola ex", 133, CardTypeEnum.DRAGON, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_133.png",
                        103
                ));

        cards.add(buildCard(
                    "Altaria", 134, CardTypeEnum.DRAGON, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_134.png",
                        334
                ));

        cards.add(buildCard(
                    "Dialga", 135, CardTypeEnum.DRAGON, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_135.png",
                        483
                ));

        cards.add(buildCard(
                    "Palkia", 136, CardTypeEnum.DRAGON, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_136.png",
                        484
                ));

        cards.add(buildCard(
                    "Turtonator", 137, CardTypeEnum.DRAGON, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_137.png",
                        776
                ));

        cards.add(buildCard(
                    "Applin", 138, CardTypeEnum.DRAGON, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_138.png",
                        840
                ));

        cards.add(buildCard(
                    "Flapple", 139, CardTypeEnum.DRAGON, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_139.png",
                        841
                ));

        cards.add(buildCard(
                    "Appletun", 140, CardTypeEnum.DRAGON, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_140.png",
                        842
                ));

        cards.add(buildCard(
                    "Eternatus", 141, CardTypeEnum.DRAGON, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_141.png",
                        890
                ));

        cards.add(buildCard(
                    "Tatsugiri ex", 142, CardTypeEnum.DRAGON, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_142.png",
                        978
                ));

        cards.add(buildCard(
                    "Eevee", 143, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_143.png",
                        133
                ));

        cards.add(buildCard(
                    "Snorlax", 144, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_144.png",
                        143
                ));

        cards.add(buildCard(
                    "Slakoth", 145, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_145.png",
                        287
                ));

        cards.add(buildCard(
                    "Vigoroth", 146, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_146.png",
                        288
                ));

        cards.add(buildCard(
                    "Slaking ex", 147, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_147.png",
                        289
                ));

        cards.add(buildCard(
                    "Swablu", 148, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_148.png",
                        333
                ));

        cards.add(buildCard(
                    "Zangoose", 149, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_149.png",
                        335
                ));

        cards.add(buildCard(
                    "Kecleon", 150, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_150.png",
                        352
                ));

        cards.add(buildCard(
                    "Bouffalant", 151, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_151.png",
                        626
                ));

        cards.add(buildCard(
                    "Rufflet", 152, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_152.png",
                        627
                ));

        cards.add(buildCard(
                    "Braviary", 153, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_153.png",
                        628
                ));

        cards.add(buildCard(
                    "Helioptile", 154, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_154.png",
                        694
                ));

        cards.add(buildCard(
                    "Heliolisk", 155, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_155.png",
                        695
                ));

        cards.add(buildCard(
                    "Oranguru", 156, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_156.png",
                        765
                ));

        cards.add(buildCard(
                    "Tandemaus", 157, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_157.png",
                        924
                ));

        cards.add(buildCard(
                    "Maushold", 158, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_158.png",
                        925
                ));

        cards.add(buildCard(
                    "Cyclizar ex", 159, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_159.png",
                        967
                ));

        cards.add(buildCard(
                    "Flamigo ex", 160, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.DOUBLE_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_160.png",
                        973
                ));

        cards.add(buildCard(
                    "Terapagos", 161, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.RARE,
                        List.of(CardVariantEnum.HOLO, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_161.png",
                        1024
                ));

        cards.add(buildCard(
                    "Amuleto da Esperança", 162, CardTypeEnum.TOOL, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_162.png"
                ));

        cards.add(buildCard(
                    "Fruta Babiri", 163, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_163.png"
                ));

        cards.add(buildCard(
                    "Liquidificador Perfeito", 164, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_164.png"
                ));

        cards.add(buildCard(
                    "Sininho de Mesa", 165, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_165.png"
                ));

        cards.add(buildCard(
                    "Varinha Relaxante", 166, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_166.png"
                ));

        cards.add(buildCard(
                    "Sagacidade do Clemont", 167, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_167.png"
                ));

        cards.add(buildCard(
                    "Fruta Capicho", 168, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_168.png"
                ));

        cards.add(buildCard(
                    "Contra-ataque de Alcance", 169, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_169.png"
                ));

        cards.add(buildCard(
                    "Cyrano", 170, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_170.png"
                ));

        cards.add(buildCard(
                    "Kit de Investigação", 171, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_171.png"
                ));

        cards.add(buildCard(
                    "Elixir do Dragão", 172, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_172.png"
                ));

        cards.add(buildCard(
                    "Drasna", 173, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.COMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_173.png"
                ));

        cards.add(buildCard(
                    "Drayton", 174, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_174.png"
                ));

        cards.add(buildCard(
                    "Bola de Penumbra", 175, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_175.png"
                ));

        cards.add(buildCard(
                    "Busca de Energia Profissional", 176, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_176.png"
                ));

        cards.add(buildCard(
                    "Montanha da Gravidade", 177, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_177.png"
                ));

        cards.add(buildCard(
                    "Olhar da Jasmine", 178, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_178.png"
                ));

        cards.add(buildCard(
                    "Apelo da Elisia", 179, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_179.png"
                ));

        cards.add(buildCard(
                    "Estádio Animado", 180, CardTypeEnum.STADIUM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_180.png"
                ));

        cards.add(buildCard(
                    "Memorando Intrometido", 181, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_181.png"
                ));

        cards.add(buildCard(
                    "Ventilador Megaton", 182, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_182.png"
                ));

        cards.add(buildCard(
                    "Fone de Ouvido Milagroso", 183, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_183.png"
                ));

        cards.add(buildCard(
                    "Fruta Passho", 184, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_184.png"
                ));

        cards.add(buildCard(
                    "Carrinho Precioso", 185, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_185.png"
                ));

        cards.add(buildCard(
                    "Chave de Embaralhamento", 186, CardTypeEnum.ITEM, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_186.png"
                ));

        cards.add(buildCard(
                    "Surfista", 187, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_187.png"
                ));

        cards.add(buildCard(
                    "Máquina Técnica: Fluorita", 188, CardTypeEnum.TOOL, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_188.png"
                ));

        cards.add(buildCard(
                    "Orbe Tera", 189, CardTypeEnum.ITEM, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_189.png"
                ));

        cards.add(buildCard(
                    "Tomila", 190, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.UNCOMMON,
                        List.of(CardVariantEnum.NORMAL, CardVariantEnum.REVERSE_HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_190.png"
                ));

        cards.add(buildCard(
                    "Energia Enriquecedora", 191, CardTypeEnum.SPECIAL_ENERGY, 
                        CardRarityEnum.ACE_SPEC_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_191.png"
                ));

        cards.add(buildCard(
                    "Exeggcute", 192, CardTypeEnum.GRASS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_192.png",
                        102
                ));

        cards.add(buildCard(
                    "Vivillon", 193, CardTypeEnum.GRASS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_193.png",
                        666
                ));

        cards.add(buildCard(
                    "Shiinotic", 194, CardTypeEnum.GRASS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_194.png",
                        756
                ));

        cards.add(buildCard(
                    "Castform Forma Ensolarada", 195, CardTypeEnum.FIRE, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_195.png",
                        351
                ));

        cards.add(buildCard(
                    "Larvesta", 196, CardTypeEnum.FIRE, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_196.png",
                        636
                ));

        cards.add(buildCard(
                    "Ceruledge", 197, CardTypeEnum.FIRE, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_197.png",
                        937
                ));

        cards.add(buildCard(
                    "Feebas", 198, CardTypeEnum.WATER, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_198.png",
                        349
                ));

        cards.add(buildCard(
                    "Spheal", 199, CardTypeEnum.WATER, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_199.png",
                        363
                ));

        cards.add(buildCard(
                    "Bruxish", 200, CardTypeEnum.WATER, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_200.png",
                        779
                ));

        cards.add(buildCard(
                    "Cetitan", 201, CardTypeEnum.WATER, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_201.png",
                        975
                ));

        cards.add(buildCard(
                    "Stunfisk", 202, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_202.png",
                        618
                ));

        cards.add(buildCard(
                    "Latios", 203, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_203.png",
                        381
                ));

        cards.add(buildCard(
                    "Mesprit", 204, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_204.png",
                        481
                ));

        cards.add(buildCard(
                    "Phanpy", 205, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_205.png",
                        231
                ));

        cards.add(buildCard(
                    "Vibrava", 206, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_206.png",
                        329
                ));

        cards.add(buildCard(
                    "Clobbopus", 207, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_207.png",
                        852
                ));

        cards.add(buildCard(
                    "Dugtrio de Alola", 208, CardTypeEnum.STEEL, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_208.png",
                        51
                ));

        cards.add(buildCard(
                    "Skarmory", 209, CardTypeEnum.STEEL, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_209.png",
                        227
                ));

        cards.add(buildCard(
                    "Flapple", 210, CardTypeEnum.DRAGON, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_210.png",
                        841
                ));

        cards.add(buildCard(
                    "Appletun", 211, CardTypeEnum.DRAGON, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_211.png",
                        842
                ));

        cards.add(buildCard(
                    "Slakoth", 212, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_212.png",
                        287
                ));

        cards.add(buildCard(
                    "Kecleon", 213, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_213.png",
                        352
                ));

        cards.add(buildCard(
                    "Braviary", 214, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_214.png",
                        628
                ));

        cards.add(buildCard(
                    "Durant ex", 215, CardTypeEnum.GRASS, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_215.png",
                        632
                ));

        cards.add(buildCard(
                    "Scovillain ex", 216, CardTypeEnum.FIRE, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_216.png",
                        952
                ));

        cards.add(buildCard(
                    "Milotic ex", 217, CardTypeEnum.WATER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_217.png",
                        350
                ));

        cards.add(buildCard(
                    "Kyurem Preto ex", 218, CardTypeEnum.WATER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_218.png",
                        646
                ));

        cards.add(buildCard(
                    "Pikachu ex", 219, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_219.png",
                        25
                ));

        cards.add(buildCard(
                    "Latias ex", 220, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_220.png",
                        380
                ));

        cards.add(buildCard(
                    "Palossand ex", 221, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_221.png",
                        770
                ));

        cards.add(buildCard(
                    "Flygon ex", 222, CardTypeEnum.FIGHTING, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_222.png",
                        330
                ));

        cards.add(buildCard(
                    "Hydreigon ex", 223, CardTypeEnum.DARK, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_223.png",
                        635
                ));

        cards.add(buildCard(
                    "Archaludon ex", 224, CardTypeEnum.STEEL, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_224.png",
                        1018
                ));

        cards.add(buildCard(
                    "Exeggutor de Alola ex", 225, CardTypeEnum.DRAGON, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_225.png",
                        103
                ));

        cards.add(buildCard(
                    "Tatsugiri ex", 226, CardTypeEnum.DRAGON, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_226.png",
                        978
                ));

        cards.add(buildCard(
                    "Slaking ex", 227, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_227.png",
                        289
                ));

        cards.add(buildCard(
                    "Cyclizar ex", 228, CardTypeEnum.COLORLESS, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_228.png",
                        967
                ));

        cards.add(buildCard(
                    "Sagacidade do Clemont", 229, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_229.png"
                ));

        cards.add(buildCard(
                    "Cyrano", 230, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_230.png"
                ));

        cards.add(buildCard(
                    "Drasna", 231, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_231.png"
                ));

        cards.add(buildCard(
                    "Drayton", 232, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_232.png"
                ));

        cards.add(buildCard(
                    "Olhar da Jasmine", 233, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_233.png"
                ));

        cards.add(buildCard(
                    "Apelo da Elisia", 234, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_234.png"
                ));

        cards.add(buildCard(
                    "Surfista", 235, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.ULTRA_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_235.png"
                ));

        cards.add(buildCard(
                    "Durant ex", 236, CardTypeEnum.GRASS, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_236.png",
                        632
                ));

        cards.add(buildCard(
                    "Milotic ex", 237, CardTypeEnum.WATER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_237.png",
                        350
                ));

        cards.add(buildCard(
                    "Pikachu ex", 238, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_238.png",
                        25
                ));

        cards.add(buildCard(
                    "Latias ex", 239, CardTypeEnum.PSYCHIC, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_239.png",
                        380
                ));

        cards.add(buildCard(
                    "Hydreigon ex", 240, CardTypeEnum.DARK, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_240.png",
                        635
                ));

        cards.add(buildCard(
                    "Archaludon ex", 241, CardTypeEnum.STEEL, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_241.png",
                        1018
                ));

        cards.add(buildCard(
                    "Exeggutor de Alola ex", 242, CardTypeEnum.DRAGON, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_242.png",
                        103
                ));

        cards.add(buildCard(
                    "Sagacidade do Clemont", 243, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_243.png"
                ));

        cards.add(buildCard(
                    "Drayton", 244, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_244.png"
                ));

        cards.add(buildCard(
                    "Olhar da Jasmine", 245, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_245.png"
                ));

        cards.add(buildCard(
                    "Apelo da Elisia", 246, CardTypeEnum.SUPPORTER, 
                        CardRarityEnum.SPECIAL_ILLUSTRATION_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_246.png"
                ));

        cards.add(buildCard(
                    "Pikachu ex", 247, CardTypeEnum.ELECTRIC, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_247.png",
                        25
                ));

        cards.add(buildCard(
                    "Exeggutor de Alola ex", 248, CardTypeEnum.DRAGON, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_248.png",
                        103
                ));

        cards.add(buildCard(
                    "Contra-ataque de Alcance", 249, CardTypeEnum.TOOL, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_249.png"
                ));

        cards.add(buildCard(
                    "Montanha da Gravidade", 250, CardTypeEnum.STADIUM, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_250.png"
                ));

        cards.add(buildCard(
                    "Maca Noturna", 251, CardTypeEnum.ITEM, 
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_251.png"
                ));

        cards.add(buildCard(
                    "Energia a Jato", 252, CardTypeEnum.SPECIAL_ENERGY, "G",
                        CardRarityEnum.SECRET_RARE,
                        List.of(CardVariantEnum.HOLO),
                        "https://assets.pokemon.com/static-assets/content-assets/cms2-pt-br/img/cards/web/SV08/SV08_PT-BR_252.png"
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
