package com.mycompany.prog10_tarea;

public class Actor extends Persona {
    
    private String personaje;

    public Actor(String personaje, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", personaje=" + personaje;
    }
    
}
