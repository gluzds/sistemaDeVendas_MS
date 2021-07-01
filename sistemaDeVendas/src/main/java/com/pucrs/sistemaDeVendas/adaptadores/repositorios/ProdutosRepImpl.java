package com.pucrs.sistemaDeVendas.adaptadores.repositorios;

import java.util.List;

import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;
import com.pucrs.sistemaDeVendas.negocio.repositorios.IProdutosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutosRepImpl implements IProdutosRepository {

	ProdutosRepImplJPA jpa;

	@Autowired
	public ProdutosRepImpl(ProdutosRepImplJPA jpa){
		this.jpa = jpa;
	}

	public List<Produto> todos() {
		return (List<Produto>) jpa.findAll();
	}

	public void adicionar(Produto produto) {
        jpa.save(produto);
	}

	public void alterar(Produto produto) {
		jpa.deleteById(produto.getCodigo());
		jpa.save(produto);
	}

	public void remover(Produto produto) {
		jpa.deleteById(produto.getCodigo());
	}
	
	public Produto findByCodigo(long codigo) {
		List<Produto> lista = (List<Produto>) jpa.findAll();
		for(Produto produto : lista){
			if(produto.getCodigo() == codigo){
				return produto;
			}
		}
		return null;
	}
}
