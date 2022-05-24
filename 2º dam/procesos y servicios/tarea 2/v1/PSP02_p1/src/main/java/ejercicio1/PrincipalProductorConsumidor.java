
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalProductorConsumidor {

    public static void main(String[] args) {
        
        try {
            Buffer b = new Buffer(6);
            Productor p = new Productor(b);
            Consumidor c = new Consumidor(b);
            
            p.start();
            Thread.sleep(3000);
            c.start();
            
            p.join();
            c.join();
            System.out.println("Termina el programa");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(PrincipalProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
