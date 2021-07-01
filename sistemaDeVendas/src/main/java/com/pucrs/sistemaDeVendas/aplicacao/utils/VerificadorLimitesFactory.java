package com.pucrs.sistemaDeVendas.aplicacao.utils;

import java.time.LocalTime;

public class VerificadorLimitesFactory {
    
    private static LocalTime abertura = LocalTime.of(9, 0);
    private static LocalTime fechamento = LocalTime.of(18, 0);

    public static IVerificadorLimites getLimites() {

        if (LocalTime.now().isAfter(abertura) && LocalTime.now().isBefore(fechamento)) {
          return new VerificadorLimitesNormal();
        } else {
          return new VerificadorLimitesReduzido();
        }

      }
}
