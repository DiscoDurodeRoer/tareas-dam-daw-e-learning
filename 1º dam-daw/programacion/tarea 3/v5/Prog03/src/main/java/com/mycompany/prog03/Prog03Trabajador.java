package com.mycompany.prog03;

public class Prog03Trabajador {

    public static void main(String[] args) {

        Trabajador t = new Trabajador();

        // Parte 3 
        System.out.println(t.consulta_Nombre());
        System.out.println(t.consulta_Edad());
        System.out.println(t.consulta_Altura());
        
        // Parte 2
        t.principal();
        
        Trabajador t2 = new Trabajador("Fernando", 33, 1.73f);

        // Parte 4
        System.out.println(t2.consulta_Nombre());
        System.out.println(t2.consulta_Edad());
        System.out.println(t2.consulta_Altura());
        
    }
}
