package maestre.ordenadores.modelo;

/**
 * Clase Portatil, hereda de Ordenador e implementa la interfaz Comparable
 * @author DiscoDurodeRoer
 */
public class Portatil extends Ordenador implements Comparable<Portatil> {

    // Atributos
    private short pulgadas;
    private int minutosBateria;

    // Constructores
    public Portatil(short pulgadas, int minutosBateria, String numeroSerie, String marca, String modelo, short RAM, String procesador, short nucleos, TipoDiscoDuro tipoDisco, boolean arrancado) throws Exception {
        super(numeroSerie, marca, modelo, RAM, procesador, nucleos, tipoDisco, arrancado);
        // Controlando que se cumplan las condiciones
        if (this.pulgadas > 99) {
            throw new Exception("Las pulgadas no puede tener mas de 2 digitos");
        }
        this.pulgadas = pulgadas;
        this.minutosBateria = minutosBateria;
    }

    public Portatil() {
    }

    // Getters and setters
    public short getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(short pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getMinutosBateria() {
        return minutosBateria;
    }

    public void setMinutosBateria(int minutosBateria) {
        this.minutosBateria = minutosBateria;
    }

    /**
     * Recarga la bateria del portatil, maximo 300
     *
     * @param minutos
     */
    public void cargar(int minutos) {
        if (this.minutosBateria + minutos > 300) {
            this.minutosBateria = 300;
        } else {
            this.minutosBateria += minutos;
        }
    }

    /**
     * Descarga la bateria del portatil, 
     * el numero de minutos de bateria no puede ser negativo.
     *
     * @param minutos
     */
    public void descargar(int minutos) {
        if (this.minutosBateria - minutos < 0) {
            this.minutosBateria = 0;
        } else {
            this.minutosBateria -= minutos;
        }
    }

    @Override
    public void dibujar() {
        System.out.println(this.toString());
        // Comprobamos si esta arrancado
        if (super.isArrancado()) {
            // Una linea por nucleo
            for (int i = 0; i < super.getNucleos(); i++) {
                // Un asterisco por GB de RAM
                for (int j = 0; j < super.getRAM(); j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        } else {
            System.out.println("El portatil esta apagado");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", pulgadas=" + pulgadas + ", minutosBateria=" + minutosBateria;
    }

    @Override
    public void reparar() {
        System.out.println("El portatil se esta reparando");
        System.out.println("****");
        System.out.println("*************");
        System.out.println("***********************");
        System.out.println("El portatil se ha reparado");
    }

    @Override
    public int compareTo(Portatil arg0) {
        // Mayor
        if (this.pulgadas > arg0.getPulgadas()) {
            return -1;
        // Igual
        } else if (this.pulgadas == arg0.getPulgadas()) {
            return 0;
        // Menor
        } else {
            return 1;
        }
    }

}
