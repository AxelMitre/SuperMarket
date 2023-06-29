/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_06;

import java.util.Date;
import java.util.List;

public class Venta {
    private int idVenta;
    private String fechaVenta;
    private List<Producto> productos;

    public Venta(int idVenta, String fechaVenta, List<Producto> productos) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.productos = productos;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
    public double calcularVentas() {
        double precioVenta = 0.0;
        for (Producto producto : productos) {
            precioVenta+=producto.getPrecio();
        }
        return precioVenta;
    }
    

    
    public int CantProdNecesidad() {
        int cantidad = 0;
        for (Producto producto : productos) {
            if (producto.getNecesidad()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public static int CantProdPreCuidados(Venta[] ventas, String fecha) {
        int cantidad = 0;
        for (Venta venta : ventas) {
            if (venta.getFechaVenta().equals(fecha)) {
                List<Producto> productos = venta.getProductos();
                for (Producto producto : productos) {
                    if (producto.getCuidado()) {
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }

    public static double TotalDescuentos(Venta[] ventas, String dia) {
        double total = 0.0;
        for (Venta venta : ventas) {
            if (venta.getFechaVenta().equals(dia)) {
                List<Producto> productos = venta.getProductos();
                for (Producto producto : productos) {
                    if (producto.getNecesidad()) {
                        double descuento = producto.getPrecio() * 0.1;
                        total += descuento;
                    }
                }
            }
        }
        return total;
    }
}



