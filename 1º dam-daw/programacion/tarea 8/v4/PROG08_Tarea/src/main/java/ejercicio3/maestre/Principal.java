package ejercicio3.maestre;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce un numero positivo");
        int n = sn.nextInt();
        
        if(n > 0){
            
            int[][] tablero = new int[n][n];
            int[] max = new int[n];
            int suma = 0;
            double media = 0;
            int mayor;
            
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    tablero[i][j] = generaNumeroAleatorio(1,9);
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println("");
            }
            
            for (int i = 0; i < tablero.length; i++) {
                mayor = tablero[i][0];
                for (int j = 1; j < tablero[0].length; j++) {
                    if(tablero[i][j] > mayor ){
                        mayor = tablero[i][j];
                    }
                }
                max[i] = mayor;
            }
            
            for (int i = 0; i < max.length; i++) {
                System.out.println("Maximo fila " + i + ": " + max[i]);
                suma += max[i];
            }
            
            media = suma / max.length;
            
            System.out.println("La media es: " + media);
            
        }else{
            System.out.println("El numero debe ser mayor que 0");
        }
        
    }
    
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
    
}
