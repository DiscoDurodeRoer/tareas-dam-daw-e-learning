package clases;

import java.time.LocalDate;

public class Asistente extends Persona {

    private String dni;
    private LocalDate fechaNacimiento;

    public Asistente(String dni, LocalDate fechaNacimiento, int codigo, String nombre) {
        super(codigo, nombre);
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return super.toString() + ",dni=" + dni + ", fechaNacimiento=" + fechaNacimiento;
    }

}
