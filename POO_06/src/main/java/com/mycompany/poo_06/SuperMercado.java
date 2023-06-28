package com.mycompany.poo_06;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juana
 */
public class SuperMercado {
    private List<Venta> ventas;

    public SuperMercado() {
        ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }
}
