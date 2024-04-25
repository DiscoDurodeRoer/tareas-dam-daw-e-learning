package com.mycompany.prog10_tarea;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PROG10_Tarea {

    public static void main(String[] args) {

        // Scanner para pedir datos
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        boolean salir = false;
        int opcion = 0;

        // Nombre de los ficheros 
        final String FICHERO_FILMS = "datosfilsms.dat";
        final String FICHERO_TXT = "listadofilms.txt";

        // obtener datos desde el fichero sino sera un arraylist vacio
        ArrayList<Film> films = obtenerFilms(FICHERO_FILMS);

        while (!salir) {

            System.out.println("1. Crear un film");
            System.out.println("2. Añadir director");
            System.out.println("3. Añadir actor");
            System.out.println("4. Eliminar director");
            System.out.println("5. Eliminar actor");
            System.out.println("6. Mostrar films");
            System.out.println("7. Exportar films");
            System.out.println("8. Salir");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1 -> {

                    // Pedimos los datos
                    System.out.println("Escribe un titulo");
                    String titulo = sn.next();

                    System.out.println("Escribe un titulo original");
                    String tituloOriginal = sn.next();

                    // Creamos el film
                    Film newFilm = new Film(titulo, tituloOriginal);

                    // Buscamos si existe
                    boolean existe = false;
                    for (Film film : films) {
                        if (film.equals(newFilm)) {
                            existe = true;
                        }
                    }

                    if (existe) {
                        System.out.println("El film ya existe");
                    } else {
                        // Añado el film
                        films.add(newFilm);
                        System.out.println("Film insertado");
                    }

                }
                case 2 -> {

                    System.out.println("Escribe un titulo");
                    String titulo = sn.next();

                    Film filmFound = null;
                    // Buscamos si existe
                    for (Film film : films) {
                        if (film.getTitulo().equals(titulo)) {
                            filmFound = film;
                        }
                    }

                    if (filmFound == null) {
                        System.out.println("No existe el film");
                    } else {

                        // Pedimos los datos del director
                        System.out.println("Nombre del director");
                        String nombre = sn.next();

                        System.out.println("Apellidos del director");
                        String apellidos = sn.next();

                        // Creamos un director
                        Persona director = new Persona(nombre, apellidos);

                        // Añadimos el director
                        filmFound.addDirector(director);
                        System.out.println("Director añadido");

                    }

                }
                case 3 -> {

                    System.out.println("Escribe un titulo");
                    String titulo = sn.next();

                    Film filmFound = null;
                    // Buscamos si existe
                    for (Film film : films) {
                        if (film.getTitulo().equals(titulo)) {
                            filmFound = film;
                        }
                    }

                    if (filmFound == null) {
                        System.out.println("No existe el film");
                    } else {

                        // Pedimos los datos del actor
                        System.out.println("Nombre del actor");
                        String nombre = sn.next();

                        System.out.println("Apellidos del actor");
                        String apellidos = sn.next();

                        System.out.println("Personaje del actor");
                        String personaje = sn.next();

                        // Creamos el actor
                        Actor actor = new Actor(nombre, apellidos, personaje);

                        // Añadimos el actor
                        filmFound.addActor(actor);
                        System.out.println("Actor añadido");

                    }

                }
                case 4 -> {

                    System.out.println("Escribe un titulo");
                    String titulo = sn.next();

                    Film filmFound = null;
                    // Buscamos si existe
                    for (Film film : films) {
                        if (film.getTitulo().equals(titulo)) {
                            filmFound = film;
                        }
                    }

                    if (filmFound == null) {
                        System.out.println("No existe el film");
                    } else {

                        // Pedimos los datos
                        System.out.println("Nombre del director");
                        String nombre = sn.next();

                        System.out.println("Apellidos del director");
                        String apellidos = sn.next();

                        // Creamos el director
                        Persona director = new Persona(nombre, apellidos);

                        // Eliminamos el director
                        filmFound.removeDirector(director);
                        System.out.println("Director eliminado");

                    }

                }
                case 5 -> {

                    System.out.println("Escribe un titulo");
                    String titulo = sn.next();

                    Film filmFound = null;
                    // Buscamos si existe
                    for (Film film : films) {
                        if (film.getTitulo().equals(titulo)) {
                            filmFound = film;
                        }
                    }

                    if (filmFound == null) {
                        System.out.println("No existe el film");
                    } else {

                        // Pedimos los datos
                        System.out.println("Nombre del actor");
                        String nombre = sn.next();

                        System.out.println("Apellidos del actor");
                        String apellidos = sn.next();

                        // Buscamos si existe el actor
                        Actor actorFound = null;
                        for (Actor actor : filmFound.getActores()) {
                            if (actor.getNombre().equals(nombre) && actor.getApellidos().equals(apellidos)) {
                                actorFound = actor;
                            }
                        }

                        // eliminamos el actor
                        filmFound.removeActor(actorFound);
                        System.out.println("Actor eliminado");

                    }
                }
                case 6 -> {
                    // Mostramos los films
                    for (Film film : films) {
                        System.out.println(film);
                    }
                }
                case 7 -> {
                    exportarTXT(FICHERO_TXT, films);
                }
                case 8 -> {
                    salir = true;
                    // Metodo guardar
                    guardarFilms(FICHERO_FILMS, films);
                }
            }

        }

    }

    public static ArrayList<Film> obtenerFilms(String fichero) {

        // Array vacio
        ArrayList<Film> films = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

            // Leemos el objeto que hay dentro
            films = (ArrayList<Film>) ois.readObject();
            System.out.println("Se han obtenido los films del fichero");

        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return films;

    }

    public static void guardarFilms(String fichero, ArrayList<Film> films) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {

            // Guardamos el arraylist completo
            oos.writeObject(films);
            System.out.println("Se ha guardado los films en el fichero");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void exportarTXT(String fichero, ArrayList<Film> films) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

            // Recorremos los films
            for (Film film : films) {

                // Titulos
                bw.write("Titulo: " + film.getTitulo() + "(" + film.getTituloOriginal() + ")\r\n");
                // Directores
                bw.write("Directores: \r\n");
                for (Persona director : film.getDirectores()) {
                    bw.write(director + " \r\n");
                }
                // Actores
                bw.write("Actores: \r\n");
                for (Actor actor : film.getActores()) {
                    bw.write(actor + " \r\n");
                }
                bw.write("\r\n");
            }

            // numero de films
            bw.write("Numero de films: " + films.size());

            System.out.println("Se han exportado los films");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
