package com.GAB1NMACHINE.MicoWave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repository")

public class MicroWaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroWaveApplication.class, args);
	}
}
