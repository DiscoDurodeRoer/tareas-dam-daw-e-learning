package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private Buffer buffer;
    private final String letras = "abcdefghijklmnopqrstuvxyz";
    private int produced;
    private final int LIMIT = 15;
    
    public Productor(Buffer buffer){
        this.produced = 0;
        this.buffer = buffer;
    }
    
    public void run(){
        while(produced < LIMIT){
            
            try {
                char c = letras.charAt((int)(Math.random() * letras.length()));
                buffer.producir(c);
                produced++;
                System.out.println("Depositado el caracter " + c + " del buffer");
                sleep((long) (Math.random() * 4000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}
