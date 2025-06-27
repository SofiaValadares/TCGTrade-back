package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Gen8Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(8);
        generation.setRegion("Galar");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(810, "Grookey", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/810.png"),
                new PokemonModel(811, "Thwackey", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/811.png"),
                new PokemonModel(812, "Rillaboom", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/812.png"),
                new PokemonModel(813, "Scorbunny", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/813.png"),
                new PokemonModel(814, "Raboot", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/814.png"),
                new PokemonModel(815, "Cinderace", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/815.png"),
                new PokemonModel(816, "Sobble", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/816.png"),
                new PokemonModel(817, "Drizzile", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/817.png"),
                new PokemonModel(818, "Inteleon", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/818.png"),
                new PokemonModel(819, "Skwovet", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/819.png"),
                new PokemonModel(820, "Greedent", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/820.png"),
                new PokemonModel(821, "Rookidee", generation, PokemonTypeEnum.FLYING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/821.png"),
                new PokemonModel(822, "Corvisquire", generation, PokemonTypeEnum.FLYING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/822.png"),
                new PokemonModel(823, "Corviknight", generation, PokemonTypeEnum.FLYING, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/823.png"),
                new PokemonModel(824, "Blipbug", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/824.png"),
                new PokemonModel(825, "Dottler", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/825.png"),
                new PokemonModel(826, "Orbeetle", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/826.png"),
                new PokemonModel(827, "Nickit", generation, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/827.png"),
                new PokemonModel(828, "Thievul", generation, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/828.png"),
                new PokemonModel(829, "Gossifleur", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/829.png"),
                new PokemonModel(830, "Eldegoss", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/830.png"),
                new PokemonModel(831, "Wooloo", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/831.png"),
                new PokemonModel(832, "Dubwool", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/832.png"),
                new PokemonModel(833, "Chewtle", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/833.png"),
                new PokemonModel(834, "Drednaw", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/834.png"),
                new PokemonModel(835, "Yamper", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/835.png"),
                new PokemonModel(836, "Boltund", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/836.png"),
                new PokemonModel(837, "Rolycoly", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/837.png"),
                new PokemonModel(838, "Carkol", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/838.png"),
                new PokemonModel(839, "Coalossal", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/839.png"),
                new PokemonModel(840, "Applin", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/840.png"),
                new PokemonModel(841, "Flapple", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/841.png"),
                new PokemonModel(842, "Appletun", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/842.png"),
                new PokemonModel(843, "Silicobra", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/843.png"),
                new PokemonModel(844, "Sandaconda", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/844.png"),
                new PokemonModel(845, "Cramorant", generation, PokemonTypeEnum.FLYING, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/845.png"),
                new PokemonModel(846, "Arrokuda", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/846.png"),
                new PokemonModel(847, "Barraskewda", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/847.png"),
                new PokemonModel(848, "Toxel", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/848.png"),
                new PokemonModel(849, "Toxtricity", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/849.png"),
                new PokemonModel(850, "Sizzlipede", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/850.png"),
                new PokemonModel(851, "Centiskorch", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/851.png"),
                new PokemonModel(852, "Clobbopus", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/852.png"),
                new PokemonModel(853, "Grapploct", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/853.png"),
                new PokemonModel(854, "Sinistea", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/854.png"),
                new PokemonModel(855, "Polteageist", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/855.png"),
                new PokemonModel(856, "Hatenna", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/856.png"),
                new PokemonModel(857, "Hattrem", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/857.png"),
                new PokemonModel(858, "Hatterene", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/858.png"),
                new PokemonModel(859, "Impidimp", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/859.png"),
                new PokemonModel(860, "Morgrem", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/860.png"),
                new PokemonModel(861, "Grimmsnarl", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/861.png"),
                new PokemonModel(862, "Obstagoon", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/862.png"),
                new PokemonModel(863, "Perrserker", generation, PokemonTypeEnum.STEEL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/863.png"),
                new PokemonModel(864, "Cursola", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/864.png"),
                new PokemonModel(865, "Sirfetch'd", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/865.png"),
                new PokemonModel(866, "Mr. Rime", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/866.png"),
                new PokemonModel(867, "Runerigus", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/867.png"),
                new PokemonModel(868, "Milcery", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/868.png"),
                new PokemonModel(869, "Alcremie", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/869.png"),
                new PokemonModel(870, "Falinks", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/870.png"),
                new PokemonModel(871, "Pincurchin", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/871.png"),
                new PokemonModel(872, "Snom", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/872.png"),
                new PokemonModel(873, "Frosmoth", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/873.png"),
                new PokemonModel(874, "Stonjourner", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/874.png"),
                new PokemonModel(875, "Eiscue", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/875.png"),
                new PokemonModel(876, "Indeedee", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/876.png"),
                new PokemonModel(877, "Morpeko", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/877.png"),
                new PokemonModel(878, "Cufant", generation, PokemonTypeEnum.STEEL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/878.png"),
                new PokemonModel(879, "Copperajah", generation, PokemonTypeEnum.STEEL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/879.png"),
                new PokemonModel(880, "Dracozolt", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/880.png"),
                new PokemonModel(881, "Arctozolt", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/881.png"),
                new PokemonModel(882, "Dracovish", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/882.png"),
                new PokemonModel(883, "Arctovish", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/883.png"),
                new PokemonModel(884, "Duraludon", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/884.png"),
                new PokemonModel(885, "Dreepy", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/885.png"),
                new PokemonModel(886, "Drakloak", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/886.png"),
                new PokemonModel(887, "Dragapult", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/887.png"),
                new PokemonModel(888, "Zacian", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/888.png"),
                new PokemonModel(889, "Zamazenta", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/889.png"),
                new PokemonModel(890, "Eternatus", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/890.png"),
                new PokemonModel(891, "Kubfu", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/891.png"),
                new PokemonModel(892, "Urshifu", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/892.png"),
                new PokemonModel(893, "Zarude", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/893.png"),
                new PokemonModel(894, "Regieleki", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/894.png"),
                new PokemonModel(895, "Regidrago", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/895.png"),
                new PokemonModel(896, "Glastrier", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/896.png"),
                new PokemonModel(897, "Spectrier", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/897.png"),
                new PokemonModel(898, "Calyrex", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/898.png"),
                new PokemonModel(899, "Wyrdeer", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/899.png"),
                new PokemonModel(900, "Kleavor", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/900.png"),
                new PokemonModel(901, "Ursaluna", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/901.png"),
                new PokemonModel(902, "Basculegion", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/902.png"),
                new PokemonModel(903, "Sneasler", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/903.png"),
                new PokemonModel(904, "Overqwil", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/904.png"),
                new PokemonModel(905, "Enamorus", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/905.png")
        );
    }
}
