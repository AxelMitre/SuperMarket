package com.mycompany.poo_06;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juana
 */
public class Supermercado {
    private List<Venta> ventas;

    public Supermercado() {
        ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }
}
