package com.mitrais.carrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MitraisCarrotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitraisCarrotApplication.class, args);
	}
}
