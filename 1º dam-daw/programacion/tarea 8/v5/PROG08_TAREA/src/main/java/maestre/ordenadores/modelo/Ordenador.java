package maestre.ordenadores.modelo;

import java.util.Objects;
import maestre.general.interfaces.Reparable;

/**
 * Clase Ordenador, implementa la interfaz Reparable
 *
 * @author DiscoDurodeRoer
 */
public abstract class Ordenador implements Reparable {

    // Atributos
    private String numeroSerie;
    private String marca;
    private String modelo;
    private short RAM;
    private String procesador;
    private short nucleos;
    private TipoDiscoDuro tipoDisco;
    private boolean arrancado;

    // Constructores
    public Ordenador(String numeroSerie, String marca, String modelo, short RAM, String procesador, short nucleos, TipoDiscoDuro tipoDisco, boolean arrancado) throws Exception {
        // Controlando que se cumplan las condiciones
        if (this.numeroSerie != null && this.numeroSerie.length() > 20) {
            throw new Exception("El numero de serie no puede tener mas de 20 caracteres");
        }
        if (this.RAM > 999) {
            throw new Exception("La RAM no puede tener mas de 3 digitos");
        }
        if (this.nucleos > 99) {
            throw new Exception("Los nucleos no puede tener mas de 2 digitos");
        }
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.RAM = RAM;
        this.procesador = procesador;
        this.nucleos = nucleos;
        this.tipoDisco = tipoDisco;
        this.arrancado = arrancado;
    }

    public Ordenador() {
    }

    // Getters and setters
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public short getRAM() {
        return RAM;
    }

    public void setRAM(short RAM) {
        this.RAM = RAM;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public short getNucleos() {
        return nucleos;
    }

    public void setNucleos(short nucleos) {
        this.nucleos = nucleos;
    }

    public TipoDiscoDuro getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(TipoDiscoDuro tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    /**
     * Arranca el ordenador, solo si esta apagado
     */
    public void arrancar() {
        if (this.arrancado) {
            System.out.println("El ordenador esta ya arrancado");
        } else {
            System.out.println("El ordenador se esta arrancando");
            this.arrancado = true;
            System.out.println("El ordenador se ha arrancado");
        }
    }

    /**
     * Apaga el ordenador, solo si esta encendido
     */
    public void apagar() {
        if (!this.arrancado) {
            System.out.println("El ordenador esta ya apagado");
        } else {
            System.out.println("El ordenador se esta apagando");
            this.arrancado = false;
            System.out.println("El ordenador se ha apagado");
        }
    }

    /**
     * Metodo abstracto para que se implemente en las clases hijas
     */
    public abstract void dibujar();

    @Override
    public String toString() {
        return "numeroSerie=" + numeroSerie + ", marca=" + marca + ", modelo=" + modelo + ", RAM=" + RAM + ", procesador=" + procesador + ", nucleos=" + nucleos + ", tipoDisco=" + tipoDisco + ", arrancado=" + arrancado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordenador other = (Ordenador) obj;
        if (!Objects.equals(this.numeroSerie, other.numeroSerie)) {
            return false;
        }
        return true;
    }

}
