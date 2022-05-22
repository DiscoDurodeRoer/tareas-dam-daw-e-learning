package tarea09;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);

        // Variables necesarias
        boolean salir = false;
        int opcion, tipoCuenta;
        String nombreTitular, apellidosTitular, DNITitular, IBAN, listaAutorizadas, infoCuenta;
        String[] listaCuentas;
        Persona titular;
        double saldo, tipoInteres, comisionMantenimiento, tipoInteresDescubierto, maxDescubierto, comisionDescubierto, cantidad;

        Banco banco = new Banco();
        banco.recuperarCuentas();
        CuentaBancaria cuenta = null;

        // Hasta que no eleginamos la opcion 7, no saldremos
        while (!salir) {

            try {

                // Menu
                System.out.println("1. Abrir una nueva cuenta.");
                System.out.println("2. Ver un listado de las cuentas disponibles");
                System.out.println("3. Obtener los datos de una cuenta concreta.");
                System.out.println("4. Realizar un ingreso en una cuenta.");
                System.out.println("5. Retirar efectivo de una cuenta.");
                System.out.println("6. Consultar el saldo actual de una cuenta.");
                System.out.println("7. Eliminar una cuenta.");
                System.out.println("8. Generar un listado de clientes.");
                System.out.println("9. Salir de la aplicación.");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        // Pedimos el titular
                        System.out.println("Introduce el nombre del titular");
                        nombreTitular = sn.next();

                        System.out.println("Introduce el apellidos del titular");
                        apellidosTitular = sn.next();

                        System.out.println("Introduce el DNI del titular");
                        DNITitular = sn.next();

                        // Creamos el titular
                        titular = new Persona(nombreTitular, apellidosTitular, DNITitular);

                        // Pedimos y validamos el IBAN
                        System.out.println("Introduce el IBAN");
                        IBAN = sn.next();

                        if (!IBAN.matches("^ES[0-9]{20}$")) {
                            throw new Exception("El IBAN no tiene el formato correcto");
                        }

                        // Pedimos el saldo inicial
                        System.out.println("Introduce el saldo inicial");
                        saldo = sn.nextDouble();

                        // Tipo de cuenta
                        System.out.println("Elige el tipo de cuenta");
                        System.out.println("1. Cuenta ahorro");
                        System.out.println("2. Cuenta corriente personal");
                        System.out.println("3. Cuenta corriente empresa");
                        tipoCuenta = sn.nextInt();

                        switch (tipoCuenta) {
                            case 1:
                                System.out.println("Introduce el tipo de interes");
                                tipoInteres = sn.nextDouble();
                                cuenta = new CuentaAhorro(tipoInteres, titular, saldo, IBAN);
                                break;
                            case 2:
                                System.out.println("Introduce una lista de entidades autorizadas");
                                listaAutorizadas = sn.next();
                                System.out.println("Introduce la comision de mantenimiento");
                                comisionMantenimiento = sn.nextDouble();
                                cuenta = new CuentaCorrientePersonal(comisionMantenimiento, listaAutorizadas, titular, saldo, IBAN);
                                break;
                            case 3:
                                System.out.println("Introduce una lista de entidades autorizadas");
                                listaAutorizadas = sn.next();
                                System.out.println("Introduce el tipo de interes descubierto");
                                tipoInteresDescubierto = sn.nextDouble();
                                System.out.println("Introduce el maximo descuierto");
                                maxDescubierto = sn.nextDouble();
                                System.out.println("Introduce la comision de por descubierto");
                                comisionDescubierto = sn.nextDouble();
                                cuenta = new CuentaCorrienteEmpresa(maxDescubierto, tipoInteresDescubierto, comisionDescubierto, listaAutorizadas, titular, saldo, IBAN);
                                break;
                            default:
                                throw new Exception("Debes elegir un tipo de cuenta");
                        }

                        if (banco.abrirCuenta(cuenta)) {
                            System.out.println("Se ha abierto la cuenta con exito");
                        } else {
                            System.out.println("Ha habido un error al abrir la cuenta");
                        }

                        break;
                    case 2:
                        listaCuentas = banco.listadoCuentas();
                        for (int i = 0; i < listaCuentas.length; i++) {
                            System.out.println(listaCuentas[i]);
                        }
                        break;
                    case 3:
                        System.out.println("Introduce el IBAN");
                        IBAN = sn.next();

                        infoCuenta = banco.informacionCuenta(IBAN);
                        if (infoCuenta != null) {
                            System.out.println(infoCuenta);
                        } else {
                            System.out.println("La cuenta no existe");
                        }

                        break;
                    case 4:
                        System.out.println("Introduce el IBAN");
                        IBAN = sn.next();

                        System.out.println("Introduce una cantidad");
                        cantidad = sn.nextDouble();

                        if (banco.ingresoCuenta(IBAN, cantidad)) {
                            System.out.println("El ingreso se hizo correctamente");
                        } else {
                            System.out.println("El ingreso no se hizo correctamente");
                        }
                        break;
                    case 5:
                        System.out.println("Introduce el IBAN");
                        IBAN = sn.next();

                        System.out.println("Introduce una cantidad");
                        cantidad = sn.nextDouble();

                        if (banco.retiradaCuenta(IBAN, cantidad)) {
                            System.out.println("La retirada se hizo correctamente");
                        } else {
                            System.out.println("La retirada no se hizo correctamente");
                        }
                        break;
                    case 6:
                        System.out.println("Introduce el IBAN");
                        IBAN = sn.next();

                        saldo = banco.obtenerSaldo(IBAN);
                        if (saldo != -1) {
                            System.out.println("El saldo es: " + saldo);
                        } else {
                            System.out.println("La cuenta no existe");
                        }
                        break;
                    case 7:
                        
                        System.out.println("Introduce el IBAN");
                        IBAN = sn.next();
                        
                        if (banco.eliminarCuenta(IBAN)) {
                            System.out.println("La cuenta se elimino correctamente");
                        } else {
                            System.out.println("La cuenta no se elimino correctamente");
                        }
                        
                        break;
                    case 8:
                        banco.generarListado();
                        System.out.println("Listado generado");
                        break;
                    case 9:
                        salir = true;
                        banco.guardarCuentas();
                        System.out.println("Cuentas guardadas");
                        break;
                }
            } catch (InputMismatchException e) {
                sn.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
