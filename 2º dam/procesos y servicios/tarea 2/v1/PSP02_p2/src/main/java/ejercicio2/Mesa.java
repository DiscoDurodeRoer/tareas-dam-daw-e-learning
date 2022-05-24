package ejercicio2;

import java.util.concurrent.Semaphore;

public class Mesa {

    private Semaphore[] palillos;
    
    public Mesa(int numPalillos){
        this.palillos = new Semaphore[numPalillos];
        for (int i = 0; i < numPalillos; i++) {
            this.palillos[i] = new Semaphore(1);
        }
        
    }
    
    public int palilloIzquierdo(int i){
        return i;
    }
    
    public int palilloDerecho(int i){
        if(i == 0){
            return this.palillos.length - 1;
        }else{
            return i - 1;
        }
    }
    
    public void cogerPalillos(int comensal) throws InterruptedException{
        this.palillos[this.palilloIzquierdo(comensal)].acquire();
        this.palillos[this.palilloDerecho(comensal)].acquire();
    }
    
    public void dejarPalillos(int comensal){
        this.palillos[this.palilloIzquierdo(comensal)].release();
        this.palillos[this.palilloDerecho(comensal)].release();
        
    }
    
}
