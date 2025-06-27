package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Gen9Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(9);
        generation.setRegion("Paldea");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(906, "Sprigatito", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/906.png"),
                new PokemonModel(907, "Floragato", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/907.png"),
                new PokemonModel(908, "Meowscarada", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/908.png"),
                new PokemonModel(909, "Fuecoco", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/909.png"),
                new PokemonModel(910, "Crocalor", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/910.png"),
                new PokemonModel(911, "Skeledirge", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/911.png"),
                new PokemonModel(912, "Quaxly", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/912.png"),
                new PokemonModel(913, "Quaxwell", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/913.png"),
                new PokemonModel(914, "Quaquaval", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/914.png"),
                new PokemonModel(915, "Lechonk", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/915.png"),
                new PokemonModel(916, "Oinkologne", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/916.png"),
                new PokemonModel(917, "Tarountula", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/917.png"),
                new PokemonModel(918, "Spidops", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/918.png"),
                new PokemonModel(919, "Nymble", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/919.png"),
                new PokemonModel(920, "Lokix", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/920.png"),
                new PokemonModel(921, "Pawmi", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/921.png"),
                new PokemonModel(922, "Pawmo", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/922.png"),
                new PokemonModel(923, "Pawmot", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/923.png"),
                new PokemonModel(924, "Tandemaus", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/924.png"),
                new PokemonModel(925, "Maushold", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/925.png"),
                new PokemonModel(926, "Fidough", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/926.png"),
                new PokemonModel(927, "Dachsbun", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/927.png"),
                new PokemonModel(928, "Smoliv", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/928.png"),
                new PokemonModel(929, "Dolliv", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/929.png"),
                new PokemonModel(930, "Arboliva", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/930.png"),
                new PokemonModel(931, "Squawkabilly", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/931.png"),
                new PokemonModel(932, "Nacli", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/932.png"),
                new PokemonModel(933, "Naclstack", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/933.png"),
                new PokemonModel(934, "Garganacl", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/934.png"),
                new PokemonModel(935, "Charcadet", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/935.png"),
                new PokemonModel(936, "Armarouge", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/936.png"),
                new PokemonModel(937, "Ceruledge", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/937.png"),
                new PokemonModel(938, "Tadbulb", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/938.png"),
                new PokemonModel(939, "Bellibolt", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/939.png"),
                new PokemonModel(940, "Wattrel", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/940.png"),
                new PokemonModel(941, "Kilowattrel", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/941.png"),
                new PokemonModel(942, "Maschiff", generation, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/942.png"),
                new PokemonModel(943, "Mabosstiff", generation, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/943.png"),
                new PokemonModel(944, "Shroodle", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/944.png"),
                new PokemonModel(945, "Grafaiai", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/945.png"),
                new PokemonModel(946, "Bramblin", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/946.png"),
                new PokemonModel(947, "Brambleghast", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/947.png"),
                new PokemonModel(948, "Toedscool", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/948.png"),
                new PokemonModel(949, "Toedscruel", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/949.png"),
                new PokemonModel(950, "Klawf", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/950.png"),
                new PokemonModel(951, "Capsakid", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/951.png"),
                new PokemonModel(952, "Scovillain", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/952.png"),
                new PokemonModel(953, "Rellor", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/953.png"),
                new PokemonModel(954, "Rabsca", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/954.png"),
                new PokemonModel(955, "Flittle", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/955.png"),
                new PokemonModel(956, "Espathra", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/956.png"),
                new PokemonModel(957, "Tinkatink", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/957.png"),
                new PokemonModel(958, "Tinkatuff", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/958.png"),
                new PokemonModel(959, "Tinkaton", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/959.png"),
                new PokemonModel(960, "Wiglett", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/960.png"),
                new PokemonModel(961, "Wugtrio", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/961.png"),
                new PokemonModel(962, "Bombirdier", generation, PokemonTypeEnum.FLYING, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/962.png"),
                new PokemonModel(963, "Finizen", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/963.png"),
                new PokemonModel(964, "Palafin", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/964.png"),
                new PokemonModel(965, "Varoom", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/965.png"),
                new PokemonModel(966, "Revavroom", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/966.png"),
                new PokemonModel(967, "Cyclizar", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/967.png"),
                new PokemonModel(968, "Orthworm", generation, PokemonTypeEnum.STEEL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/968.png"),
                new PokemonModel(969, "Glimmet", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/969.png"),
                new PokemonModel(970, "Glimmora", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/970.png"),
                new PokemonModel(971, "Greavard", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/971.png"),
                new PokemonModel(972, "Houndstone", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/972.png"),
                new PokemonModel(973, "Flamigo", generation, PokemonTypeEnum.FLYING, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/973.png"),
                new PokemonModel(974, "Cetoddle", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/974.png"),
                new PokemonModel(975, "Cetitan", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/975.png"),
                new PokemonModel(976, "Veluza", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/976.png"),
                new PokemonModel(977, "Dondozo", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/977.png"),
                new PokemonModel(978, "Tatsugiri", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/978.png"),
                new PokemonModel(979, "Annihilape", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/979.png"),
                new PokemonModel(980, "Clodsire", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/980.png"),
                new PokemonModel(981, "Farigiraf", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/981.png"),
                new PokemonModel(982, "Dudunsparce", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/982.png"),
                new PokemonModel(983, "Kingambit", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/983.png"),
                new PokemonModel(984, "Great Tusk", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/984.png"),
                new PokemonModel(985, "Scream Tail", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/985.png"),
                new PokemonModel(986, "Brute Bonnet", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/986.png"),
                new PokemonModel(987, "Flutter Mane", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/987.png"),
                new PokemonModel(988, "Slither Wing", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/988.png"),
                new PokemonModel(989, "Sandy Shocks", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/989.png"),
                new PokemonModel(990, "Iron Treads", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/990.png"),
                new PokemonModel(991, "Iron Bundle", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/991.png"),
                new PokemonModel(992, "Iron Hands", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.ELECTRIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/992.png"),
                new PokemonModel(993, "Iron Jugulis", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/993.png"),
                new PokemonModel(994, "Iron Moth", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/994.png"),
                new PokemonModel(995, "Iron Thorns", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.ELECTRIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/995.png"),
                new PokemonModel(996, "Frigibax", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/996.png"),
                new PokemonModel(997, "Arctibax", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/997.png"),
                new PokemonModel(998, "Baxcalibur", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/998.png"),
                new PokemonModel(999, "Gimmighoul", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/999.png"),
                new PokemonModel(1000, "Gholdengo", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1000.png"),
                new PokemonModel(1001, "Wo-Chien", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1001.png"),
                new PokemonModel(1002, "Chien-Pao", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1002.png"),
                new PokemonModel(1003, "Ting-Lu", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1003.png"),
                new PokemonModel(1004, "Chi-Yu", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1004.png"),
                new PokemonModel(1005, "Roaring Moon", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1005.png"),
                new PokemonModel(1006, "Iron Valiant", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1006.png"),
                new PokemonModel(1007, "Koraidon", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1007.png"),
                new PokemonModel(1008, "Miraidon", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1008.png"),
                new PokemonModel(1009, "Walking Wake", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1009.png"),
                new PokemonModel(1010, "Iron Leaves", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1010.png"),
                new PokemonModel(1011, "Dipplin", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1011.png"),
                new PokemonModel(1012, "Poltchageist", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1012.png"),
                new PokemonModel(1013, "Sinistcha", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1013.png"),
                new PokemonModel(1014, "Okidogi", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1014.png"),
                new PokemonModel(1015, "Munkidori", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1015.png"),
                new PokemonModel(1016, "Fezandipiti", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1016.png"),
                new PokemonModel(1017, "Ogerpon", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1017.png"),
                new PokemonModel(1018, "Archaludon", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1018.png"),
                new PokemonModel(1019, "Hydrapple", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1019.png"),
                new PokemonModel(1020, "Gouging Fire", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1020.png"),
                new PokemonModel(1021, "Raging Bolt", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1021.png"),
                new PokemonModel(1022, "Iron Boulder", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1022.png"),
                new PokemonModel(1023, "Iron Crown", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1023.png"),
                new PokemonModel(1024, "Terapagos", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1024.png"),
                new PokemonModel(1025, "Pecharunt", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1025.png")
        );
    }
}
