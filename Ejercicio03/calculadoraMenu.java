import java.util.Scanner;

public class calculadoraMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Calculadora ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el primer número: ");
                    double num1 = scan.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    double num2 = scan.nextDouble();
                    System.out.println("Resultado: " + (num1 + num2));
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("Ingrese el primer número: ");
                    num1 = scan.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scan.nextDouble();
                    System.out.println("Resultado: " + (num1 - num2));
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Ingrese el primer número: ");
                    num1 = scan.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scan.nextDouble();
                    System.out.println("Resultado: " + (num1 * num2));
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Ingrese el primer número: ");
                    num1 = scan.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scan.nextDouble();
                    while (num2==0){
                        System.out.print("Error: El divisor no puede ser cero. Ingrese otro número: ");
                        num2 = scan.nextDouble();
                    }
                    System.out.println("Resultado: " + (num1 / num2));
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Saliendo de la calculadora...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    System.out.println("");
            }
        } while (opcion != 5);


    }
}