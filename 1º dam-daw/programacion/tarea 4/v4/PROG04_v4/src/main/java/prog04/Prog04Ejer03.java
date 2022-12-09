package prog04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog04Ejer03 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        
        try {
            
            // Pido un capital
            System.out.println("Escribe el capital");
            long capital = sn.nextLong();
            
            // Pido el porcentaje rentabilidad
            System.out.println("Escribe un porcentaje de rentabilidad");
            double porc = sn.nextDouble();
            
            // Calculo la rentabilidad de un mes
            double rentabilidad = (porc / 100) * capital;
            // Calculo la rentabilidad en 12 meses
            double rentabilidad12m = rentabilidad * 12;
            
            // El capital final es el capital inicial mas lo ganado en 12 meses
            double capitalFinal = capital + rentabilidad12m;
            
            // Muestro el capital final
            System.out.println("El capital final es de " + capitalFinal);
            
        } catch (InputMismatchException e) {
            System.out.println("Debes escribir un numero");
        }
    }
    
}
