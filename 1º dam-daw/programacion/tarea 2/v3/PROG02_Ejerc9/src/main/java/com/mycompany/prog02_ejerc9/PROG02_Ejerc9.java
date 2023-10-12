package com.mycompany.prog02_ejerc9;

public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        
        // indicamos el año
        int anio = 2000;
        
        // Un año bisiesto es cuando es divisible entre 4 pero no por 100 excepto que sea divisible por 400
        if( anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0){
            System.out.println("Es bisiesto");
        }else{
            System.out.println("No es bisiesto");
        }
        
        
    }
}
