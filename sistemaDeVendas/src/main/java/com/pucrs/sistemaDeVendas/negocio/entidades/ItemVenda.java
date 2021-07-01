package com.pucrs.sistemaDeVendas.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemVenda {

	@Id @GeneratedValue
	private long id;
	private int quantidade;
	private double imposto;
	@OneToOne
	private Produto produto;

	public ItemVenda(int quantidade, double imposto, Produto produto){
		this.quantidade = quantidade;
		this.imposto = imposto;
		this.produto = produto;
	}

	public ItemVenda(){
		
	}

	public int getQuantidade(){
		return this.quantidade;
	}


	public double getImposto(){
		return this.imposto;
	}

	public Produto getProduto(){
		return this.produto;
	}

	public long getId(){
		return this.id;
	}
}
