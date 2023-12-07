package com.mycompany.prog04_01;

import java.util.Scanner;

public class PROG04_01 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        // Validamos que el numero sea positivo
        int num = 0;
        do {
            System.out.println("Introduce un numero");
            num = sn.nextInt();

            if (num < 0) {
                System.out.println("Debes introducir un numero positivo");
            }

        } while (num < 0);

        // Mostramos el resultado
        // Puedes usar factorial o factorialRec
        System.out.println("El factorial es: " + factorial(num));
        
    }

    public static int factorial(int n) {

        // Empezamos en n
        int factorial = n;
        // Recorremos de n-1 a 1 (sin contar el 1)
        for (int i = n - 1; i > 1; i--) {
            // multiplicamos
            factorial *= i;
        }
        // devolvemos el valor
        return factorial;
    }

    public static int factorialRec(int n) {
        // Si n es 1, terminamos la recursion
        if (n == 1) {
            return 1;
        } else {
            // Sino, continuamos  la recursion
            return n * factorial(n - 1);
        }
    }

}
