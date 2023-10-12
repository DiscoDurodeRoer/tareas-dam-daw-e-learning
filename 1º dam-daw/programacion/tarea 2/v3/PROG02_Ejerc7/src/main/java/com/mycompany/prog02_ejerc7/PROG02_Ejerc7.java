package com.mycompany.prog02_ejerc7;

public class PROG02_Ejerc7 {

    public static void main(String[] args) {
        
        // Variables
        int C1 = 5;
        int C2 = 12;
        
        // Obtenemos x (debemos castear a double para evitar perder decimales)
        double x = (double) -C2 / C1;
        
        // Sacamos 4 decimales
        System.out.printf("X => %.4f", x);
        
    }
}
