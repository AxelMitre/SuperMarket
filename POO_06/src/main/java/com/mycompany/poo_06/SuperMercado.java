/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_06;

import java.util.ArrayList;

/**
 *
 * @author CS08
 */
public class SuperMercado {
    private String nombre;
    private Venta[] ventas;
    
    public SuperMercado(String nombre, Venta[] ventas){
        this.nombre = nombre;
        this.ventas = ventas;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public Venta[] getVenta(int ind){
        return this.ventas;
    }

}
