/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CS-08
 */
public class main {
    public static void main(String[] args) throws ParseException {       
        Producto[] producto = cargarProductos();
        ArrayList<Venta> venta = cargarVenta(producto);
        actividades(venta);
    }
    
    public static Producto[] cargarProductos() {
        Producto[] productos = new Producto[20];      
        productos[0] = new Producto("Leche", 2.0, false, false);
        productos[1] = new Producto("Pan", 1.5, false, false);
        productos[2] = new Producto("Arroz", 3.0, false, false);
        productos[3] = new Producto("Azúcar", 2.5, false, false);
        productos[4] = new Producto("Aceite", 4.0, false, false);
        productos[5] = new Producto("Huevos", 2.5, true, false);
        productos[6] = new Producto("Queso", 3.5, true, false);
        productos[7] = new Producto("Pescado", 5.0, true, false);
        productos[8] = new Producto("Carne", 6.0, true, false);
        productos[9] = new Producto("Pollo", 4.5, true, false);
        productos[10] = new Producto("Papel higiénico", 1.0, false, true);
        productos[11] = new Producto("Detergente", 2.0, false, true);
        productos[12] = new Producto("Jabón de manos", 1.5, false, true);
        productos[13] = new Producto("Cepillo de dientes", 2.5, false, true);
        productos[14] = new Producto("Pasta dental", 3.0, false, true);
        productos[15] = new Producto("Medicamentos", 10.0, true, true);
        productos[16] = new Producto("Vacunas", 15.0, true, true);
        productos[17] = new Producto("Antiséptico", 5.0, true, true);
        productos[18] = new Producto("Vendas", 3.0, true, true);
        productos[19] = new Producto("Termómetro", 8.0, true, true);

        return productos;
    }

    private static ArrayList<Venta> cargarVenta(Producto[] producto) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de ventas:");
        int numVentas = scanner.nextInt();
        ArrayList<Venta> venta = new ArrayList<>();
        for (int i = 0; i < numVentas; i++) {
            System.out.println("Cuantos productos va a agregar a la venta");
            int num = scanner.nextInt();
            ArrayList<Producto> productos = new ArrayList<>();
            for (int j = 0; j < num; j++){
                Productos(producto);
                System.out.print("Ingrese el índice del producto que desea seleccionar: ");
                int ind = scanner.nextInt();
                if (ind >= 0 && ind < producto.length) {

                    Producto productoSeleccionado = producto[ind];
                    productos.set(j, productoSeleccionado);
                }          
            }
            System.out.println("En que fecha se realizo la venta:(dd/MM/yyyy)");
            String fechaStr = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = dateFormat.parse(fechaStr);
            venta.add(i, new Venta(i, fecha, productos));
        }
        return venta;
    }
    
    public static void Productos(Producto[] productos) {
        System.out.println("Productos cargados en el supermercado:");
        int i =0;
        for (Producto producto : productos) {
            i++;
            System.out.println("id de prducto: "+i );
            System.out.println("Nombre: " + producto.getNombre(i));
            System.out.println("Precio: " + producto.getPrecio(i));
            System.out.println(" precio cuidado: " + producto.getCuidado(i));
            System.out.println(" primera necesidad: " + producto.getNecesidad(i));
            System.out.println("+------------------------------------+");
        }
    }

    private static void actividades(ArrayList<Venta> ventas) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una actividad:");
        System.out.println("1. Calcular ventas");
        System.out.println("2. Cantidad de productos de primera necesidad");
        System.out.println("3. Cantidad de productos precios cuidados");
        System.out.println("4. Total de descuentos");
        System.out.print("Ingrese el número de la actividad que desea realizar: ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            double totalVentas = 0.0;
            for (Venta venta : ventas) {
                totalVentas += venta.calcularVentas();
            }
            System.out.println("El total de ventas es: " + totalVentas);
        } else if (opcion == 2) {
            int totalProductosNecesidad = 0;
            for (Venta venta : ventas) {
                totalProductosNecesidad += venta.CantProdNecesidad();
            }
            System.out.println("La cantidad de productos de primera necesidad es: " + totalProductosNecesidad);
            
        } else if (opcion == 3) {
            System.out.println("Ingrese la fecha para obtener la cantidad de productos precios cuidados (dd/MM/yyyy):");
            String fechaStr = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = dateFormat.parse(fechaStr);
            int totalProductosCuidados = Venta.CantProdPreCuidados(ventas, fecha);
            System.out.println("La cantidad de productos preicios cuidados en la fecha " + fechaStr + " es: " + totalProductosCuidados);
            
        } else if (opcion == 4) {
            System.out.println("Ingrese la fecha para obtener el total de descuentos (dd/MM/yyyy):");
            String fechaStr = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = dateFormat.parse(fechaStr);
            double totalDescuentos = Venta.TotalDescuentos(ventas, fecha);
            System.out.println("El total de descuentos en la fecha " + fechaStr + " es: " + totalDescuentos);
            
        } else {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }
}
