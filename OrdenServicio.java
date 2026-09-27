package com.edu.domain;

import java.util.ArrayList;
import java.util.List;

public class OrdenServicio {
    private String cliente;
    private String nroOrden;
    private List<ItemServicio> items;

    public OrdenServicio(String cliente, String nroOrden) {
        this.cliente = cliente;
        this.nroOrden = nroOrden;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemServicio item) {
        if (item == null) {
            throw new IllegalArgumentException("Es necesario un item");
        }
        items.add(item);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemServicio item : items) {
            subtotal += item.getCantidad() * item.getCostoUnitario();
        }
        return subtotal;
    }

    public void validar(){
        if(cliente == null || cliente.isEmpty())
            throw new IllegalArgumentException("El cliente no puede ser nulo o vacío.");
        if(nroOrden == null || nroOrden.isEmpty())
            throw new IllegalArgumentException("El número de orden no puede ser nulo o vacío.");
        if(items == null || items.isEmpty())
            throw new IllegalArgumentException("La lista de items no puede ser nula o vacía.");
        for(ItemServicio item:items){
            if(item == null|| item.getDescripcion().isEmpty())
                throw new IllegalArgumentException("Los items no pueden ser nulos o vacíos.");
        }
    }

    public void mostrarOrden(){
        System.out.println("Cliente: " + cliente);
        System.out.println("Número de Orden: " + nroOrden);
        System.out.println("Items:");
        for (ItemServicio item : items) {
            System.out.println("Producto: " + item.getDescripcion() + ": " + item.getCantidad() + " x " + item.getCostoUnitario());
        }
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    public List<ItemServicio> getItems() {
        return items;
    }

    public void setItems(List<ItemServicio> items) {
        this.items = items;
    }

}
