
package ejer6;

public class Ejer6 {

    /**
     *
     * Diseña un programa Java que cree un tipo enumerado para los meses del
     * año. El programa debe realizar las siguientes operaciones: Crear una
     * variable m del tipo enumerado y asignarle el mes de marzo. Mostrar por
     * pantalla su valor. Asignar a la variable m, la cadena de texto "MARZO".
     * Mostrar por pantalla el valor de la variable de tipo enumerado tras
     * realizar la asignación.
     */
    public static void main(String[] args) {
        Meses m = Meses.MARZO;
        System.out.println(m);
        
        m = "Marzo"; // No se puede hacer
        System.out.println(m);
    }

}
