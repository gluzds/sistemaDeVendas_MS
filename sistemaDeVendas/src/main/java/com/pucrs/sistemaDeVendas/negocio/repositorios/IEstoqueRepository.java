package com.pucrs.sistemaDeVendas.negocio.repositorios;

import java.util.List;

import com.pucrs.sistemaDeVendas.negocio.entidades.ItemEstoque;

public interface IEstoqueRepository {

	public abstract List<ItemEstoque> todos();

	public abstract void adiciona(ItemEstoque item);

	public abstract void baixa(ItemEstoque item, int quantidade);

}
