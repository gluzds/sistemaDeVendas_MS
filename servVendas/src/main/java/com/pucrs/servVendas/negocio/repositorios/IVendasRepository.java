package com.pucrs.servVendas.negocio.repositorios;

import java.util.List;

import com.pucrs.servVendas.negocio.entidades.Venda;

public interface IVendasRepository {

	public abstract void salvar(Venda venda);

	public abstract Venda recupera(long numero);

	public abstract List<Venda> todos();

}
