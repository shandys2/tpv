package com.example.tpv.modelos;

public class RowPedido {

    private String nombre;

    private String precio;
    private String cantidad;


    public RowPedido(String nombre, String precio, String cantidad){

        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}

