package com.pucrs.servVendas.negocio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numero;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemVenda> itemVenda;

	public Venda(List<ItemVenda> itemVenda){
		this.itemVenda = itemVenda;
	}
	protected Venda(){
		
	}

	public long getNumero(){
		return numero;
	}

	public double getSubTotal(){
		double subtotal = 0.0;
		for (ItemVenda item : itemVenda){
			subtotal += item.getProduto().getPrecoUnitario();
		}
		return subtotal;
	}

	public List<ItemVenda> getItemVenda(){
		return itemVenda;
	}

}
