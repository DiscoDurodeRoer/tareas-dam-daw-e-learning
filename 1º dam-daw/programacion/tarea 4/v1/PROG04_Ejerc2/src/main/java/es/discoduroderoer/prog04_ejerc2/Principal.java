package es.discoduroderoer.prog04_ejerc2;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        int numDivisiones = 0;
        int num1 = 0;
        int num2 = 0;
        double resultado = 0;
        
        while(num1 != -1 && num2 != -1){
            
            try {
                System.out.println("Introduce el dividendo");
                num1 = sn.nextInt();
                System.out.println("Introduce el divisor");
                num2 = sn.nextInt();
            
                if(num1 != -1 && num2 != -1){
                    
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                    numDivisiones++;

                }
            
            } catch (ArithmeticException e) {
                System.out.println("No se puede dividir entre 0");
            } 
            
        }
        
        System.out.println("Numero divisiones: " + numDivisiones);
        
        
    }
    
}
