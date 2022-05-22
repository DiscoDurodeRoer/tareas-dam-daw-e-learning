package tarea_3_dam_daw_elearning;

public class Articulo {

    private String codigo_barra;
    private String denominacion;
    private int unidades;
    private double precio_compra;
    private int beneficio; // valor entre 0-100
    private double pvp;

    public Articulo() {
    }

    public Articulo(String codigo_barra, String denominacion, int unidades, double precio_compra, int beneficio) {
        this.codigo_barra = codigo_barra;
        this.denominacion = denominacion;
        this.unidades = unidades;
        this.precio_compra = precio_compra;
        this.beneficio = beneficio;
        this.calcularPVP();
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getCodigo_barra() {
        return this.codigo_barra;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
        this.calcularPVP();
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
        this.calcularPVP();
    }

    public double getPvp() {
        return pvp;
    }

    public void calcularPVP() {
        pvp = precio_compra + ((precio_compra * beneficio) / 100);
    }

}
