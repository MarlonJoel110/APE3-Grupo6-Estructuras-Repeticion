import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero;
        int resultado;

        System.out.print("Ingrese un número entre 1 y 12: ");
        numero = sc.nextInt();

        while (numero < 1 || numero > 12) {
            System.out.print("Número incorrecto. Ingrese un número entre 1 y 12: ");
            numero = sc.nextInt();
        }

        System.out.println("\nTabla de multiplicar del " + numero);

        for (int i = 1; i <= 12; i++) {
            resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        sc.close();
    }
}
