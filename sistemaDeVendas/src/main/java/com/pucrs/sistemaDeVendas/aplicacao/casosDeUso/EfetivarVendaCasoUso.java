package com.pucrs.sistemaDeVendas.aplicacao.casosDeUso;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

import com.google.gson.Gson;
import com.pucrs.sistemaDeVendas.aplicacao.dtos.ItemCarrinhoDTO;
import com.pucrs.sistemaDeVendas.negocio.entidades.ItemVenda;
import com.pucrs.sistemaDeVendas.negocio.entidades.Produto;
import com.pucrs.sistemaDeVendas.negocio.entidades.Venda;
import com.pucrs.sistemaDeVendas.negocio.servicos.ServicoDeProduto;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EfetivarVendaCasoUso {

	private ServicoDeProduto servicoDeProduto;
	private HttpClient client;
	private String BASE_URL = "http://host.docker.internal:8080/vendas";
	@Autowired
    private RabbitTemplate rabbitTemplate;

	@Autowired
	public EfetivarVendaCasoUso(ServicoDeProduto servicoDeProduto){
		this.servicoDeProduto = servicoDeProduto;
		client = HttpClient.newHttpClient();
	}

	public void run(List<ItemCarrinhoDTO> itens){
		List<ItemVenda> listaItens = new ArrayList<>();
		boolean rollback = false; 
		for (ItemCarrinhoDTO item : itens){
			if(buscarItem(item.getCodigo(), item.getQuantidade())){
				baixaItem(item.getCodigo(), item.getQuantidade());
			} else {
				rollback = true;
			}
			Produto produto = servicoDeProduto.getById(item.getCodigo());
			ItemVenda itemVenda = new ItemVenda(item.getQuantidade(), 5.0, produto);
			listaItens.add(itemVenda);
		}
		if(!rollback){
			Venda venda = new Venda(listaItens);
			registrarVenda(venda);
		} else {
			rollback(itens);
		}
	}

	private void registrarVenda(Venda venda){
		String gsonObject = new Gson().toJson(venda);
		rabbitTemplate.convertAndSend("spring-boot-exchange", "vendas.nova", gsonObject);
	}

	private boolean buscarItem(long codProd, int quantidade){
		client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://" + BASE_URL + "/vendas/autorizacao?codProd=" + codProd + "&qtdade=" + quantidade))
            .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println(response.body());
		if(response.body().equals("true")){
			return true;
		} else {
			return false;
		}
	}

	private boolean baixaItem(long codProd, int quantidade){
		client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://" + BASE_URL + "/vendas/baixa?codProd=" + codProd + "&qtdade=" + quantidade))
            .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println(response.body());
		if(response.body().equals("true")){
			return true;
		} else {
			return false;
		}
	}

	private void rollback(List<ItemCarrinhoDTO> itens){
		for(ItemCarrinhoDTO item : itens){
			String gsonObject = new Gson().toJson(item);
			rabbitTemplate.convertAndSend("spring-boot-exchange", "estoque.rollback", gsonObject);
		}
	}
}