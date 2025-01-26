/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaquetePrincipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloPeticion implements Runnable {

    private Socket socketCliente;

    public HiloPeticion(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    public void run() {
        try (
                InputStreamReader inSR = new InputStreamReader(socketCliente.getInputStream()); PrintWriter printWriter = new PrintWriter(socketCliente.getOutputStream(), true); BufferedReader bufLeer = new BufferedReader(inSR);) {
            System.out.println("Atendiendo al cliente ");
            //variables locales
            String peticion;
            String html;

            //mensaje petición cliente
            peticion = bufLeer.readLine();
            //para compactar la petición y facilitar así su análisis, suprimimos todos
            //los espacios en blanco que contenga
            peticion = peticion.replaceAll(" ", "");
            //si realmente se trata de una petición 'GET' (que es la única que vamos a
            //implementar en nuestro Servidor)
            if (peticion.startsWith("GET")) {
                //extrae la subcadena entre 'GET' y 'HTTP/1.1'
                peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

                //si corresponde a la página de inicio
                if (peticion.length() == 0 || peticion.equals("/")) {
                    //sirve la página
                    html = Paginas.html_index;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length());
                    printWriter.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                    printWriter.println("\n");
                    printWriter.println(html);
                } //si corresponde a la página del Quijote
                else if (peticion.equals("/quijote")) {
                    //sirve la página
                    html = Paginas.html_quijote;
                    printWriter.println(Mensajes.lineaInicial_OK);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length());
                    printWriter.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                    printWriter.println("\n");
                    printWriter.println(html);
                } //en cualquier otro caso
                else {
                    //sirve la página
                    html = Paginas.html_noEncontrado;
                    printWriter.println(Mensajes.lineaInicial_NotFound);
                    printWriter.println(Paginas.primeraCabecera);
                    printWriter.println("Content-Length: " + html.length());
                    printWriter.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                    printWriter.println("\n");
                    printWriter.println(html);
                }

            }
            System.out.println("cliente atendido");
        } catch (IOException ex) {
            Logger.getLogger(HiloPeticion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.socketCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloPeticion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
