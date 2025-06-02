package br.com.arquitetura.spring.jpa.globals;

import br.com.arquitetura.spring.jpa.enums.RoleNameEnum;
import br.com.arquitetura.spring.jpa.models.DomainItemsModel;
import br.com.arquitetura.spring.jpa.models.DomainModel;
import br.com.arquitetura.spring.jpa.models.RoleModel;
import br.com.arquitetura.spring.jpa.models.UserModel;
import br.com.arquitetura.spring.jpa.repositories.DomainItemsRepository;
import br.com.arquitetura.spring.jpa.repositories.DomainRepository;
import br.com.arquitetura.spring.jpa.repositories.RoleRepository;
import br.com.arquitetura.spring.jpa.repositories.UserRepository;
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
                                  DomainItemsRepository domainItemsRepository) {
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
