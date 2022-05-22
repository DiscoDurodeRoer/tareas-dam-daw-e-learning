
package tarea09;

import java.io.Serializable;

/**
 * Clase que representa a una persona
 */
public class Persona implements Imprimible, Serializable {

    private String nombre;
    private String apellidos;
    private String DNI;

    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String devolverInfoString() {
        return "nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI;
    }
    
}
