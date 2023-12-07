package com.mycompany.prog04_08;

import java.util.Scanner;

public class PROG04_08 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        int n = 0;
        do {

            // Validamos que el valor de n esta entre 0 y 20
            try {
                System.out.println("Introduce el valor de n (entre 0 y 20)");
                n = sn.nextInt();

                if (!(n >= 0 && n <= 20)) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("El valor debe estar entre 0 y 20");
            }

        } while (!(n >= 0 && n <= 20));

        // Recorremos de 1 a 20
        for (int i = 1; i <= n; i++) {

            //Mostramos el valor de cada uno, el numero de veces indicada
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
            System.out.println("");

        }

    }
}
