package prog04ejer04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog04Ejer04 {
    //para este ejemplo no definimos atributos 
    //métodos 

    public int pedirEdad() {

        Scanner sn = new Scanner(System.in);

        int edad = 0;

        do {

            try {
                System.out.println("Introduce una edad mayor que 0");
                edad = sn.nextInt();

                if (edad < 0) {
                    System.out.println("Debes introducir una edad mayor que 0");
                }
            } catch (InputMismatchException e) {
                sn.next();
                System.out.println("Debes introducir un numero entero");
                edad = -1;
            }

        } while (edad < 0);

        return edad;
        
    }

    public void classificarEdad(String nombre, int edad) {
        
        String rango = "";
        if(edad >= 0 && edad <= 25){
            rango = "A";
        }else if (edad >= 26 && edad <= 50){
            rango = "B";
        }else{
            rango = "C";
        }
        
        int decada = edad + 10;
        
        System.out.println(nombre + ", estas clasificado como " + rango + " y dentro de una década tendrás " + decada + " años");
        
    }

    public static void main(String[] args) {
        //declaración de variables 
        int edad;
        String nombre;
        //escribir aquí el código para pedir por teclado el nombre
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        
        System.out.println("Introuce el nombre");
        nombre = sn.next();
        
        //declaración el objeto p para trabajar con los métodos 
        Prog04Ejer04 p = new Prog04Ejer04();
        
        //llamada al método pedirEdad() que devuelve un entero validado 
        edad = p.pedirEdad(); //llamada al método classificarEdad() 
        p.classificarEdad(nombre, edad);
    }

}
