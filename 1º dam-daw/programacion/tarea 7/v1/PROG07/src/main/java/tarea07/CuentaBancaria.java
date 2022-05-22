
package tarea07;

public abstract class CuentaBancaria implements Imprimible {
    
    private Persona titular;
    private double saldo;
    private String IBAN;

    public CuentaBancaria(Persona titular, double saldo, String IBAN) {
        this.titular = titular;
        this.saldo = saldo;
        this.IBAN = IBAN;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    
    @Override
    public String devolverInfoString(){
        return "titular=" + titular.devolverInfoString() + ", saldo=" + saldo + ", IBAN=" + IBAN;
    }

}
