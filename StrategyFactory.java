package com.edu.Service.factory;

import com.edu.Service.strategy.BonificacionStrategy;
import com.edu.Service.strategy.*;

public class StrategyFactory {
    
    private StrategyFactory() {
        // Private constructor to prevent instantiation
    }    

    public static AjusteEconomicoStrategy crear(TipoAjuste tipoAjuste){
        if(tipoAjuste == null){
            throw new IllegalArgumentException("El tipo de ajuste no puede ser nulo.");
        }
        return switch (tipoAjuste) {
            case BONIFICACION -> new BonificacionStrategy(10); // Porcentaje de descuento del 10%
            case CONVENIO -> new ConvenioEspecialStrategy(500); // Monto fijo de $500
            case URGENTE -> new ServicioUrgenteStrategy(15); // Porcentaje de recargo del 15%
            case SIN_AJUSTE -> new SinAjusteStrategy(); // Sin ajuste
        };
    
    }
}
