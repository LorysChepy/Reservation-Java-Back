package com.GAB1NMACHINE.microwaves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class MicroWaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroWaveApplication.class, args);
	}
}
