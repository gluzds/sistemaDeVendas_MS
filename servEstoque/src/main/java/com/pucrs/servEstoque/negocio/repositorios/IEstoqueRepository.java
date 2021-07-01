package com.pucrs.servEstoque.negocio.repositorios;

import java.util.List;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;

public interface IEstoqueRepository {

	public abstract List<ItemEstoque> todos();

	public abstract void adicionaItem(ItemEstoque item);

	public abstract boolean baixa(ItemEstoque item, int quantidade);

	public abstract void adicionaQtd(long codigo, int quantidade);
}
