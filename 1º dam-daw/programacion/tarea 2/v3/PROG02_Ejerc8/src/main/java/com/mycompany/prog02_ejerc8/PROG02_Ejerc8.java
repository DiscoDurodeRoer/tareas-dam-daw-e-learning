package com.mycompany.prog02_ejerc8;

public class PROG02_Ejerc8 {

    public static void main(String[] args) {

        // Alumnos
        int numProg = 15;
        int numEnt = 5;
        int numBD = 5;

        // Obtenemos el total
        int total = numProg + numEnt + numBD;

        // regla de 3
        //     total   => 100%
        // alumno_asig => x
        double porcProg = (double) numProg * 100 / total;
        double porcEnt = (double) numEnt * 100 / total;
        double porcBD = (double) numBD * 100 / total;
        
        // Mostramos los porcentajes
        System.out.printf("Porc programacion: %.1f\n", porcProg);
        System.out.printf("Porc entornos: %.1f\n", porcEnt);
        System.out.printf("Porc base datos: %.1f\n", porcBD);

    }
}
