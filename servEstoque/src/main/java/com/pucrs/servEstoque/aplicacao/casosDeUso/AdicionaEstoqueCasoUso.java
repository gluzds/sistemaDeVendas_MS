package com.pucrs.servEstoque.aplicacao.casosDeUso;

import com.pucrs.servEstoque.negocio.servicos.ServicoDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionaEstoqueCasoUso {
    private ServicoDeEstoque servicoDeEstoque;

	@Autowired
	public AdicionaEstoqueCasoUso(ServicoDeEstoque servicoDeEstoque){
		this.servicoDeEstoque = servicoDeEstoque;
	}

    public void run(long codigo, int quantidade) {
		servicoDeEstoque.adicionaQtd(codigo, quantidade);
	}
}
