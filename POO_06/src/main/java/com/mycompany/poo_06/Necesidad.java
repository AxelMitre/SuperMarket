/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_06;


/**
 *
 * @author CS-08
 */
public class Necesidad extends Producto{
    public Necesidad(String nombre, double precio, boolean cuidado, boolean necesidad) {
        super(nombre, precio - (precio * (0.1)), cuidado, necesidad);
    }
    
    
}
