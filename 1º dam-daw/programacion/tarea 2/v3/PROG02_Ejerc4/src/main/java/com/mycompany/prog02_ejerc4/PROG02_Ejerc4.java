package com.mycompany.prog02_ejerc4;

public class PROG02_Ejerc4 {

    public static void main(String[] args) {

        // declaramos la edad
        byte edad = 16;

        // booleano para indicar si es mayor o no
        boolean esMayor = edad >= 18;
        String respuesta;

        // Guardamos la respuesta
        respuesta = esMayor ? "Es mayor" : "Es menor";
        
        System.out.println(respuesta);

    }
}
