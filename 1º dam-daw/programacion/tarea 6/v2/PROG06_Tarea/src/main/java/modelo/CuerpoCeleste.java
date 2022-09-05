package modelo;

import java.io.Serializable;

/**
 * Clase que representa un cuerpo celeste
 * @author DRR
 */
public class CuerpoCeleste implements Serializable {

    private short codigoCuerpo;
    private String nombre;
    private String tipoObjeto;
    private int diametro;

    public CuerpoCeleste() { }
    
    public CuerpoCeleste(short codigoCuerpo, String nombre, String tipoObjeto, int diametro) {
        this.codigoCuerpo = codigoCuerpo;
        this.nombre = nombre;
        this.tipoObjeto = tipoObjeto;
        this.diametro = diametro;
    }

    public short getCodigoCuerpo() {
        return codigoCuerpo;
    }

    public void setCodigoCuerpo(short codigoCuerpo) {
        this.codigoCuerpo = codigoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" + "codigoCuerpo=" + codigoCuerpo + ", nombre=" + nombre + ", tipoObjeto=" + tipoObjeto + ", diametro=" + diametro + '}';
    }

}
