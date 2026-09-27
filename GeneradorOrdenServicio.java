package com.edu.Service.template;

import com.edu.Service.strategy.AjusteEconomicoStrategy;
import com.edu.domain.OrdenServicio;


/**
 * Clase abstracta que define el esqueleto del proceso de generación de una orden de servicio.
 * Utiliza el patrón Template Method para permitir que las subclases definan ciertos pasos del proceso.
 */
public abstract class GeneradorOrdenServicio {

    protected AjusteEconomicoStrategy ajusteEconomicoStrategy;

    protected GeneradorOrdenServicio(AjusteEconomicoStrategy ajuste) {
        if (ajuste == null) {
            throw new IllegalArgumentException("El ajuste económico no puede ser nulo.");
        }
        this.ajusteEconomicoStrategy = ajuste;
    }

    public final void procesar(OrdenServicio orden){
        orden.validar();
        double subtotal = orden.calcularSubtotal();
        double totalFinal = ajusteEconomicoStrategy.aplicar(subtotal);
        String contenido = generarContenido(orden, subtotal, totalFinal);   
        exportar(contenido);
        informar(orden, totalFinal);
    }   

    protected abstract String generarContenido(OrdenServicio orden, double subtotal, double totalFinal);

    protected abstract void exportar(String contenido);

    protected void informar(OrdenServicio orden,double totalFinal){
        System.out.println("Aviso, - Orden "+orden.getNroOrden()
                +"Generada correctamente. Total final: "+totalFinal);
    }
}
