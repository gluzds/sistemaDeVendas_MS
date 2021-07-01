package com.pucrs.servEstoque.adaptadores.controllers;

import java.util.ArrayList;
import java.util.List;

import com.pucrs.servEstoque.aplicacao.casosDeUso.AdicionarProdutoCasoUso;
import com.pucrs.servEstoque.aplicacao.casosDeUso.BaixaEstoqueCasoUso;
import com.pucrs.servEstoque.aplicacao.casosDeUso.ListarProdutosCasoUso;
import com.pucrs.servEstoque.aplicacao.casosDeUso.SelecionarProdutoCasoUso;
import com.pucrs.servEstoque.aplicacao.dtos.ProdutoEstoqueDTO;
import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;
import com.pucrs.servEstoque.negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {

	private SelecionarProdutoCasoUso selecionarProdutoCasoUso;
	private ListarProdutosCasoUso listarProdutosCasoUso;
	private BaixaEstoqueCasoUso baixaEstoqueCasoUso;

	@Autowired
	public Controller(SelecionarProdutoCasoUso selecionarProdutoCasoUso, AdicionarProdutoCasoUso adicionarProdutoCasoUso, ListarProdutosCasoUso listarProdutosCasoUso, BaixaEstoqueCasoUso baixaEstoqueCasoUso){
		this.selecionarProdutoCasoUso = selecionarProdutoCasoUso;
		this.listarProdutosCasoUso = listarProdutosCasoUso;
		this.baixaEstoqueCasoUso = baixaEstoqueCasoUso;
	}

	@GetMapping("/produtos")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<ProdutoEstoqueDTO> listaProdutos() {
		List<ProdutoEstoqueDTO> listaDTO = new ArrayList<ProdutoEstoqueDTO>();
	    ArrayList<ItemEstoque> lista = (ArrayList<ItemEstoque>) listarProdutosCasoUso.run();
		for(ItemEstoque item : lista){
			Produto prod = item.getProduto();
			listaDTO.add(new ProdutoEstoqueDTO(prod.getCodigo(), prod.getDescricao(), prod.getPrecoUnitario(), item.getQuantidadeDisponivel()));
		}
		return listaDTO;
	}
  
	@GetMapping("/autorizacao")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public boolean podeVender(@RequestParam final Long codProd,
							  @RequestParam final Integer qtdade) {
	  return selecionarProdutoCasoUso.run(codProd, qtdade);
	}

	@PostMapping("/baixa")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public boolean baixa(@RequestParam final Long codProd,
							  @RequestParam final Integer qtdade) {
		return baixaEstoqueCasoUso.run(codProd, qtdade);
	}
}