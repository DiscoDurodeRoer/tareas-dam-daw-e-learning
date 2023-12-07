package com.mycompany.prog04_07;

import java.util.Scanner;

public class PROG04_07 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        boolean acertado = false;

        do {

            // Pedimos el login y el password
            System.out.println("Introduce el login");
            String login = sn.next();

            System.out.println("Introduce el password");
            String password = sn.next();

            // Si es correcto, lo marcamos
            if (login.equals("admin") && password.equals("1234")) {
                acertado = true;
            }else{
                System.out.println("No es correcto");
            }

        } while (!acertado);

        System.out.println("Es correcto");
        
    }
}
