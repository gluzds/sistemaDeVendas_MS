package com.pucrs.sistemaDeVendas.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemEstoque {

	@Id @GeneratedValue
	private long id;
	private int quantidadeDisponivel;
	@OneToOne
	private Produto produto;

	public ItemEstoque(int quantidadeDisponivel, Produto produto){
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.produto = produto;
	}

	public ItemEstoque(){
		
	}

	public int getQuantidadeDisponivel(){
		return this.quantidadeDisponivel;
	}

	public Produto getProduto(){
		return this.produto;
	}

	public long getId(){
		return this.id;
	}

	public void setQuantidadeDisponivel(int quantidade){
		this.quantidadeDisponivel = quantidade;
	}
}
