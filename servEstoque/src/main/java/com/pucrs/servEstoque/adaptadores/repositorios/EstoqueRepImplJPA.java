package com.pucrs.servEstoque.adaptadores.repositorios;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;

import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepImplJPA extends CrudRepository<ItemEstoque, Long>{

}