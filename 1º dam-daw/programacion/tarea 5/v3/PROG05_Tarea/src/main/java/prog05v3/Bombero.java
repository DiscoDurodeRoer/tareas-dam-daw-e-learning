package prog05v3;

import java.time.LocalDate;
/**
 * Clase Bombero, hereda de funcionario
 */
public class Bombero extends Funcionario {

    private Puesto puesto;
    private String parque;
    // Numero de bomberos creados
    private static int numBomberos = 0;

    public Bombero() {
    }

    public Bombero(Puesto puesto, String parque, String nombre, String apellidos, int edad, LocalDate fechaIngreso) {
        super(nombre, apellidos, edad, fechaIngreso);
        this.puesto = puesto;
        this.parque = parque;
        // Numero de bomberos creados
        Bombero.numBomberos++;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getParque() {
        return parque;
    }

    public void setParque(String parque) {
        this.parque = parque;
    }

    public static int getNumBomberos() {
        return numBomberos;
    }

    /**
     * Calcula la antiguedad
     */
    public void calculoAntiguedad() {

        int anios = this.calcularAnios();

        if (anios >= 1 && anios < 5) {
            this.puesto.setSueldo(this.puesto.getSueldo() * 1.01);
        } else if (anios >= 5 && anios < 10) {
            this.puesto.setSueldo(this.puesto.getSueldo() * 1.05);
        } else if (anios >= 10) {
            this.puesto.setSueldo(this.puesto.getSueldo() * 1.1);
        }

    }

    /**
     * Indica la diferencia de años entre un dia concreto y la fecha actual
     * Hecho con LocalDate
     *
     * @return años de diferencia
     */
    private int calcularAnios() {

        //Fecha actual
        LocalDate actual = LocalDate.now();

        //Cojo los datos necesarios        
        int diaActual = actual.getDayOfMonth();
        int mesActual = actual.getMonthValue();
        int anioActual = actual.getYear();

        //Diferencia de años
        int diferencia = anioActual - super.getFechaIngreso().getYear();

        //Si el mes actual es menor que el que me pasan le resto 1
        //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
        //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
        if (mesActual <= super.getFechaIngreso().getMonthValue()) {
            //si
            if (mesActual == super.getFechaIngreso().getMonthValue()) {
                if (super.getFechaIngreso().getDayOfMonth() > diaActual) {
                    diferencia--;
                }
            } else {
                diferencia--;
            }
        }

        return diferencia;

    }

    /**
     * Devuelve la información
     * @return info getInfo
     */
    @Override
    public String getInfo() {
        return super.getInfo() + " En el puesto " + this.puesto.getNombrePuesto() + " y en el parque " + this.getParque();
    }

}
