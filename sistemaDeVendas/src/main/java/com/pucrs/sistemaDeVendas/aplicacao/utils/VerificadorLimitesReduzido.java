package com.pucrs.sistemaDeVendas.aplicacao.utils;

import com.pucrs.sistemaDeVendas.negocio.entidades.ItemVenda;
import com.pucrs.sistemaDeVendas.negocio.entidades.Venda;

public class VerificadorLimitesReduzido implements IVerificadorLimites{
    private double limiteValor = 5000.0;
    private int limiteProdQtd = 5;
    private int limiteQtdItens = 10;

    @Override
    public boolean verificaLimites(Venda venda){
        if(venda.getSubTotal() > limiteValor){
            return false;
        }
        int qtdItens = 0;
        for(ItemVenda item : venda.getItemVenda()){
            int qtdadeDoItem = item.getQuantidade();
            if(qtdadeDoItem > limiteProdQtd){
                return false;
            }
            qtdItens += qtdadeDoItem;
        }
        if(qtdItens > limiteQtdItens){
            return false;
        }
        return true;
    }
}
