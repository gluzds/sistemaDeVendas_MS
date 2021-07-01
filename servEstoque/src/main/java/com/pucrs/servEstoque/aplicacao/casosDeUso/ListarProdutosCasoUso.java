package com.pucrs.servEstoque.aplicacao.casosDeUso;

import java.util.List;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;
import com.pucrs.servEstoque.negocio.servicos.ServicoDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListarProdutosCasoUso {

    private ServicoDeEstoque servicoDeEstoque;
    
    @Autowired
    public ListarProdutosCasoUso(ServicoDeEstoque servicoDeEstoque){
        this.servicoDeEstoque = servicoDeEstoque; 
    }

    public List<ItemEstoque> run(){
		return servicoDeEstoque.todos();
	}
}
