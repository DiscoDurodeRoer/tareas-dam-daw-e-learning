package es.discoduroderoer.prog04_ejerc1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        int NUM_INT_DEFAULT = 5;
        int NUM_MAX_DEFAULT = 10;
        
        boolean salir = false;
        int opcion = 0;
        int numInt = NUM_INT_DEFAULT;
        int numMax = NUM_MAX_DEFAULT;
        
        while(!salir){
            
            System.out.println("1. Configurar");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");
            opcion = sn.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Introduce el numero de intentos");
                    numInt = sn.nextInt();
                    System.out.println("Introduce el numero maximo generado");
                    numMax = sn.nextInt();
                    break;
                case 2:
                    
                    int numOculto = (int)Math.floor(Math.random()*numMax+1);
                    int intentosJugador = 1;
                    int numJugador = 0;
                    boolean acertado = false;
                    
                    while(intentosJugador <= numInt && !acertado){
                        
                        System.out.println("Introduce un numero");
                        numJugador = sn.nextInt();
                        
                        if(numJugador == numOculto){
                            System.out.println("Has ganado!. Has necesitado " + intentosJugador + " intentos");
                            acertado = true;
                        }else{
                            if(numJugador > numOculto){
                                System.out.println("El numero oculto es menor");
                            }else{
                                System.out.println("El numero oculto es mayor");
                            }
                            System.out.println("Te quedan " + (numInt - intentosJugador) + " intentos");
                            intentosJugador++;
                        }
                        
                    }
                    
                    break;
                    
                case 3:
                    salir = true;
                    break;
            }
            
        }
        
    }
    
}
