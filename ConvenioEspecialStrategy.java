package com.edu.Service.strategy;

public class ConvenioEspecialStrategy implements AjusteEconomicoStrategy {
    private double montoFijo;
    public ConvenioEspecialStrategy(double montoFijo) {
        if (montoFijo < 0)
            throw new IllegalArgumentException("El monto fijo no puede ser negativo.");
        this.montoFijo = montoFijo;
    }
     @Override
    public double aplicar(double subtotal) {
        return subtotal - montoFijo;
    }
    @Override
    public String getNombre() {
     return "Convenio especial con $"+montoFijo+" de monto fijo";
    }

    public double getMontoFijo() {
        return montoFijo;
    }
    public void setMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }
   
    
}
