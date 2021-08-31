package com.calsoft.emicalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class EmiCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmiCalculatorApplication.class, args);
	}

}
