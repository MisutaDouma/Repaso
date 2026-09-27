package com.edu.Service.strategy;

public class ServicioUrgenteStrategy implements AjusteEconomicoStrategy {
    private double porcentajeRecargo;
    public ServicioUrgenteStrategy(double porcentajeRecargo) {
        if (porcentajeRecargo < 0)
            throw new IllegalArgumentException("El porcentaje de recargo no puede ser negativo.");
        this.porcentajeRecargo = porcentajeRecargo;
    }
    @Override
    public double aplicar(double subtotal) {
        return subtotal + (subtotal * porcentajeRecargo / 100);
    }

    @Override
    public String getNombre() {
        return "Servicio urgente con %"+porcentajeRecargo+" de recargo";      
    }

    public double getPorcentajeRecargo() {
        return porcentajeRecargo;
    }
    public void setPorcentajeRecargo(double porcentajeRecargo) {
        this.porcentajeRecargo = porcentajeRecargo;
    }
}
