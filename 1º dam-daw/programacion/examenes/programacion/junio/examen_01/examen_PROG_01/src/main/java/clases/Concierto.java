package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concierto implements Comparable<Concierto> {

    private String nombre;
    private LocalDate fecha;
    private Artista artista;
    private String estilo;
    private ArrayList<Asistente> asistentes;

    public Concierto(String nombre, LocalDate fecha, Artista artista, String estilo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.artista = artista;
        this.estilo = estilo;
        this.asistentes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public ArrayList<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(ArrayList<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public void aniadirAsistente(Asistente asistente) {
        this.asistentes.add(asistente);
    }

    @Override
    public int compareTo(Concierto o) {
        return this.fecha.compareTo(o.getFecha());
    }

    @Override
    public String toString() {
        return "Concierto{" + "nombre=" + nombre + ", fecha=" + fecha + ", artista=" + artista + ", estilo=" + estilo + ", asistentes=" + asistentes + '}';
    }

}
