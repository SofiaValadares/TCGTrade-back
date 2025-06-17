package br.com.arquitetura.spring.jpa.globals;

import br.com.arquitetura.spring.jpa.enums.PokemonTypeEnum;
import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import br.com.arquitetura.spring.jpa.models.*;
import br.com.arquitetura.spring.jpa.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
public class DataInitializer {

    private static final String ROLE_ADMIN = "admin";

    private final BCryptPasswordEncoder passwordEncoder;

    public DataInitializer(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository,
                                  DomainRepository domainRepository,
                                  DomainItemsRepository domainItemsRepository,
                                  PokemonRepository pokemonRepository,
                                  GenerationRepository generationRepository) {
        return args -> {
            // Criar as roles
            RoleModel roleAdmin = createRoleIfNotFound("ROLE_ADMIN", roleRepository);

            // Verificar se o usuario admin já existe
            Optional<UserModel> adminUserOpt = userRepository.findByUsername(ROLE_ADMIN);
            if (adminUserOpt.isEmpty()) {
                UserModel adminUser = new UserModel();
                adminUser.setName("Admin");
                adminUser.setUsername(ROLE_ADMIN);
                adminUser.setPassword(passwordEncoder.encode("senha123"));
                adminUser.setEmail("admin@adminxyz.com");
                adminUser.setEnabled(true);
                adminUser.setAccountNonExpired(true);
                adminUser.setAccountNonLocked(true);
                adminUser.setCredentialsNonExpired(true);
                adminUser.setUserRegistered(ROLE_ADMIN);
                adminUser.setDateRegistered(LocalDateTime.now());

                Set<RoleModel> roles = new HashSet<>();
                roles.add(roleAdmin);
                adminUser.setRoles(roles);

                userRepository.save(adminUser);
            }

            var nomePesquisaTipo = "TIPO POKEMON";
            Optional<DomainModel> domainTipoOpt = domainRepository.findByName(nomePesquisaTipo);
            if (domainTipoOpt.isEmpty()) {
                DomainModel domainTipo = new DomainModel();
                domainTipo.setName(nomePesquisaTipo);
                domainTipo.setDescription("Lista de todos os tipos de pokemon.");
                domainTipo.setEnabled(true);
                domainTipo.setUserRegistered(ROLE_ADMIN);
                domainTipo.setDateRegistered(LocalDateTime.now());
                domainRepository.save(domainTipo);

                Optional<DomainModel> domainSave = domainRepository.findByName(nomePesquisaTipo);

                List<DadosDomainItem> tipos = Arrays.asList(
                        new DadosDomainItem("NORMAL", "normal"),
                        new DadosDomainItem("FIRE", "fire"),
                        new DadosDomainItem("WATER", "water"),
                        new DadosDomainItem("ELECTRIC", "electric"),
                        new DadosDomainItem("GRASS", "grass"),
                        new DadosDomainItem("ICE", "ice"),
                        new DadosDomainItem("FIGHTING", "fighting"),
                        new DadosDomainItem("POISON", "poison"),
                        new DadosDomainItem("GROUND", "ground"),
                        new DadosDomainItem("FLYING", "flying"),
                        new DadosDomainItem("PSYCHIC", "psychic"),
                        new DadosDomainItem("BUG", "bug"),
                        new DadosDomainItem("ROCK", "rock"),
                        new DadosDomainItem("GHOST", "ghost"),
                        new DadosDomainItem("DRAGON", "dragon"),
                        new DadosDomainItem("DARK", "dark"),
                        new DadosDomainItem("STEEL", "steel"),
                        new DadosDomainItem("FAIRY", "fairy")
                );

                for (DadosDomainItem tipo : tipos) {
                    DomainItemsModel domainItem = new DomainItemsModel();
                    domainItem.setDomainModel(domainSave.get());
                    domainItem.setCodDomainItems(tipo.getCodigo());
                    domainItem.setName(tipo.getNome());
                    domainItem.setEnabled(true);
                    domainItem.setUserRegistered(ROLE_ADMIN);
                    domainItem.setDateRegistered(LocalDateTime.now());

                    domainItemsRepository.save(domainItem);
                }
            }




            // Importar Dominio Unidade Federativa
            var nomePesqusiaUF = "UNIDADE FEDERATIVA";
            Optional<DomainModel> domainUFOpt = domainRepository.findByName(nomePesqusiaUF);
            if (domainUFOpt.isEmpty()) {
                DomainModel domainUF = new DomainModel();
                domainUF.setName(nomePesqusiaUF);
                domainUF.setDescription("Lista todas Unidades Federativa do Brasil.");
                domainUF.setEnabled(true);
                domainUF.setUserRegistered(ROLE_ADMIN);
                domainUF.setDateRegistered(LocalDateTime.now());
                domainRepository.save(domainUF);

                Optional<DomainModel> domainSave = domainRepository.findByName(nomePesqusiaUF);

                List<DadosDomainItem> ufs = Arrays.asList(
                        new DadosDomainItem("AC", "Acre"),
                        new DadosDomainItem("AL", "Alagoas"),
                        new DadosDomainItem("AP", "Amapá"),
                        new DadosDomainItem("AM", "Amazonas"),
                        new DadosDomainItem("BA", "Bahia"),
                        new DadosDomainItem("CE", "Ceará"),
                        new DadosDomainItem("DF", "Distrito Federal"),
                        new DadosDomainItem("ES", "Espírito Santo"),
                        new DadosDomainItem("GO", "Goiás"),
                        new DadosDomainItem("MA", "Maranhão"),
                        new DadosDomainItem("MT", "Mato Grosso"),
                        new DadosDomainItem("MS", "Mato Grosso do Sul"),
                        new DadosDomainItem("MG", "Minas Gerais"),
                        new DadosDomainItem("PA", "Pará"),
                        new DadosDomainItem("PB", "Paraíba"),
                        new DadosDomainItem("PR", "Paraná"),
                        new DadosDomainItem("PE", "Pernambuco"),
                        new DadosDomainItem("PI", "Piauí"),
                        new DadosDomainItem("RJ", "Rio de Janeiro"),
                        new DadosDomainItem("RN", "Rio Grande do Norte"),
                        new DadosDomainItem("RS", "Rio Grande do Sul"),
                        new DadosDomainItem("RO", "Rondônia"),
                        new DadosDomainItem("RR", "Roraima"),
                        new DadosDomainItem("SC", "Santa Catarina"),
                        new DadosDomainItem("SP", "São Paulo"),
                        new DadosDomainItem("SE", "Sergipe"),
                        new DadosDomainItem("TO", "Tocantins")
                );

                // Adicionando cada UF no repositório
                for (DadosDomainItem uf : ufs) {
                    DomainItemsModel domainItem = new DomainItemsModel();
                    domainItem.setDomainModel(domainSave.get());
                    domainItem.setCodDomainItems(uf.getCodigo());
                    domainItem.setName(uf.getNome());
                    domainItem.setEnabled(true);
                    domainItem.setUserRegistered(ROLE_ADMIN);
                    domainItem.setDateRegistered(LocalDateTime.now());

                    domainItemsRepository.save(domainItem);
                }
            }

            // Importar Dominio Unidade Federativa
            var nomePesqusiaOR = "ORGÃO EMISSOR";
            Optional<DomainModel> domainOROpt = domainRepository.findByName(nomePesqusiaOR);
            if (domainOROpt.isEmpty()) {
                DomainModel domain = new DomainModel();
                domain.setName(nomePesqusiaOR);
                domain.setDescription("Lista Orgão Emissor do Brasil.");
                domain.setEnabled(true);
                domain.setUserRegistered(ROLE_ADMIN);
                domain.setDateRegistered(LocalDateTime.now());
                domainRepository.save(domain);

                Optional<DomainModel> domanSave = domainRepository.findByName(nomePesqusiaOR);

                List<DadosDomainItem> oes = Arrays.asList(
                        new DadosDomainItem("SDS", "Secretaria de Defesa Social"),
                        new DadosDomainItem("SSP", "Secretaria de Segurança Pública"),
                        new DadosDomainItem("DIC", "Diretoria de Identificação Civil"),
                        new DadosDomainItem("IFP", "Instituto de Identificação"),
                        new DadosDomainItem("IGP", "Instituto Geral de Perícias")
                );
                // Adicionando cada Orgão Emissor no repositório
                for (DadosDomainItem oe : oes) {
                    DomainItemsModel domainItem = new DomainItemsModel();
                    domainItem.setDomainModel(domanSave.get());
                    domainItem.setCodDomainItems(oe.getCodigo());
                    domainItem.setName(oe.getNome());
                    domainItem.setEnabled(true);
                    domainItem.setUserRegistered(ROLE_ADMIN);
                    domainItem.setDateRegistered(LocalDateTime.now());

                    domainItemsRepository.save(domainItem);
                }
            }

            List<GenerationModel> generations = Arrays.asList(
                    new GenerationModel(null, 1, "Kanto"),
                    new GenerationModel(null, 2, "Johto"),
                    new GenerationModel(null, 3, "Hoenn"),
                    new GenerationModel(null, 4, "Sinnoh"),
                    new GenerationModel(null, 5, "Unova"),
                    new GenerationModel(null, 6, "Kalos"),
                    new GenerationModel(null, 7, "Alola"),
                    new GenerationModel(null, 8, "Galar"),
                    new GenerationModel(null, 9, "Paldea")
            );

            for (GenerationModel gen : generations) {
                if (generationRepository.findByNumber(gen.getNumber()).isEmpty()) {
                    gen.setUserRegistered(ROLE_ADMIN);
                    gen.setDateRegistered(LocalDateTime.now());
                    generationRepository.save(gen);
                }
            }

            for (int i = 1; i <= 9; i++) {
                Optional<GenerationModel> genOptional = generationRepository.findByNumber(i);

                if (genOptional.isPresent()) {
                    GenerationModel gen = genOptional.get();

                    List<PokemonModel> pokemons = switch (i) {
                        case 1 -> List.of(
                                new PokemonModel(1, "Bulbasaur", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
                                new PokemonModel(2, "Ivysaur", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"),
                                new PokemonModel(3, "Venusaur", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"),
                                new PokemonModel(4, "Charmander", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
                                new PokemonModel(5, "Charmeleon", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png"),
                                new PokemonModel(6, "Charizard", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"),
                                new PokemonModel(7, "Squirtle", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"),
                                new PokemonModel(8, "Wartortle", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png"),
                                new PokemonModel(9, "Blastoise", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png"),
                                new PokemonModel(10, "Caterpie", gen, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png"),
                                new PokemonModel(11, "Metapod", gen, PokemonTypeEnum.BUG, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png"),
                                new PokemonModel(12, "Butterfree", gen, PokemonTypeEnum.BUG, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png"),
                                new PokemonModel(13, "Weedle", gen, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png"),
                                new PokemonModel(14, "Kakuna", gen, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png"),
                                new PokemonModel(15, "Beedrill", gen, PokemonTypeEnum.BUG, PokemonTypeEnum.POISON, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png"),
                                new PokemonModel(16, "Pidgey", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png"),
                                new PokemonModel(17, "Pidgeotto", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png"),
                                new PokemonModel(18, "Pidgeot", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png"),
                                new PokemonModel(19, "Rattata", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png"),
                                new PokemonModel(20, "Raticate", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png"),
                                new PokemonModel(21, "Spearow", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png"),
                                new PokemonModel(22, "Fearow", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/22.png"),
                                new PokemonModel(23, "Ekans", gen, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png"),
                                new PokemonModel(24, "Arbok", gen, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/24.png"),
                                new PokemonModel(25, "Pikachu", gen, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"),
                                new PokemonModel(26, "Raichu", gen, PokemonTypeEnum.ELECTRIC, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png"),
                                new PokemonModel(27, "Sandshrew", gen, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/27.png"),
                                new PokemonModel(28, "Sandslash", gen, PokemonTypeEnum.GROUND, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/28.png"),
                                new PokemonModel(29, "Nidoran", gen, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/29.png"),
                                new PokemonModel(30, "Nidorina", gen, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/30.png"),
                                new PokemonModel(31, "Nidoqueen", gen, PokemonTypeEnum.POISON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/31.png"),
                                new PokemonModel(32, "Nidoran", gen, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/32.png"),
                                new PokemonModel(33, "Nidorino", gen, PokemonTypeEnum.POISON, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/33.png"),
                                new PokemonModel(34, "Nidoking", gen, PokemonTypeEnum.POISON, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/34.png"),
                                new PokemonModel(35, "Clefairy", gen, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png"),
                                new PokemonModel(36, "Clefable", gen, PokemonTypeEnum.FAIRY, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/36.png"),
                                new PokemonModel(37, "Vulpix", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/37.png"),
                                new PokemonModel(38, "Ninetales", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/38.png"),
                                new PokemonModel(39, "Jigglypuff", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png"),
                                new PokemonModel(40, "Wigglypuff", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/40.png"),
                                new PokemonModel(41, "Zubat", gen, PokemonTypeEnum.POISON, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/41.png"),
                                new PokemonModel(42, "Golbat", gen, PokemonTypeEnum.POISON, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/42.png")
                        );
                        case 2 -> List.of(
                                new PokemonModel(152, "Chikorita", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/152.png"),
                                new PokemonModel(153, "Bayleef", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/153.png"),
                                new PokemonModel(154, "Meganium", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/154.png"),
                                new PokemonModel(155, "Cyndaquil", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/155.png"),
                                new PokemonModel(156, "Quilava", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/156.png"),
                                new PokemonModel(157, "Typhlosion", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/157.png"),
                                new PokemonModel(158, "Totodile", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/158.png"),
                                new PokemonModel(159, "Croconaw", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/159.png"),
                                new PokemonModel(160, "Feraligatr", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/160.png"),
                                new PokemonModel(161, "Sentret", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/161.png")
                        );
                        case 3 -> List.of(
                                new PokemonModel(252, "Treecko", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/252.png"),
                                new PokemonModel(253, "Grovyle", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/253.png"),
                                new PokemonModel(254, "Sceptile", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/254.png"),
                                new PokemonModel(255, "Torchic", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/255.png"),
                                new PokemonModel(256, "Combusken", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/256.png"),
                                new PokemonModel(257, "Blaziken", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/257.png"),
                                new PokemonModel(258, "Mudkip", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/258.png"),
                                new PokemonModel(259, "Marshtomp", gen, PokemonTypeEnum.WATER, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/259.png"),
                                new PokemonModel(260, "Swampert", gen, PokemonTypeEnum.WATER, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/260.png"),
                                new PokemonModel(261, "Poochyena", gen, PokemonTypeEnum.DARK, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/261.png")
                        );
                        case 4 -> List.of(
                                new PokemonModel(387, "Turtwig", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/387.png"),
                                new PokemonModel(388, "Grotle", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/388.png"),
                                new PokemonModel(389, "Torterra", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.GROUND, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/389.png"),
                                new PokemonModel(390, "Chimchar", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/390.png"),
                                new PokemonModel(391, "Monferno", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/391.png"),
                                new PokemonModel(392, "Infernape", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/392.png"),
                                new PokemonModel(393, "Piplup", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/393.png"),
                                new PokemonModel(394, "Prinplup", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/394.png"),
                                new PokemonModel(395, "Empoleon", gen, PokemonTypeEnum.WATER, PokemonTypeEnum.STEEL, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/395.png"),
                                new PokemonModel(396, "Starly", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/396.png")
                        );

                        case 5 -> List.of(
                                new PokemonModel(495, "Snivy", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/495.png"),
                                new PokemonModel(496, "Servine", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/496.png"),
                                new PokemonModel(497, "Serperior", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/497.png"),
                                new PokemonModel(498, "Tepig", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/498.png"),
                                new PokemonModel(499, "Pignite", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/499.png"),
                                new PokemonModel(500, "Emboar", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/500.png"),
                                new PokemonModel(501, "Oshawott", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/501.png"),
                                new PokemonModel(502, "Dewott", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/502.png"),
                                new PokemonModel(503, "Samurott", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/503.png"),
                                new PokemonModel(504, "Patrat", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/504.png")
                        );

                        case 6 -> List.of(
                                new PokemonModel(650, "Chespin", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/650.png"),
                                new PokemonModel(651, "Quilladin", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/651.png"),
                                new PokemonModel(652, "Chesnaught", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/652.png"),
                                new PokemonModel(653, "Fennekin", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/653.png"),
                                new PokemonModel(654, "Braixen", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/654.png"),
                                new PokemonModel(655, "Delphox", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.PSYCHIC, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/655.png"),
                                new PokemonModel(656, "Froakie", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/656.png"),
                                new PokemonModel(657, "Frogadier", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/657.png"),
                                new PokemonModel(658, "Greninja", gen, PokemonTypeEnum.WATER, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/658.png"),
                                new PokemonModel(659, "Bunnelby", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/659.png")
                        );

                        case 7 -> List.of(
                                new PokemonModel(722, "Rowlet", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/722.png"),
                                new PokemonModel(723, "Dartrix", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/723.png"),
                                new PokemonModel(724, "Decidueye", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/724.png"),
                                new PokemonModel(725, "Litten", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/725.png"),
                                new PokemonModel(726, "Torracat", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/726.png"),
                                new PokemonModel(727, "Incineroar", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/727.png"),
                                new PokemonModel(728, "Popplio", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/728.png"),
                                new PokemonModel(729, "Brionne", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/729.png"),
                                new PokemonModel(730, "Primarina", gen, PokemonTypeEnum.WATER, PokemonTypeEnum.FAIRY, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/730.png"),
                                new PokemonModel(731, "Pikipek", gen, PokemonTypeEnum.NORMAL, PokemonTypeEnum.FLYING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/731.png")
                        );

                        case 8 -> List.of(
                                new PokemonModel(810, "Grookey", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/810.png"),
                                new PokemonModel(811, "Thwackey", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/811.png"),
                                new PokemonModel(812, "Rillaboom", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/812.png"),
                                new PokemonModel(813, "Scorbunny", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/813.png"),
                                new PokemonModel(814, "Raboot", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/814.png"),
                                new PokemonModel(815, "Cinderace", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/815.png"),
                                new PokemonModel(816, "Sobble", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/816.png"),
                                new PokemonModel(817, "Drizzile", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/817.png"),
                                new PokemonModel(818, "Inteleon", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/818.png"),
                                new PokemonModel(819, "Skwovet", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/819.png")
                        );

                        case 9 -> List.of(
                                new PokemonModel(906, "Sprigatito", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/906.png"),
                                new PokemonModel(907, "Floragato", gen, PokemonTypeEnum.GRASS, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/907.png"),
                                new PokemonModel(908, "Meowscarada", gen, PokemonTypeEnum.GRASS, PokemonTypeEnum.DARK, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/908.png"),
                                new PokemonModel(909, "Fuecoco", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/909.png"),
                                new PokemonModel(910, "Crocalor", gen, PokemonTypeEnum.FIRE, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/910.png"),
                                new PokemonModel(911, "Skeledirge", gen, PokemonTypeEnum.FIRE, PokemonTypeEnum.GHOST, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/911.png"),
                                new PokemonModel(912, "Quaxly", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/912.png"),
                                new PokemonModel(913, "Quaxwell", gen, PokemonTypeEnum.WATER, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/913.png"),
                                new PokemonModel(914, "Quaquaval", gen, PokemonTypeEnum.WATER, PokemonTypeEnum.FIGHTING, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/914.png"),
                                new PokemonModel(915, "Lechonk", gen, PokemonTypeEnum.NORMAL, null, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/915.png")
                        );

                        default -> List.of();
                    };

                    for (PokemonModel pokemon : pokemons) {
                        if (pokemonRepository.findByNumber(pokemon.getNumber()).isEmpty()) {
                            pokemon.setUserRegistered(ROLE_ADMIN);
                            pokemon.setDateRegistered(LocalDateTime.now());
                            pokemonRepository.save(pokemon);
                        }
                    }
                }
            }





        };
    }

    private RoleModel createRoleIfNotFound(String roleName, RoleRepository roleRepository) {
        Optional<RoleModel> roleOpt = roleRepository.findByRoleName(RoleNameEnum.valueOf(roleName));
        if (roleOpt.isEmpty()) {
            RoleModel role = new RoleModel();
            role.setRoleName(RoleNameEnum.valueOf(roleName));
            role.setUserRegistered(ROLE_ADMIN);
            role.setDateRegistered(LocalDateTime.now());
            return roleRepository.save(role);
        }
        return roleOpt.get();
    }

    private class DadosDomainItem {
        private String codigo;
        private String nome;

        public DadosDomainItem(String codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }
    }

}
