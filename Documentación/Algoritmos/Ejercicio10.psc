Proceso SistemaIntegradoVentas
  Definir opcion, totalVentas, unidadesVendidas Como Entero
	Definir totalRecaudado, ventaMayor Como Real
	Definir producto Como Caracter
	Definir cantidad Como Entero
	Definir precio, montoVenta, promedio Como Real
	
	totalVentas <- 0
	unidadesVendidas <- 0
	totalRecaudado <- 0
	ventaMayor <- 0
	
	Repetir
		
		Escribir ""
		Escribir "=== SISTEMA INTEGRADO DE VENTAS ==="
		Escribir "1) Registrar venta"
		Escribir "2) Mostrar estadísticas"
		Escribir "3) Salir"
		Escribir "Seleccione una opción: "
		Leer opcion
		
		Segun opcion Hacer
			
			1:
				Escribir "Ingrese el nombre del producto: "
				Leer producto
				
				Escribir "Ingrese la cantidad: "
				Leer cantidad
				
				Mientras cantidad <= 0 Hacer
					Escribir "Error: La cantidad debe ser mayor a 0. Ingrese nuevamente: "
					Leer cantidad
				FinMientras
				
				Escribir "Ingrese el precio unitario: "
				Leer precio
				
				Mientras precio < 0 Hacer
					Escribir "Error: El precio no puede ser negativo. Ingrese nuevamente: "
					Leer precio
				FinMientras
				
				montoVenta <- cantidad * precio
				
				totalVentas <- totalVentas + 1
				unidadesVendidas <- unidadesVendidas + cantidad
				totalRecaudado <- totalRecaudado + montoVenta
				
				Si totalVentas = 1 O montoVenta > ventaMayor Entonces
					ventaMayor <- montoVenta
				FinSi
				
				Escribir "Venta registrada: ", producto, " x", cantidad
				Escribir "Monto: $", montoVenta
				
			2:
				Escribir ""
				Escribir "--- ESTADÍSTICAS GLOBALES ---"
				
				Si totalVentas > 0 Entonces
					promedio <- totalRecaudado / totalVentas
					
					Escribir "Número de ventas: ", totalVentas
					Escribir "Unidades vendidas: ", unidadesVendidas
					Escribir "Total recaudado: $", totalRecaudado
					Escribir "Venta mayor: $", ventaMayor
					Escribir "Promedio por venta: $", promedio
				SiNo
					Escribir "No se han registrado ventas todavía."
				FinSi
				
			3:
				Escribir "Saliendo del programa. ¡Hasta luego!"
				
			De Otro Modo:
				Escribir "Opción no válida. Intente nuevamente."
				
		FinSegun
		
	Hasta Que opcion = 3
	
FinProceso
