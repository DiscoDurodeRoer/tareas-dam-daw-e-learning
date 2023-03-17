package prog05v4;

import java.time.LocalDate;

public class Utilidades {

    /**
     * Indicamos si la fecha es mayor de hoy
     * @param fecha
     * @return boolean
     */
    public static boolean mayorFecha(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }

    /**
     * Indica el precio de la visita, variando segun la especialidad
     * @param tipoVisita
     * @param especialidad
     * @param precioMinimo
     * @return double
     * @throws Exception 
     */
    public static double precioVisita(int tipoVisita, Especialidad especialidad, double precioMinimo) throws Exception {

        double precioFinal = precioMinimo;

        switch (tipoVisita) {
            case Visita.CONSULTA:
                if (especialidad == Especialidad.DIGESTIVO) {
                    precioFinal = precioFinal * 1.15;
                }
                break;
            case Visita.REVISION:
                if (especialidad == Especialidad.GINECOLOGÍA) {
                    precioFinal = precioFinal * 1.1;
                }
                break;
            case Visita.URGENCIAS:
                if (especialidad != Especialidad.MCABECERA) {
                    precioFinal = precioFinal * 1.5;
                }
                break;
            case Visita.RECETAS:
                precioFinal = precioFinal * 0.9;
                break;
            default:
                throw new Exception("No existe el tipo de visita");
        }

        return precioFinal;
    }

    /**
     * Valida un codigo de medico, para que devuelva verdadero debe cumplirse 
     * una de estas condiciones
     * <ul>
     *  <li>Cadena de 7 caracteres</li>
     *  <li>Dos primeros caracteres sean algunos de estos: "TR", "DI", "GI", "MC"</li>
     *  <li>Los siguientes 5 caracteres sean números</li>
     * </ul>
     * @param codigo
     * @return
     * @throws Exception 
     */
    public static boolean codigoValido(String codigo) throws Exception {

        boolean longitudMayor7 = codigo.length() == 7;
        boolean letras = false;
        boolean digitos = false;

        // Comprobamos las letras
        try {
            String[] letrasValidas = {"TR", "DI", "GI", "MC"};
            // obtenemos los 2 primeros caracteres
            String subcadenaLetras = codigo.substring(0, 2);

            for (int i = 0; i < letrasValidas.length; i++) {
                if (letrasValidas[i].equals(subcadenaLetras)) {
                    letras = true;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {

        }

        // Validamos los numeros
        try {
            // Obtenemos los 5 siguientes caracteres a partir de la 3 posicion
            String subcadenaNumeros = codigo.substring(2, 7);
            Integer.parseInt(subcadenaNumeros);
            // Si llega aqui es que es un numero
            digitos = true;
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {

        }

        // Sino cumple las 3 condiciones, lanza excepcion
        if (!longitudMayor7 && !letras && !digitos) {
            throw new Exception("Codigo no valido");
        }

        return true;
    }

}
