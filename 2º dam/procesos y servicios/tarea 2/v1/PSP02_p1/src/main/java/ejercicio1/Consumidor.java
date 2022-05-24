package ejercicio1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {
    
    private Buffer buffer;
    private int consumed;
    private final int LIMIT = 15;
    
    public Consumidor(Buffer buffer){
        this.consumed = 0;
        this.buffer = buffer;
    }
    
    public void run(){
        while(consumed < LIMIT){
            
            try {
                char c = buffer.consumir();
                consumed++;
                System.out.println("Recogido el caracter " + c + " del buffer");
                sleep((long) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
