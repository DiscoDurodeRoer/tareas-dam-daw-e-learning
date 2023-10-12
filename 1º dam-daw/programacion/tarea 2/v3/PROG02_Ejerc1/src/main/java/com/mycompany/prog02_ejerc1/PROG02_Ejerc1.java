package com.mycompany.prog02_ejerc1;

public class PROG02_Ejerc1 {

    public static void main(String[] args) {
        
        // Valor maximo no modificable
        final short VALOR = 5000;
        // Si el nuevo empleado tiene carner conducir o no
        boolean carnet = false;
        // Un mes del año en formato numerico
        byte numMes = 1;
        // y en formato cadena
        String mes = "Enero";
        // El nombre y apellidos de una persona
        String nombreApellidos = "Fernando Ureña";
        // Sexo: con dos valores posibles 'V' o 'M'
        char sexo = 'V';
        // Milisegundos transcurridos desde el 01/01/1970 hasta nuestros dias
        int tiempo = 1697052226;
        // saldo de una cuenta bancaria
        float saldo = 100.5f;
        // Distancia en kms desde la Tierra a Jupiter
        long distancia = 60562000000l;
     
        // Mostrar valores
        System.out.printf("Valor: %d\n", VALOR);
        System.out.printf("carnet: %b\n", carnet);
        System.out.printf("numMes: %d\n", numMes);
        System.out.printf("mes: %s\n", mes);
        System.out.printf("nombreApellidos: %s\n", nombreApellidos);
        System.out.printf("sexo: %s\n", sexo);
        System.out.printf("tiempo: %d\n", tiempo);
        System.out.printf("saldo: %.2f\n", saldo);
        System.out.printf("distancia: %d\n", distancia);
        
    }
}
