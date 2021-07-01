package com.pucrs.servEstoque.adaptadores.controllers;

import com.google.gson.Gson;
import com.pucrs.servEstoque.aplicacao.casosDeUso.AdicionaEstoqueCasoUso;
import com.pucrs.servEstoque.aplicacao.dtos.ItemCarrinhoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
  @Autowired
  private AdicionaEstoqueCasoUso adicionaEstoqueCasoUso;

  public void receiveMessage(String jsonObject) {
    ItemCarrinhoDTO novaQuantidade = new Gson().fromJson(jsonObject, ItemCarrinhoDTO.class);
    adicionaEstoqueCasoUso.run(novaQuantidade.getCodigo(), novaQuantidade.getQuantidade());
  }
}