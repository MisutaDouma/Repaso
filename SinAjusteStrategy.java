package com.edu.Service.strategy;

public class SinAjusteStrategy implements AjusteEconomicoStrategy {
    
    public SinAjusteStrategy() {
    }

    @Override
    public double aplicar(double subtotal) {
        return subtotal;
    }

    @Override
    public String getNombre() {
        return "Sin ajuste";
    }
}
