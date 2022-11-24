package ejercicio2.maestre;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        
        final int TAMANIO_TABLERO = 8;
        final int NUM_RONDAS_MAX = 5;
        
        boolean[] tablero = new boolean[TAMANIO_TABLERO];
        colocarMosca(tablero);
        
        int numRondas = 0;
        int posUsuario = 0;
        boolean moscaCazada = false;
        
        while(!moscaCazada && numRondas < NUM_RONDAS_MAX){
            
            System.out.println("Ronda nº " + (numRondas + 1));
            
            System.out.println("Introduce la posicion donde esta la mosca");
            posUsuario = sn.nextInt();
            
            if(posUsuario >= 0 && posUsuario < tablero.length){
                if(tablero[posUsuario]){
                    moscaCazada = true;
                    System.out.println("La mosca ha sido cazada en " + (numRondas + 1) + " rondas");
                }else if(moscaCerca(tablero, posUsuario)){
                    System.out.println("La mosca ha revoloteado");
                    colocarMosca(tablero);
                }else{
                    System.out.println("La mosca no se ha movido");
                }
                numRondas++;
                
            }
        }
        
        if(!moscaCazada){
            System.out.println("Has perdido");
        }
        
    }
    
    public static boolean moscaCerca(boolean tablero[], int pos){
        
        int posMosca = 0;
        for (int i = 0; i < tablero.length; i++) {
            if(tablero[i]){
                posMosca = i;
            }
        }
        
        return posMosca + 1 == pos || posMosca - 1 == pos;
    }
    
    public static void colocarMosca(boolean tablero[]){
        
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = false;
        }
        
        int posAleatoria = generaNumeroAleatorio(0, tablero.length - 1);
        tablero[posAleatoria] = true; 
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
    
}
