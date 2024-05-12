package clases;

public class Artista extends Persona {

    private int numIntegrantes;
    private String estilo;
    private double cache;

    public Artista(int numIntegrantes, String estilo, double cache, int codigo, String nombre) {
        super(codigo, nombre);
        this.numIntegrantes = numIntegrantes;
        this.estilo = estilo;
        this.cache = cache;
    }

    public int getNumIntegrantes() {
        return numIntegrantes;
    }

    public void setNumIntegrantes(int numIntegrantes) {
        this.numIntegrantes = numIntegrantes;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return super.toString() + ", numIntegrantes=" + numIntegrantes + ", estilo=" + estilo + ", cache=" + cache;
    }

}
