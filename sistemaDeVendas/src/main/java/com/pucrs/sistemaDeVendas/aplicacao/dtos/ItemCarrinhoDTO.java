package com.pucrs.sistemaDeVendas.aplicacao.dtos;

public class ItemCarrinhoDTO {
        
    private int codigo;
    private int quantidade;

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public int getCodigo(){
        return this.codigo;
    }
}
