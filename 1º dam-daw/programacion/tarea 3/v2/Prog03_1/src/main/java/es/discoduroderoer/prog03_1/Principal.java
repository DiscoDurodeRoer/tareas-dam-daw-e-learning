package es.discoduroderoer.prog03_1;

public class Principal {

    public static void main(String[] args) {

        System.out.println("Primera fecha, inicializada con el primer constructor");
        Fecha objFecha1 = new Fecha(enumMes.ABRIL);
        objFecha1.setDia(15);
        objFecha1.setAnio(2021);
        System.out.println("La fecha es: " + objFecha1.toString());
        System.out.println(objFecha1.isSummer() ? "Es verano" : "No es verano");
        
        System.out.println("Segunda fecha, inicializada con el segundo constructor");
        Fecha objFecha2 = new Fecha(15, enumMes.JULIO, 2021);
        System.out.println(objFecha2.getAnio());
        System.out.println("La fecha es: " + objFecha2.toString());
        System.out.println(objFecha2.isSummer() ? "Es verano" : "No es verano");
    
    }

}
