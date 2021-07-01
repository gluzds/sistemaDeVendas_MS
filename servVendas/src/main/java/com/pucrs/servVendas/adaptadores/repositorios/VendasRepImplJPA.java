package com.pucrs.servVendas.adaptadores.repositorios;

import com.pucrs.servVendas.negocio.entidades.Venda;

import org.springframework.data.repository.CrudRepository;

public interface VendasRepImplJPA extends CrudRepository<Venda, Long>{

}