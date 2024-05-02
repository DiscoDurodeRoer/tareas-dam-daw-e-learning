package PROG05_Ejerc1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    // Clientes globales
    static Cliente cliente1;
    static Cliente cliente2;
    static Cliente cliente3;
    static Cliente cliente4;
    static Cliente cliente5;

    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {

        sn.useDelimiter("\n");

        boolean salir = false;
        int opcion;

        while (!salir) {

            try {
                // menu
                System.out.println("1. Nuevo Cliente.");
                System.out.println("2. Consulta de un cliente por DNI.");
                System.out.println("3. Consulta de un cliente por Apellidos y Nombre");
                System.out.println("4. Listado de todos los Clientes.");
                System.out.println("5. Salir.");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1 -> {

                        System.out.println("Indica el numero de cliente (entre 1 y 5)");
                        int numCliente = sn.nextInt();

                        // Validamos el rango
                        Validacion.esta_en_rango(numCliente, 1, 5);

                        Cliente cliente = entrada_datos();

                        switch (numCliente) {
                            case 1 -> {
                                cliente1 = cliente;
                            }
                            case 2 -> {
                                cliente2 = cliente;
                            }
                            case 3 -> {
                                cliente3 = cliente;
                            }
                            case 4 -> {
                                cliente4 = cliente;
                            }
                            case 5 -> {
                                cliente5 = cliente;
                            }
                            default -> {
                                System.out.println("Introduce un numero entre 1 y 5");
                            }
                        }

                    }
                    case 2 -> {
                        consulta_dni();
                    }
                    case 3 -> {
                        consulta_nombre();
                    }
                    case 4 -> {
                        listado_Clientes();
                    }
                    case 5 -> {
                        salir = true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public static Cliente entrada_datos() throws Exception {

        // Pedimos los datos
        System.out.println("Introduce el dni");
        String dni = sn.next();

        System.out.println("Introduce el nombre");
        String nombre = sn.next();

        System.out.println("Introduce el apellidos");
        String apellidos = sn.next();

        System.out.println("Introduce el direccion");
        String direccion = sn.next();

        System.out.println("Introduce el poblacion");
        String poblacion = sn.next();

        System.out.println("Introduce el codigo postal");
        int codPostal = sn.nextInt();

        // Creamos y devolvemos el cliente, el dni se valida dentro
        Cliente cliente = new Cliente(dni, nombre, apellidos, direccion, poblacion, codPostal);

        return cliente;

    }

    public static void consulta_dni() throws Exception {

        // Pido un dni
        System.out.println("Introduce el dni");
        String dni = sn.next();

        // Creo un cliente solo con el dni
        Cliente cliente = new Cliente(dni);

        // Compruebo si existe
        if (cliente.existe_Dni()) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No existe el cliente");
        }

    }

    public static void consulta_nombre() {

        // Pido un nombre y apellido
        System.out.println("Introduce el nombre");
        String nombre = sn.next();

        System.out.println("Introduce el apellidos");
        String apellidos = sn.next();

        // Creo un cliente solo con el nombre y dni
        Cliente cliente = new Cliente(nombre, apellidos);

        // Compruebo si existe
        if (cliente.existe_nombre()) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No existe el cliente");
        }

    }

    public static void listado_Clientes() {

        // Muestro cada cliente si esta creado
        if (Principal.cliente1 != null) {
            System.out.println("Cliente 1: " + Principal.cliente1.toString());
        } else {
            System.out.println("Cliente 1 aun no creado");
        }

        if (Principal.cliente2 != null) {
            System.out.println("Cliente 2: " + Principal.cliente2.toString());
        } else {
            System.out.println("Cliente 2 aun no creado");
        }

        if (Principal.cliente3 != null) {
            System.out.println("Cliente 3: " + Principal.cliente3.toString());
        } else {
            System.out.println("Cliente 3 aun no creado");
        }

        if (Principal.cliente4 != null) {
            System.out.println("Cliente 4: " + Principal.cliente4.toString());
        } else {
            System.out.println("Cliente 4 aun no creado");
        }

        if (Principal.cliente5 != null) {
            System.out.println("Cliente 5: " + Principal.cliente5.toString());
        } else {
            System.out.println("Cliente 5 aun no creado");
        }

    }

}
