package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Validacion;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        // Scanner
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);

        // Variables
        boolean salir = false;
        int opcion;
        Vehiculo v = null;
        String marca, modelo, matricula, descripcion, nombrePropietario, dniPropietario;
        int numKm, dia, mes, anio, capacidad, consumo, litros, anios;
        LocalDate fechaMatriculacion;
        double precio;

        while (!salir) {

            try {

                // Menu
                System.out.println("Selecciona una opcion");
                System.out.println("1. Nuevo Vehículo.");
                System.out.println("2. Ver datos identificativos");
                System.out.println("3. Ver estado del vehículo");
                System.out.println("4. Viajar");
                System.out.println("5. Repostar");
                System.out.println("6. Llenar depósito.");
                System.out.println("7. Actualizar precio combustible.");
                System.out.println("8. Mostrar antigüedad.");
                System.out.println("9. Mostrar propietario.");
                System.out.println("10. Salir.");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1 -> {

                        // Marca
                        System.out.println("Introduce la marca");
                        marca = sn.next();

                        if (Validacion.estaVacio(marca)) {
                            throw new Exception("La marca no puede estar vacia");
                        }

                        // Modelo
                        System.out.println("Introduce la modelo");
                        modelo = sn.next();

                        if (Validacion.estaVacio(modelo)) {
                            throw new Exception("El modelo no puede estar vacio");
                        }

                        // Matricula
                        System.out.println("Introduce la matricula");
                        matricula = sn.next();

                        if (Validacion.estaVacio(matricula)) {
                            throw new Exception("La matricula no puede estar vacio");
                        }

                        // Num KM
                        System.out.println("Introduce el numero de km");
                        numKm = sn.nextInt();

                        if (!Validacion.esPositivo(numKm)) {
                            throw new Exception("El numero de km debe ser positivo");
                        }

                        // Fecha
                        System.out.println("Introduce el dia");
                        dia = sn.nextInt();

                        System.out.println("Introduce el mes");
                        mes = sn.nextInt();

                        System.out.println("Introduce el año");
                        anio = sn.nextInt();

                        fechaMatriculacion = LocalDate.of(anio, mes, dia);

                        if (Validacion.fechaMayorHoy(fechaMatriculacion)) {
                            throw new Exception("La fecha es mayor que hoy");
                        }

                        // capacidad
                        System.out.println("Introduce la capacidad entre 1 y 100");
                        capacidad = sn.nextInt();

                        if (!Validacion.estaEnRango(capacidad, 1, 100)) {
                            throw new Exception("La capacidad debe estar entre 1 y 100");
                        }

                        // Consumo
                        System.out.println("Introduce el consumo del vehiculo entre 1 y 20");
                        consumo = sn.nextInt();

                        if (!Validacion.estaEnRango(consumo, 1, 20)) {
                            throw new Exception("La capacidad debe estar entre 1 y 20");
                        }

                        // descripcion
                        System.out.println("Introduce la descripcion");
                        descripcion = sn.next();

                        // precio
                        System.out.println("Introduce el precio");
                        precio = sn.nextDouble();

                        // propietario
                        System.out.println("Introduce el nombre del propietario");
                        nombrePropietario = sn.next();

                        System.out.println("Introduce el DNI del propietario");
                        dniPropietario = sn.next();

                        Validacion.validarDNI(dniPropietario);

                        // Creacion del vehiculo
                        v = new Vehiculo(marca, modelo, matricula, numKm, fechaMatriculacion, capacidad, consumo, descripcion, precio, nombrePropietario, dniPropietario);

                        System.out.println("El vehiculo se ha creado");
                    }
                    case 2 -> {
                        if (v != null) {
                            v.mostrarDatosIdentificativos();
                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 3 -> {
                        if (v != null) {
                            v.mostrarEstadoVehiculo();
                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 4 -> {
                        if (v != null) {

                            // pedimos y validamos los km
                            System.out.println("Introduce el numero de km");
                            numKm = sn.nextInt();

                            if (!Validacion.esPositivo(numKm)) {
                                throw new Exception("Los KM deben ser positivos");
                            }

                            v.viajar(numKm);
                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 5 -> {
                        if (v != null) {

                             // pedimos y validamos los litros
                            System.out.println("Introduce los litros");
                            litros = sn.nextInt();

                            if (!Validacion.esPositivo(litros)) {
                                throw new Exception("Los litros deben ser positivos");
                            }

                            v.repostar(litros);

                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 6 -> {
                        if (v != null) {
                            v.llenar();
                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 7 -> {
                        if (v != null) {

                             // pedimos y validamos el nuevo precio
                            System.out.println("Introduce el nuevo precio");
                            precio = sn.nextDouble();

                            if (!Validacion.esPositivo(precio)) {
                                throw new Exception("El precio debe ser positivo");
                            }

                            v.actualizarPrecio(precio);

                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 8 -> {
                        if (v != null) {

                            // Obtenemos los años
                            anios = v.get_Anios();

                            System.out.println("La antiguedad del vehiculo es de " + anios + " años");

                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 9 -> {
                        if (v != null) {
                            System.out.println("Nombre propietario: " + v.getNombrePropietario() + " y DNI propietario: " + v.getDniPropietario());
                        } else {
                            System.out.println("Debes crear el vehiculo");
                        }
                    }
                    case 10 -> {
                        salir = true;
                    }
                    default -> {
                        System.out.println("Debes insertar un numero entre 1 y 10");
                    }
                }
            } catch (InputMismatchException e) {
                sn.next();
                System.out.println("Introduce el valor correspondiente");
            } catch (DateTimeException e) {
                System.out.println("La fecha no tiene el formato correcto");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
