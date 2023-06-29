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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es el nombre del super mercado:");
        String nombre = scanner.next();
        Producto[] producto = new Producto[20];
        producto = cargarProductos();
        PrimeraNecesidad[] primeraNecesidad = new PrimeraNecesidad[10];
        primeraNecesidad = cargarProductosPrimeraNecesidad(); 
        Venta[] venta = cargarVenta(producto,primeraNecesidad);
        SuperMercado superMercado = new SuperMercado(nombre, venta);
        
        actividades(venta);
    }
    
    private static Producto[] cargarProductos() {
        Producto[] producto = new Producto[20];
        producto[0] = new Producto(1,"Pan", 1.5, false, false);
        producto[1] = new Producto(2,"Pan", 1.5, false, false);
        producto[2] = new Producto(3,"Arroz", 3.0, false, false);
        producto[3] = new Producto(4,"Azúcar", 2.5, false, false);
        producto[4] = new Producto(5,"Aceite", 4.0, false, false);
        producto[5] = new Producto(6,"Huevos", 2.5, true, false);
        producto[6] = new Producto(7,"Queso", 3.5, true, false);
        producto[7] = new Producto(8,"Pescado", 5.0, true, false);
        producto[8] = new Producto(9,"Carne", 6.0, true, false);
        producto[9] = new Producto(10,"Pollo", 4.5, true, false);
        producto[10] = new Producto(11,"Papel higiénico", 1.0, false, true);
        producto[11] = new Producto(12,"Detergente", 2.0, false, true);
        producto[12] = new Producto(13,"Jabón de manos", 1.5, false, true);
        producto[13] = new Producto(14,"Cepillo de dientes", 2.5, false, true);
        producto[14] = new Producto(15,"Pasta dental", 3.0, false, true);
        producto[15] = new Producto(16,"Medicamentos", 10.0, true, true);
        producto[16] = new Producto(17,"Vacunas", 15.0, true, true);
        producto[17] = new Producto(18,"Antiséptico", 5.0, true, true);
        producto[18] = new Producto(19,"Vendas", 3.0, true, true);
        producto[19] = new Producto(20,"Termómetro", 8.0, true, true);


        return producto;
    }
    
    private static PrimeraNecesidad[] cargarProductosPrimeraNecesidad(){
        PrimeraNecesidad[] primeraNecesidad = new PrimeraNecesidad[10];
        primeraNecesidad[0] = new PrimeraNecesidad(1,"Papel higiénico", 1.0, false, true);
        primeraNecesidad[1] = new PrimeraNecesidad(2,"Detergente", 2.0, false, true);
        primeraNecesidad[2] = new PrimeraNecesidad(3,"Jabón de manos", 1.5, false, true);
        primeraNecesidad[3] = new PrimeraNecesidad(4,"Cepillo de dientes", 2.5, false, true);
        primeraNecesidad[4] = new PrimeraNecesidad(5,"Pasta dental", 3.0, false, true);
        primeraNecesidad[5] = new PrimeraNecesidad(6,"Medicamentos", 10.0, true, true);
        primeraNecesidad[6] = new PrimeraNecesidad(7,"Vacunas", 15.0, true, true);
        primeraNecesidad[7] = new PrimeraNecesidad(8,"Antiséptico", 5.0, true, true);
        primeraNecesidad[8] = new PrimeraNecesidad(9,"Vendas", 3.0, true, true);
        primeraNecesidad[9] = new PrimeraNecesidad(10,"Termómetro", 8.0, true, true);     
                
        return primeraNecesidad; 
    }
    


 
    private static Venta[] cargarVenta(Producto[] producto, PrimeraNecesidad[] primeraNecesidad){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de ventas:");
        int numVentas = scanner.nextInt();
        Venta[] venta = new Venta[numVentas];
        for (int i = 0; i < numVentas; i++) {
            System.out.println("Cuantos productos va a agregar a la venta");
            int num = scanner.nextInt();  
            ArrayList<Producto> productos = new ArrayList<>();
            Productos(producto);
            for (int j = 0; j < num; j++){
                System.out.print("Ingrese el índice del producto que desea seleccionar: ");
                int ind = scanner.nextInt();
                for (Producto prod : producto) {
                    if (prod.getId() == ind) {
                        System.out.println("Producto seleccionado:");
                        System.out.println("ID: "+prod.getId());
                        int Id = prod.getId();
                        System.out.println("Nombre: " + prod.getNombre());
                        String nom = prod.getNombre();
                        System.out.println("Precio: " + prod.getPrecio());
                        double precio = prod.getPrecio();
                        System.out.println("Es de primera necesidad: " + prod.getNecesidad());
                        boolean necesidad = prod.getNecesidad();
                        System.out.println("Es de precio cuidado: " + prod.getCuidado());
                        boolean cuidado = prod.getCuidado();
                        productos.add(new Producto(Id, nom,precio,cuidado,necesidad));
                    }
                }
            }  
            System.out.println("En que fecha se realizo la venta:(dd/MM/yyyy)");
            String fecha = scanner.next();
            venta[i] = new Venta(i, fecha, productos);
        }
        return venta;
    }
    
    

    private static void actividades(Venta[] ventas){
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

    private static void Productos(Producto[] producto) {
        System.out.println("Lista de ingredientes:");
        for (Producto productos : producto) {
            System.out.println("id: "+productos.getId());
            System.out.println("nombre"+productos.getNombre());
            System.out.println("precio"+productos.getPrecio());
            System.out.println("PrecioCuidado"+productos.getCuidado());
            System.out.println("PrimeraNecesidad"+productos.getNecesidad());
            System.out.println("+-------------------------------------");
        }
    }
}
