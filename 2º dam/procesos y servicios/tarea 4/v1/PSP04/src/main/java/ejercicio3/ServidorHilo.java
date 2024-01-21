package ejercicio3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {

    private Socket sc;

    public ServidorHilo(Socket sc) {
        this.sc = sc;
    }

    @Override
    public void run() {

        DataInputStream in = null;
        DataOutputStream out = null;
        try {

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Introduce el usuario");
            String usuario = in.readUTF().trim();

            out.writeUTF("Introduce el password");
            String password = in.readUTF().trim();

            if (usuario.equals("DDR") && password.equals("123456")) {

                out.writeBoolean(true);


                boolean salir = false;

                while (!salir) {
                    
                    out.writeUTF("Introduce un comando (ls/get/exit)");
                    String comando = in.readUTF().trim();

                    switch (comando) {
                        case "ls":
                            
                            File directorioactual = new File("./ficheros");
                            File[] ficheros = directorioactual.listFiles();
                            
                            ArrayList<String> nombresFicheros = new ArrayList<>();
                            for (int i = 0; i < ficheros.length; i++) {
                                if(ficheros[i].isFile()){
                                    nombresFicheros.add(ficheros[i].getName());
                                }
                            }
                            
                            out.writeInt(nombresFicheros.size());
                            
                            for (String nombresFichero : nombresFicheros) {
                                out.writeUTF(nombresFichero);
                            }
                            
                            
                            break;
                        case "get":

                            String ruta = in.readUTF().trim();

                            File f = new File("./ficheros/" + ruta);

                            if (f.exists()) {
                                out.writeBoolean(true);

                                BufferedReader br = new BufferedReader(new FileReader("./ficheros/" + ruta));

                                String linea = "";
                                String contenido = "";

                                while ((linea = br.readLine()) != null) {
                                    contenido += linea + "\r\n";
                                }

                                br.close();

                                byte[] contenidoFichero = contenido.getBytes();

                                out.writeInt(contenidoFichero.length);

                                for (int i = 0; i < contenidoFichero.length; i++) {
                                    out.writeByte(contenidoFichero[i]);
                                }


                            } else {
                                out.writeBoolean(false);
                            }
                            break;
                        case "exit":
                            salir = true;
                            break;
                    }
                }

            } else {

                out.writeBoolean(false);
            }
            
            sc.close();

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
