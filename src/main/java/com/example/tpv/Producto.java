package com.example.tpv;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true , nullable = false )
    public int id;
    @Column(name = "NOMBRE")
    public String nombre;
    @Column(name = "PRECIO")
    public String precio;
    @Column(name = "IMPUESTO")
    public String impuesto;
    @Column(name = "STOCK")
    public int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
