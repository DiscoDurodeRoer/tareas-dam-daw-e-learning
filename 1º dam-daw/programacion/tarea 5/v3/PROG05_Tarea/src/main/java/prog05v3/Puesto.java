
package prog05v3;

/**
 * Clase Puesto
 */
public class Puesto {
    
    private String nombrePuesto;
    private String descripcionPuesto;
    private CategoriaPuesto categoria;
    private double sueldo;

    public Puesto(String nombrePuesto, String descripcionPuesto, CategoriaPuesto categoria) {
        this.nombrePuesto = nombrePuesto;
        this.descripcionPuesto = descripcionPuesto;
        this.categoria = categoria;
        this.establecerSueldo();
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    public CategoriaPuesto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPuesto categoria) {
        this.categoria = categoria;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    /**
     * Calcula el sueldo segun la categoria
     * - PEON = 1500
     * - CABO = 1800
     * - ESPECIALISTA = 2000
     */
    private void establecerSueldo(){
        switch(this.categoria){
            case PEON:
                this.sueldo = 1500;
                break;
            case CABO:
                this.sueldo = 1800;
                break;
            case ESPECIALISTA:
                this.sueldo = 2000;
                break;
        }
    }
    
    
}
