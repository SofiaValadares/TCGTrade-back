package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.util.Arrays;
import java.util.List;

public class Gen1Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(1);
        generation.setRegion("Kanto");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(1, "Bulbasaur", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
                new PokemonModel(2, "Ivysaur", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"),
                new PokemonModel(3, "Venusaur", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"),
                new PokemonModel(4, "Charmander", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
                new PokemonModel(5, "Charmeleon", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png"),
                new PokemonModel(6, "Charizard", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"),
                new PokemonModel(7, "Squirtle", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"),
                new PokemonModel(8, "Wartortle", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png"),
                new PokemonModel(9, "Blastoise", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png"),
                new PokemonModel(10, "Caterpie", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png"),
                new PokemonModel(11, "Metapod", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png"),
                new PokemonModel(12, "Butterfree", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png"),
                new PokemonModel(13, "Weedle", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png"),
                new PokemonModel(14, "Kakuna", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png"),
                new PokemonModel(15, "Beedrill", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png"),
                new PokemonModel(16, "Pidgey", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png"),
                new PokemonModel(17, "Pidgeotto", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png"),
                new PokemonModel(18, "Pidgeot", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png"),
                new PokemonModel(19, "Rattata", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png"),
                new PokemonModel(20, "Raticate", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png"),
                new PokemonModel(21, "Spearow", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png"),
                new PokemonModel(22, "Fearow", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/22.png"),
                new PokemonModel(23, "Ekans", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png"),
                new PokemonModel(24, "Arbok", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/24.png"),
                new PokemonModel(25, "Pikachu", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"),
                new PokemonModel(26, "Raichu", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png"),
                new PokemonModel(27, "Sandshrew", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/27.png"),
                new PokemonModel(28, "Sandslash", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/28.png"),
                new PokemonModel(29, "Nidoran", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/29.png"),
                new PokemonModel(30, "Nidorina", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/30.png"),
                new PokemonModel(31, "Nidoqueen", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/31.png"),
                new PokemonModel(32, "Nidoran", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/32.png"),
                new PokemonModel(33, "Nidorino", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/33.png"),
                new PokemonModel(34, "Nidoking", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/34.png"),
                new PokemonModel(35, "Clefairy", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png"),
                new PokemonModel(36, "Clefable", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/36.png"),
                new PokemonModel(37, "Vulpix", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/37.png"),
                new PokemonModel(38, "Ninetales", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/38.png"),
                new PokemonModel(39, "Jigglypuff", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png"),
                new PokemonModel(40, "Wigglypuff", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/40.png"),
                new PokemonModel(41, "Zubat", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/41.png"),
                new PokemonModel(42, "Golbat", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/42.png"),
                new PokemonModel(43, "Oddish", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/43.png"),
                new PokemonModel(44, "Gloom", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/44.png"),
                new PokemonModel(45, "Vileplume", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/45.png"),
                new PokemonModel(46, "Paras", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/46.png"),
                new PokemonModel(47, "Parasect", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/47.png"),
                new PokemonModel(48, "Venonat", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/48.png"),
                new PokemonModel(49, "Venomoth", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/49.png"),
                new PokemonModel(50, "Diglett", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/50.png"),
                new PokemonModel(51, "Dugtrio", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/51.png"),
                new PokemonModel(52, "Meowth", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/52.png"),
                new PokemonModel(53, "Persian", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/53.png"),
                new PokemonModel(54, "Psyduck", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/54.png"),
                new PokemonModel(55, "Golduck", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/55.png"),
                new PokemonModel(56, "Mankey", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/56.png"),
                new PokemonModel(57, "Primeape", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/57.png"),
                new PokemonModel(58, "Growlithe", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/58.png"),
                new PokemonModel(59, "Arcanine", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/59.png"),
                new PokemonModel(60, "Poliwag", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/60.png"),
                new PokemonModel(61, "Poliwhirl", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/61.png"),
                new PokemonModel(62, "Poliwrath", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/62.png"),
                new PokemonModel(63, "Abra", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/63.png"),
                new PokemonModel(64, "Kadabra", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/64.png"),
                new PokemonModel(65, "Alakazam", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/65.png"),
                new PokemonModel(66, "Machop", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/66.png"),
                new PokemonModel(67, "Machoke", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/67.png"),
                new PokemonModel(68, "Machamp", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/68.png"),
                new PokemonModel(69, "Bellsprout", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/69.png"),
                new PokemonModel(70, "Weepinbell", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/70.png"),
                new PokemonModel(71, "Victreebel", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/71.png"),
                new PokemonModel(72, "Tentacool", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/72.png"),
                new PokemonModel(73, "Tentacruel", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/73.png"),
                new PokemonModel(74, "Geodude", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/74.png"),
                new PokemonModel(75, "Graveler", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/75.png"),
                new PokemonModel(76, "Golem", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/76.png"),
                new PokemonModel(77, "Ponyta", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/77.png"),
                new PokemonModel(78, "Rapidash", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/78.png"),
                new PokemonModel(79, "Slowpoke", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/79.png"),
                new PokemonModel(80, "Slowbro", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/80.png"),
                new PokemonModel(81, "Magnemite", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/81.png"),
                new PokemonModel(82, "Magneton", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/82.png"),
                new PokemonModel(83, "Farfetch'd", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/83.png"),
                new PokemonModel(84, "Doduo", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/84.png"),
                new PokemonModel(85, "Dodrio", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/85.png"),
                new PokemonModel(86, "Seel", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/86.png"),
                new PokemonModel(87, "Dewgong", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/87.png"),
                new PokemonModel(88, "Grimer", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/88.png"),
                new PokemonModel(89, "Muk", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/89.png"),
                new PokemonModel(90, "Shellder", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/90.png"),
                new PokemonModel(91, "Cloyster", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/91.png"),
                new PokemonModel(92, "Gastly", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/92.png"),
                new PokemonModel(93, "Haunter", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/93.png"),
                new PokemonModel(94, "Gengar", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/94.png"),
                new PokemonModel(95, "Onix", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/95.png"),
                new PokemonModel(96, "Drowzee", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/96.png"),
                new PokemonModel(97, "Hypno", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/97.png"),
                new PokemonModel(98, "Krabby", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/98.png"),
                new PokemonModel(99, "Kingler", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/99.png"),
                new PokemonModel(100, "Voltorb", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/100.png"),
                new PokemonModel(101, "Electrode", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/101.png"),
                new PokemonModel(102, "Exeggcute", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/102.png"),
                new PokemonModel(103, "Exeggutor", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/103.png"),
                new PokemonModel(104, "Cubone", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/104.png"),
                new PokemonModel(105, "Marowak", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/105.png"),
                new PokemonModel(106, "Hitmonlee", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/106.png"),
                new PokemonModel(107, "Hitmonchan", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/107.png"),
                new PokemonModel(108, "Lickitung", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/108.png"),
                new PokemonModel(109, "Koffing", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/109.png"),
                new PokemonModel(110, "Weezing", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/110.png"),
                new PokemonModel(111, "Rhyhorn", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/111.png"),
                new PokemonModel(112, "Rhydon", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png"),
                new PokemonModel(113, "Chansey", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/113.png"),
                new PokemonModel(114, "Tangela", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/114.png"),
                new PokemonModel(115, "Kangaskhan", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/115.png"),
                new PokemonModel(116, "Horsea", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/116.png"),
                new PokemonModel(117, "Seadra", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/117.png"),
                new PokemonModel(118, "Goldeen", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/118.png"),
                new PokemonModel(119, "Seaking", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/119.png"),
                new PokemonModel(120, "Staryu", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/120.png"),
                new PokemonModel(121, "Starmie", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/121.png"),
                new PokemonModel(122, "Mr. Mime", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/122.png"),
                new PokemonModel(123, "Scyther", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/123.png"),
                new PokemonModel(124, "Jynx", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/124.png"),
                new PokemonModel(125, "Electabuzz", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/125.png"),
                new PokemonModel(126, "Magmar", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/126.png"),
                new PokemonModel(127, "Pinsir", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/127.png"),
                new PokemonModel(128, "Tauros", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/128.png"),
                new PokemonModel(129, "Magikarp", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/129.png"),
                new PokemonModel(130, "Gyarados", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/130.png"),
                new PokemonModel(131, "Lapras", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/131.png"),
                new PokemonModel(132, "Ditto", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"),
                new PokemonModel(133, "Eevee", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/133.png"),
                new PokemonModel(134, "Vaporeon", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/134.png"),
                new PokemonModel(135, "Jolteon", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/135.png"),
                new PokemonModel(136, "Flareon", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/136.png"),
                new PokemonModel(137, "Porygon", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/137.png"),
                new PokemonModel(138, "Omanyte", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/138.png"),
                new PokemonModel(139, "Omastar", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/139.png"),
                new PokemonModel(140, "Kabuto", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/140.png"),
                new PokemonModel(141, "Kabutops", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/141.png"),
                new PokemonModel(142, "Aerodactyl", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/142.png"),
                new PokemonModel(143, "Snorlax", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png"),
                new PokemonModel(144, "Articuno", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/144.png"),
                new PokemonModel(145, "Zapdos", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/145.png"),
                new PokemonModel(146, "Moltres", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png"),
                new PokemonModel(147, "Dratini", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/147.png"),
                new PokemonModel(148, "Dragonair", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/148.png"),
                new PokemonModel(149, "Dragonite", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/149.png"),
                new PokemonModel(150, "Mewtwo", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png"),
                new PokemonModel(151, "Mew", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/151.png")
        );
    }
}
