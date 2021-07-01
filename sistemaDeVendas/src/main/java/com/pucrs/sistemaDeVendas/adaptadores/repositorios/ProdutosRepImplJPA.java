package com.pucrs.sistemaDeVendas.adaptadores.repositorios;

import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutosRepImplJPA extends CrudRepository<Produto, Long>{

}