package com.pucrs.sistemaDeVendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.pucrs" })
@EntityScan(basePackages = { "com.pucrs" })
@EnableJpaRepositories(basePackages = { "com.pucrs" })
public class SistemaDeVendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistemaDeVendasApplication.class, args);
	}

}
