package ejer8;

import java.util.Scanner;

public class Ejer8 {

    /**
     * Diseña un programa Java que calcule la suma, resta, multiplicación y
     * división de dos números introducidos por teclado. Incorpora también las
     * funciones que permitan realizar la potencia de un número y la raíz
     * cuadrada del otro.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce x");
        int x = sc.nextInt();

        System.out.println("introduce y");
        int y = sc.nextInt();

        System.out.println("Suma: " + (x + y));
        System.out.println("Resta: " + (x - y));
        System.out.println("Multiplicacion: " + (x * y));
        
        if (y == 0) {
            System.out.println("No se puede dividir por cero");
        } else {
            System.out.println("Division: " + (double)(x / y));
        }

        System.out.println("Potencia: " + (Math.pow(x, 2)));
        System.out.println("Raiz cuadrada: " + (Math.sqrt(y)));

    }

}
