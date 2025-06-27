package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.util.Arrays;
import java.util.List;

public class Gen7Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(7);
        generation.setRegion("Alola");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(722, "Rowlet", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/722.png"),
                new PokemonModel(723, "Dartrix", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/723.png"),
                new PokemonModel(724, "Decidueye", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/724.png"),
                new PokemonModel(725, "Litten", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/725.png"),
                new PokemonModel(726, "Torracat", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/726.png"),
                new PokemonModel(727, "Incineroar", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/727.png"),
                new PokemonModel(728, "Popplio", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/728.png"),
                new PokemonModel(729, "Brionne", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/729.png"),
                new PokemonModel(730, "Primarina", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/730.png"),
                new PokemonModel(731, "Pikipek", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/731.png"),
                new PokemonModel(732, "Trumbeak", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/732.png"),
                new PokemonModel(733, "Toucannon", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/733.png"),
                new PokemonModel(734, "Yungoos", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/734.png"),
                new PokemonModel(735, "Gumshoos", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/735.png"),
                new PokemonModel(736, "Grubbin", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/736.png"),
                new PokemonModel(737, "Charjabug", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.ELECTRIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/737.png"),
                new PokemonModel(738, "Vikavolt", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.ELECTRIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/738.png"),
                new PokemonModel(739, "Crabrawler", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/739.png"),
                new PokemonModel(740, "Crabominable", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/740.png"),
                new PokemonModel(741, "Oricorio", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/741.png"),
                new PokemonModel(742, "Cutiefly", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/742.png"),
                new PokemonModel(743, "Ribombee", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/743.png"),
                new PokemonModel(744, "Rockruff", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/744.png"),
                new PokemonModel(745, "Lycanroc", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/745.png"),
                new PokemonModel(746, "Wishiwashi", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/746.png"),
                new PokemonModel(747, "Mareanie", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/747.png"),
                new PokemonModel(748, "Toxapex", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/748.png"),
                new PokemonModel(749, "Mudbray", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/749.png"),
                new PokemonModel(750, "Mudsdale", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/750.png"),
                new PokemonModel(751, "Dewpider", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/751.png"),
                new PokemonModel(752, "Araquanid", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/752.png"),
                new PokemonModel(753, "Fomantis", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/753.png"),
                new PokemonModel(754, "Lurantis", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/754.png"),
                new PokemonModel(755, "Morelull", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/755.png"),
                new PokemonModel(756, "Shiinotic", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/756.png"),
                new PokemonModel(757, "Salandit", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/757.png"),
                new PokemonModel(758, "Salazzle", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FIRE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/758.png"),
                new PokemonModel(759, "Stufful", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/759.png"),
                new PokemonModel(760, "Bewear", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/760.png"),
                new PokemonModel(761, "Bounsweet", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/761.png"),
                new PokemonModel(762, "Steenee", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/762.png"),
                new PokemonModel(763, "Tsareena", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/763.png"),
                new PokemonModel(764, "Comfey", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/764.png"),
                new PokemonModel(765, "Oranguru", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/765.png"),
                new PokemonModel(766, "Passimian", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/766.png"),
                new PokemonModel(767, "Wimpod", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/767.png"),
                new PokemonModel(768, "Golisopod", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/768.png"),
                new PokemonModel(769, "Sandygast", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/769.png"),
                new PokemonModel(770, "Palossand", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/770.png"),
                new PokemonModel(771, "Pyukumuku", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/771.png"),
                new PokemonModel(772, "Type: Null", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/772.png"),
                new PokemonModel(773, "Silvally", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/773.png"),
                new PokemonModel(774, "Minior", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/774.png"),
                new PokemonModel(775, "Komala", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/775.png"),
                new PokemonModel(776, "Turtonator", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/776.png"),
                new PokemonModel(777, "Togedemaru", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/777.png"),
                new PokemonModel(778, "Mimikyu", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/778.png"),
                new PokemonModel(779, "Bruxish", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/779.png"),
                new PokemonModel(780, "Drampa", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/780.png"),
                new PokemonModel(781, "Dhelmise", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/781.png"),
                new PokemonModel(782, "Jangmo-o", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/782.png"),
                new PokemonModel(783, "Hakamo-o", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/783.png"),
                new PokemonModel(784, "Kommo-o", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/784.png"),
                new PokemonModel(785, "Tapu Koko", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/785.png"),
                new PokemonModel(786, "Tapu Lele", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/786.png"),
                new PokemonModel(787, "Tapu Bulu", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/787.png"),
                new PokemonModel(788, "Tapu Fini", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/788.png"),
                new PokemonModel(789, "Cosmog", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/789.png"),
                new PokemonModel(790, "Cosmoem", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/790.png"),
                new PokemonModel(791, "Solgaleo", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/791.png"),
                new PokemonModel(792, "Lunala", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/792.png"),
                new PokemonModel(793, "Nihilego", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/793.png"),
                new PokemonModel(794, "Buzzwole", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/794.png"),
                new PokemonModel(795, "Pheromosa", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/795.png"),
                new PokemonModel(796, "Xurkitree", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/796.png"),
                new PokemonModel(797, "Celesteela", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/797.png"),
                new PokemonModel(798, "Kartana", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/798.png"),
                new PokemonModel(799, "Guzzlord", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/799.png"),
                new PokemonModel(800, "Necrozma", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/800.png"),
                new PokemonModel(801, "Magearna", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/801.png"),
                new PokemonModel(802, "Marshadow", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/802.png"),
                new PokemonModel(803, "Poipole", generation, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/803.png"),
                new PokemonModel(804, "Naganadel", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/804.png"),
                new PokemonModel(805, "Stakataka", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/805.png"),
                new PokemonModel(806, "Blacephalon", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/806.png"),
                new PokemonModel(807, "Zeraora", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/807.png"),
                new PokemonModel(808, "Meltan", generation, PokemonTypeEnum.STEEL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/808.png"),
                new PokemonModel(809, "Melmetal", generation, PokemonTypeEnum.STEEL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/809.png")
        );
    }
}
