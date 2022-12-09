package prog04ejer02;

import java.util.Scanner;

public class Prog04Ejer02 {
    
    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        int numPares = 0;
        int numMult3 = 0;
        int num;
        
        String respuesta = "";
        
        while(!respuesta.equalsIgnoreCase("Y")){
            
            System.out.println("Introduce un numero");
            num = sn.nextInt();
            
            if(num % 2 == 0){
                numPares++;
            }
            if(num % 3 == 0){
                numMult3++;
            }
            
            System.out.println("¿Quieres terminar? Escribe Y para finalizar");
            respuesta = sn.next();
            
        }
        
        System.out.println("Numero de pares: " + numPares);
        System.out.println("Numero de multiplo de 3: " + numMult3);
        
        if(numPares == numMult3){
            System.out.println("Hay tantos pares como multiplos de 3");
        } else if(numPares > numMult3){
            System.out.println("Hay mas pares que multiplos de 3");
        }else{
            System.out.println("Hay mas multiplos de 3 que pares");
        }
        
    }
    
}
