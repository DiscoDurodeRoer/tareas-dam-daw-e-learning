package prog05v4;

/**
 * Clase Paciente
 * @author DiscoDuroderoer
 */
public class Paciente {
    
    // Atributos
    private String codigo;
    private String nombre;
    private String apellido;

    // Constructores
    public Paciente(String codigo, String nombre, String apellido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Paciente() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
