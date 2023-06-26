/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_06;

import java.util.ArrayList;

/**
 *
 * @author CS-08
 */
public class Producto {

    private ArrayList<String> nombres;
    private ArrayList<Double> precios;
    private ArrayList<Boolean> cuidados;
    private ArrayList<Boolean> necesidads;

    public Producto() {
        nombres = new ArrayList<>();
        precios = new ArrayList<>();
        cuidados = new ArrayList<>();
        necesidads = new ArrayList<>();
    }

    public Producto(String nombre, double precio, boolean cuidado, boolean necesidad) {
        nombres.add(nombre);
        precios.add(precio);
        cuidados.add(cuidado);
        necesidads.add(necesidad);
    }

    
    public String getNombre(int indice) {
        return nombres.get(indice);
    }

    public double getPrecio(int indice) {
        return precios.get(indice);
    }

    public boolean getCuidado(int indice) {
        return cuidados.get(indice);
    }

    public boolean getNecesidad(int indice) {
        return necesidads.get(indice);
    }

}

