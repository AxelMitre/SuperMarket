/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_06;

/**
 *
 * @author CS08
 */
public class PrimeraNecesidad extends Producto{
    public PrimeraNecesidad(int id, String nombre, double precio, boolean cuidados, boolean necesidades) {
        super(id, nombre, precio-(precio*0.1), cuidados, necesidades);
    }
    
}
