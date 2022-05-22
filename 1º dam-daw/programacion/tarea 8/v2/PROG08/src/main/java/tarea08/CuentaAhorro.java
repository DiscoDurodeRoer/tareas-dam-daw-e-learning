
package tarea08;

public class CuentaAhorro extends CuentaBancaria {
    
    private double tipoInteresAnual;

    public CuentaAhorro(double tipoInteresAnual, Persona titular, double saldo, String IBAN) {
        super(titular, saldo, IBAN);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }
    
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ", tipoInteresAnual=" + tipoInteresAnual;
    }
    
}
