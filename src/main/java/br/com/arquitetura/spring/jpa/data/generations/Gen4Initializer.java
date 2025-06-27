package br.com.arquitetura.spring.jpa.data.generations;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.models.GenerationModel;
import br.com.arquitetura.spring.jpa.models.PokemonModel;

import java.util.Arrays;
import java.util.List;

public class Gen4Initializer {

    private static final GenerationModel generation;

    static {
        generation = new GenerationModel();
        generation.setNumber(4);
        generation.setRegion("Sinnoh");
    }

    public static GenerationModel getGen() {
        return generation;
    }

    public static List<PokemonModel> getPokemons() {
        return Arrays.asList(
                new PokemonModel(387, "Turtwig", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/387.png"),
                new PokemonModel(388, "Grotle", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/388.png"),
                new PokemonModel(389, "Torterra", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/389.png"),
                new PokemonModel(390, "Chimchar", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/390.png"),
                new PokemonModel(391, "Monferno", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/391.png"),
                new PokemonModel(392, "Infernape", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/392.png"),
                new PokemonModel(393, "Piplup", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/393.png"),
                new PokemonModel(394, "Prinplup", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/394.png"),
                new PokemonModel(395, "Empoleon", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/395.png"),
                new PokemonModel(396, "Starly", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/396.png"),
                new PokemonModel(397, "Staravia", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/397.png"),
                new PokemonModel(398, "Staraptor", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/398.png"),
                new PokemonModel(399, "Bidoof", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/399.png"),
                new PokemonModel(400, "Bibarel", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.WATER, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/400.png"),
                new PokemonModel(401, "Kricketot", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/401.png"),
                new PokemonModel(402, "Kricketune", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/402.png"),
                new PokemonModel(403, "Shinx", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/403.png"),
                new PokemonModel(404, "Luxio", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/404.png"),
                new PokemonModel(405, "Luxray", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/405.png"),
                new PokemonModel(406, "Budew", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/406.png"),
                new PokemonModel(407, "Roserade", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/407.png"),
                new PokemonModel(408, "Cranidos", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/408.png"),
                new PokemonModel(409, "Rampardos", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/409.png"),
                new PokemonModel(410, "Shieldon", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/410.png"),
                new PokemonModel(411, "Bastiodon", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/411.png"),
                new PokemonModel(412, "Burmy", generation, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/412.png"),
                new PokemonModel(413, "Wormadam", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.GRASS, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/413.png"),
                new PokemonModel(414, "Mothim", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/414.png"),
                new PokemonModel(415, "Combee", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/415.png"),
                new PokemonModel(416, "Vespiquen", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/416.png"),
                new PokemonModel(417, "Pachirisu", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/417.png"),
                new PokemonModel(418, "Buizel", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/418.png"),
                new PokemonModel(419, "Floatzel", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/419.png"),
                new PokemonModel(420, "Cherubi", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/420.png"),
                new PokemonModel(421, "Cherrim", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/421.png"),
                new PokemonModel(422, "Shellos", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/422.png"),
                new PokemonModel(423, "Gastrodon", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/423.png"),
                new PokemonModel(424, "Ambipom", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/424.png"),
                new PokemonModel(425, "Drifloon", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/425.png"),
                new PokemonModel(426, "Drifblim", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/426.png"),
                new PokemonModel(427, "Buneary", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/427.png"),
                new PokemonModel(428, "Lopunny", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/428.png"),
                new PokemonModel(429, "Mismagius", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/429.png"),
                new PokemonModel(430, "Honchkrow", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/430.png"),
                new PokemonModel(431, "Glameow", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/431.png"),
                new PokemonModel(432, "Purugly", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/432.png"),
                new PokemonModel(433, "Chingling", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/433.png"),
                new PokemonModel(434, "Stunky", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/434.png"),
                new PokemonModel(435, "Skuntank", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/435.png"),
                new PokemonModel(436, "Bronzor", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/436.png"),
                new PokemonModel(437, "Bronzong", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/437.png"),
                new PokemonModel(438, "Bonsly", generation, PokemonTypeEnum.ROCK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/438.png"),
                new PokemonModel(439, "Mime Jr.", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/439.png"),
                new PokemonModel(440, "Happiny", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/440.png"),
                new PokemonModel(441, "Chatot", generation, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/441.png"),
                new PokemonModel(442, "Spiritomb", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/442.png"),
                new PokemonModel(443, "Gible", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/443.png"),
                new PokemonModel(444, "Gabite", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/444.png"),
                new PokemonModel(445, "Garchomp", generation, PokemonTypeEnum.DRAGON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/445.png"),
                new PokemonModel(446, "Munchlax", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/446.png"),
                new PokemonModel(447, "Riolu", generation, PokemonTypeEnum.FIGHTING, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/447.png"),
                new PokemonModel(448, "Lucario", generation, PokemonTypeEnum.FIGHTING, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/448.png"),
                new PokemonModel(449, "Hippopotas", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/449.png"),
                new PokemonModel(450, "Hippowdon", generation, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/450.png"),
                new PokemonModel(451, "Skorupi", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.BUG, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/451.png"),
                new PokemonModel(452, "Drapion", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/452.png"),
                new PokemonModel(453, "Croagunk", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/453.png"),
                new PokemonModel(454, "Toxicroak", generation, PokemonTypeEnum.POISON, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/454.png"),
                new PokemonModel(455, "Carnivine", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/455.png"),
                new PokemonModel(456, "Finneon", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/456.png"),
                new PokemonModel(457, "Lumineon", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/457.png"),
                new PokemonModel(458, "Mantyke", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/458.png"),
                new PokemonModel(459, "Snover", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/459.png"),
                new PokemonModel(460, "Abomasnow", generation, PokemonTypeEnum.GRASS, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/460.png"),
                new PokemonModel(461, "Weavile", generation, PokemonTypeEnum.DARK, PokemonTypeEnum.ICE, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/461.png"),
                new PokemonModel(462, "Magnezone", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/462.png"),
                new PokemonModel(463, "Lickilicky", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/463.png"),
                new PokemonModel(464, "Rhyperior", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.ROCK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/464.png"),
                new PokemonModel(465, "Tangrowth", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/465.png"),
                new PokemonModel(466, "Electivire", generation, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/466.png"),
                new PokemonModel(467, "Magmortar", generation, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/467.png"),
                new PokemonModel(468, "Togekiss", generation, PokemonTypeEnum.FAIRY, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/468.png"),
                new PokemonModel(469, "Yanmega", generation, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/469.png"),
                new PokemonModel(470, "Leafeon", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/470.png"),
                new PokemonModel(471, "Glaceon", generation, PokemonTypeEnum.ICE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/471.png"),
                new PokemonModel(472, "Gliscor", generation, PokemonTypeEnum.GROUND, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/472.png"),
                new PokemonModel(473, "Mamoswine", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/473.png"),
                new PokemonModel(474, "Porygon-Z", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/474.png"),
                new PokemonModel(475, "Gallade", generation, PokemonTypeEnum.PSYCHIC, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/475.png"),
                new PokemonModel(476, "Probopass", generation, PokemonTypeEnum.ROCK, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/476.png"),
                new PokemonModel(477, "Dusknoir", generation, PokemonTypeEnum.GHOST, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/477.png"),
                new PokemonModel(478, "Froslass", generation, PokemonTypeEnum.ICE, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/478.png"),
                new PokemonModel(479, "Rotom", generation, PokemonTypeEnum.ELECTRIC, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/479.png"),
                new PokemonModel(480, "Uxie", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/480.png"),
                new PokemonModel(481, "Mesprit", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/481.png"),
                new PokemonModel(482, "Azelf", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/482.png"),
                new PokemonModel(483, "Dialga", generation, PokemonTypeEnum.STEEL, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/483.png"),
                new PokemonModel(484, "Palkia", generation, PokemonTypeEnum.WATER, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/484.png"),
                new PokemonModel(485, "Heatran", generation, PokemonTypeEnum.FIRE, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/485.png"),
                new PokemonModel(486, "Regigigas", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/486.png"),
                new PokemonModel(487, "Giratina", generation, PokemonTypeEnum.GHOST, PokemonTypeEnum.DRAGON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/487.png"),
                new PokemonModel(488, "Cresselia", generation, PokemonTypeEnum.PSYCHIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/488.png"),
                new PokemonModel(489, "Phione", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/489.png"),
                new PokemonModel(490, "Manaphy", generation, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/490.png"),
                new PokemonModel(491, "Darkrai", generation, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/491.png"),
                new PokemonModel(492, "Shaymin", generation, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/492.png"),
                new PokemonModel(493, "Arceus", generation, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/493.png")
        );
    }
}
