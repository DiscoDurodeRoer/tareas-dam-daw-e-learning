package prog05v4;

import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        // Variables necesarias
        boolean salir = false;
        boolean codigoMedicoCorrecto = false;
        boolean pacientesCreados = false, medicosCreados = false, visitasCreadas = false;
        int opcion, opcionEspecialidad;

        String nombrePac, apellidosPac, codigoMed, nombreMed, DNIMed;
        Paciente p1 = null, p2 = null, p3 = null;
        Medico m1 = null, m2 = null, m3 = null, m4 = null;
        Visita v1 = null, v2 = null, v3 = null, v4 = null, v5 = null;
        Especialidad especialidad;

        while (!salir) {

            try {

                // Menu
                System.out.println("1. Pacientes");
                System.out.println("2. Médicos");
                System.out.println("3. Visitas");
                System.out.println("4. Imprimir visitas");
                System.out.println("5. Imprimir total de visitas por tipos");
                System.out.println("6. Salir");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        // Pedimos el nombre y apellidos del paciente
                        System.out.println("Nombre del paciente");
                        nombrePac = sn.next();
                        System.out.println("Apellidos del paciente");
                        apellidosPac = sn.next();
                        System.out.println("Ahora se insertaran los pacientes de forma automatica");
                        // Creamos los pacientes
                        p1 = new Paciente("1", nombrePac, apellidosPac);
                        p2 = new Paciente("2", nombrePac, apellidosPac);
                        p3 = new Paciente("3", nombrePac, apellidosPac);
                        pacientesCreados = true;
                        break;
                    case 2:
                        // Pedimos y validamos el codigo del medico
                        codigoMedicoCorrecto = false;
                        do {
                            System.out.println("Introduce el codigo del medico");
                            codigoMed = sn.next();

                            try {
                                Utilidades.codigoValido(codigoMed);
                                codigoMedicoCorrecto = true;
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }

                        } while (!codigoMedicoCorrecto);

                        // Pedimos el nombre y el DNI del medico
                        System.out.println("Nombre del medico");
                        nombreMed = sn.next();

                        System.out.println("DNI del medico");
                        DNIMed = sn.next();

                        // Pedimos y validamos la especialidad
                        do {

                            System.out.println("Escoge la especialidad");
                            for (int i = 0; i < Especialidad.values().length; i++) {
                                System.out.println((i + 1) + ". " + Especialidad.values()[i].name());
                            }
                            opcionEspecialidad = sn.nextInt();
                        } while (!(opcionEspecialidad >= 1 && opcionEspecialidad <= 4));
                        especialidad = Especialidad.values()[opcionEspecialidad];

                        // Creamos los medicos
                        m1 = new Medico(codigoMed, nombreMed, DNIMed, especialidad);
                        m2 = new Medico("DI0001", "Marian", "12345678A", Especialidad.DIGESTIVO);
                        m3 = new Medico("GI0002", "Ana Paz", "12345678B", Especialidad.GINECOLOGÍA);
                        m4 = new Medico("TR0003", "Pedro", "12345678C", Especialidad.TRAUMATOLOGÍA);
                        medicosCreados = true;
                        break;
                    case 3:

                        // Solo crearemos las visitas, si los pacientes y medicos estan creados
                        if (pacientesCreados && medicosCreados) {
                            Visita.reinicializarVisita();
                            v1 = new Visita("1", LocalDate.of(2022, Month.FEBRUARY, 8), p1, m1, Visita.CONSULTA, "Descripcion1", "Tratamiento1", Utilidades.precioVisita(Visita.CONSULTA, Especialidad.DIGESTIVO, Visita.PRECIO_MINIMO));
                            v2 = new Visita("2", LocalDate.of(2022, Month.FEBRUARY, 10), p1, m1, Visita.REVISION, "Descripcion2", "Tratamiento2", Utilidades.precioVisita(Visita.REVISION, Especialidad.GINECOLOGÍA, Visita.PRECIO_MINIMO));
                            v3 = new Visita("3", LocalDate.of(2022, Month.FEBRUARY, 10), p2, m2, Visita.RECETAS, "Descripcion3", "Tratamiento3", Utilidades.precioVisita(Visita.RECETAS, Especialidad.TRAUMATOLOGÍA, Visita.PRECIO_MINIMO));
                            v4 = new Visita("4", LocalDate.of(2022, Month.FEBRUARY, 11), p3, m3, Visita.URGENCIAS, "Descripcion4", "Tratamiento5", Utilidades.precioVisita(Visita.URGENCIAS, Especialidad.TRAUMATOLOGÍA, Visita.PRECIO_MINIMO));
                            v5 = new Visita("5", LocalDate.of(2022, Month.FEBRUARY, 11), p2, m4, Visita.CONSULTA, "Descripcion4", "Tratamiento5", Utilidades.precioVisita(Visita.CONSULTA, Especialidad.MCABECERA, Visita.PRECIO_MINIMO));
                            visitasCreadas = true;
                        } else {
                            System.out.println("Debes crear los pacientes y los medicos");
                        }

                        break;
                    case 4:

                        // Solo mostraremos todos lo objetos si las visitas estan creadas
                        // Si se han creado las visitas, los pacientes y medicos tb se han creado
                        if (visitasCreadas) {
                            
                            System.out.println("---Pacientes---");
                            System.out.println(p1.toString());
                            System.out.println(p2.toString());
                            System.out.println(p3.toString());
                            
                            System.out.println("---Medicos---");
                            System.out.println(m1.toString());
                            System.out.println(m2.toString());
                            System.out.println(m3.toString());
                            System.out.println(m4.toString());
                            
                            System.out.println("---Visitas---");
                            System.out.println(v1.toString());
                            System.out.println("-----");
                            System.out.println(v2.toString());
                            System.out.println("-----");
                            System.out.println(v3.toString());
                            System.out.println("-----");
                            System.out.println(v4.toString());
                            System.out.println("-----");
                            System.out.println(v5.toString());
                            System.out.println("-----");
                            
                        }else{
                            System.out.println("Debes crear los objetos antes");
                        }
                        
                        break;
                    case 5:

                        // Mostramos el numero de visita de cada tipo
                        System.out.println("-------------");
                        System.out.println("Num de consultas: " + Visita.devuelveNumVisita(Visita.CONSULTA));
                        System.out.println("Num de revisiones: " + Visita.devuelveNumVisita(Visita.REVISION));
                        System.out.println("Num de recetas: " + Visita.devuelveNumVisita(Visita.RECETAS));
                        System.out.println("Num de urgencias: " + Visita.devuelveNumVisita(Visita.URGENCIAS));
                        System.out.println("-------------");
                        
                        break;
                    case 6:
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
