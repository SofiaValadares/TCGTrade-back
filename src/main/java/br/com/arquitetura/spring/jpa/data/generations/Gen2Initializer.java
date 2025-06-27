package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.util.Arrays;
import java.util.List;

public class Gen2Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(2);
        generation.setRegion("Johto");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(152, "Chikorita", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/152.png"),
                new PokemonModel(153, "Bayleef", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/153.png"),
                new PokemonModel(154, "Meganium", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/154.png"),
                new PokemonModel(155, "Cyndaquil", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/155.png"),
                new PokemonModel(156, "Quilava", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/156.png"),
                new PokemonModel(157, "Typhlosion", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/157.png"),
                new PokemonModel(158, "Totodile", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/158.png"),
                new PokemonModel(159, "Croconaw", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/159.png"),
                new PokemonModel(160, "Feraligatr", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/160.png"),
                new PokemonModel(161, "Sentret", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/161.png"),
                new PokemonModel(162, "Furret", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/162.png"),
                new PokemonModel(163, "Hoothoot", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/163.png"),
                new PokemonModel(164, "Noctowl", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/164.png"),
                new PokemonModel(165, "Ledyba", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/165.png"),
                new PokemonModel(166, "Ledian", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/166.png"),
                new PokemonModel(167, "Spinarak", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/167.png"),
                new PokemonModel(168, "Ariados", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/168.png"),
                new PokemonModel(169, "Crobat", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/169.png"),
                new PokemonModel(170, "Chinchou", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ELECTRIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/170.png"),
                new PokemonModel(171, "Lanturn", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ELECTRIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/171.png"),
                new PokemonModel(172, "Pichu", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/172.png"),
                new PokemonModel(173, "Cleffa", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/173.png"),
                new PokemonModel(174, "Igglybuff", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/174.png"),
                new PokemonModel(175, "Togepi", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/175.png"),
                new PokemonModel(176, "Togetic", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/176.png"),
                new PokemonModel(177, "Natu", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/177.png"),
                new PokemonModel(178, "Xatu", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/178.png"),
                new PokemonModel(179, "Mareep", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/179.png"),
                new PokemonModel(180, "Flaaffy", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/180.png"),
                new PokemonModel(181, "Ampharos", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/181.png"),
                new PokemonModel(182, "Bellossom", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/182.png"),
                new PokemonModel(183, "Marill", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/183.png"),
                new PokemonModel(184, "Azumarill", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/184.png"),
                new PokemonModel(185, "Sudowoodo", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/185.png"),
                new PokemonModel(186, "Politoed", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/186.png"),
                new PokemonModel(187, "Hoppip", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/187.png"),
                new PokemonModel(188, "Skiploom", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/188.png"),
                new PokemonModel(189, "Jumpluff", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/189.png"),
                new PokemonModel(190, "Aipom", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/190.png"),
                new PokemonModel(191, "Sunkern", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/191.png"),
                new PokemonModel(192, "Sunflora", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/192.png"),
                new PokemonModel(193, "Yanma", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/193.png"),
                new PokemonModel(194, "Wooper", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/194.png"),
                new PokemonModel(195, "Quagsire", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/195.png"),
                new PokemonModel(196, "Espeon", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/196.png"),
                new PokemonModel(197, "Umbreon", generation, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/197.png"),
                new PokemonModel(198, "Murkrow", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/198.png"),
                new PokemonModel(199, "Slowking", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/199.png"),
                new PokemonModel(200, "Misdreavous", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/200.png"),
                new PokemonModel(201, "Unown", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/201.png"),
                new PokemonModel(202, "Wobbuffet", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/202.png"),
                new PokemonModel(203, "Girafarig", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/203.png"),
                new PokemonModel(204, "Pineco", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/204.png"),
                new PokemonModel(205, "Forretress", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/205.png"),
                new PokemonModel(206, "Dunsparce", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/206.png"),
                new PokemonModel(207, "Gligar", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/207.png"),
                new PokemonModel(208, "Steelix", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/208.png"),
                new PokemonModel(209, "Snubbull", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/209.png"),
                new PokemonModel(210, "Granbull", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/210.png"),
                new PokemonModel(211, "Qwilfish", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/211.png"),
                new PokemonModel(212, "Scizor", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/212.png"),
                new PokemonModel(213, "Shuckle", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/213.png"),
                new PokemonModel(214, "Heracross", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/214.png"),
                new PokemonModel(215, "Sneasel", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/215.png"),
                new PokemonModel(216, "Teddiursa", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/216.png"),
                new PokemonModel(217, "Ursaring", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/217.png"),
                new PokemonModel(218, "Slugma", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/218.png"),
                new PokemonModel(219, "Magcargo", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/219.png"),
                new PokemonModel(220, "Swinub", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/220.png"),
                new PokemonModel(221, "Piloswine", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/221.png"),
                new PokemonModel(222, "Corsola", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/222.png"),
                new PokemonModel(223, "Remoraid", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/223.png"),
                new PokemonModel(224, "Octillery", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/224.png"),
                new PokemonModel(225, "Delibird", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/225.png"),
                new PokemonModel(226, "Mantine", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/226.png"),
                new PokemonModel(227, "Skarmory", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/227.png"),
                new PokemonModel(228, "Houndour", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/228.png"),
                new PokemonModel(229, "Houndoom", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/229.png"),
                new PokemonModel(230, "Kingdra", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/230.png"),
                new PokemonModel(231, "Phanpy", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/231.png"),
                new PokemonModel(232, "Donphan", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/232.png"),
                new PokemonModel(233, "Porygon2", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/233.png"),
                new PokemonModel(234, "Stantler", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/234.png"),
                new PokemonModel(235, "Smeargle", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/235.png"),
                new PokemonModel(236, "Tyrogue", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/236.png"),
                new PokemonModel(237, "Hitmontop", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/237.png"),
                new PokemonModel(238, "Smoochum", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/238.png"),
                new PokemonModel(239, "Elekid", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/239.png"),
                new PokemonModel(240, "Magby", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/240.png"),
                new PokemonModel(241, "Miltank", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/241.png"),
                new PokemonModel(242, "Blissey", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/242.png"),
                new PokemonModel(243, "Raikou", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/243.png"),
                new PokemonModel(244, "Entei", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/244.png"),
                new PokemonModel(245, "Suicune", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/245.png"),
                new PokemonModel(246, "Larvitar", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/246.png"),
                new PokemonModel(247, "Pupitar", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/247.png"),
                new PokemonModel(248, "Tyranitar", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/248.png"),
                new PokemonModel(249, "Lugia", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/249.png"),
                new PokemonModel(250, "Ho-oh", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/250.png"),
                new PokemonModel(251, "Celebi", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/251.png")
        );
    }
}
