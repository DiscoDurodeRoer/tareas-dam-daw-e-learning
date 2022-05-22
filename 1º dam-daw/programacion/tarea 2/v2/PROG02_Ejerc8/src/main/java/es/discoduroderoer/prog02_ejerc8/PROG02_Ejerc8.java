
package es.discoduroderoer.prog02_ejerc8;

import java.util.Scanner;

public class PROG02_Ejerc8 {

    public static void main(String[] args) {
         Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce alumnos programacion:");
        int prog = sn.nextInt();
        
        System.out.println("Introduce alumnos entornos:");
        int entornos = sn.nextInt();
        
        System.out.println("Introduce alumnos base de datos:");
        int baseDatos = sn.nextInt();
    
        int total = prog + entornos + baseDatos;
        
        double porcProg = (double) (prog * 100) / total;
        double porcEntorno = (double) (entornos * 100) / total;
        double porcBaseDatos =  (double) (baseDatos * 100) / total;
        
        System.out.printf("PROG: %.1f \n",porcProg);
        System.out.printf("entorno: %.1f\n",porcEntorno);
        System.out.printf("base datos: %.1f\n",porcBaseDatos);
    
    }
    
}
