package supuesto5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Supuesto 6
 * @author DDR
 */
public class SumaNumeros_DDR {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        int n = 0;
        int suma = 0;
        do {

            try {
                System.out.println("Introduce un numero, -1 para salir");
                n = sn.nextInt();
                
                // Si es diferente a -1, lo sumamos
                if(n != -1){
                    suma += n;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero");
                sn.next();
            }

        } while (n != -1);

        // mostramos la suma
        System.out.println("Suma: " + suma);
        
    }

}
