package org.usco.agro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.usco.agro.*")
public class AgroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgroApplication.class, args);
	}

}
