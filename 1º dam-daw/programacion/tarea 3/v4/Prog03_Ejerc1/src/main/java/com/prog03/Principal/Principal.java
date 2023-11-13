
package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;

public class Principal {

    public static void main(String[] args) {
        
        //Instanciamos dos objetos del tipo Rectangulo
        Rectangulo r1 = new Rectangulo();
        Rectangulo r2 = new Rectangulo(5, 5);
        
        System.out.println("Base r1: " + r1.getBase());
        
        // Modificamos la base y la altura
        r1.setBase(20);
        r1.setAltura(10);

        // base de r1
        System.out.println("Base r1: " + r1.getBase());
        // info de r1
        System.out.println("r1 toString: " + r1.toString());
        
        // r2 ¿es cuadrado?
        System.out.println("¿r2 es cuadrado?" + r2.isCuadrado());
        // info de r2
        System.out.println("r2 toString" + r2.toString());
        
    }
    
}
