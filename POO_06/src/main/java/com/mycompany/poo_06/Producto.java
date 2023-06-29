package com.mycompany.poo_06;

import java.util.ArrayList;

public class Producto {
    private int id;
    private String nombres;
    private Double precios;
    private Boolean cuidados;
    private Boolean necesidades;
    
    
    public Producto(int id, String nombre, double precio, boolean cuidado, boolean necesidade) {
        this.id = id;
        this.nombres = nombre;
        this.precios = precio;
        this.cuidados = cuidado;
        this.necesidades = necesidade;
    }

    public int getId(){
        return id;
    }
    
    public String getNombre() {
        return nombres;
    }

    public double getPrecio() {
        return precios;
    }
    
    public Boolean getCuidado() {
        return cuidados;
    }

    public Boolean getNecesidad() {
        return necesidades;
    }
}
