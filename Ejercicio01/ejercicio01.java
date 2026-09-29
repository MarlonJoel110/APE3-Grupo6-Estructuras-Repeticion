import java.util.Scanner;

public class PromedioCalificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables
        int N;
        double nota;
        double suma = 0;
        int aprobados = 0;
        int reprobados = 0;
        double notaMayor = -1;
        double notaMenor = 11;
        double promedio;

        // Lectura y validación de la cantidad de estudiantes
        do {
            System.out.print("Ingrese la cantidad de estudiantes (N > 0): ");
            N = scanner.nextInt();
            if (N <= 0) {
                System.out.println("Error: La cantidad de estudiantes debe ser mayor a 0.");
            }
        } while (N <= 0);

        // Bucle para registrar las notas de cada estudiante
        for (int i = 1; i <= N; i++) {
            System.out.print("Ingrese la calificacion del estudiante " + i + " (0 - 10): ");
            nota = scanner.nextDouble();

            // Validación de la nota en el rango [0, 10]
            while (nota < 0 || nota > 10) {
                System.out.print("Error: La nota debe estar entre 0 y 10. Intente de nuevo: ");
                nota = scanner.nextDouble();
            }

            // Acumulación
            suma += nota;

            // Conteo de aprobados y reprobados (nota mínima de aprobación = 7)
            if (nota >= 7) {
                aprobados++;
            } else {
                reprobados++;
            }

            // Determinación de la nota mayor y menor
            if (nota > notaMayor) {
                notaMayor = nota;
            }

            if (nota < notaMenor) {
                notaMenor = nota;
            }
        }

        // Cálculo del promedio general
        promedio = suma / N;

        // Mostrar resultados
        System.out.println("---------------------------------------");
        System.out.println("RESUMEN DE CALIFICACIONES");
        System.out.println("---------------------------------------");
        System.out.printf("Promedio general: %.2f\n", promedio);
        System.out.println("Calificacion mayor: " + notaMayor);
        System.out.println("Calificacion menor: " + notaMenor);
        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("Cantidad de reprobados: " + reprobados);

        scanner.close();
    }
}
