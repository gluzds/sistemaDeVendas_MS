package com.pucrs.servVendas.aplicacao.casosDeUso;

import java.util.List;

import com.pucrs.servVendas.negocio.entidades.Venda;
import com.pucrs.servVendas.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVendasCasoUso {

	private ServicoVendas servicoVendas;

	@Autowired
	public ConsultaVendasCasoUso(ServicoVendas servicoVendas){
		this.servicoVendas = servicoVendas;
	}

	public List<Venda> run() {
		return servicoVendas.todos();
	}

}
