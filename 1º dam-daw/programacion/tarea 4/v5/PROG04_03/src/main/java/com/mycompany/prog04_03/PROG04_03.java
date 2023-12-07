package com.mycompany.prog04_03;

import java.util.Locale;
import java.util.Scanner;

public class PROG04_03 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        // pedimos una nota
        System.out.println("Introduce una nota entre 0 y 10");
        double nota = sn.nextDouble();

        // Indicamos la nota
        if (nota >= 0 && nota < 3) {
            System.out.println("Muy deficiente");
        }else if(nota >= 3 && nota < 5){
            System.out.println("Insuficiente");
        }else if(nota >= 5 && nota < 6.5){
            System.out.println("Bien");
        }else if(nota >= 6.5 && nota < 9){
            System.out.println("Notable");
        }else if (nota >= 9 && nota <= 10){
            System.out.println("Sobresaliente");
        }else{
            System.out.println("debes introducir un valor entre 0 y 10");
        }

    }
}
