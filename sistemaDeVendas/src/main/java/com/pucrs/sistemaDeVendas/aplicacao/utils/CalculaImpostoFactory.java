package com.pucrs.sistemaDeVendas.aplicacao.utils;

// Tendo em vista que a informacao do pais do produto sera armazenado posteriormente, podemos obter esse dado para calcular o imposto.
public class CalculaImpostoFactory {

    public static ICalculaImposto getImposto(String pais) {
        switch (pais.toLowerCase()) {
            case "brasil":
                return new CalculaImpostoBrasil();
            default:
                return new CalculaImpostoBrasil();
        }

      }
}
