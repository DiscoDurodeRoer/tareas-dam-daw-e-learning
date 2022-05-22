
package tarea09;

/**
 * Clase que representa una cuenta corriente de empresa, hereda de cuenta bancaria
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
    private double maximoDescubierto;
    private double tipoInteresDescubierto;
    private double comisiónFijaDescubierto;

    public CuentaCorrienteEmpresa(double maximoDescubierto, double tipoInteresDescubierto, double comisiónFijaDescubierto, String listaEntidades, Persona titular, double saldo, String IBAN) {
        super(listaEntidades, titular, saldo, IBAN);
        this.maximoDescubierto = maximoDescubierto;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.comisiónFijaDescubierto = comisiónFijaDescubierto;
    }

    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getComisiónFijaDescubierto() {
        return comisiónFijaDescubierto;
    }

    public void setComisiónFijaDescubierto(double comisiónFijaDescubierto) {
        this.comisiónFijaDescubierto = comisiónFijaDescubierto;
    }
    
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", maximoDescubierto=" + maximoDescubierto + ", tipoInteresDescubierto=" + tipoInteresDescubierto + ", comisionFijaDescubierto=" + comisiónFijaDescubierto;
    }

    
}
