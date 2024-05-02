package PROG05_Ejerc1;

public class Validacion {

    public static void esta_en_rango(int valor, int min, int max) throws Exception {
        if (!(valor >= min && valor <= max)) {
            throw new Exception("Valor " + valor + " debe estar entre " + min + " y " + max);
        }
    }

    public static void comprobar_dni(String dni) throws Exception {

        if (!(dni.length() >= 8 && dni.length() <= 9)) {
            throw new Exception("La longitud del dni no es correcta");
        }

        String parteNumerica = dni.substring(0, dni.length() - 1);

        int numeroDni;
        try {
            numeroDni = Integer.parseInt(parteNumerica);
        } catch (NumberFormatException e) {
            throw new Exception("el formato de la parte numerica no es correcta");
        }

        final int DIVISOR = 23;

        char letrasNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int resto = numeroDni % DIVISOR;

        char letra = letrasNIF[resto];

        String nuevoDNI = numeroDni + "" + letra;

        if (!nuevoDNI.equals(dni)) {
            throw new Exception("El DNI no es correcto");
        }

    }

}
