package supuesto1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Supuesto 1
 * @author DDR
 */
public class DeportesConIF_DDR {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        boolean correcto = false;
        int temp = 0;
        // Validamos la temperatura
        do{
            try {
                System.out.println("Escribe una temperatura");
                temp = sn.nextInt();
                // Si llego aqui es que se ha insertado un número
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                correcto = false;
                sn.next();
            }
        }while(!correcto);
        
        System.out.println("El deporte mas apropiado es: ");
        
        // Usamos if / else if para mostrar el valor adecuado
        if(temp > 30){
            System.out.println("Natación");
        }else if (temp > 15 && temp <= 30){
            System.out.println("Golf");
        }else if (temp > 5 && temp <= 15){
            System.out.println("Tenis");
        }else if (temp > -10 && temp <= 5){
            System.out.println("Esquí");
        }else{
            System.out.println("Damas");
        }
        
    }
    
}
