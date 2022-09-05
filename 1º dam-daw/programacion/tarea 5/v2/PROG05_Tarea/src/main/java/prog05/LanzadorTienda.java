package prog05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LanzadorTienda {

    public static void main(String[] args) {

        try {
            System.out.println("Bievenido a DDR Sports");

            // Obtenemos el articulo
            ArticuloDeportivo articulo = obtenerDatosArticulo();

            boolean salir = false;
            int opcion, unidades;

            while (!salir) {

                try {

                    // Muestra el menu
                    mostrarMenu();
                    opcion = leerOpcion();

                    switch (opcion) {
                        case 1:
                            System.out.println("El codigo completo del articulo es: " + articulo.getCodigoCompleto());
                            break;

                        case 2:
                            System.out.println("La descripcion del articulo es: " + articulo.getDescripcion());
                            break;
                        case 3:
                            System.out.println("El codigo de ciudad del articulo es: " + articulo.getCodigoCiudad());
                            break;
                        case 4:
                            System.out.println("El codigo de la tienda del articulo es: " + articulo.getCodigoTienda());
                            break;
                        case 5:
                            System.out.println("El codigo del articulo es: " + articulo.getCodigoArticulo());
                            break;
                        case 6:
                            System.out.println("El digito de control del articulo es: " + articulo.getDigitoControl());
                            break;
                        case 7:
                            // Pedimos el numero de unidades
                            System.out.println("Introduce unidades");
                            unidades = Integer.parseInt(leerTeclado());
                            articulo.incrementarUnidades(unidades);

                            break;
                        case 8:
                            // Pedimos el numero de unidades
                            System.out.println("Introduce unidades");
                            unidades = Integer.parseInt(leerTeclado());
                            articulo.decrementarUnidades(unidades);

                            break;
                        case 9:
                            System.out.println("Las unidades del articulo son: " + articulo.getUnidades());
                            break;
                        case 10:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo entre 1 y 10");

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Insertar solo numeros");
                }
            }

        } catch (ExcepcionTiendaDeportes ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Adios desde DDR Sports");

    }

    /**
     * Muestra el menu
     */
    public static void mostrarMenu() {
        System.out.println("1. Ver el código completo del articulo");
        System.out.println("2. Ver la descripcion del articulo");
        System.out.println("3. Ver el codigo de la ciudad");
        System.out.println("4. Ver el codigo de la tienda");
        System.out.println("5. Ver el codigo del articulo");
        System.out.println("6. Ver el digito de control");
        System.out.println("7. Aumentar unidades");
        System.out.println("8. Decrementar unidades");
        System.out.println("9. Consultar unidades");
        System.out.println("10. Salir");
    }

    /**
     * Devuelve un dato por teclado
     * @return 
     */
    public static String leerTeclado() {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        return sn.next();
    }

    /**
     * Devuelve un dato por teclado de tipo numero
     * @return
     * @throws InputMismatchException 
     */
    public static int leerOpcion() throws InputMismatchException {
        Scanner sn = new Scanner(System.in);
        return sn.nextInt();
    }

    /**
     * Obtiene y valida un articulo
     * @return
     * @throws ExcepcionTiendaDeportes 
     */
    public static ArticuloDeportivo obtenerDatosArticulo() throws ExcepcionTiendaDeportes {

        System.out.println("Introduce la descripcion");
        String desc = leerTeclado();

        validarDescripcion(desc);

        System.out.println("Introduce el codigo completo");
        String codigo = leerTeclado();

        validarCodigo(codigo);
        
        // Creo el articulo
        String ciudad = codigo.substring(0, 2);
        String tienda = codigo.substring(2, 4);
        String art = codigo.substring(4, 10);
        ArticuloDeportivo articulo = new ArticuloDeportivo(ciudad, tienda, art, desc, 0);

        return articulo;

    }

    /**
     * Validar la descripcion del articulo
     * @param descripcion
     * @throws ExcepcionTiendaDeportes 
     */
    public static void validarDescripcion(String descripcion) throws ExcepcionTiendaDeportes {
        if (descripcion.length() > 40) {
            throw new ExcepcionTiendaDeportes("La descripcion no puede superar los 40 caracteres");
        }
    }

    /**
     * Valida el codigo de articulo
     * @param codigo
     * @throws ExcepcionTiendaDeportes 
     */
    public static void validarCodigo(String codigo) throws ExcepcionTiendaDeportes {

        if (codigo.length() != 12) {
            throw new ExcepcionTiendaDeportes("El codigo debe ser de 12 caracteres");
        }

        int codCiudad;
        try {
            String ciudad = codigo.substring(0, 2);
            codCiudad = Integer.parseInt(ciudad);
        } catch (NumberFormatException e) {
            throw new ExcepcionTiendaDeportes("El codigo de la ciudad no es numericos");
        }

        int codTienda;
        try {
            String tienda = codigo.substring(2, 4);
            codTienda = Integer.parseInt(tienda);
        } catch (NumberFormatException e) {
            throw new ExcepcionTiendaDeportes("El codigo de la tienda no es numericos");
        }

        int codArt;
        try {
            String articulo = codigo.substring(4, 10);
            codArt = Integer.parseInt(articulo);
        } catch (NumberFormatException e) {
            throw new ExcepcionTiendaDeportes("El codigo del articulo no es numericos");
        }

        int codDigito;
        try {
            String digito = codigo.substring(10);
            codDigito = Integer.parseInt(digito);
        } catch (NumberFormatException e) {
            throw new ExcepcionTiendaDeportes("El codigo de control no es numericos");
        }

        // Controlamos el digito de control
        int suma = codCiudad + codTienda + codArt;
        int digitoControlCalculado = suma % 99;

        if (digitoControlCalculado != codDigito) {
            throw new ExcepcionTiendaDeportes("El digito de control es incorrecto");
        }

    }

}
