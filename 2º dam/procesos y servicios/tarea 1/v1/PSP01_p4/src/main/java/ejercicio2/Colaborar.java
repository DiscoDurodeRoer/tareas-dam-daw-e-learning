package ejercicio2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Colaborar {

    public static void main(String[] args) {

        if (args.length == 1) {
            try {
                for (int i = 1; i <= 10; i++) {

                    System.out.println("Lanzado el proceso: " + i);

                    String comando = "java -jar lenguaje.jar " + (i * 10) + " " + args[0];
                    System.out.println("Comando lanzado " + comando);

                    Runtime.getRuntime().exec(comando);

                }
            } catch(SecurityException ex){
                System.out.println("Problema seguridad: " + ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Debe tener 1 parametro");
        }

    }

}
