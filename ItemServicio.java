package com.edu.domain;

public class ItemServicio {
    private String descripcion;
    private int cantidad;
    private double costoUnitario;

    public ItemServicio(String descripcion, int cantidad, double costoUnitario) {
        if (descripcion == null || descripcion.isEmpty())
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía.");
        if (cantidad < 0)
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        if (costoUnitario < 0)
            throw new IllegalArgumentException("El costo unitario no puede ser negativo.");

        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}

    