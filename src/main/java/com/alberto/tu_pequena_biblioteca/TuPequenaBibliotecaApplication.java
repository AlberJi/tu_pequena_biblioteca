package com.alberto.tu_pequena_biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TuPequenaBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuPequenaBibliotecaApplication.class, args);
	}

}
