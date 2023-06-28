package com.mycompany.poo_06;

import java.util.ArrayList;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private boolean cuidados;
    private boolean necesidades;

    public Producto(int id, String nombre, double precio, boolean cuidados, boolean necesidades) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cuidados = cuidados;
        this.necesidades = necesidades;
    }

    // Getters y setters
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getCuidado() {
        return cuidados;
    }

    public void setCuidado(boolean cuidados) {
        this.cuidados = cuidados;
    }

    public boolean getNecesidad() {
        return necesidades;
    }

    public void setNecesidad(boolean necesidades) {
        this.necesidades = necesidades;
    }
}
