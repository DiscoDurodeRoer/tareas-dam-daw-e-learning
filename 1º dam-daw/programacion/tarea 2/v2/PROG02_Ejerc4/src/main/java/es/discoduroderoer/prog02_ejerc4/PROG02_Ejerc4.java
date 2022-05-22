
package es.discoduroderoer.prog02_ejerc4;

import java.util.Scanner;

public class PROG02_Ejerc4 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce la edad:");
        int edad = sn.nextInt();
        
        System.out.println(edad >= 18 ? "Es mayor de edad":"No es mayor de edad");
        
    }
    
}
