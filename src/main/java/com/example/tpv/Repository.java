package com.example.tpv;

import com.example.tpv.modelos.Producto;
import com.example.tpv.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static List<Usuario> listaUsuarios= new ArrayList<>();
    static List<Producto> listaProductos=new ArrayList<>();

    public Repository(){
        cargarDatos();
    }


    private void cargarDatos(){

        Usuario u1= new Usuario();
            u1.setUser("pepe");
            u1.setPass("1");
            u1.setAdmin(false);
        Usuario u2= new Usuario();
            u2.setUser("dani");
            u2.setPass("2");
            u2.setAdmin(true);

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);

        Producto p1 = new Producto();
            p1.setNombre("Cafe-cortado");
            p1.setImpuesto("21");
            p1.setPrecio("1,20");
            p1.setStock(100);
            p1.setCategoria("CAFE");
        Producto p2 = new Producto();
            p2.setNombre("Cafe-solo");
            p2.setImpuesto("21");
            p2.setPrecio("1,10");
            p2.setStock(200);
            p2.setCategoria("CAFE");
           Producto p3 = new Producto();
            p3.setNombre("Cafe-leche");
            p3.setImpuesto("21");
            p3.setPrecio("1,30");
            p3.setStock(110);
            p3.setCategoria("CAFE");
        Producto p4 = new Producto();
            p4.setNombre("Napolitana");
            p4.setImpuesto("21");
            p4.setPrecio("1,25");
            p4.setStock(56);
            p4.setCategoria("BOLLERIA");
        Producto p5 = new Producto();
            p5.setNombre("Donut");
            p5.setImpuesto("21");
            p5.setPrecio("1,30");
            p5.setStock(78);
            p5.setCategoria("BOLLERIA");
        Producto p6 = new Producto();
            p6.setNombre("Cookie");
            p6.setImpuesto("21");
            p6.setPrecio("0,70");
            p6.setStock(44);
            p6.setCategoria("BOLLERIA");
        Producto p7 = new Producto();
            p7.setNombre("Croisant");
            p7.setImpuesto("21");
            p7.setPrecio("1,30");
            p7.setStock(21);
            p7.setCategoria("BOLLERIA");
        Producto p8 = new Producto();
            p8.setNombre("Batido-choco");
            p8.setImpuesto("21");
            p8.setPrecio("2,00");
            p8.setStock(16);
            p8.setCategoria("BEBIDAS");
        Producto p9 = new Producto();
            p9.setNombre("Kas-limon");
            p9.setImpuesto("21");
            p9.setPrecio("2,10");
            p9.setStock(60);
            p9.setCategoria("BEBIDAS");
        Producto p10 = new Producto();
            p10.setNombre("Coca-cola");
            p10.setImpuesto("21");
            p10.setPrecio("2,30");
            p10.setStock(50);
            p10.setCategoria("BEBIDAS");

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);
        listaProductos.add(p7);
        listaProductos.add(p8);
        listaProductos.add(p9);
        listaProductos.add(p10);



    }




}
