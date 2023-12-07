package com.mycompany.prog04_04;

import java.util.Scanner;

public class PROG04_04 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        // pedimos el año
        System.out.println("Introduce el año");
        int anio = sn.nextInt();

        /*
         *  Un año es bisiesto,
            si es divisible entre 4 y 100 o es divisible entre 400 
         */
        if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) {
            System.out.println("El año es bisiesto");
        } else {
            System.out.println("El año no es bisiesto");
        }

    }
}
