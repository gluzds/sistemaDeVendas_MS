package com.pucrs.servVendas.negocio.servicos;

import java.util.List;

import com.pucrs.servVendas.negocio.entidades.Venda;
import com.pucrs.servVendas.negocio.repositorios.IVendasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoVendas {

	private IVendasRepository vendasRepository;

	@Autowired
	public ServicoVendas(IVendasRepository vendasRepository){
		this.vendasRepository = vendasRepository;
	}

	public void salvar(Venda venda) {
		vendasRepository.salvar(venda);
	}
	
	public Venda recupera(long numero) {
		return vendasRepository.recupera(numero);
	}
	
	public List<Venda> todos() {
		return vendasRepository.todos();
	}

}
