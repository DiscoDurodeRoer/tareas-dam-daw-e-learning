package prog04ejer01;

import java.util.Scanner;

public class Prog04Ejer01 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Introduce un numero");
            int num = sn.nextInt();
            
            if(num < 0){
                System.out.println("El numero es negativo");
            }else{
                
                boolean esPrimo = true;
                
                for (int j = (int) Math.sqrt(num); j > 1 && esPrimo; j--) {
                    if(num % j == 0){
                        esPrimo = false;
                    }
                }
                
                if(esPrimo){
                    System.out.println("El numero es primo");
                }else{
                    System.out.println("El numero no es primo");
                }
                
                
            }
            
        }
        
    }

}
