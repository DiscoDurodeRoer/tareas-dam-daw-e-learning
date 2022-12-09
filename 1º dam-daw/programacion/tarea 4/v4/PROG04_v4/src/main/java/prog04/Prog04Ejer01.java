package prog04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog04Ejer01 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        try {
            
            // Pedimos un numero
            System.out.println("Escribe un numero mayor que 0");
            int n = sn.nextInt();

            // Si es menor o igual 0, mostramos un mensaje
            if(n <= 0){
                System.out.println("el numero debe ser mayor que 0");
            }else{
                // Obtenemos el cuadrado y la raiz
                double cuadrado = Math.pow(n, 2);
                double raiz = Math.sqrt(n);

                System.out.println("Cuadrado: " + cuadrado);
                System.out.println("Raiz: " + raiz);
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes escribir un numero");
        }
        
        
    }
    
}
