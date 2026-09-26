# Ejercicio 08: Estacionamiento Universitario

## 1. Análisis del Problema

El objetivo principal de este programa es administrar el control de accesos y la recaudación económica de un parqueadero universitario mediante un **menú interactivo controlado por un valor centinela (`0`)**, aplicando tarifas por hora según la categoría del vehículo.

### Requerimientos Funcionales:

1. **Control de Flujo con Centinela:** El menú de selección se ejecuta indefinidamente hasta que el operador ingresa la opción `0`, la cual detiene el ingreso de datos y emite el resumen final de caja.

2. **Validación de Datos:**
   - **Tipo de vehículo:** Solo se aceptan valores enteros en el rango `[0, 3]`. Si se ingresa una opción no válida o un texto, se muestra un mensaje de error sin interrumplir el programa.
   - **Tiempo de permanencia:** Las horas registradas deben ser un valor numérico estrictamente mayor a `0` (`horas > 0`).

3. **Estructura Tarifaria por Categoria:**
   - **Auto (Opción 1):** `$1.50` por hora.
   - **Moto (Opción 2):** `$0.75` por hora.
   - **Autobús (Opción 3):** `$3.00` por hora.

4. **Cálculo de Indicadores y Métricas:**
   - Emisión de comprobante/ticket individual por vehículo.
   - Contadores independientes por cada tipo de vehículo (`totalAutos`, `totalMotos`, `totalBuses`).
   - Conteo total de vehículos procesados.
   - Acumulador general de recaudación total en caja (`recaudacionTotal`).
   - Identificación del **cobro máximo registrado** (`mayorCobro`) y la categoría a la que perteneció (`tipoMayorCobro`).

---

## 2. Entradas, Procesos y Salidas

| Fase | Elemento / Variable | Tipo de Dato | Descripción |
| ----- | ----- | ----- | ----- |
| **Entrada** | `tipoVehiculo` | Entero (`int`) | Opción del menú (`1`=Auto, `2`=Moto, `3`=Bus, `0`=Centinela Salir). |
| | `horas` | Real (`double`) | Cantidad de horas estacionadas (debe ser `> 0`). |
| **Proceso** | `validaOpcion` | Booleano | Evalúa si `tipoVehiculo >= 0 Y tipoVehiculo <= 3`. |
| | `validaHoras` | Booleano | Evalúa si `horas > 0`. |
| | `tarifaActual` | Real (`double`) | Asigna tarifa fija según tipo: Auto (`1.50`), Moto (`0.75`), Bus (`3.00`). |
| | `cobroIndividual` | Real (`double`) | `horas * tarifaActual`. |
| | `totalAutos` | Entero (`int`) | Contador de autos registrados. |
| | `totalMotos` | Entero (`int`) | Contador de motos registradas. |
| | `totalBuses` | Entero (`int`) | Contador de autobuses registrados. |
| | `totalVehiculos` | Entero (`int`) | Suma acumulada de todos los vehículos procesados. |
| | `recaudacionTotal` | Real (`double`) | Acumulador general de ingresos (`recaudacionTotal + cobroIndividual`). |
| | `mayorCobro` | Real (`double`) | Mantiene el valor máximo cobrado en una sola transacción. |
| | `tipoMayorCobro` | Texto (`String`) | Guarda el nombre de la categoría con el mayor cobro. |
| **Salida** | Ticket Individual | Texto / Moneda | Detalle de cobro por vehículo registrado. |
| | Reporte de Caja | Reporte Final | Recaudación total, cantidad por tipo y mayor cobro. |

---

## 3. Algoritmo en Pseudocódigo (PSeInt / Estándar)

