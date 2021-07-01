package com.pucrs.sistemaDeVendas.aplicacao.casosDeUso;

import java.util.List;

import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;
import com.pucrs.sistemaDeVendas.negocio.servicos.ServicoDeProduto;

import org.springframework.stereotype.Component;

@Component
public class ListarProdutosCasoUso {

    private ServicoDeProduto servicoDeProduto;

    public ListarProdutosCasoUso(ServicoDeProduto servicoDeProduto){
        this.servicoDeProduto = servicoDeProduto; 
    }

    public List<Produto> run(){
		return servicoDeProduto.todos();
	}
}
