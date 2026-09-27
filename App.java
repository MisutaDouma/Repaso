package com.edu;

import com.edu.domain.OrdenServicio;
import com.edu.Service.factory.StrategyFactory;
import com.edu.Service.factory.TipoAjuste;
import com.edu.Service.strategy.AjusteEconomicoStrategy;
import com.edu.Service.strategy.BonificacionStrategy;
import com.edu.Service.strategy.ConvenioEspecialStrategy;
import com.edu.Service.template.GeneradorOrdenArchivo;
import com.edu.Service.template.GeneradorOrdenConsola;
import com.edu.Service.template.GeneradorOrdenServicio;
import com.edu.domain.ItemServicio;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   System.out.println();
        System.out.println( "Aplicacion de servicios telefonicos" );

        OrdenServicio orden = new OrdenServicio("Juan Perez", "ORD-001");
        orden.agregarItem(new ItemServicio("Mouse", 10, 5000));
        orden.agregarItem(new ItemServicio("Teclado", 5, 10000));
        orden.mostrarOrden();

        // SEgunda etapa- aplicar patron de diseñpo Strategy
        AjusteEconomicoStrategy ajuste = new BonificacionStrategy(10); // 10% de descuento
        double subtotal =orden.calcularSubtotal();
        System.out.println("Subtotal: "+ subtotal);
        System.out.println("Ajuste: "+ ajuste.aplicar(subtotal));
        System.out.println();

        //Tercera etapa- aplicar patron de diseño Template Method
        GeneradorOrdenServicio generador1 = new GeneradorOrdenConsola(new BonificacionStrategy(10));
        generador1.procesar(orden);
        System.out.println("-".repeat(60));

        GeneradorOrdenServicio generador2 = new GeneradorOrdenArchivo(new ConvenioEspecialStrategy(500));
        generador2.procesar(orden);

        // Cuarta etapa- aplicar patron de diseño Factory Method

        GeneradorOrdenServicio generador3 = new GeneradorOrdenArchivo(StrategyFactory.crear(TipoAjuste.URGENTE));
        generador3.procesar(orden);
        System.out.println();
    }
}
