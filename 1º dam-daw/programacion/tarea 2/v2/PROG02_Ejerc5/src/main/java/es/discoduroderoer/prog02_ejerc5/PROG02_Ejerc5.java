
package es.discoduroderoer.prog02_ejerc5;

import java.util.Scanner;

public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce la cantidad de segundos:");
        int segundos = sn.nextInt();
        
        int dias = segundos / 86400;
        
        int seg_restantes = segundos % 86400;
        
        int horas = seg_restantes / 3600;
        
        seg_restantes = seg_restantes % 3600;
        
        int minutos = seg_restantes % 60;
        
        System.out.println("Dias: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        
    }
    
}
