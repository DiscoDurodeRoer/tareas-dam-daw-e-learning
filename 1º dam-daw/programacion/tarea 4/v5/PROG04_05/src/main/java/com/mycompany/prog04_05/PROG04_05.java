package com.mycompany.prog04_05;

import java.util.Scanner;

public class PROG04_05 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        // Pedimos el valor de n
        System.out.println("Introduce n");
        int n = sn.nextInt();

        for (int numeroEspacios = n, numeroAsteriscos = 1; 
                numeroEspacios > 0; 
                numeroEspacios--, numeroAsteriscos += 2) {

            // Pinto los espacios
            for (int i = 0; i < numeroEspacios; i++) {
                System.out.print(" ");
            }
            
            // Pinto los asteriscos
            for (int i = 0; i < numeroAsteriscos; i++) {
                System.out.print("*");
            }
            
            System.out.println("");
            
        }

    }
}
