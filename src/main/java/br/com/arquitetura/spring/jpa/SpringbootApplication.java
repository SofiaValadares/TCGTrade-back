package br.com.arquitetura.spring.jpa;

import br.com.arquitetura.spring.jpa.globals.audit.AuditorAwareImpl;
import br.com.arquitetura.spring.jpa.properties.StorageProperties;
import br.com.arquitetura.spring.jpa.services.StorageService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableConfigurationProperties(StorageProperties.class)
@EnableJpaRepositories(basePackages = "br.com.arquitetura.spring.jpa.repositories")
@EntityScan(basePackages = "br.com.arquitetura.spring.jpa.models")
@EnableScheduling
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public AuditorAwareImpl auditorAware() {
		return new AuditorAwareImpl();
	}

	@Bean
	CommandLineRunner initStorage(StorageService storageService) {
		return args -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
