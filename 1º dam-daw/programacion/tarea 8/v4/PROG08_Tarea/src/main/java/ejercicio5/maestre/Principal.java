package ejercicio5.maestre;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        final int NUM_DIGITOS = 3;
        final int NUM_INTENTOS_MAX = 7;

        int[] clave = new int[NUM_DIGITOS];

        generarClave(clave);

        boolean acertado = false;
        boolean todoVerde;
        int numeroIntentos = 0;
        String claveUsuario;
        int[] digitosClaveUsuario;
        char[] pistas;

        while (!acertado && numeroIntentos < NUM_INTENTOS_MAX) {

            System.out.println("Introduce un número de 3 digitos");
            claveUsuario = sn.next();

            if (esNumero(claveUsuario)) {

                if (claveUsuario.length() == NUM_DIGITOS) {

                    digitosClaveUsuario = devuelveDigitos(claveUsuario);

                    pistas = generaPistas(digitosClaveUsuario, clave);

                    todoVerde = true;
                    
                    System.out.print("Pista: ");
                    for (int i = 0; i < pistas.length; i++) {
                        if(pistas[i] != 'v'){
                            todoVerde = false;
                        }
                        System.out.print(pistas[i] + " ");
                    }
                    System.out.println("");
                    
                    if(todoVerde){
                        acertado = true;
                    }else{
                        numeroIntentos++;
                        System.out.println("Has fallado, te quedan " + (NUM_INTENTOS_MAX - numeroIntentos) + " intentos");
                    }
                    
                    
                } else {
                    System.out.println("Debe tener 3 digitos");
                }
            } else {
                System.out.println("No es un numero");
            }
        }

        if (acertado) {
            System.out.println("Has acertado en " + (numeroIntentos+1) + " intentos");
        } else {
            System.out.println("Has perdido");
        }

        System.out.println("Fin programa");
        
        
    }

    public static void generarClave(int[] clave) {

        for (int i = 0; i < clave.length; i++) {
            clave[i] = -1;
        }

        int digito;
        boolean repetido;
        for (int i = 0; i < clave.length; i++) {

            do {
                repetido = false;

                digito = generaNumeroAleatorio(0, 9);

                for (int j = 0; j < i; j++) {
                    if (digito == clave[j]) {
                        repetido = true;
                    }
                }
            } while (repetido);

            clave[i] = digito;

        }

    }

    public static boolean esNumero(String numero) {

        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static int[] devuelveDigitos(String numero) {

        int[] digitos = new int[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            digitos[i] = Integer.parseInt(numero.substring(i, i + 1));
        }
        return digitos;
    }

    public static char[] generaPistas(int[] digitosClaveUsuario, int[] digitosClaveOriginal) {

        char[] pistas = new char[digitosClaveUsuario.length];
        
        for (int i = 0; i < digitosClaveUsuario.length; i++) {
            
            if(digitosClaveUsuario[i] == digitosClaveOriginal[i]){
                pistas[i] = 'v';
            }else{
                boolean existe = false;
                for (int j = 0; j < digitosClaveOriginal.length; j++) {
                    if(i != j && digitosClaveUsuario[i] == digitosClaveOriginal[j]){
                        existe = true;
                    }
                }
                
                if(existe){
                    pistas[i] = 'a';
                }else{
                    pistas[i] = 'r';
                }
                
                
            }
            
        }
        
        return pistas;
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
}
