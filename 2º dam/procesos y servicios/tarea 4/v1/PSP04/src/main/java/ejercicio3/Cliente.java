package ejercicio3;

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
            Socket sc = new Socket("localhost", 1500);

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");

            String mensaje = in.readUTF().trim();
            System.out.println(mensaje);
            String usuario = sn.next();
            out.writeUTF(usuario);

            mensaje = in.readUTF().trim();
            System.out.println(mensaje);
            String password = sn.next();
            out.writeUTF(password);

            boolean exito = in.readBoolean();

            if (exito) {

                boolean salir = false;

                while (!salir) {

                    mensaje = in.readUTF().trim();
                    System.out.println(mensaje);
                    String comando = sn.next();
                    out.writeUTF(comando);

                    switch (comando) {
                        case "ls":
                            int numFiles = in.readInt();
                            for (int i = 0; i < numFiles; i++) {
                                String nombreFichero = in.readUTF().trim();
                                System.out.println(nombreFichero);
                            }
                            break;
                        case "get":
                            System.out.println("Introduce la ruta del archivo a mostrar");
                            String ruta = sn.next();

                            out.writeUTF(ruta);

                            boolean existe = in.readBoolean();

                            if (existe) {

                                int longitud = in.readInt();

                                byte[] contenido = new byte[longitud];

                                for (int i = 0; i < longitud; i++) {
                                    contenido[i] = in.readByte();
                                }

                                String contenidoFichero = new String(contenido);

                                System.out.println(contenidoFichero);

                            } else {
                                System.out.println("Error, no existe el fichero");
                            }
                            break;
                        case "exit":
                            salir = true;
                            break;
                    }

                }

            } else {
                System.out.println("Usuario o password incorrectos");
            }

            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
