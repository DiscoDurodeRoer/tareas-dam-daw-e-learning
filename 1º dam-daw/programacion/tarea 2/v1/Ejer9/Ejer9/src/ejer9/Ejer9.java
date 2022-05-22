package ejer9;

import java.util.Scanner;

public class Ejer9 {

    /**
     * Diseña un programa Java que solicite un número de 5 dígitos del teclado,
     * separe el número en sus dígitos individuales y los muestre por pantalla.
     * Por ejemplo, si el número es 53123 que muestre:
     *
     * 5 3 1 2 3
     *
     * Utilizando los operadores aritméticos de la división y el resto según
     * precises.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        do {
            System.out.println("Inserta un numero de cifras");
            num = sc.nextInt();
        } while (!(num >= 10000 && num <= 99999));

        String cadena = "";
        for (int i = num; i > 0; i /= 10) {
            cadena = (i%10) + " " + cadena;
        }
        System.out.println(cadena);
    }

}
