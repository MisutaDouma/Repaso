package com.edu.Service.template;

import com.edu.Service.strategy.AjusteEconomicoStrategy;
import com.edu.domain.OrdenServicio;

public class GeneradorOrdenConsola extends GeneradorOrdenServicio {
    

    public GeneradorOrdenConsola(AjusteEconomicoStrategy ajusteEconomicoStrategy) {
        super(ajusteEconomicoStrategy);
    }

    @Override
    protected String generarContenido(OrdenServicio orden, double subtotal, double totalFinal) {
        return "== ORDEN DE SERVICIO - CONSOLA |"+
        "Nro Orden: "+orden.getNroOrden()+
        " | Cliente: "+orden.getCliente()+
        " | Subtotal: "+subtotal+
        " | Total Final: "+totalFinal+
        " | Estrategia de ajuste: "+ajusteEconomicoStrategy.getNombre();
    }

    @Override
    protected void exportar(String contenido) {
        System.out.println("Exportando orden a consola...");
        System.out.println(contenido);

    }
}
