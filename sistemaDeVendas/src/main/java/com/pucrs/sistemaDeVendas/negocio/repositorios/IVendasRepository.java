package com.pucrs.sistemaDeVendas.negocio.repositorios;

import java.util.List;

import com.pucrs.sistemaDeVendas.negocio.entidades.Venda;

public interface IVendasRepository {

	public abstract void salvar(Venda venda);

	public abstract Venda recupera(long numero);

	public abstract List<Venda> todos();

}
