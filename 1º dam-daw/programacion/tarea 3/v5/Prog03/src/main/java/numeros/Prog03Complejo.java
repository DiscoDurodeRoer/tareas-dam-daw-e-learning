package numeros;

public class Prog03Complejo {

    public static void main(String[] args) {
        // Creamos los complejos
        Complejo c1 = new Complejo(3, 4);
        Complejo c2 = new Complejo(1, 7);

        c1.cambia_Real(5);
        c1.cambia_Imag(6);

        // Probamos el metodo sumar
        c1.sumar(c2);

        // Mostramos los complejos
        System.out.println(c1.toString());
        System.out.println(c2.toString());

    }

}
