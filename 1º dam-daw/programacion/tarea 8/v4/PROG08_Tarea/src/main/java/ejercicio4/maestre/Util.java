package ejercicio4.maestre;

import java.util.ArrayList;

/**
 * Utilidades de validacion
 * @author DDR
 */
public class Util {

    /**
     * Valida la longitud de una cadena
     * @param cadena
     * @param longitudMax
     * @return 
     */
    public static boolean validarLongitud(String cadena, int longitudMax) {
        return cadena.length() <= longitudMax;
    }

    /**
     * Valida si el numero de cifras es menor o igual que el indicado
     * @param num
     * @param numCifras
     * @return 
     */
    public static boolean validarNumCifras(int num, int numCifras) {

        int contador = 0;

        if (num == 0) {
            contador = 1;
        } else {

            // Contamos las cifras
            for (int i = Math.abs(num); i > 0; i /= 10) {
                contador++;
            }

        }

        // indicamos si es menor o igual
        return contador <= numCifras;
    }

    /**
     * Valida el tipo del cuerpo celeste
     * @param tipo
     * @return 
     */
    public static boolean validarTipoObjeto(String tipo) {

        switch (tipo) {
            case "planeta":
            case "planetaEnano":
            case "luna":
                return true;
        }

        return false;

    }
    
    
    public static boolean existeCuerpo(ArrayList<CuerpoCeleste> cuerpos, short codigoCuerpo){
        for (CuerpoCeleste c : cuerpos) {
            if(codigoCuerpo == c.getCodigoCuerpo()){
                return true;
            }
        }
        return false;
    }

}
