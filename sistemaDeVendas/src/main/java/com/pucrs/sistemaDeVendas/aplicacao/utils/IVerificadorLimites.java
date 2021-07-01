package com.pucrs.sistemaDeVendas.aplicacao.utils;

import com.pucrs.sistemaDeVendas.negocio.entidades.Venda;

public interface IVerificadorLimites {
    boolean verificaLimites(Venda venda);
}
