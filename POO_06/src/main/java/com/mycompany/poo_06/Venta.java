/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_06;

import com.mycompany.poo_06.Producto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CS-08
 */
public class Venta {
    private int idVenta;
    private Date fechaVenta;
    private List<Producto> productos;

    public Venta(int idVenta, Date fechaVenta, List<Producto> productos) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.productos = productos;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public List<Producto> getProductos() {
        return productos;
    }   
    public double calcularVentas() {
    double precioVenta = 0.0;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            precioVenta += producto.getPrecio(i);
        }
        return precioVenta;
    }
    
    public int CantProdNecesidad() {
        int cantidad = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getNecesidad(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    
    public static int CantProdPreCuidados(List<Venta> ventas, Date fecha) {
        int cantidad = 0;
        for (Venta venta : ventas) {
            if (venta.getFechaVenta().equals(fecha)) {
                List<Producto> productos = venta.getProductos();
                for (Producto producto : productos) {
                    if (producto.getCuidado(0)) { 
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }


    
    public static double TotalDescuentos(List<Venta> ventas, Date dia) {
        double total = 0.0;
        for (Venta venta : ventas) {
            if (venta.getFechaVenta().equals(dia)) {
                List<Producto> productos = venta.getProductos();
                for (Producto producto : productos) {
                    if (producto.getNecesidad(0)) { // Suponiendo que deseas acceder al primer producto de la lista
                        double descuento = producto.getPrecio(0) * 0.1; // Suponiendo que deseas acceder al precio del primer producto
                        total += descuento;
                    }
                }
            }
        }
        return total;
    }
}



