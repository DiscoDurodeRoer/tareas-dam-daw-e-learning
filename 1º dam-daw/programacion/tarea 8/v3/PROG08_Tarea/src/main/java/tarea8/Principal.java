package tarea8;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);
        boolean salir = false;

        Banco banco = new Banco();

        int opcion, tipoCuenta;
        double cantidad, saldoInicial, tipoInteres, comisionMantenimiento, comisionFijaDescubierto, tipoInteresDescubierto, maxDescubierto;
        boolean exito;

        String IBAN, nombreTitular, apellidosTitular, DNITitular, listaEntidades;
        Persona titular;
        CuentaBancaria b;

        while (!salir) {

            try {

                System.out.println("1. Abrir una nueva cuenta");
                System.out.println("2. Ver listado de las cuentas disponibles");
                System.out.println("3. Obtener los datos de una cuenta concreta. ");
                System.out.println("4. Realizar un ingreso en una cuenta");
                System.out.println("5. Retirar efectivo de una cuenta ");
                System.out.println("6. Consultar el saldo actual de una cuenta");
                System.out.println("7. Eliminar cuenta");
                System.out.println("8. Numero de cuenta de ahorro");
                System.out.println("9. Saldo acumulado cuenta corriente");
                System.out.println("10. Top 3 titulares");
                System.out.println("11. Salir de la aplicación");
                System.out.println("Elige una opción");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        b = null;

                        System.out.println("Introduce el nombre del titular");
                        nombreTitular = sn.next();

                        System.out.println("Introduce los apellidos del titular");
                        apellidosTitular = sn.next();

                        System.out.println("Introduce el DNI del titular");
                        DNITitular = sn.next();

                        titular = new Persona(nombreTitular, apellidosTitular, DNITitular);

                        System.out.println("Introduce el IBAN de la cuenta con el formato ESNNNNNNNNNNNNNNNNNNNN donde N debe ser un numero");
                        IBAN = sn.next();

                        if (!IBAN.matches("^ES[0-9]{20}$")) {
                            throw new Exception("El IBAN no tiene el formato correcto");
                        }

                        System.out.println("Introduce el saldo inical");
                        saldoInicial = sn.nextDouble();

                        System.out.println("Elige el tipo de cuenta");
                        System.out.println("1. Cuenta de ahorro");
                        System.out.println("2. Cuenta corriente personal");
                        System.out.println("3. Cuenta corriente de empresa");
                        tipoCuenta = sn.nextInt();

                        switch (tipoCuenta) {
                            case 1:
                                System.out.println("Introduce el tipo de interés de remuneración");
                                tipoInteres = sn.nextDouble();
                                b = new CuentaAhorro(tipoInteres, titular, saldoInicial, IBAN);
                                break;
                            case 2:
                                System.out.println("Introduce la comisión de mantenimiento");
                                comisionMantenimiento = sn.nextDouble();
                                System.out.println("Introduce la lista de entidades autorizadas");
                                listaEntidades = sn.next();
                                b = new CuentaCorrientePersonal(comisionMantenimiento, listaEntidades, titular, saldoInicial, IBAN);
                                break;
                            case 3:
                                System.out.println("Introduce la comision fija por descubierto");
                                comisionFijaDescubierto = sn.nextDouble();
                                System.out.println("Introduce el tipo de interes por descubierto");
                                tipoInteresDescubierto = sn.nextDouble();
                                System.out.println("Introduce el maximo descubierto");
                                maxDescubierto = sn.nextDouble();
                                System.out.println("Introduce la lista de entidades autorizadas");
                                listaEntidades = sn.next();
                                b = new CuentaCorrienteEmpresa(comisionFijaDescubierto, tipoInteresDescubierto, maxDescubierto, listaEntidades, titular, saldoInicial, IBAN);
                                break;
                            default:
                                throw new Exception("Debes elegir un tipo de cuenta");
                        }

                        exito = banco.abrirCuenta(b);

                        if (exito) {
                            System.out.println("Se ha insertado correctamente");
                        } else {
                            System.out.println("No se ha insertado correctamente");
                        }

                        break;
                    case 2:
                        banco.listadoCuentas();
                        break;
                    case 3:
                        System.out.println("Introduce el IBAN de la cuenta");
                        IBAN = sn.next();
                        String resultado = banco.informacionCuenta(IBAN);
                        if (resultado == null) {
                            System.out.println("No existe la cuenta bancaria");
                        } else {
                            System.out.println("Informacion de la cuenta: " + resultado);
                        }
                        break;
                    case 4:
                        System.out.println("Introduce el IBAN de la cuenta");
                        IBAN = sn.next();
                        System.out.println("Introduce el saldo a ingresar");
                        cantidad = sn.nextDouble();
                        exito = banco.ingresoCuenta(IBAN, cantidad);
                        if (exito) {
                            System.out.println("El ingreso se hizo correctamente");
                        } else {
                            System.out.println("El ingreso no se hizo correctamente");
                        }
                        break;
                    case 5:
                        System.out.println("Introduce el IBAN de la cuenta");
                        IBAN = sn.next();
                        System.out.println("Introduce el saldo a retirar");
                        cantidad = sn.nextDouble();
                        exito = banco.retiradaCuenta(IBAN, cantidad);
                        if (exito) {
                            System.out.println("La retirada se hizo correctamente");
                        } else {
                            System.out.println("La retirada no se hizo correctamente");
                        }
                        break;
                    case 6:
                        System.out.println("Introduce el IBAN de la cuenta");
                        IBAN = sn.next();
                        double saldo = banco.obtenerSaldo(IBAN);
                        if (saldo == -1) {
                            System.out.println("La cuenta no existe");
                        } else {
                            System.out.println("El saldo de la cuenta es: " + saldo);
                        }
                        break;
                    case 7:
                        System.out.println("Introduce el IBAN de la cuenta");
                        IBAN = sn.next();
                        
                        if(banco.eliminarCuenta(IBAN)){
                            System.out.println("La cuenta bancaria ha sido eliminada");
                        }else{
                            System.out.println("La cuenta bancaria no ha sido eliminada");
                        }
                        break;
                    case 8: 
                        System.out.println("Numero de cuentas de ahorro: " + banco.numcuentaAhorro());
                        break;
                    case 9:
                        System.out.println("Introduce la comisión de mantenimiento");
                        comisionMantenimiento = sn.nextDouble();
                        
                        System.out.println("Saldo acumulado: " + banco.saldoAcumuladoCuentaCorriente(comisionMantenimiento));
                        
                        break;
                    case 10:
                        
                        System.out.println("Titulares mas ricos");
                        banco.top3Cuentas();
                        break;
                    case 11:
                        salir = true;
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
