package ejercicio02;

import java.util.Scanner;

/**
 * APE 3 - Estructuras de Repetición en Java
 * Ejercicio 2: Control de edades con centinela
 * 
 * Descripción: Permite ingresar edades válidas de personas hasta ingresar el centinela -1.
 * Calcula y muestra el número de menores de edad, adultos, mayores de 65 años y el promedio de edad.
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables acumuladoras y contadoras
        int menores = 0;
        int adultos = 0;
        int mayores65 = 0;
        int sumaEdades = 0;
        int totalPersonas = 0;
        int edad = 0;

        System.out.println("==================================================");
        System.out.println("       SISTEMA DE CONTROL DE EDADES             ");
        System.out.println("==================================================");
        System.out.println("Instrucciones: Ingrese las edades una a una.");
        System.out.println("Para finalizar el ingreso, escriba el centinela: -1\n");

        // Estructura repetitiva while impulsada por centinela
        while (true) {
            System.out.print("Ingrese la edad (-1 para terminar): ");

            // Validar que la entrada sea un número entero
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();

                // Evaluar condición centinela de salida
                if (edad == -1) {
                    break;
                }

                // Validación de rango de edad lógico (0 a 120 años)
                if (edad < 0 || edad > 120) {
                    System.out.println("  [!] Error: Edad no válida. Debe estar entre 0 y 120 años.");
                    continue;
                }

                // Clasificación según rangos de edad
                if (edad < 18) {
                    menores++;
                } else if (edad <= 64) {
                    adultos++;
                } else {
                    mayores65++;
                }

                // Acumulación de suma y conteo global
                sumaEdades += edad;
                totalPersonas++;

            } else {
                System.out.println("  [!] Error: Entrada inválida. Ingrese únicamente números enteros.");
                scanner.next(); // Limpieza del búfer de lectura
            }
        }

        // Presentación de resultados y reporte final
        System.out.println("\n==================================================");
        System.out.println("              RESUMEN ESTADÍSTICO                 ");
        System.out.println("==================================================");

        if (totalPersonas > 0) {
            double promedio = (double) sumaEdades / totalPersonas;

            System.out.println(" Total de personas registradas : " + totalPersonas);
            System.out.println(" Menores de edad (< 18 años)    : " + menores);
            System.out.println(" Adultos (18 a 64 años)         : " + adultos);
            System.out.println(" Mayores de 65 años (>= 65)     : " + mayores65);
            System.out.printf(" Promedio general de edades     : %.2f años\n", promedio);
        } else {
            System.out.println(" No se registraron edades válidas para procesar.");
        }

        System.out.println("==================================================");

        scanner.close();
    }
}