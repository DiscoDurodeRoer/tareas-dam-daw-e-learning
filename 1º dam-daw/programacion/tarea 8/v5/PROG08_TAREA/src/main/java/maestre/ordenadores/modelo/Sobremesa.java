package maestre.ordenadores.modelo;

/**
 * Clase Sobremesa, hereda de Ordenador e implementa la interfaz Comparable
 *
 * @author DiscoDurodeRoer
 */
public class Sobremesa extends Ordenador {

    // Atributos
    private String placaBase;
    private String tarjetaGrafica;

    // Constructores
    public Sobremesa(String placaBase, String tarjetaGrafica, String numeroSerie, String marca, String modelo, short RAM, String procesador, short nucleos, TipoDiscoDuro tipoDisco, boolean arrancado) throws Exception {
        super(numeroSerie, marca, modelo, RAM, procesador, nucleos, tipoDisco, arrancado);
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public Sobremesa() {
    }

    // Getters and setters
    public String getPlacaBase() {
        return placaBase;
    }

    public void setPlacaBase(String placaBase) {
        this.placaBase = placaBase;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
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
            System.out.println("El sobremesa esta apagado");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", placaBase=" + placaBase + ", tarjetaGrafica=" + tarjetaGrafica;
    }

    @Override
    public void reparar() {
        System.out.println("El sobremesa se esta reparando");
        System.out.println("****");
        System.out.println("*************");
        System.out.println("***********************");
        System.out.println("El sobremesa se ha reparado");
    }

}
