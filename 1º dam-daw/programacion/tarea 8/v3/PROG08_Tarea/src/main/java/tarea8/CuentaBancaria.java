package tarea8;

public abstract class CuentaBancaria implements Imprimible, Comparable<CuentaBancaria> {

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
    public int compareTo(CuentaBancaria o){
        if(this.saldo > o.getSaldo()){
            return -1;
        }else if(this.saldo < o.getSaldo()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "titular=" + titular.devolverInfoString() + ", saldo=" + saldo + ", IBAN=" + IBAN;
    }
    
}
