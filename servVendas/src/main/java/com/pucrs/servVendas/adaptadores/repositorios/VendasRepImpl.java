package com.pucrs.servVendas.adaptadores.repositorios;

import java.util.List;
import java.util.Optional;

import com.pucrs.servVendas.negocio.entidades.Venda;
import com.pucrs.servVendas.negocio.repositorios.IVendasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendasRepImpl implements IVendasRepository{

	VendasRepImplJPA jpa;

	@Autowired
	public VendasRepImpl(VendasRepImplJPA jpa) {
		this.jpa = jpa;
	}

	public void salvar(Venda venda) {
		jpa.save(venda);
	}

	public Venda recupera(long numero) {
		Optional<Venda> optionalVenda = jpa.findById(numero);
		Venda venda = optionalVenda.get();
		return venda;
	}

	public List<Venda> todos() {
		return (List<Venda>) jpa.findAll();
	}

}
