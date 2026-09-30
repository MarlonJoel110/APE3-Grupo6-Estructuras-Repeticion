Algoritmo PromedioCalificaciones
    // Declaracion de variables
    Definir N, i, aprobados, reprobados Como Entero
    Definir nota, suma, nota_mayor, nota_menor, promedio Como Real
    
    // Inicializacion de acumuladores y contadores
    suma <- 0
    aprobados <- 0
    reprobados <- 0
    nota_mayor <- -1
    nota_menor <- 11
    
    // Lectura y validacion de la cantidad de estudiantes
    Repetir
        Escribir "Ingrese la cantidad de estudiantes (N > 0): "
        Leer N
        Si N <= 0 Entonces
            Escribir "Error: La cantidad de estudiantes debe ser mayor a 0."
        FinSi
    Hasta Que N > 0
    
    // Bucle para registrar las notas de cada estudiante
    Para i <- 1 Hasta N Con Paso 1 Hacer
        Escribir "Ingrese la calificacion del estudiante ", i, " (0 - 10): "
        Leer nota
        
        // Validacion de la nota en el rango [0, 10]
        Mientras nota < 0 O nota > 10 Hacer
            Escribir "Error: La nota debe estar entre 0 y 10. Intente de nuevo: "
            Leer nota
        FinMientras
        
        // Acumulacion
        suma <- suma + nota
        
        // Conteo de aprobados y reprobados (considerando minima de aprobacion = 7)
        Si nota >= 7 Entonces
            aprobados <- aprobados + 1
        Sino
            reprobados <- reprobados + 1
        FinSi
        
        // Determinacion de la nota mayor y menor
        Si nota > nota_mayor Entonces
            nota_mayor <- nota
        FinSi
        
        Si nota < nota_menor Entonces
            nota_menor <- nota
        FinSi
    FinPara
    
    // Calculo del promedio general
    promedio <- suma / N
    
    // Mostrar resultados
    Escribir "---------------------------------------"
    Escribir "RESUMEN DE CALIFICACIONES"
    Escribir "---------------------------------------"
    Escribir "Promedio general: ", promedio
    Escribir "Calificacion mayor: ", nota_mayor
    Escribir "Calificacion menor: ", nota_menor
    Escribir "Cantidad de aprobados: ", aprobados
    Escribir "Cantidad de reprobados: ", reprobados
FinAlgoritmo
