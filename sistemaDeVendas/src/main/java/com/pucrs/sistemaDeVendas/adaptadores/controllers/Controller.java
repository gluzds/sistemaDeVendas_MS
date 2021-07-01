package com.pucrs.sistemaDeVendas.adaptadores.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pucrs.sistemaDeVendas.aplicacao.casosDeUso.EfetivarVendaCasoUso;
import com.pucrs.sistemaDeVendas.aplicacao.casosDeUso.ListarProdutosCasoUso;
import com.pucrs.sistemaDeVendas.aplicacao.dtos.ItemCarrinhoDTO;
import com.pucrs.sistemaDeVendas.aplicacao.utils.CalculaImpostoFactory;
import com.pucrs.sistemaDeVendas.negocio.entidades.ItemCarrinho;
import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {

	private EfetivarVendaCasoUso efetivarVendaCasoUso;
	private ListarProdutosCasoUso listarProdutosCasoUso;

	@Autowired
	public Controller(EfetivarVendaCasoUso efetivarVendaCasoUso, ListarProdutosCasoUso listarProdutosCasoUso){
		this.efetivarVendaCasoUso = efetivarVendaCasoUso;
		this.listarProdutosCasoUso = listarProdutosCasoUso;
	}
  
	@PostMapping("/confirmacao")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public boolean confirmaVenda(@RequestBody final ItemCarrinhoDTO[] itens) {
		ArrayList<ItemCarrinhoDTO> itensList = new ArrayList<ItemCarrinhoDTO>(Arrays.asList(itens));
		efetivarVendaCasoUso.run(itensList);
		return true;
	}

	@GetMapping("/verificarProdutos")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Produto> teste() {
		return listarProdutosCasoUso.run();
	}
  
	@PostMapping("/subtotal")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Integer[] calculaSubtotal(@RequestBody final ItemCarrinho[] itens) {
	  Integer subtotal = 0;
	  Integer imposto = 0;
  
	  for (final ItemCarrinho item : itens) {
		
		Produto prod = listarProdutosCasoUso.run().stream().filter(p -> p.getCodigo() == item.getCodigo()).findAny().orElse(null);

		if (prod != null) {
		  subtotal += (int) (prod.getPrecoUnitario() * item.getQuantidade());
		} else {
		  throw new IllegalArgumentException("Codigo invalido");
		}
	  }
	  imposto = (int) CalculaImpostoFactory.getImposto("brasil").calcula(subtotal);
	  final Integer[] resp = new Integer[3];
	  resp[0] = subtotal;
	  resp[1] = imposto;
	  resp[2] = subtotal + imposto;
	  return resp;
	}
}
