/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer3;

/**
 * @class Ejer3
 * @description descripcion de la clase
 * @author Fernando
 */
public class Ejer3 {

    public static void main(String[] args) {

        boolean casado;
        final int MAXIMO = 999999;
        byte diasem;
        short diaanual;
        char sexo;
        long miliseg;
        double totalfactura;
        long poblacion;

        // utilizamos el operador de asignacion (=)
        casado = true;
        diasem = 1;
        diaanual = 300;
        sexo = 'M';
        miliseg = 105124200000L;
        totalfactura = 10350.678;
        poblacion = 6775235741L;

        //println
        System.out.println("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS ---");
        System.out.println("\tEl valor de la variable casado es " + casado);
        System.out.println("\tEl valor de la variable MAXIMO es " + MAXIMO);
        System.out.println("\tEl valor de la variable diasem es " + diasem);
        System.out.println("\tEl valor de la variable diaanual es " + diaanual);
        System.out.println("\tEl valor de la variable miliseg es " + miliseg);
        System.out.println("\tEl valor de la variable totalfactura es " + totalfactura);
        System.out.println("\tEl valor de la variable poblacion es " + poblacion);
        System.out.println("\tEl valor de la variable sexo es " + sexo);
        
        //print
        System.out.print("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS ---\n");
        System.out.print("\tEl valor de la variable casado es " + casado+"\n");
        System.out.print("\tEl valor de la variable MAXIMO es " + MAXIMO+"\n");
        System.out.print("\tEl valor de la variable diasem es " + diasem+"\n");
        System.out.print("\tEl valor de la variable diaanual es " + diaanual+"\n");
        System.out.print("\tEl valor de la variable miliseg es " + miliseg+"\n");
        System.out.print("\tEl valor de la variable totalfactura es " + totalfactura+"\n");
        System.out.print("\tEl valor de la variable poblacion es " + poblacion+"\n");
        System.out.print("\tEl valor de la variable sexo es " + sexo+"\n");
        
        
        //printf
        System.out.printf("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS ---\n");
        System.out.printf("\tEl valor de la variable casado es %b\n", casado);
        System.out.printf("\tEl valor de la variable MAXIMO es %d\n", MAXIMO);
        System.out.printf("\tEl valor de la variable diasem es %d\n", diasem);
        System.out.printf("\tEl valor de la variable diaanual es %d\n", diaanual);
        System.out.printf("\tEl valor de la variable miliseg es %d\n", miliseg);
        System.out.printf("\tEl valor de la variable totalfactura es %.6f\n",totalfactura);
        System.out.printf("\tEl valor de la variable totalfactura es %12.5e\n",totalfactura);
        System.out.printf("\tEl valor de la variable poblacion es %d\n", poblacion);
        System.out.printf("\tEl valor de la variable sexo es %c\n" , sexo);

    } // fin del main

} // fin de la clase
