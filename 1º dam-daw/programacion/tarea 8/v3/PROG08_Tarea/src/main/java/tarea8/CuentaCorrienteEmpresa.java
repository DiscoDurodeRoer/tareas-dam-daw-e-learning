package tarea8;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
    private double comisionFijaDescubierto;
    private double tipoInteresDescubierto;
    private double maxdescubierto;

    public CuentaCorrienteEmpresa(double comisionFijaDescubierto, double tipoInteresDescubierto, double maxdescubierto, String listaEntidades, Persona titular, double saldo, String IBAN) {
        super(listaEntidades, titular, saldo, IBAN);
        this.comisionFijaDescubierto = comisionFijaDescubierto;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maxdescubierto = maxdescubierto;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getMaxdescubierto() {
        return maxdescubierto;
    }

    public void setMaxdescubierto(double maxdescubierto) {
        this.maxdescubierto = maxdescubierto;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    @Override
    public String devolverInfoString() {
        return super.toString() + ", tipoInteresDescubierto=" + tipoInteresDescubierto + ", maxdescubierto=" + maxdescubierto;
    }
    
}
