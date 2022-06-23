package tarea8;

import java.util.ArrayList;
import java.util.Collections;

public class Banco {

    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public boolean abrirCuenta(CuentaBancaria b) {

        CuentaBancaria existe = this.buscarCuenta(b.getIBAN());
        if (existe != null) {
            System.out.println("La cuenta bancaria ya existe");
            return false;
        }

        this.cuentas.add(b);

        System.out.println("La cuenta bancaria se ha insertado correctamente");
        return true;

    }

    public void listadoCuentas() {
        for (CuentaBancaria c : this.cuentas) {
            System.out.println(c.devolverInfoString());
        }
    }

    public String informacionCuenta(String IBAN) {
        CuentaBancaria b = this.buscarCuenta(IBAN);
        if (b != null) {
            return b.devolverInfoString();
        }
        return null;
    }

    public boolean ingresoCuenta(String IBAN, double cantidad) {
        CuentaBancaria b = this.buscarCuenta(IBAN);
        if (b != null) {
            b.setSaldo(b.getSaldo() + cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String IBAN, double cantidad) {
        CuentaBancaria b = this.buscarCuenta(IBAN);
        if (b != null) {

            boolean sePuedeRetirar = false;

            if (b.getSaldo() - cantidad > 0) {
                sePuedeRetirar = true;
            } else if (b instanceof CuentaCorrienteEmpresa) {
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa) b;
                if (Math.abs(aux.getSaldo() - cantidad) < aux.getMaxdescubierto()) {
                    sePuedeRetirar = true;
                }
            }

            if (sePuedeRetirar) {
                b.setSaldo(b.getSaldo() - cantidad);
                return true;
            }
            return false;
        }
        return false;
    }

    public double obtenerSaldo(String IBAN) {
        CuentaBancaria b = this.buscarCuenta(IBAN);
        if (b != null) {
            return b.getSaldo();
        }
        return -1;
    }

    public boolean eliminarCuenta(String IBAN) {

        CuentaBancaria b = this.buscarCuenta(IBAN);
        if (b != null) {
            if (b.getSaldo() == 0) {
                this.cuentas.remove(b);
                return true;
            }
        }
        return false;
    }

    public int numcuentaAhorro() {
        int numCuentas = 0;
        for (CuentaBancaria c : this.cuentas) {
            if (c instanceof CuentaAhorro) {
                numCuentas++;
            }
        }
        return numCuentas;

    }

    public double saldoAcumuladoCuentaCorriente(double comisionMantenimiento) {

        double saldoAcumulado = 0;
        for (CuentaBancaria c : this.cuentas) {
            if (c instanceof CuentaCorrientePersonal) {
                CuentaCorrientePersonal aux = (CuentaCorrientePersonal)c;
                if(aux.getComisionMantenimiento() > comisionMantenimiento){
                    saldoAcumulado += c.getSaldo();
                }
            }
        }
        return saldoAcumulado;

    }
    
    public void top3Cuentas(){
        
        ArrayList<CuentaBancaria> copia = (ArrayList<CuentaBancaria>) this.cuentas.clone();
        
        Collections.sort(copia);
        
        for (int i = 0; i < 3; i++) {
            System.out.println(copia.get(i).getTitular().devolverInfoString());
        }
        
    }

    private CuentaBancaria buscarCuenta(String IBAN) {
        CuentaBancaria b = null;
        for (CuentaBancaria c : this.cuentas) {
            if (c.getIBAN().equals(IBAN)) {
                return c;
            }
        }
        return null;
    }

}
