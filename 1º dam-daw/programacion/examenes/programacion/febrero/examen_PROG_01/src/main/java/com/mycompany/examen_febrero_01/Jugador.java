package com.mycompany.examen_febrero_01;

import java.util.Objects;

public class Jugador {

    private String nombre;
    private String apellidos;
    private int dorsal;
    private Equipo equipo;
    private int vecesMejorPartido;

    private int partidos;
    private double kmsRecorridos;
    private double mediaKm;

    public Jugador(String nombre, String apellidos, int dorsal, Equipo equipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.mediaKm = 0;
        this.partidos = 0;
        this.vecesMejorPartido = 0;
        this.kmsRecorridos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getVecesMejorPartido() {
        return vecesMejorPartido;
    }

    public double getMediaKm() {
        return mediaKm;
    }

    public void elegidoMejorPartido() {
        this.vecesMejorPartido++;
    }

    public void anidirKm(double km) {
        this.kmsRecorridos += km;
        this.partidos++;
        this.mediaKm = this.kmsRecorridos / this.partidos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.dorsal;
        hash = 37 * hash + Objects.hashCode(this.equipo);
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
        final Jugador other = (Jugador) obj;
        if (this.dorsal != other.dorsal) {
            return false;
        }
        return Objects.equals(this.equipo, other.equipo);
    }

    @Override
    public String toString() {
        return this.equipo.getNombre() + " | " + this.nombre + " | " + this.apellidos + " | " + this.mediaKm + " | " + this.vecesMejorPartido;
    }

}
