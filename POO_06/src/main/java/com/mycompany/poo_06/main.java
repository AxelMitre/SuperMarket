package com.mycompany.poo_06;

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
    public static void main(String[] args){      
        ArrayList<Venta> venta = cargarVenta();
        actividades(venta);
    }
    
    private static ArrayList<Producto> cargarProductos(ArrayList<Producto> producto) {
        producto.add(new Producto(1,"Pan", 1.5, false, false));
        producto.add(new Producto(2,"Pan", 1.5, false, false));
        producto.add(new Producto(3,"Arroz", 3.0, false, false));
        producto.add(new Producto(4,"Azúcar", 2.5, false, false));
        producto.add(new Producto(5,"Aceite", 4.0, false, false));
        producto.add(new Producto(6,"Huevos", 2.5, true, false));
        producto.add(new Producto(7,"Queso", 3.5, true, false));
        producto.add(new Producto(8,"Pescado", 5.0, true, false));
        producto.add(new Producto(9,"Carne", 6.0, true, false));
        producto.add(new Producto(10,"Pollo", 4.5, true, false));
        producto.add(new Producto(11,"Papel higiénico", 1.0, false, true));
        producto.add(new Producto(12,"Detergente", 2.0, false, true));
        producto.add(new Producto(13,"Jabón de manos", 1.5, false, true));
        producto.add(new Producto(14,"Cepillo de dientes", 2.5, false, true));
        producto.add(new Producto(15,"Pasta dental", 3.0, false, true));
        producto.add(new Producto(16,"Medicamentos", 10.0, true, true));
        producto.add(new Producto(17,"Vacunas", 15.0, true, true));
        producto.add(new Producto(18,"Antiséptico", 5.0, true, true));
        producto.add(new Producto(19,"Vendas", 3.0, true, true));
        producto.add(new Producto(20,"Termómetro", 8.0, true, true));

        return producto;
    }



    private static ArrayList<Venta> cargarVenta(){
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de ventas:");
        int numVentas = scanner.nextInt();
        ArrayList<Venta> venta = new ArrayList<>();
        for (int i = 0; i < numVentas; i++) {
            System.out.println("Cuantos productos va a agregar a la venta");
            int num = scanner.nextInt();
            ArrayList<Producto> producto = new ArrayList<>();
            cargarProductos(producto);
            Productos(producto);
            
            for (int j = 0; j < num; j++){
                System.out.print("Ingrese el índice del producto que desea seleccionar: ");
                String nom = null;
                double precio = 0.0;
                boolean necesidad = false;
                boolean cuidado = false;
                int ind = scanner.nextInt();
                if (ind >= 0 && ind < productos.size()) {
                    Producto productoSeleccionado = productos.get(ind);
                    System.out.println("Producto seleccionado:");
                    System.out.println("Nombre: " + productoSeleccionado.getNombre());
                    nom = productoSeleccionado.getNombre();
                    System.out.println("Precio: " + productoSeleccionado.getPrecio());
                    precio = productoSeleccionado.getPrecio();
                    System.out.println("Es de primera necesidad: " + productoSeleccionado.getNecesidad());
                    necesidad = productoSeleccionado.getNecesidad();
                    System.out.println("Es de precio cuidado: " + productoSeleccionado.getCuidado());
                    cuidado = productoSeleccionado.getCuidado();
                }
                productos.add(new Producto(j,nom,precio,necesidad,cuidado));
            }
            System.out.println("En que fecha se realizo la venta:(dd/MM/yyyy)");
            String fecha = scanner.next();
            venta.add(i, new Venta(i, fecha, productos));
            System.out.println("Cantidad de ventas: " + venta.size());
        }
        return venta;
    }
    
    public static void Productos(ArrayList<Producto> productos) {
        System.out.println("Productos cargados en el supermercado:");
        int i =0;
        for (Producto producto : productos) {
            System.out.println("id de prducto: "+producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println(" precio cuidado: " + producto.getCuidado());
            System.out.println(" primera necesidad: " + producto.getNecesidad());
            System.out.println("+------------------------------------+");
        }
    }

    private static void actividades(ArrayList<Venta> ventas){
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
                System.out.println("La cantidad de productos de primera necesidad es: " + totalProductosNecesidad);
            }
            
        } else if (opcion == 3) {
            System.out.println("Ingrese la fecha para obtener la cantidad de productos precios cuidados (dd/MM/yyyy):");
            String fecha = scanner.next();
            int totalProductosCuidados = Venta.CantProdPreCuidados(ventas, fecha);
            System.out.println("La cantidad de productos preicios cuidados en la fecha " + fecha + " es: " + totalProductosCuidados);
            
        } else if (opcion == 4) {
            System.out.println("Ingrese la fecha para obtener el total de descuentos (dd/MM/yyyy):");
            String fecha = scanner.next();
            double totalDescuentos = Venta.TotalDescuentos(ventas, fecha);
            System.out.println("El total de descuentos en la fecha " + fecha + " es: " + totalDescuentos);
            
        } else{
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }
}
