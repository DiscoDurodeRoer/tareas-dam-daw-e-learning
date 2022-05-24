package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo extends Thread {
    
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;
    
    public Filosofo(Mesa m, int comensal){
        this.comensal = comensal;
        this.indiceComensal = comensal - 1;
        this.mesa = m;
    }
    
    public void run(){
        while(true){
            try {
                this.pensando();
                System.out.println("Filosofo " + this.comensal + " esta hambriento");
                mesa.cogerPalillos(this.indiceComensal);
                this.comiendo();
                System.out.println("Filosofo " + this.comensal + " ha terminado de comer, palillos libres: " + (this.mesa.palilloIzquierdo(this.indiceComensal) + 1)  + ", " + (this.mesa.palilloDerecho(this.indiceComensal) + 1));
                mesa.dejarPalillos(this.indiceComensal);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
    }
    
    public void pensando() throws InterruptedException{
        System.out.println("Filosofo " + this.comensal + " esta pensando");
        Thread.sleep(2000);
    }

    public void comiendo() throws InterruptedException{
        System.out.println("Filosofo " + this.comensal + " esta comiendo");
        Thread.sleep(2000);
    }
    
}
