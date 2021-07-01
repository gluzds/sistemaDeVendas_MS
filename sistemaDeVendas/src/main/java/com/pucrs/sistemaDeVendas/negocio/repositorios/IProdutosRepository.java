package com.pucrs.sistemaDeVendas.negocio.repositorios;

import java.util.List;

import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;

public interface IProdutosRepository {

	public abstract List<Produto> todos();

	public abstract void adicionar(Produto item);

	public abstract void alterar(Produto item);

	public abstract void remover(Produto item);
	
	public abstract Produto findByCodigo(long codigo);
}
