package com.mycompany.prog06;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PROG06 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        boolean salir = false;
        int opcion;
        final String FICHERO = "alumnos.dat";

        while (!salir) {

            try {

                System.out.println("1. Añadir alumno");
                System.out.println("2. Listar alumnos");
                System.out.println("3. Buscar alumno");
                System.out.println("4. Borrar alumno");
                System.out.println("5. Borrar fichero de alumnos");
                System.out.println("6. Salir");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1 -> {

                        // Pedimos los datos
                        System.out.println("Introduce el NIF");
                        String NIF = sn.next();

                        System.out.println("Introduce el nombre");
                        String nombre = sn.next();

                        System.out.println("Introduce el telefono");
                        int telefono = sn.nextInt();

                        System.out.println("Introduce la direccion");
                        String direccion = sn.next();

                        System.out.println("Introduce la nota media");
                        double notaMedia = sn.nextDouble();

                        // Creo el alumno
                        Alumno alumno = new Alumno(NIF, nombre, telefono, direccion, notaMedia);

                        // Añadimos el alumno
                        if (aniadirAlumno(FICHERO, alumno)) {
                            System.out.println("Se ha añadido un alumno");
                        } else {
                            System.out.println("No se ha añadido un alumno");
                        }

                    }
                    case 2 -> {
                        // Mostramos los alumnos
                        listarAlumnos(FICHERO);
                    }
                    case 3 -> {
                        // Pido el NIF
                        System.out.println("Introduce el NIF del alumno a buscar");
                        String NIF = sn.next();

                        // Busco el alumno en el fichero
                        Alumno alumno = buscarAlumno(FICHERO, NIF);

                        // Indico el resultado
                        if (alumno != null) {
                            System.out.println("El alumno encontrado es: " + alumno);
                        } else {
                            System.out.println("No se ha encontrado el alumno");
                        }

                    }
                    case 4 -> {

                        // Pido el NIF
                        System.out.println("Introduce el NIF del alumno a buscar");
                        String NIF = sn.next();

                        // Borro el alumno (si existe)
                        boolean borrado = borrarAlumno(FICHERO, NIF);

                        // Muestro el resultado
                        if (borrado) {
                            System.out.println("El alumno se ha borrado");
                        } else {
                            System.out.println("El alumno no se ha borrado");
                        }
                    }
                    case 5 -> {
                        // Borro el fichero y muestro el resultado
                        if (borrarFichero(FICHERO)) {
                            System.out.println("Se ha borrado");
                        } else {
                            System.out.println("No se ha borrado");
                        }
                    }
                    case 6 -> {
                        salir = true;
                    }
                    default -> {
                        System.out.println("Elige opciones entre 1 y 6");
                    }
                }
            } catch (InputMismatchException e) {
                sn.next();
                System.err.println("El formato de lo introducido es incorrecto");
            }
        }

    }

    public static boolean aniadirAlumno(String fichero, Alumno alumno) {

        try {

            // Creo un objeto de File para saber cual objeto usar
            File f = new File(fichero);

            FileOutputStream fos;
            ObjectOutputStream oos;
            if (f.exists()) {
                // Pongo append a true
                fos = new FileOutputStream(fichero, true);
                // Uso la clase propia para evitar cabeceras
                oos = new MiObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(fichero);
                oos = new ObjectOutputStream(fos);
            }

            // Escribo el objeto en el fichero
            oos.writeObject(alumno);
            // Cierro los streams
            oos.close();
            fos.close();

            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;

    }

    public static void listarAlumnos(String fichero) {

        // try resources
        // Cierra automaticamente los streams al terminar el try catch
        try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Recorro los alumnos hasta que no haya mas en el fichero
            while (true) {
                // leo el objeto del fichero
                Alumno a = (Alumno) ois.readObject();
                // muestro el objeto
                System.out.println(a);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No hay alumnos");
        } catch (EOFException ex) {
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static Alumno buscarAlumno(String fichero, String NIF) {

        Alumno alumno = null;
        // try resources
        // Cierra automaticamente los streams al terminar el try catch
        try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Cuando encuentre el alumno, saldre
            while (alumno == null) {
                // leo el objeto del fichero
                Alumno a = (Alumno) ois.readObject();
                // Si el NIF es igual lo almaceno
                if (a.getNIF().equals(NIF)) {
                    alumno = a;
                }
            }

        } catch (FileNotFoundException | EOFException ex) {
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return alumno;
    }

    public static boolean borrarAlumno(String fichero, String NIF) {

        ArrayList<Alumno> alumnos = new ArrayList<>();
        boolean existe = false;
        // try resources
        // Cierra automaticamente los streams al terminar el try catch
        try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                // leo el objeto del fichero
                Alumno a = (Alumno) ois.readObject();
                // Si el NIF NO es igual lo almaceno en el arraylist
                if (!a.getNIF().equals(NIF)) {
                    alumnos.add(a);
                } else {
                    // El alumno existe
                    existe = true;
                }
            }

        } catch (FileNotFoundException | EOFException ex) {
        } catch (IOException | ClassNotFoundException ex) {
             System.err.println(ex.getMessage());
        }

        // si existe y se ha borrado el fichero, almaceno los de la lista
        if (existe && borrarFichero(fichero)) {
            // Almaceno los alumnos
            for (Alumno alumno : alumnos) {
                aniadirAlumno(fichero, alumno);
            }
            return true;
        }
        return false;
    }

    public static boolean borrarFichero(String fichero) {
        File f = new File(fichero);
        return f.delete();
    }

}
