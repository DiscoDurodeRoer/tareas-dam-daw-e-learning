package prog04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog04Ejer02 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        try {
            
            // Pido el numero de niños
            System.out.println("Escribe un numero de niños");
            int ninos = sn.nextInt();
            
            // Pido el numero de niñas
            System.out.println("Escribe un numero de niñas");
            int ninas = sn.nextInt();

            // Obtengo el total
            int total = ninos + ninas;
            
            /*
                300 alumnos ---- 100%
                 y  alumnos -----  x
            */    
            
            // Calculo el porcentaje
            double porcNinos = (double)ninos * 100 / total;
            double porcNinas = (double)ninas * 100 / total;
            
            // Mostramos los porcentajes
            System.out.println("Porcentaje niños: " + porcNinos);
            System.out.println("Porcentaje niñas: " + porcNinas);
            
        } catch (InputMismatchException e) {
            System.out.println("Debes escribir un numero");
        }
    }
    
}
