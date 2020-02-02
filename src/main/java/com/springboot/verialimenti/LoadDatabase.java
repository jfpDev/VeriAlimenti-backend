package com.springboot.verialimenti;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(ArticlesRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Articles("Plátano verde hartón", 2000, 10000, 5)));
			log.info("Preloading " + repository.save(new Articles("Papa parda caucana", 2000, 20000, 10)));
			log.info("Preloading " + repository.save(new Articles("Zapallo", 1850, 18500, 10)));
			log.info("Preloading " + repository.save(new Articles("Cebolla cabezona morada", 1500, 15000, 10)));
			log.info("Preloading " + repository.save(new Articles("Aguacates papelillo", 6500, 32500, 5)));
			log.info("Preloading " + repository.save(new Articles("Coliflor", 4050, 12150, 3)));

		};
	}
}
