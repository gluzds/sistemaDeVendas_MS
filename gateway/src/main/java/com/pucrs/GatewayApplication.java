package com.pucrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p
				.path("/vendas/produtos")
				.uri("http://servEstoque:8080"))
			.route(p->p
				.path("/vendas/autorizacao")
				.uri("http://servEstoque:8080"))
			.route(p->p
				.path("/vendas/baixa")
				.uri("http://servEstoque:8080"))
			.route(p -> p
				.path("/vendas/historico")
				.uri("http://servVendas:8080"))
			.route(p->p
				.path("/vendas/confirmacao")
				.uri("http://sistemaDeVendas:8080"))
			.route(p->p
				.path("/vendas/subtotal")
				.uri("http://sistemaDeVendas:8080"))
			.route(p->p
				.path("/vendas/verificarProdutos")
				.uri("http://sistemaDeVendas:8080"))
			.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}