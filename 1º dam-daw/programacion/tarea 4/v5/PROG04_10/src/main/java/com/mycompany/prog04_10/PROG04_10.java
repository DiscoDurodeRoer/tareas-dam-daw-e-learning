package com.mycompany.prog04_10;

import java.util.Scanner;

public class PROG04_10 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        int numAcertar = 49;

        int numUsuario = 0;

        while (numUsuario != numAcertar) {

            // el usuario introduce su numero
            System.out.println("Introduce un numero");
            numUsuario = sn.nextInt();

            // si el numero es mayor al que buscamos, le decimos "menos"
            if (numUsuario > numAcertar) {
                System.out.println("menos");
                
                // si el numero es menor al que buscamos, le decimos "mayor"
            } else if (numUsuario < numAcertar) {
                System.out.println("mayor");

                // sino hemos acertado
            } else {
                System.out.println("Has acertado!!!");
            }

        }

    }
}
