package com.pucrs.servEstoque.negocio.servicos;

import java.util.List;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;
import com.pucrs.servEstoque.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoDeEstoque {

	private IEstoqueRepository estoqueRepository;

	@Autowired
	public ServicoDeEstoque(IEstoqueRepository estoqueRepository){
		this.estoqueRepository = estoqueRepository;
	}

	public List<ItemEstoque> todos(){
		return estoqueRepository.todos();
	}

	public void adicionaItem(ItemEstoque item){
		estoqueRepository.adicionaItem(item);
	}

	public boolean baixa(ItemEstoque item, int quantidade){
		return estoqueRepository.baixa(item, quantidade);
	}

	public ItemEstoque getByCodProduto(long codProduto){
		ItemEstoque itemEstoque = estoqueRepository.todos()
		.stream()
		.filter(p -> p.getProduto().getCodigo() == codProduto)
		.findAny()
		.orElse(null);
		return itemEstoque;
	}

	public void adicionaQtd(long codigo, int quantidade){
		estoqueRepository.adicionaQtd(codigo, quantidade);
	}
}
