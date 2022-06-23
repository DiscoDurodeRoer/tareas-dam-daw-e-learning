package tarea8;

public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteres;

    public CuentaAhorro(double tipoInteres, Persona titular, double saldo, String IBAN) {
        super(titular, saldo, IBAN);
        this.tipoInteres = tipoInteres;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String devolverInfoString() {
        return super.toString() + ", tipoInteres=" + tipoInteres;
    }

}
