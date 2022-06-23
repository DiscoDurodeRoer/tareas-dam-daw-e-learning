
package tarea8.ejerc2;

import java.util.HashSet;

public class Principal {

 
    public static void main(String[] args) {
        
        final int MINIMO = 0;
        final int MAXIMO = 14;
        
        
        HashSet<Integer> numeros = new HashSet<>();
        
        int numColisiones = 0;
        while(numeros.size() != 8){
            
            int num = generarNumeroAleatorio(MINIMO, MAXIMO);
            
            if(numeros.add(num)){
                System.out.println("Se ha insertado el número " + num);
            } else{
                System.out.println("Número repetido " + num);
                numColisiones++;
            }
            
        }
        
        if(numColisiones == 0){
            System.out.println("No ha habido colisiones");
        }else{
            double porcentaje = (double)(numColisiones * 100) / (numColisiones + numeros.size());
            System.out.println("% colisiones: " + porcentaje);
        }
        
        
    }
    
    public static int generarNumeroAleatorio(int minimo, int maximo){
        return (int) Math.floor(Math.random() * (maximo + minimo + 1) + minimo); 
    }
    
}
