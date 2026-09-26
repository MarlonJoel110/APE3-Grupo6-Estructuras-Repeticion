package ejercicio08;

import java.util.Scanner;

/**
 * APE 3 - Estructuras de Repetición en Java
 * Ejercicio 8: Estacionamiento universitario
 * 
 * Descripción: Controla el ingreso de vehículos al parqueadero universitario según su tipo
 * y horas de estancia. Calcula cobro individual, acumulador total de caja y reporte por tipo.
 * Centinela de salida: Opción 0 en el menú de tipo de vehículo.
 */
public class Ejercicio08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constantes de tarifa por hora
        final double TARIFA_AUTO = 1.50;
        final double TARIFA_MOTO = 0.75;
        final double TARIFA_BUS = 3.00;

        // Variables de contadores y acumuladores
        int totalAutos = 0;
        int totalMotos = 0;
        int totalBuses = 0;
        int totalVehiculos = 0;

        double recaudacionTotal = 0.0;
        double mayorCobro = 0.0;
        String tipoMayorCobro = "N/A";

        int tipoVehiculo = -1;

        System.out.println("==================================================");
        System.out.println("     ESTACIONAMIENTO UNIVERSITARIO - UTA          ");
        System.out.println("==================================================");
        System.out.println("Tarifas aplicables por hora:");
        System.out.println(" 1. Auto     : $1.50 / hora");
        System.out.println(" 2. Moto     : $0.75 / hora");
        System.out.println(" 3. Autobús  : $3.00 / hora");
        System.out.println(" 0. Salir (Centinela)\n");

        // Ciclo principal controlado por centinela
        while (tipoVehiculo != 0) {
            System.out.print("\nSeleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): ");

            if (!scanner.hasNextInt()) {
                System.out.println("  [!] Error: Ingrese un opción numérica válida (0 - 3).");
                scanner.next();
                continue;
            }

            tipoVehiculo = scanner.nextInt();

            // Condición centinela para finalizar
            if (tipoVehiculo == 0) {
                System.out.println("\nFinalizando jornada de registro...");
                break;
            }

            // Validación de menú de opciones
            if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                System.out.println("  [!] Error: Tipo de vehículo inválido. Elija entre 1, 2, 3 o 0.");
                continue;
            }

            // Lectura y validación de horas de parqueo
            double horas = 0;
            boolean horasValidas = false;

            while (!horasValidas) {
                System.out.print("Ingrese número de horas estacionado: ");
                if (scanner.hasNextDouble()) {
                    horas = scanner.nextDouble();
                    if (horas > 0) {
                        horasValidas = true;
                    } else {
                        System.out.println("  [!] Error: Las horas deben ser mayores a 0.");
                    }
                } else {
                    System.out.println("  [!] Error: Ingrese un valor numérico válido para las horas.");
                    scanner.next();
                }
            }

            // Asignación de tarifa y acumuladores por tipo
            double tarifaActual = 0.0;
            String nombreTipo = "";

            switch (tipoVehiculo) {
                case 1:
                    tarifaActual = TARIFA_AUTO;
                    nombreTipo = "Auto";
                    totalAutos++;
                    break;
                case 2:
                    tarifaActual = TARIFA_MOTO;
                    nombreTipo = "Moto";
                    totalMotos++;
                    break;
                case 3:
                    tarifaActual = TARIFA_BUS;
                    nombreTipo = "Autobús";
                    totalBuses++;
                    break;
            }

            // Cálculo de cobro individual
            double cobroIndividual = horas * tarifaActual;
            recaudacionTotal += cobroIndividual;
            totalVehiculos++;

            System.out.println("--------------------------------------------------");
            System.out.printf(" Ticket Emitido: %s | Horas: %.2f | Tarifa: $%.2f/h\n", nombreTipo, horas, tarifaActual);
            System.out.printf(" Total a pagar : $%.2f\n", cobroIndividual);
            System.out.println("--------------------------------------------------");

            // Evaluación del mayor cobro del turno
            if (cobroIndividual > mayorCobro) {
                mayorCobro = cobroIndividual;
                tipoMayorCobro = nombreTipo;
            }
        }

        // Reporte consolidado
        System.out.println("\n==================================================");
        System.out.println("         REPORTE FINAL DE RECAUDACIÓN             ");
        System.out.println("==================================================");
        System.out.println(" Total Vehículos Registrados : " + totalVehiculos);
        System.out.println("   - Autos                   : " + totalAutos);
        System.out.println("   - Motos                   : " + totalMotos);
        System.out.println("   - Autobuses               : " + totalBuses);
        System.out.println("--------------------------------------------------");
        System.out.printf(" Recaudación Total en Caja   : $%.2f\n", recaudacionTotal);
        if (totalVehiculos > 0) {
            System.out.printf(" Mayor Cobro Registrado      : $%.2f (%s)\n", mayorCobro, tipoMayorCobro);
        } else {
            System.out.println(" No se registraron cobros durante la sesión.");
        }
        System.out.println("==================================================");

        scanner.close();
    }
}