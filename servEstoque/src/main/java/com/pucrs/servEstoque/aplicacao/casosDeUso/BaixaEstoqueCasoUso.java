package com.pucrs.servEstoque.aplicacao.casosDeUso;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;
import com.pucrs.servEstoque.negocio.servicos.ServicoDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaixaEstoqueCasoUso {

	private ServicoDeEstoque servicoDeEstoque;

    @Autowired
    public BaixaEstoqueCasoUso(ServicoDeEstoque servicoDeEstoque){
        this.servicoDeEstoque = servicoDeEstoque; 
    }

    public boolean run(long codigo, int quantidade){
        ItemEstoque item = servicoDeEstoque.getByCodProduto(codigo);
        return servicoDeEstoque.baixa(item, quantidade);
    }
}
