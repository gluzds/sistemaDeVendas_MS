package com.pucrs.servVendas.adaptadores.controllers;

import java.util.List;

import com.pucrs.servVendas.aplicacao.casosDeUso.ConsultaVendasCasoUso;
import com.pucrs.servVendas.negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {

	private ConsultaVendasCasoUso consultaVendasCasoUso;


	@Autowired
	public Controller(ConsultaVendasCasoUso consultaVendasCasoUso){
		this.consultaVendasCasoUso = consultaVendasCasoUso;
	}
  
	@GetMapping("/historico")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Venda> vendasEfetuadas() {
	  return consultaVendasCasoUso.run();
	}

}
