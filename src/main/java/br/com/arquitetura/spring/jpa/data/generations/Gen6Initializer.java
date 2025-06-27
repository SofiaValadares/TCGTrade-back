package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.util.Arrays;
import java.util.List;

public class Gen6Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(6);
        generation.setRegion("Kalos");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(650, "Chespin", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/650.png"),
                new PokemonModel(651, "Quilladin", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/651.png"),
                new PokemonModel(652, "Chesnaught", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/652.png"),
                new PokemonModel(653, "Fennekin", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/653.png"),
                new PokemonModel(654, "Braixen", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/654.png"),
                new PokemonModel(655, "Delphox", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/655.png"),
                new PokemonModel(656, "Froakie", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/656.png"),
                new PokemonModel(657, "Frogadier", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/657.png"),
                new PokemonModel(658, "Greninja", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/658.png"),
                new PokemonModel(659, "Bunnelby", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/659.png"),
                new PokemonModel(660, "Diggersby", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/660.png"),
                new PokemonModel(661, "Fletchling", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/661.png"),
                new PokemonModel(662, "Fletchinder", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/662.png"),
                new PokemonModel(663, "Talonflame", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/663.png"),
                new PokemonModel(664, "Scatterbug", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/664.png"),
                new PokemonModel(665, "Spewpa", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/665.png"),
                new PokemonModel(666, "Vivillon", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/666.png"),
                new PokemonModel(667, "Litleo", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/667.png"),
                new PokemonModel(668, "Pyroar", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/668.png"),
                new PokemonModel(669, "Flabébé", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/669.png"),
                new PokemonModel(670, "Floette", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/670.png"),
                new PokemonModel(671, "Florges", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/671.png"),
                new PokemonModel(672, "Skiddo", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/672.png"),
                new PokemonModel(673, "Gogoat", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/673.png"),
                new PokemonModel(674, "Pancham", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/674.png"),
                new PokemonModel(675, "Pangoro", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/675.png"),
                new PokemonModel(676, "Furfrou", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/676.png"),
                new PokemonModel(677, "Espurr", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/677.png"),
                new PokemonModel(678, "Meowstic", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/678.png"),
                new PokemonModel(679, "Honedge", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/679.png"),
                new PokemonModel(680, "Doublade", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/680.png"),
                new PokemonModel(681, "Aegislash", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/681.png"),
                new PokemonModel(682, "Spritzee", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/682.png"),
                new PokemonModel(683, "Aromatisse", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/683.png"),
                new PokemonModel(684, "Swirlix", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/684.png"),
                new PokemonModel(685, "Slurpuff", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/685.png"),
                new PokemonModel(686, "Inkay", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/686.png"),
                new PokemonModel(687, "Malamar", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/687.png"),
                new PokemonModel(688, "Binacle", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/688.png"),
                new PokemonModel(689, "Barbaracle", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/689.png"),
                new PokemonModel(690, "Skrelp", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/690.png"),
                new PokemonModel(691, "Dragalge", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/691.png"),
                new PokemonModel(692, "Clauncher", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/692.png"),
                new PokemonModel(693, "Clawitzer", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/693.png"),
                new PokemonModel(694, "Helioptile", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/694.png"),
                new PokemonModel(695, "Heliolisk", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.NORMAL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/695.png"),
                new PokemonModel(696, "Tyrunt", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/696.png"),
                new PokemonModel(697, "Tyrantrum", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/697.png"),
                new PokemonModel(698, "Amaura", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/698.png"),
                new PokemonModel(699, "Aurorus", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/699.png"),
                new PokemonModel(700, "Sylveon", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/700.png"),
                new PokemonModel(701, "Hawlucha", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/701.png"),
                new PokemonModel(702, "Dedenne", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/702.png"),
                new PokemonModel(703, "Carbink", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/703.png"),
                new PokemonModel(704, "Goomy", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/704.png"),
                new PokemonModel(705, "Sliggoo", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/705.png"),
                new PokemonModel(706, "Goodra", generation, PokemonTypeEnum.DRAGON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/706.png"),
                new PokemonModel(707, "Klefki", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/707.png"),
                new PokemonModel(708, "Phantump", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/708.png"),
                new PokemonModel(709, "Trevenant", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/709.png"),
                new PokemonModel(710, "Pumpkaboo", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/710.png"),
                new PokemonModel(711, "Gourgeist", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/711.png"),
                new PokemonModel(712, "Bergmite", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/712.png"),
                new PokemonModel(713, "Avalugg", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/713.png"),
                new PokemonModel(714, "Noibat", generation, PokemonTypeEnum.FLYING, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/714.png"),
                new PokemonModel(715, "Noivern", generation, PokemonTypeEnum.FLYING, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/715.png"),
                new PokemonModel(716, "Xerneas", generation, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/716.png"),
                new PokemonModel(717, "Yveltal", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/717.png"),
                new PokemonModel(718, "Zygarde", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/718.png"),
                new PokemonModel(719, "Diancie", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/719.png"),
                new PokemonModel(720, "Hoopa", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/720.png"),
                new PokemonModel(721, "Volcanion", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/721.png")
        );
    }
}
