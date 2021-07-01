package com.pucrs.servEstoque.aplicacao.casosDeUso;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;
import com.pucrs.servEstoque.negocio.servicos.ServicoDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SelecionarProdutoCasoUso {

	private ServicoDeEstoque servicoDeEstoque;
	
	@Autowired
	public SelecionarProdutoCasoUso(ServicoDeEstoque servicoDeEstoque){
		this.servicoDeEstoque = servicoDeEstoque;
	}
	
	public boolean run(long codProduto, int qtdade){
		ItemEstoque item = servicoDeEstoque.getByCodProduto(codProduto);
		if (item.getQuantidadeDisponivel() < qtdade){
			return false;
		} else {
			return true;
		}
	}
}