```text
Algoritmo EstacionamientoUniversitario
    Definir tipoVehiculo, totalAutos, totalMotos, totalBuses, totalVehiculos Como Entero
    Definir horas, tarifaActual, cobroIndividual, recaudacionTotal, mayorCobro Como Real
    Definir tipoMayorCobro, nombreTipo Como Cadena
    
    totalAutos <- 0
    totalMotos <- 0
    totalBuses <- 0
    totalVehiculos <- 0
    recaudacionTotal <- 0.0
    mayorCobro <- 0.0
    tipoMayorCobro <- "N/A"
    tipoVehiculo <- -1
    
    Escribir "=================================================="
    Escribir "     ESTACIONAMIENTO UNIVERSITARIO - UTA          "
    Escribir "=================================================="
    
    Mientras tipoVehiculo <> 0 Hacer
        Escribir "Seleccione Tipo de Vehiculo (1:Auto, 2:Moto, 3:Bus, 0:Salir):"
        Leer tipoVehiculo
        
        Si tipoVehiculo = 0 Entonces
            Escribir "Finalizando jornada de registro..."
        Sino
            Si tipoVehiculo >= 1 Y tipoVehiculo <= 3 Entonces
                Repetir
                    Escribir "Ingrese numero de horas estacionado (> 0):"
                    Leer horas
                    Si horas <= 0 Entonces
                        Escribir "[!] Error: Las horas deben ser mayores a 0."
                    FinSi
                Hasta Que horas > 0
                
                Segun tipoVehiculo Hacer
                    Caso 1:
                        tarifaActual <- 1.50
                        nombreTipo <- "Auto"
                        totalAutos <- totalAutos + 1
                    Caso 2:
                        tarifaActual <- 0.75
                        nombreTipo <- "Moto"
                        totalMotos <- totalMotos + 1
                    Caso 3:
                        tarifaActual <- 3.00
                        nombreTipo <- "Autobus"
                        totalBuses <- totalBuses + 1
                FinSegun
                
                cobroIndividual <- horas * tarifaActual
                recaudacionTotal <- recaudacionTotal + cobroIndividual
                totalVehiculos <- totalVehiculos + 1
                
                Si cobroIndividual > mayorCobro Entonces
                    mayorCobro <- cobroIndividual
                    tipoMayorCobro <- nombreTipo
                FinSi
                
                Escribir "--------------------------------------------------"
                Escribir "Ticket: ", nombreTipo, " | Horas: ", horas, " | Tarifa: $", tarifaActual
                Escribir "Total a pagar: $", cobroIndividual
                Escribir "--------------------------------------------------"
            Sino
                Escribir "[!] Error: Tipo de vehiculo invalido. Elija 1, 2, 3 o 0."
            FinSi
        FinSi
    FinMientras
    
    // Reporte Final de Cierre
    Escribir "=================================================="
    Escribir "         REPORTE FINAL DE RECAUDACION             "
    Escribir "=================================================="
    Escribir "Total Vehiculos Registrados : ", totalVehiculos
    Escribir "  - Autos                   : ", totalAutos
    Escribir "  - Motos                   : ", totalMotos
    Escribir "  - Autobuses               : ", totalBuses
    Escribir "--------------------------------------------------"
    Escribir "Recaudacion Total en Caja   : $", recaudacionTotal
    
    Si totalVehiculos > 0 Entonces
        Escribir "Mayor Cobro Registrado      : $", mayorCobro, " (", tipoMayorCobro, ")"
    Sino
        Escribir "No se registraron cobros durante la sesion."
    FinSi
    Escribir "=================================================="
FinAlgoritmo
```

---

## 4. Diagrama de Flujo (Representación Mermaid)

```mermaid
graph TD
    A([Inicio]) --> B[Inicializar: totalAutos=0, totalMotos=0, totalBuses=0,<br>totalVehiculos=0, recaudacionTotal=0.0, mayorCobro=0.0]
    B --> C[/Leer tipoVehiculo/]
    C --> D{¿tipoVehiculo == 0?}
    D -- Sí --> M{¿totalVehiculos > 0?}
    D -- No --> E{¿1 <= tipoVehiculo <= 3?}
    E -- No --> F[/Mostrar Error: Opción Inválida/] --> C
    E -- Sí --> G[/Leer horas/]
    G --> H{¿horas > 0?}
    H -- No --> I[/Mostrar Error: Horas deben ser > 0/] --> G
    H -- Sí --> J[Determinar tarifa por tipo:<br>Auto=$1.50 | Moto=$0.75 | Bus=$3.00]
    J --> K[cobroIndividual = horas * tarifa<br>recaudacionTotal += cobroIndividual<br>Incrementar contadores por tipo]
    K --> L{¿cobroIndividual > mayorCobro?}
    L -- Sí --> N[mayorCobro = cobroIndividual<br>tipoMayorCobro = nombreTipo] --> O[/Mostrar Ticket Emitido/] --> C
    L -- No --> O
    M -- Sí --> P[/Mostrar Reporte Final de Recaudación y Mayor Cobro/] --> Q([Fin])
    M -- No --> R[/Mostrar: No se registraron cobros en la sesión/] --> Q
```

