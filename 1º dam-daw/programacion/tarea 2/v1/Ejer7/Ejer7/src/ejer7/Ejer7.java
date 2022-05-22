package ejer7;

import java.util.Scanner;

public class Ejer7 {

    /**
     * Diseña un programa Java para resolver una ecuación de primer grado con
     * una incógnita (x), suponiendo que los coeficientes de la ecuación (C1 y
     * C2) se introducen desde teclado. C1x + C2 = 0
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        
        System.out.println("Introduce C1");
        int C1 = sc.nextInt();
        
        System.out.println("Introduce C2");
        int C2 =  sc.nextInt();
        
        int x = -C2 / C1;
        
        System.out.println("x="+x);
    }

}
