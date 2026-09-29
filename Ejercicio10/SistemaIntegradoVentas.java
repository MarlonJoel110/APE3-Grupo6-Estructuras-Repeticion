import java.util.Scanner;

public class SistemaIntegradoVentas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int opcion = 0;
        int totalVentas = 0;
        int unidadesVendidas = 0;
        double totalRecaudado = 0.0;
        double ventaMayor = 0.0;
        
        do {
            System.out.println("\n=== SISTEMA INTEGRADO DE VENTAS ===");
            System.out.println("1) Registrar venta");
            System.out.println("2) Mostrar estadísticas");
            System.out.println("3) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1:
                    teclado.nextLine();
                    System.out.print("Ingrese el nombre del producto: ");
                    String producto = teclado.nextLine();
                    
                    int cantidad = 0;
                    System.out.print("Ingrese la cantidad: ");
                    cantidad = teclado.nextInt();
                    while (cantidad <= 0) {
                        System.out.print("Error: La cantidad debe ser mayor a 0. Ingrese nuevamente: ");
                        cantidad = teclado.nextInt();
                    }
                    
                    double precio = 0.0;
                    System.out.print("Ingrese el precio unitario: ");
                    precio = teclado.nextDouble();
                    while (precio < 0) {
                        System.out.print("Error: El precio no puede ser negativo. Ingrese nuevamente: ");
                        precio = teclado.nextDouble();
                    }
                    
                    double montoVenta = cantidad * precio;
                    
                    totalVentas++;
                    unidadesVendidas += cantidad;
                    totalRecaudado += montoVenta;
                    
                    if (totalVentas == 1 || montoVenta > ventaMayor) {
                        ventaMayor = montoVenta;
                    }
                    
                    System.out.printf("Venta registrada: %s x%d. Monto: $%.2f%n", producto, cantidad, montoVenta);
                    break;
                    
                case 2:
                    System.out.println("\n--- ESTADÍSTICAS GLOBALES ---");
                    if (totalVentas > 0) {
                        double promedio = totalRecaudado / totalVentas;
                        
                        System.out.println("Número de ventas: " + totalVentas);
                        System.out.println("Unidades vendidas: " + unidadesVendidas);
                        System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);
                        System.out.printf("Venta mayor: $%.2f%n", ventaMayor);
                        System.out.printf("Promedio por venta: $%.2f%n", promedio);
                    } else {
                        System.out.println("No se han registrado ventas todavía.");
                    }
                    break;
                    
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
            
        } while (opcion != 3);
        
    }
}

