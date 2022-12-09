package prog04ejer03;

import java.util.Scanner;

public class Prog04Ejer03 {

    public static void main(String[] args) {

       Scanner sn = new Scanner(System.in);
       
       System.out.println("Introduce un numero en el intervalo minimo");
       int min = sn.nextInt();
       
       System.out.println("Introduce un numero en el intervalo maximo");
       int max = sn.nextInt();
       
       if(min > max){
           int aux = max;
           max = min;
           min = aux;
       }
       
       final int NUM_INT = 10;
       final String NOMBRE = "DDR";
       
       int numOculto = (int)Math.floor(Math.random()*(max-min+1)+(min));
       int numIntentos = 1;
       int numJugador = 0;
       boolean acertado = false;
       
       while(numIntentos <= NUM_INT && !acertado){
       
           System.out.println(NOMBRE + ", introduce tu intento " + numIntentos + " para adivinar el numero del intervalo [" + min + ", " + max + "]");
           numJugador = sn.nextInt();
           
           if(numJugador == numOculto){
               acertado = true;
               System.out.println("Has ganado, has necesitado " + numIntentos + " intentos");
           }else{
               if(numJugador > numOculto){
                   System.out.println("El numero oculto es menor");
               }else{
                   System.out.println("El numero oculto es mayor");
               }
               System.out.println("Te quedan " + (NUM_INT - numIntentos) + " intentos");
               numIntentos++;
           }   
       }
       
       if(!acertado){
           System.out.println("Has perdido, te has quedado sin intentos");
       }
       
    }
}
