package com.pucrs.sistemaDeVendas.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTOS")
public class Produto {

	@Id
	private long codigo;
	private String descricao;
	private double precoUnitario;

	public Produto(long codigo, String descricao, double precoUnitario){
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	protected Produto(){

	}

	public long getCodigo(){
		return this.codigo;
	}

	public String getDescricao(){
		return this.descricao;
	}

	public double getPrecoUnitario(){
		return this.precoUnitario;
	}

}
