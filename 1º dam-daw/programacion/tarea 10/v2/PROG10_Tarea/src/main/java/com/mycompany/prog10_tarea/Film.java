package com.mycompany.prog10_tarea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Film implements Serializable {

    private String titulo;
    private String tituloOriginal;

    private ArrayList<Persona> directores;
    private ArrayList<Actor> actores;

    public Film(String titulo, String tituloOriginal) {
        this.titulo = titulo;
        this.tituloOriginal = tituloOriginal;
        this.directores = new ArrayList<>();
        this.actores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public ArrayList<Persona> getDirectores() {
        return directores;
    }

    public void setDirectores(ArrayList<Persona> directores) {
        this.directores = directores;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        return Objects.equals(this.titulo, other.titulo);
    }

    public void addActor(Actor actor) {
        this.actores.add(actor);
    }

    public void addDirector(Persona director) {
        this.directores.add(director);
    }

    public void removeActor(Actor actor) {
        this.actores.remove(actor);
    }

    public void removeDirector(Persona director) {
        this.directores.remove(director);
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + ", tituloOriginal=" + tituloOriginal + ", directores=" + directores + ", actores=" + actores;
    }

}
