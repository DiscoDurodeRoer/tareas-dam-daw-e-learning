package clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class GestionConciertos {

    private ArrayList<Concierto> conciertos;
    private ArrayList<Persona> personas;

    public GestionConciertos() {
        this.conciertos = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public void ordenarConciertos() {
        Collections.sort(this.conciertos);
    }

    public void ordenarPersonas() {
        Collections.sort(this.personas);
    }

    public void listarConciertos() {
        for (Concierto concierto : conciertos) {
            System.out.println(concierto);
        }
    }

    public void listarArtistas() {
        for (Persona persona : personas) {
            if (persona instanceof Artista) {
                System.out.println(persona);
            }
        }
    }

    public void listarAsistentes() {
        for (Persona persona : personas) {
            if (persona instanceof Asistente) {
                System.out.println(persona);
            }
        }
    }

    public void aniadirArtista(int numIntegrantes, String estilo, double cache, int codigo, String nombre) {

        Artista artista = new Artista(numIntegrantes, estilo, cache, codigo, nombre);

        this.personas.add(artista);

        this.ordenarPersonas();

        System.out.println("El artista " + codigo + " ha sido añadido");
    }

    public void aniadirAsistente(String dni, LocalDate fechaNacimiento, int codigo, String nombre) {
        Asistente asistente = new Asistente(dni, fechaNacimiento, codigo, nombre);

        this.personas.add(asistente);

        this.ordenarPersonas();

        System.out.println("El asistente " + codigo + " ha sido añadido");
    }

    public void aniadirConcierto(String nombre, LocalDate fecha, int codigoArtista, String estilo) {

        Artista artista = buscarArtista(codigoArtista);

        if (artista != null) {

            if (artista.getEstilo().equalsIgnoreCase(estilo)) {

                Concierto concierto = new Concierto(nombre, fecha, artista, estilo);

                this.conciertos.add(concierto);

                this.ordenarConciertos();

                System.out.println("El concierto se ha añadido");
            } else {
                System.out.println("El estilo no coincide");
            }

        } else {
            System.out.println("El artista no existe");
        }

    }

    public void listarConciertosByEstilo(String estilo) {
        for (Concierto concierto : conciertos) {
            if (concierto.getEstilo().equalsIgnoreCase(estilo)) {
                System.out.println(concierto);
            }
        }
    }

    public void listarConciertosByArtista(int codigoArtista) {
        for (Concierto concierto : conciertos) {
            if (concierto.getArtista().getCodigo() == codigoArtista) {
                System.out.println(concierto);
            }
        }
    }

    public void aniadirAsistenteConcierto(String nombreConcierto, int codigoAsistente) {
        Concierto concierto = buscarConcierto(nombreConcierto);

        if (concierto != null) {

            Asistente asistente = buscarAsistente(codigoAsistente);
            if (asistente != null) {
                concierto.aniadirAsistente(asistente);

                System.out.println("Se ha añadido el asistente " + codigoAsistente + " al concierto " + nombreConcierto);
            } else {
                System.out.println("No existe el asistente");
            }
        } else {
            System.out.println("No existe el concierto");
        }

    }

    public int numConciertosAsistente(int codigoAsistente) {

        int contador = 0;

        for (Concierto concierto : conciertos) {
            for (Asistente asistente : concierto.getAsistentes()) {
                if (asistente.getCodigo() == codigoAsistente) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public void guardarDatos(String fichero) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

            bw.write("Concierto \r\n");
            for (Concierto concierto : conciertos) {
                bw.write(concierto.toString() + "\r\n");
            }

            bw.write("Asistentes \r\n");
            for (Persona persona : personas) {
                if (persona instanceof Asistente) {
                    bw.write(persona.toString() + "\r\n");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private Artista buscarArtista(int codigo) {
        for (Persona persona : personas) {
            if (persona instanceof Artista && persona.getCodigo() == codigo) {
                return (Artista) persona;
            }
        }
        return null;
    }

    private Asistente buscarAsistente(int codigo) {
        for (Persona persona : personas) {
            if (persona instanceof Asistente && persona.getCodigo() == codigo) {
                return (Asistente) persona;
            }
        }
        return null;
    }

    private Concierto buscarConcierto(String nombreConcierto) {
        for (Concierto concierto : conciertos) {
            if (concierto.getNombre().equalsIgnoreCase(nombreConcierto)) {
                return concierto;
            }
        }
        return null;
    }

}
