package tarea08;

import java.util.ArrayList;

public class Banco {

    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public boolean abrirCuenta(CuentaBancaria c) {

        CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
        if (existe != null) {
            System.out.println("Ya existe la cuenta bancaria");
            return false;
        }

        this.cuentas.add(c);
        return true;

    }

    public String[] listadoCuentas() {
        String[] infoCuentas = new String[this.cuentas.size()];
        for (int i = 0; i < infoCuentas.length; i++) {
            infoCuentas[i] = this.cuentas.get(i).devolverInfoString();
        }
        return infoCuentas;
    }

    public String informacionCuenta(String IBAN) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.devolverInfoString();
        }
        return null;
    }

    public boolean ingresoCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {

            boolean sePuedeRetirar = false;
            
            if (c.getSaldo() - cantidad >= 0) {
                sePuedeRetirar = true;
            }else if(c instanceof CuentaCorrienteEmpresa){
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)c;
                if(Math.abs(c.getSaldo() - cantidad) <= aux.getMaximoDescubierto()){
                    sePuedeRetirar = true;
                }
            }
            
            if(sePuedeRetirar){
                c.setSaldo(c.getSaldo() - cantidad);
            }
            
            return sePuedeRetirar;

        }
        return false;
    }

    public double obtenerSaldo(String IBAN) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.getSaldo();
        }
        return -1;
    }
    
    public boolean eliminarCuenta(String IBAN){
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if(c != null){
            for (CuentaBancaria cAux: this.cuentas) {
                if(cAux.getIBAN().equals(IBAN) && cAux.getSaldo() == 0){
                    this.cuentas.remove(cAux);
                    return true;
                }
            }
        }
        return false;
    }

    private CuentaBancaria buscarCuenta(String IBAN) {
        for (CuentaBancaria c: this.cuentas) {
            if (c.getIBAN().equals(IBAN)) {
                return c;
            }
        }
        return null;
    }

}
