package maestre.electrodomesticos;

import maestre.general.interfaces.Reparable;

public class Aspirador implements Reparable {

    private int potencia;

    public Aspirador(int potencia) {
        this.potencia = potencia;
    }

    public Aspirador() {
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    @Override
    public void reparar() {
        System.out.println("El aspirador se esta reparando");
        System.out.println("++++");
        System.out.println("++++++++++++++");
        System.out.println("+++++++++++++++++++++++");
        System.out.println("El aspirador se ha reparado");
    }

}
