package com.mycompany.prog06;

import java.io.Serializable;

public class Alumno implements Serializable {

    private String NIF;
    private String nombre;
    private int telefono;
    private String direccion;
    private double notaMedia;

    public Alumno(String NIF, String nombre, int telefono, String direccion, double notaMedia) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.notaMedia = notaMedia;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "Alumno{" + "NIF=" + NIF + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", notaMedia=" + notaMedia + '}';
    }

}
