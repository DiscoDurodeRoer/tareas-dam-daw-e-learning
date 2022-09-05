package supuesto4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Supuesto 4
 * @author DDR
 */
public class SumaNaturalesConWhile_DDR {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        int n = 0;
        boolean correcto = false;

        // Validamos que n sea un numero
        do {
            try {
                System.out.println("Introduce un numero natural");
                n = sn.nextInt();

                // Debe ser mayor que 0 para que sea un numero natural
                if (n > 0) {
                    correcto = true;
                } else {
                    System.out.println("Debes introducir un numero natural");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero");
                sn.next();
            }

        } while (!correcto);

        int suma = 0;

        // Suma de 1 a n
        int i = 1;
        while (i <= n) {
            suma += i;
            i++;
        }
        
        // Mostrando la suma final
        System.out.println("Suma: " + suma);

    }

}
