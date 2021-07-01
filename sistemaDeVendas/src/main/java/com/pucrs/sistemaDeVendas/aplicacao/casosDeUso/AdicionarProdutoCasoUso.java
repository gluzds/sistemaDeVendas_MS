package com.pucrs.sistemaDeVendas.aplicacao.casosDeUso;

import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;
import com.pucrs.sistemaDeVendas.negocio.servicos.ServicoDeProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionarProdutoCasoUso {

	private ServicoDeProduto servicoDeProduto;

	@Autowired
	public AdicionarProdutoCasoUso(ServicoDeProduto servicoDeProduto){
		this.servicoDeProduto = servicoDeProduto;
	}

	public void run(Produto produto){
		servicoDeProduto.adicionar(produto);
	}

}
