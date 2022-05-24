package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {
        
    private Socket sc;

    public ServidorHilo(Socket sc) {
        this.sc = sc;
    }
    
    public void run(){
     
        System.out.println("Cliente conectado");
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            int numAleatorio = generaNumeroAleatorio(1,100);
            int numUsuario = 0;
            
            System.out.println("Num generado: " + numAleatorio);
            
            do {
                
                out.writeUTF("Escribe un numero entre 1 y 100");

                numUsuario = in.readInt();

                System.out.println("Numero recibido: " + numUsuario);

                if(numUsuario == numAleatorio){
                    out.writeUTF("¡Has ganado!");
                }else if (numUsuario < numAleatorio){
                    out.writeUTF("El numero buscado es mayor");
                }else{
                    out.writeUTF("El numero buscado es menor");
                }

                out.writeBoolean(numUsuario == numAleatorio);
            } while(numUsuario != numAleatorio);
            
            sc.close();
            System.out.println("Cliente desconectado");
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private int generaNumeroAleatorio(int minimo,int maximo){
       int num=(int)(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
    
}
