package com.mycompany.tarea_psp_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tarea_PSP_6 {

    public static void main(String[] args) {
        try {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");

            String nombreUsuario;
            do {
                System.out.println("Introduce el nombre del usuario (8 letras minisculas)");
                nombreUsuario = sn.next().trim();

                if (!validarNombreUsuario(nombreUsuario)) {
                    System.out.println("Error, el nombre del usuario debe tener 8 letras minusculas");
                    escribirLog("Error, el nombre del usuario debe tener un formato válido: " + nombreUsuario);
                }

            } while (!validarNombreUsuario(nombreUsuario));

            escribirLog("Usuario ingresado correctamente " + nombreUsuario);

            String nombreFichero;
            do {
                System.out.println("Introduce el nombre del fichero (8 caracteres y 3 caracteres de extension)");
                nombreFichero = sn.next().trim();

                if (!validarNombreFichero(nombreFichero)) {
                    System.out.println("Error, el nombre del fichero debe tener 8 caracteres y 3 caracteres de extension");
                    escribirLog("Error, el nombre del fichero debe tener un formato válido: " + nombreFichero);
                }

            } while (!validarNombreFichero(nombreFichero));

            escribirLog("Fichero ingresado correctamente " + nombreFichero);

            leerFichero(nombreFichero);

        } catch (IOException ex) {
            Logger.getLogger(Tarea_PSP_6.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean validarNombreUsuario(String nombreUsuario) {
        return nombreUsuario.matches("[a-z]{8}");
    }

    public static boolean validarNombreFichero(String nombreFichero) {
        return nombreFichero.matches("[a-zA-Z0-9]{8}\\.[a-zA-Z0-9]{3}");
    }

    public static void leerFichero(String nombreFichero) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

    }

    private static void escribirLog(String mensaje) throws IOException {

        try (PrintWriter pw = new PrintWriter(new FileWriter("registro.log", true))) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatoFecha = LocalDateTime.now().format(formato);

            pw.println("[" + formatoFecha + "]" + mensaje);
        }

    }

}
