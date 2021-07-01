package com.pucrs.servEstoque.adaptadores.repositorios;

import com.pucrs.servEstoque.negocio.entidades.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutosRepImplJPA extends CrudRepository<Produto, Long>{

}