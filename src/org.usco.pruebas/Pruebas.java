package org.usco.pruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.usco.pruebas.*")
public class PruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebasApplication.class, args);
	}

}
