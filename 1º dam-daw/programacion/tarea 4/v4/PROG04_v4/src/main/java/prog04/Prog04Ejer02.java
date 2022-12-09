package prog04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog04Ejer02 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        try {
            
            System.out.println("Escribe un numero de niños");
            int ninos = sn.nextInt();
            
            System.out.println("Escribe un numero de niñas");
            int ninas = sn.nextInt();

            int total = ninos + ninas;
            
            /*
                300 alumnos ---- 100%
                 y  alumnos -----  x
            */    
            
            double porcNinos = (double)ninos * 100 / total;
            double porcNinas = (double)ninas * 100 / total;
            
            System.out.println("Porcentaje niños: " + porcNinos);
            System.out.println("Porcentaje niñas: " + porcNinas);
            
        } catch (InputMismatchException e) {
            System.out.println("Debes escribir un numero");
        }
    }
    
}
