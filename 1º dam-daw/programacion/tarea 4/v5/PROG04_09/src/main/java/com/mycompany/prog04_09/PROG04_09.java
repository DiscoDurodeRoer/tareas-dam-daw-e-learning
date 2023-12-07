package com.mycompany.prog04_09;

import java.util.Scanner;

public class PROG04_09 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        // Pedimos la cantidad y validamos que sea multiplo de 5
        int cantidad;
        do {
            System.out.println("Introduce la cantidad multiplo de 5");
            cantidad = sn.nextInt();

            if (cantidad % 5 != 0) {
                System.out.println("Debe ser multiplo de 5");
            }

        } while (cantidad % 5 != 0);

        // Array de billetes
        int[] billetes = {500, 200, 100, 50, 20, 10, 5};

        // Recorremos los billetes
        for (int i = 0; i < billetes.length && cantidad > 0; i++) {

            // Si la cantidad dividida el billete actual es mayor que 0
            if (cantidad / billetes[i] > 0) {
                // Mostramos la cantidad de billetes
                System.out.println((cantidad / billetes[i]) + " billete/s de " + billetes[i] + "€");
                // actualizamos la cantidad
                cantidad = cantidad % billetes[i];
            }

        }

    }
}
