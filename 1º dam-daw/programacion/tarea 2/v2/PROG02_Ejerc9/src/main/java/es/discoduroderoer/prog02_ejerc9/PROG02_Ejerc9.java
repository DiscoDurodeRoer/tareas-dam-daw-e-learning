
package es.discoduroderoer.prog02_ejerc9;

import java.util.Scanner;

public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce un año");
        int año = sn.nextInt();
        
        if((año % 4 == 0 & año % 100 != 0) || año % 400 == 0){
            System.out.println("Es bisiesto");
        }else{
            System.out.println("No es bisiesto");
        }
        
        
    }
    
}
