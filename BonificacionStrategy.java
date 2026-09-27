package com.edu.Service.strategy;

public class BonificacionStrategy implements AjusteEconomicoStrategy {
    private double porcentajeDescuento;

    public BonificacionStrategy(double porcentajeDescuento){
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100)
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        this.porcentajeDescuento = porcentajeDescuento;
    }

     @Override
    public double aplicar(double subtotal) {
        return subtotal - (subtotal * porcentajeDescuento / 100);
    }

    @Override
    public String getNombre() {
        return "Bonificacion con %"+porcentajeDescuento+" de descuento";
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
