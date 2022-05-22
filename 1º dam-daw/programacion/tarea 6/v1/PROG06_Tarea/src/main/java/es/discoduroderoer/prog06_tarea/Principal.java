package es.discoduroderoer.prog06_tarea;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);

        boolean salir = false;
        boolean correcto = false;
        int opcion;

        Concesionario concesionario = new Concesionario();
        Vehiculo v;
        String marca, matricula, descripcion, nombreProp, DNIProp;
        int kms=0, dia, mes, anio;
        double precio=0;
        LocalDate fechaMatriculacion=null;

        while (!salir) {

            System.out.println("1. Nuevo vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo");
            System.out.println("4. Modificar kms vehiculo");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println("Introduce la marca");
                    marca = sn.next();

                    do {
                        System.out.println("Introduce la matricula");
                        matricula = sn.next();
                    } while (!Validacion.validarMatricula(matricula));

                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el numero de km");
                            kms = sn.nextInt();
                        } catch (InputMismatchException e) {
                            correcto = false;
                            sn.next();
                        }

                    } while (!correcto);

                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el dia de la fecha de matriculacion");
                            dia = sn.nextInt();

                            System.out.println("Introduce el mes de la fecha de matriculacion");
                            mes = sn.nextInt();

                            System.out.println("Introduce el año de la fecha de matriculacion");
                            anio = sn.nextInt();

                            fechaMatriculacion = LocalDate.of(anio, mes, dia);
                        } catch (InputMismatchException e) {
                            correcto = false;
                            sn.next();
                        } catch(DateTimeException e){
                            correcto = false;
                        }

                    } while (!correcto);

                    System.out.println("Introduce la descripcion");
                    descripcion = sn.next();

                    do {
                        System.out.println("Introduce el nombre del propietario");
                        nombreProp = sn.next();
                    } while (!Validacion.validarNombre(nombreProp));

                    do {
                        System.out.println("Introduce el dni del propietario");
                        DNIProp = sn.next();
                    } while (!Validacion.validarDNI(DNIProp));

                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el precio");
                            precio = sn.nextDouble();
                        } catch (InputMismatchException e) {
                            correcto = false;
                            sn.next();
                        }

                    } while (!correcto);

                    v = new Vehiculo(marca, matricula, kms, fechaMatriculacion, descripcion, precio, nombreProp, DNIProp);
                    
                    switch(concesionario.insertarVehiculo(v)){
                        case -2:
                            System.out.println("El vehiculo existe");
                            break;
                        case -1:
                            System.out.println("El concesionario esta lleno");
                            break;
                        case 0:
                            System.out.println("Vehiculo insertado correctamente");
                            break;
                    }
                    
                    
                    break;
                case 2:
                    concesionario.listarVehiculos();
                    break;
                case 3:

                    System.out.println("Inserta la matricula");
                    matricula = sn.next();

                    v = concesionario.buscaVehiculo(matricula);

                    if (v != null) {
                        System.out.println(v.getMarca());
                        System.out.println(v.getMatricula());
                        System.out.println(v.getPrecio());
                    } else {
                        System.out.println("No existe el vehiculo con la matricula introducida");
                    }

                    break;
                case 4:
                    System.out.println("Inserta la matricula");
                    matricula = sn.next();

                    System.out.println("Inserta los nuevos kms");
                    kms = sn.nextInt();

                    if (concesionario.actualizaKms(matricula, kms)) {
                        System.out.println("Los kms se ha actualizado correctamente");
                    } else {
                        System.out.println("No existe el vehiculo con la matricula introducida");
                    }

                    break;
                case 5:
                    salir = true;
                    break;
            }

        }

    }

}
