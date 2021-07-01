package com.pucrs.sistemaDeVendas.aplicacao.utils;

public class CalculaImpostoBrasil implements ICalculaImposto{

    private double ICMS = 0.17;

    @Override
    public long calcula(long valor) {
        return (long) (valor * ICMS);
    }
    
}
