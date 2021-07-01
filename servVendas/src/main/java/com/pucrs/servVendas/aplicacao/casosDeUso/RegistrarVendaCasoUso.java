package com.pucrs.servVendas.aplicacao.casosDeUso;

import com.pucrs.servVendas.negocio.entidades.Venda;
import com.pucrs.servVendas.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrarVendaCasoUso {

	private ServicoVendas servicoVendas;

	@Autowired
	public RegistrarVendaCasoUso(ServicoVendas servicoVendas){
		this.servicoVendas = servicoVendas;
	}
	
	public void run(Venda venda){
		servicoVendas.salvar(venda);
	}
}