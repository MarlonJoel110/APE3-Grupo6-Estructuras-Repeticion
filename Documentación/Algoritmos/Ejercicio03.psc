Algoritmo CalculadoraMenu
    Definir opcion Como Entero
    Definir num1, num2 Como Real
	
    Mientras opcion <> 5 Hacer
        Escribir "=== Calculadora ==="
        Escribir "1. Sumar"
        Escribir "2. Restar"
        Escribir "3. Multiplicar"
        Escribir "4. Dividir"
        Escribir "5. Salir"
        Escribir "Ingrese una opción: "
        Leer opcion
        
        Segun opcion Hacer
            1:
                Escribir "Ingrese el primer número:"
                Leer num1
                Escribir "Ingrese el segundo número:"
                Leer num2
                Escribir "Resultado: ", (num1 + num2)
                Escribir ""
            2:
                Escribir "Ingrese el primer número:"
                Leer num1
                Escribir "Ingrese el segundo número:"
                Leer num2
                Escribir "Resultado: ", (num1 - num2)
                Escribir ""
            3:
                Escribir "Ingrese el primer número:"
                Leer num1
                Escribir "Ingrese el segundo número:"
                Leer num2
                Escribir "Resultado: ", (num1 * num2)
                Escribir ""
            4:
                Escribir "Ingrese el primer número:"
                Leer num1
                Escribir "Ingrese el segundo número:"
                Leer num2
                
                Mientras num2 == 0 Hacer
                    Escribir "Error: El divisor no puede ser cero. Ingrese otro número:"
                    Leer num2
                FinMientras
                Escribir "Resultado: ", (num1 / num2)
                Escribir ""
            5:
                Escribir "Saliendo de la calculadora..."
            De Otro Modo:
                Escribir "Opción inválida. Por favor, intente nuevamente."
                Escribir ""
        FinSegun
        
    Fin Mientras
    
FinAlgoritmo
