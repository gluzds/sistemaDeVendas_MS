package com.pucrs.sistemaDeVendas.aplicacao.dtos;

public class ProdutoEstoqueDTO {

    private long codigo;
    private String descricao;
    private double preco;
    private int qtdade;

    public ProdutoEstoqueDTO(long codigo, String descricao, double preco, int qtdade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdade = qtdade;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtdade() {
        return qtdade;
    }
}
