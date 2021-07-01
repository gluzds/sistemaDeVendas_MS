package com.pucrs.servEstoque.negocio.servicos;

import java.util.List;

import com.pucrs.servEstoque.negocio.entidades.Produto;
import com.pucrs.servEstoque.negocio.repositorios.IProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDeProduto {

	private IProdutosRepository produtosRepository;

	@Autowired
	public ServicoDeProduto(IProdutosRepository produtosRepository){
		this.produtosRepository = produtosRepository;
	}

	public List<Produto> todos(){
		return produtosRepository.todos();
	}

	public void adicionar(Produto produto){
		produtosRepository.adicionar(produto);
	}

	public void alterar(Produto produto){
		produtosRepository.alterar(produto);
	}

	public void remover(Produto produto){
		produtosRepository.alterar(produto);
	}

}