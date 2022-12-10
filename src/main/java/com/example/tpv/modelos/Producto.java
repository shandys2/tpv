package com.example.tpv.modelos;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity(name ="PRODUCTOS")
@Table(name = "PRODUCTOS")

public class Producto {

    private int id;

    private String nombre;

    private String precio;

    private String impuesto;

    private int stock;
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true , nullable = false )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name = "PRECIO")
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    @Column(name = "IMPUESTO")
    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }
    @Column(name = "STOCK")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
