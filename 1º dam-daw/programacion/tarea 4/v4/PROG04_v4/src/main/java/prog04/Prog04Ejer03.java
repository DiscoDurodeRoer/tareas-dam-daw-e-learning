package prog04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog04Ejer03 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        
        try {
            
            System.out.println("Escribe el capital");
            long capital = sn.nextLong();
            
            System.out.println("Escribe un porcentaje de rentabilidad");
            double porc = sn.nextDouble();
            
            double rentabilidad = (porc / 100) * capital;
            double rentabilidad12m = rentabilidad * 12;
            
            double capitalFinal = capital + rentabilidad12m;
            
            System.out.println("El capital final es de " + capitalFinal);
            
        } catch (InputMismatchException e) {
            System.out.println("Debes escribir un numero");
        }
    }
    
}
