package com.mycompany.prog02_ejerc5;

public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        
        // Segundos
        int segs = 86400;
        
        // Minutos
        int mins = segs / 60;
        
        // Horas
        int horas = mins / 60;
        // minutos restantes
        mins = mins % 60;
        
        // dias
        int dias = horas / 24;
        // horas restantes
        horas = horas % 24;
        
        // resultado
        System.out.println("mins: " + mins);
        System.out.println("horas: " + horas);
        System.out.println("dias: " + dias);
        
        
    }
}
