package ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {
        
    private Socket sc;
    
    public ServidorHilo(Socket sc){
        this.sc = sc;
    }
    
    @Override
    public void run(){
        
            DataInputStream in = null;
            DataOutputStream out = null;
        try {
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            String ruta = in.readUTF();
            
            File f = new File(ruta);
            
            if(f.exists()){
                out.writeBoolean(true);
                
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                
                String linea = "";
                String contenido = "";
                
                while((linea = br.readLine()) != null){
                    contenido += linea+"\r\n";
                }
                
                br.close();
                
                byte[] contenidoFichero = contenido.getBytes();
                
                out.writeInt(contenidoFichero.length);
                
                for (int i = 0; i < contenidoFichero.length; i++) {
                    out.writeByte(contenidoFichero[i]);
                }
                
                sc.close();
                
            }else{
                out.writeBoolean(false);
            }
            
            
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
    
}