---

## 5. Prueba de Escritorio

### Tabla de Traza

| Paso | `tipoVehiculo` | `horas` | Validaciones | `totalAutos` | `totalMotos` | `totalBuses` | `totalVehiculos` | `cobroIndividual` | `recaudacionTotal` | `mayorCobro` | Salida / Acción en Consola |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **1** | - | - | - | 0 | 0 | 0 | 0 | $0.00 | $0.00 | $0.00 | Inicialización de variables. |
| **2** | `1` (Auto) | `2.0` | Válidos | **1** | 0 | 0 | **1** | `$3.00` | **$3.00** | **$3.00** | Ticket Auto emitido ($3.00). Récord inicial. |
| **3** | `2` (Moto) | `4.0` | Válidos | 1 | **1** | 0 | **2** | `$3.00` | **$6.00** | $3.00 | Ticket Moto emitido ($3.00). |
| **4** | `3` (Bus) | `3.0` | Válidos | 1 | 1 | **1** | **3** | `$9.00` | **$15.00** | **$9.00** | Ticket Autobús emitido ($9.00). **Nuevo mayor cobro**. |
| **5** | `5` | - | Tipo Inválido | 1 | 1 | 1 | 3 | - | $15.00 | $9.00 | Muestra: `[!] Error: Tipo de vehículo inválido.` |
| **6** | `1` (Auto) | `-1` | Horas Inválidas | 1 | 1 | 1 | 3 | - | $15.00 | $9.00 | Muestra: `[!] Error: Horas deben ser mayores a 0.` Repite lectura horas. |
| **7** | `0` | - | **Centinela** | 1 | 1 | 1 | 3 | - | $15.00 | $9.00 | Activa **centinela**, rompe el ciclo. |
| **8** | - | - | Reporte | 1 | 1 | 1 | 3 | - | $15.00 | $9.00 | Emite Reporte Final: 3 vehículos, Total: `$15.00`, Mayor: `$9.00 (Autobús)`. |

---

## 6. Código Fuente Implementado (Java)

```java
package ejercicio08;

import java.util.Scanner;

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
                System.out.println("  [!] Error: Ingrese una opción numérica válida (0 - 3).");
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
```

---

## 7. Evidencia de Ejecución en Consola

```text
==================================================
     ESTACIONAMIENTO UNIVERSITARIO - UTA          
==================================================
Tarifas aplicables por hora:
 1. Auto     : $1.50 / hora
 2. Moto     : $0.75 / hora
 3. Autobús  : $3.00 / hora
 0. Salir (Centinela)


Seleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): 1
Ingrese número de horas estacionado: 2
--------------------------------------------------
 Ticket Emitido: Auto | Horas: 2.00 | Tarifa: $1.50/h
 Total a pagar : $3.00
--------------------------------------------------

Seleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): 2
Ingrese número de horas estacionado: 4
--------------------------------------------------
 Ticket Emitido: Moto | Horas: 4.00 | Tarifa: $0.75/h
 Total a pagar : $3.00
--------------------------------------------------

Seleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): 3
Ingrese número de horas estacionado: 3
--------------------------------------------------
 Ticket Emitido: Autobús | Horas: 3.00 | Tarifa: $3.00/h
 Total a pagar : $9.00
--------------------------------------------------

Seleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): 5
  [!] Error: Tipo de vehículo inválido. Elija entre 1, 2, 3 o 0.

Seleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): 1
Ingrese número de horas estacionado: -1
  [!] Error: Las horas deben ser mayores a 0.
Ingrese número de horas estacionado: 1
--------------------------------------------------
 Ticket Emitido: Auto | Horas: 1.00 | Tarifa: $1.50/h
 Total a pagar : $1.50
--------------------------------------------------

Seleccione Tipo de Vehículo (1: Auto, 2: Moto, 3: Bus, 0: Salir): 0

Finalizando jornada de registro...

==================================================
         REPORTE FINAL DE RECAUDACIÓN             
==================================================
 Total Vehículos Registrados : 4
   - Autos                   : 2
   - Motos                   : 1
   - Autobuses               : 1
--------------------------------------------------
 Recaudación Total en Caja   : $16.50
 Mayor Cobro Registrado      : $9.00 (Autobús)
==================================================
```