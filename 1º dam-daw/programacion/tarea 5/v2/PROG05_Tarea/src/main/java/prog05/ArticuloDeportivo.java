package prog05;

public class ArticuloDeportivo {
    
    /* Atributos */
    private String codigoCiudad;
    private String codigoTienda;
    private String codigoArticulo;
    private int digitoControl;
    private String descripcion;
    private int unidades;

    /* Constructores */
    
    public ArticuloDeportivo() {
        this.codigoArticulo = "0";
        this.codigoTienda = "0";
        this.codigoArticulo = "0";
        this.digitoControl = 0;
        this.descripcion = "";
        this.unidades = 0;
    }

    public ArticuloDeportivo(String codigoCiudad, String codigoTienda, String codigoArticulo, String descripcion, int unidades) {
        this.codigoCiudad = codigoCiudad;
        this.codigoTienda = codigoTienda;
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.calcularDigitoControl();
    }
    
     public ArticuloDeportivo(ArticuloDeportivo copia) {
        this.codigoCiudad = copia.getCodigoCiudad();
        this.codigoTienda = copia.getCodigoTienda();
        this.codigoArticulo = copia.getCodigoArticulo();
        this.digitoControl = copia.getDigitoControl();
        this.descripcion = copia.getDescripcion();
        this.unidades = copia.getUnidades();
    }

    /* Getters and setters */
     
    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
        // recalculo el digito de control
        this.calcularDigitoControl();
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
        // recalculo el digito de control
        this.calcularDigitoControl();
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
        // recalculo el digito de control
        this.calcularDigitoControl();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getDigitoControl() {
        return digitoControl;
    }
    
    private void calcularDigitoControl(){
        
        // Convierto los codigos
        int ciudad = Integer.parseInt(this.codigoCiudad);
        int tienda = Integer.parseInt(this.codigoTienda);
        int articulo = Integer.parseInt(this.codigoArticulo);
        
        // Calculo el digito de control
        int suma = ciudad + tienda + articulo;
        this.digitoControl = suma % 99;
        
    }
    
    public void incrementarUnidades(int unidades){
        this.unidades += unidades;
    }
    
    public void decrementarUnidades(int unidades){
        // si nos quedamos en negativo, lo dejamos a 0
        if(this.unidades - unidades < 0){
            this.unidades = 0;
            System.out.println("Las unidades no puede ser negativo, se queda a 0");
        }else{
            this.unidades -= unidades;
        }
    }
    
    public String getCodigoCompleto(){
        return this.codigoCiudad + this.codigoTienda + this.codigoArticulo + this.digitoControl;
    }

    @Override
    public String toString() {
        return "ArticuloDeportivo{" + "codigoCiudad=" + codigoCiudad + ", codigoTienda=" + codigoTienda + ", codigoArticulo=" + codigoArticulo + ", digitoControl=" + digitoControl + ", descripcion=" + descripcion + ", unidades=" + unidades + '}';
    }
    
}
