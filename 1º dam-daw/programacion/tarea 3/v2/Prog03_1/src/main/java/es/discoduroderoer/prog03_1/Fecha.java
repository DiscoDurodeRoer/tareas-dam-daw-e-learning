
package es.discoduroderoer.prog03_1;

enum enumMes {
    ENERO, FEBRERO,
    MARZO, ABRIL,
    MAYO, JUNIO,
    JULIO, AGOSTO,
    SEPTIEMBRE, OCTUBRE,
    NOVIEMBRE, DICIEMBRE
}

public class Fecha {
    
    private int dia;
    private enumMes mes;
    private int anio;

    public Fecha(enumMes mes) {
        this.mes = mes;
    }

    public Fecha(int dia, enumMes mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public enumMes getMes() {
        return mes;
    }

    public void setMes(enumMes mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public boolean isSummer(){
        return (this.mes == enumMes.JUNIO && this.dia >= 21) || this.mes == enumMes.JULIO || this.mes == enumMes.AGOSTO || (this.mes == enumMes.SEPTIEMBRE && this.dia < 21);
    }

    @Override
    public String toString() {
        return  dia + " de " + mes.name().toLowerCase() + " de " + anio;
    }
    
}
