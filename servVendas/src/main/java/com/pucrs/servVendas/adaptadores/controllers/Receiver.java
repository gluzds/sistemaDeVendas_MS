package com.pucrs.servVendas.adaptadores.controllers;

import com.google.gson.Gson;
import com.pucrs.servVendas.aplicacao.casosDeUso.RegistrarVendaCasoUso;
import com.pucrs.servVendas.negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
  @Autowired
  private RegistrarVendaCasoUso registrarVendaCasoUso;

  public void receiveMessage(String jsonObject) {
    Venda novaVenda = new Gson().fromJson(jsonObject, Venda.class);
    registrarVendaCasoUso.run(novaVenda);
  }
}