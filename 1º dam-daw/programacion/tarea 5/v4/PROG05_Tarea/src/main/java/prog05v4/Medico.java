package prog05v4;

/**
 * Clase Medico
 * @author DiscoDuroderoer
 */
public class Medico {
            
    // Atributos
    private String codigo;
    private String nombre;
    private String dni;
    private Especialidad especialidad;

    // Constructores
    public Medico(String codigo, String nombre, String dni, Especialidad especialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
    }

    public Medico() {
    }

    // getters and setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" + "codigo=" + codigo + ", nombre=" + nombre + ", dni=" + dni + ", especialidad=" + especialidad + '}';
    }

}
