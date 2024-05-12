package clases;

public class Persona implements Comparable<Persona> {

    private int codigo;
    private String nombre;

    public Persona(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Persona o) {
        if (this.getCodigo() > o.getCodigo()) {
            return 1;
        } else if (this.getCodigo() < o.getCodigo()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nombre=" + nombre;
    }

}
