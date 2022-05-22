package tarea09;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar cuentas bancarias
 */
public class Banco {

    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    /**
     * Abre una cuenta y la añade a nuestra lista
     * @param c
     * @return 
     */
    public boolean abrirCuenta(CuentaBancaria c) {

        // Buscamos si existe
        CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
        // Sino existe, devolvemos false
        if (existe != null) {
            System.out.println("Ya existe la cuenta bancaria");
            return false;
        }

        // Añadimos la cuenta
        this.cuentas.add(c);
        return true;

    }

    /**
     * Mostramos las cuentas
     * @return 
     */
    public String[] listadoCuentas() {
        // Creo un arrays con el numero de cuentas
        String[] infoCuentas = new String[this.cuentas.size()];
        for (int i = 0; i < infoCuentas.length; i++) {
            // Obtengo la info de la cuenta
            infoCuentas[i] = this.cuentas.get(i).devolverInfoString();
        }
        return infoCuentas;
    }

    /**
     * Devolvemos la informacion de la cuenta
     * @param IBAN
     * @return 
     */
    public String informacionCuenta(String IBAN) {

        // Buscamos si existe
        CuentaBancaria c = this.buscarCuenta(IBAN);
        // Si existe devolvemos la informacion de la cuenta
        if (c != null) {
            return c.devolverInfoString();
        }
        return null;
    }

    /**
     * Ingresamos una cantidad a una cuenta concreta
     * @param IBAN
     * @param cantidad
     * @return 
     */
    public boolean ingresoCuenta(String IBAN, double cantidad) {

        // Buscamos si existe
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            // Sumamos el saldo
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }
        return false;
    }

    /**
     * Retiramos saldo de la cuenta
     * @param IBAN
     * @param cantidad
     * @return 
     */
    public boolean retiradaCuenta(String IBAN, double cantidad) {

        // Buscamos si existe
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {

            boolean sePuedeRetirar = false;
            
            // Si tiene saldo, puede retirar
            if (c.getSaldo() - cantidad >= 0) {
                sePuedeRetirar = true;
            // Si es de tipo CuentaCorrienteEmpresa
            }else if(c instanceof CuentaCorrienteEmpresa){
                // Si es mayor que el maximo descubierto
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)c;
                if(Math.abs(c.getSaldo() - cantidad) <= aux.getMaximoDescubierto()){
                    sePuedeRetirar = true;
                }
            }
            
            // Si se puede retirar resto la cantidad
            if(sePuedeRetirar){
                c.setSaldo(c.getSaldo() - cantidad);
            }
            
            return sePuedeRetirar;

        }
        return false;
    }

    /**
     * Obtiene el saldo de la cuenta
     * @param IBAN
     * @return 
     */
    public double obtenerSaldo(String IBAN) {
        // Buscamos si existe
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.getSaldo();
        }
        return -1;
    }
    
    /**
     * Elimina la cuenta del IBAN
     * @param IBAN
     * @return 
     */
    public boolean eliminarCuenta(String IBAN){
        // Buscamos si existe
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if(c != null){
            for (CuentaBancaria cAux: this.cuentas) {
                // si es de ese IBAN y el saldo es igual a 0
                if(cAux.getIBAN().equals(IBAN) && cAux.getSaldo() == 0){
                    this.cuentas.remove(cAux);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Busca la cuenta por su IBAN
     * @param IBAN
     * @return 
     */
    private CuentaBancaria buscarCuenta(String IBAN) {
        for (CuentaBancaria c: this.cuentas) {
            if (c.getIBAN().equals(IBAN)) {
                return c;
            }
        }
        return null;
    }
    
    /**
     * Guarda las cuentas en un fichero binario
     */
    public void guardarCuentas(){
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datoscuentasbancarias.dat"))) {
            
            // Guardo cada cuenta
            for (CuentaBancaria cuenta : cuentas) {
                oos.writeObject(cuenta);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }
    
    /**
     * Recupero las cuentas del fichero binario
     */
    public void recuperarCuentas(){
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datoscuentasbancarias.dat"))) {
           
            // Cuando me quede sin cuentas, salta la excepcion EOFException
            while(true){
                CuentaBancaria cuenta = (CuentaBancaria)ois.readObject();
                this.abrirCuenta(cuenta);
            }
           
        } catch (FileNotFoundException ex) {
            System.out.println("No hay fichero");
        } catch (EOFException ex) {
            System.out.println("Cuentas añadidas del fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }
    
    /**
     * Genera un txt con la informacion de las cuentas
     */
    public void generarListado(){
        
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("ListadoClientesCCC.txt"));) {
           
            String linea;
            // Recorro cada cuenta
            for (CuentaBancaria cuenta : cuentas) {
                linea = cuenta.getTitular().devolverInfoString() + " " + cuenta.getIBAN() + "\r\n";
                bw.write(linea);
            }
            bw.write("Num cuentas: " + cuentas.size());
        } catch (IOException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
