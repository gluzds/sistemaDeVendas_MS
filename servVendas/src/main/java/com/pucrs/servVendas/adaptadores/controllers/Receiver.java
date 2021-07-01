package com.pucrs.servVendas.adaptadores.controllers;

import com.google.gson.Gson;
import com.pucrs.servVendas.aplicacao.casosDeUso.RegistrarVendaCasoUso;
import com.pucrs.servVendas.negocio.entidades.Venda;
import com.pucrs.servVendas.negocio.servicos.ServicoVendas;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
  @Autowired
  private ServicoVendas servicoVendas;
  
  @RabbitListener(queues = "spring-boot")
  public void receiveMessage(String jsonObject) {
    System.out.println("-------****------- Recebido nova venda -------****-------");
    System.out.println(jsonObject);
    Venda novaVenda = new Gson().fromJson(jsonObject, Venda.class);
    servicoVendas.salvar(novaVenda);
  }
}