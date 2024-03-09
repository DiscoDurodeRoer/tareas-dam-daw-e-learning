package com.mycompany.examen_febrero_01;

import java.util.Objects;

public class Equipo {
    
    private String nombre;
    private int division;

    public Equipo(String nombre, int division) {
        this.nombre = nombre;
        this.division = division;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDivision() {
        return division;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nombre);
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
        final Equipo other = (Equipo) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
    
}
