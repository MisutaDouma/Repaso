package com.edu.Service.template;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.edu.Service.strategy.AjusteEconomicoStrategy;
import com.edu.domain.ItemServicio;
import com.edu.domain.OrdenServicio;

public class GeneradorOrdenArchivo extends GeneradorOrdenServicio {
    
    public GeneradorOrdenArchivo(AjusteEconomicoStrategy ajusteEconomicoStrategy) {
        super(ajusteEconomicoStrategy);
    }

    @Override
    protected String generarContenido(OrdenServicio orden, double subtotal, double totalFinal) {
        StringBuilder sb = new StringBuilder();

        sb.append("== ORDEN DE SERVICIO - ARCHIVO |\n")
          .append("Nro Orden: "+orden.getNroOrden()+"\n")
          .append(" | Cliente: "+orden.getCliente()+"\n")
          .append(" | Subtotal: "+subtotal+"\n")
          .append(" | Total Final: "+totalFinal+"\n")
          .append(" | Estrategia de ajuste: "+ajusteEconomicoStrategy.getNombre()+"\n");
          for (ItemServicio item : orden.getItems()) {
            sb.append("\nProducto: ")
              .append(item.getDescripcion())
              .append(" | Cantidad: ")
              .append(item.getCantidad())
              .append(" | Costo Unitario: ")
              .append(item.getCostoUnitario())
              .append("\n");
          }
        sb.append("\n");
        sb.append("Subtotal: $"+ subtotal+"\n");
        sb.append("Total Final: $"+ totalFinal+"\n");
        sb.append("Fin de la orden de servicio");
        return sb.toString();
    }

    @Override
    protected void exportar(String contenido) {
        
        Path rutaArchivo = Path.of("orden.txt");
        try {
            Files.writeString(rutaArchivo, contenido, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}
