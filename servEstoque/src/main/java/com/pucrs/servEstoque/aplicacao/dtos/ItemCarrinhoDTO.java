package com.pucrs.servEstoque.aplicacao.dtos;

public class ItemCarrinhoDTO {
        
    private long codigo;
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

    public long getCodigo(){
        return this.codigo;
    }
}
