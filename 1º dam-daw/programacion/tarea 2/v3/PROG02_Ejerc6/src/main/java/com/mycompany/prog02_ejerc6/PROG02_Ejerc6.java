package com.mycompany.prog02_ejerc6;

public class PROG02_Ejerc6 {

    public static void main(String[] args) {

        // Definimos las variables
        RAZAS var1 = RAZAS.PEKINES;
        RAZAS var2 = RAZAS.GALGO;

        // comparamos
        System.out.println(var1 == var2);

        // numero de razas
        System.out.println("Num razas: " + RAZAS.values().length);

        // obtener la posicion de las razas
        int posVar1 = 0;
        int posVar2 = 0;
        for (int i = 0; i < RAZAS.values().length; i++) {
            if (var1 == RAZAS.values()[i]) {
                posVar1 = i;
            }
            if (var2 == RAZAS.values()[i]) {
                posVar2 = i;
            }
        }
        
        System.out.println("posicion var1: " + posVar1);
        System.out.println("posicion var2: " + posVar2);

    }
}
