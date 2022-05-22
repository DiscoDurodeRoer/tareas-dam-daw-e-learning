
package tarea09;

/**
 * Clase que representa una cuenta corriente personal, hereda de cuenta bancaria
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    private double comisionMantenimiento;

    public CuentaCorrientePersonal(double comisionMantenimiento, String listaEntidades, Persona titular, double saldo, String IBAN) {
        super(listaEntidades, titular, saldo, IBAN);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", comisionMantenimiento=" + comisionMantenimiento;
    }
    
}
