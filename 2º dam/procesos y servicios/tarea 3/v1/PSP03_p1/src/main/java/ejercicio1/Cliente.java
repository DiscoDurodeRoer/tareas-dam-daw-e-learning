package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        try {
            Socket sc = new Socket("localhost", 2000);

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            boolean salir = false;
            
            Scanner sn = new Scanner(System.in);
            
            do{
                
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                int num = sn.nextInt();
                out.writeInt(num);

                mensaje = in.readUTF();
                System.out.println(mensaje);

                salir = in.readBoolean();
                
            }while(!salir);
            
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
