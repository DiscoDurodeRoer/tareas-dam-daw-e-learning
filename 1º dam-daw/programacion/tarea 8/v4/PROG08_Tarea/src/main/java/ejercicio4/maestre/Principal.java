package ejercicio4.maestre;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        short codigoCuerpo;
        String nombre, tipoObjeto;
        int diametro;

        CuerpoCeleste cc;
        ArrayList<CuerpoCeleste> cuerpos = new ArrayList<>();

        String respuesta;

        while (!salir) {
            try {
                // Pido el codigo de cuerpo celeste
                System.out.println("Introduce el codigo del cuerpo");
                codigoCuerpo = sn.nextShort();

                // Valido el numero de cifras
                if (!Util.validarNumCifras(codigoCuerpo, 3)) {
                    throw new Exception("El codigo del cuerpo no debe tener mas de 3 digitos");
                }

                if (Util.existeCuerpo(cuerpos, codigoCuerpo)) {
                    throw new Exception("El codigo del cuerpo ya existe");
                }
               
                // Pido el nombre del cuerpo celeste
                System.out.println("Introduce el nombre del cuerpo");
                nombre = sn.next();

                // Valido la longitud del nombre
                if (!Util.validarLongitud(nombre, 15)) {
                    throw new Exception("El nombre del cuerpo no debe tener mas de 15 caracteres");
                }

                // Pido el tipo del cuerpo celeste
                System.out.println("Introduce el tipo del cuerpo (planeta/planetaEnano/luna)");
                tipoObjeto = sn.next();

                // Valido el tipo del cuerpo celeste
                if (!Util.validarTipoObjeto(tipoObjeto)) {
                    throw new Exception("El tipo del cuerpo debe ser planeta, planetaEnano o luna");
                }

                // Pido el diametro del cuerpo celeste
                System.out.println("Introduce el diametro del cuerpo");
                diametro = sn.nextInt();

                // Valido el numero de cifras
                if (!Util.validarNumCifras(diametro, 6)) {
                    throw new Exception("El diametro del cuerpo no debe tener mas de 6 digitos");
                }

                // Creo el cuerpo celeste
                cc = new CuerpoCeleste(codigoCuerpo, nombre, tipoObjeto, diametro);

                cuerpos.add(cc);

                boolean correcto = false;
                do {
                    System.out.println("¿Quieres insertar más cuerpos? (Y/N)");
                    respuesta = sn.next().toUpperCase();
                    
                    if(respuesta.equals("Y") || respuesta.equals("N")){
                        correcto = true;
                    }
                    
                } while (!correcto);

                if (respuesta.equals("N")) {
                    salir = true;
                }

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        for (CuerpoCeleste cuerpo : cuerpos) {
            System.out.println(cuerpo);
        }

    }

}
