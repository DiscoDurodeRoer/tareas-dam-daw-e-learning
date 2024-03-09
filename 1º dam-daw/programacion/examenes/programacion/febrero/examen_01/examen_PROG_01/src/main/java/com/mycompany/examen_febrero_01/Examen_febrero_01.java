package com.mycompany.examen_febrero_01;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Examen_febrero_01 {

    public static void main(String[] args) {

        // Scanner para pedir datos
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);

        boolean salir = false;
        int opcion;

        // Limites
        final int MAX_JUGADORES = 99;
        final int MAX_EQUIPOS = 20;

        // Arrays donde almacenar datos
        int numJugadores = 0;
        Jugador[] jugadores = new Jugador[MAX_JUGADORES];

        int numEquipos = 0;
        Equipo[] equipos = new Equipo[MAX_EQUIPOS];

        while (!salir) {

            try {

                System.out.println("1. Añadir equipo");
                System.out.println("2. Añadir jugador");
                System.out.println("3. Mostrar jugadores por equipo");
                System.out.println("4. Mejor del partido");
                System.out.println("5. Km recorridos cada jugador");
                System.out.println("6. Listar jugadores federados");
                System.out.println("7. Salir");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1 -> {

                        // Comprobamos si hay suficiente espacio
                        if (numEquipos < MAX_EQUIPOS) {

                            // Pedimos los datos del equipo
                            System.out.println("Escribe el nombre del equipo");
                            String nombre = sn.next();

                            System.out.println("Escribe la division");
                            int division = sn.nextInt();

                            if (!(division >= 1 && division <= 3)) {
                                throw new Exception("La division solo puede ser 1,2 o 3");
                            }

                            // Creo el equipo
                            Equipo nuevoEquipo = new Equipo(nombre, division);

                            // Compruebo que existe
                            boolean existe = false;
                            for (int i = 0; i < numEquipos && !existe; i++) {
                                if (equipos[i].equals(nuevoEquipo)) {
                                    existe = true;
                                }
                            }

                            if (existe) {
                                throw new Exception("El equipo existe");
                            }

                            // Añado el equipo
                            equipos[numEquipos++] = nuevoEquipo;

                            System.out.println("Se ha añadido el equipo");

                        } else {
                            System.out.println("No se pueden crear mas equipos");
                        }

                    }
                    case 2 -> {

                        // Sino hay equipos, no podremos crear jugadores
                        if (numEquipos == 0) {
                            System.out.println("No hay equipos, debes crearte al menos uno");
                        } else if (numJugadores < MAX_JUGADORES) {

                            // Pedimos los datos del jugador
                            System.out.println("Escribe el nombre del jugador");
                            String nombre = sn.next();

                            System.out.println("Escribe el nombre del jugador");
                            String apellidos = sn.next();

                            System.out.println("Escribe el dorsal del jugador");
                            int dorsal = sn.nextInt();

                            if (!(dorsal >= 1 && dorsal <= 99)) {
                                throw new Exception("El numero de dorsal solo puede ser entre 1 y 99");
                            }

                            // Selecciono un equipo
                            int equipoSeleccionado = -1;
                            do {

                                System.out.println("Elige un equipo: ");
                                for (int i = 0; i < numEquipos; i++) {
                                    System.out.println((i + 1) + ". " + equipos[i].getNombre());
                                }

                                equipoSeleccionado = sn.nextInt() - 1;

                                if (!(equipoSeleccionado >= 0 && equipoSeleccionado < numEquipos)) {
                                    System.out.println("Debes elegir un equipo en el rango");
                                }

                            } while (!(equipoSeleccionado >= 0 && equipoSeleccionado < numEquipos));

                            // Obtengo el equipo
                            Equipo equipo = equipos[equipoSeleccionado];

                            // Creo el equipo
                            Jugador nuevoJugador = new Jugador(nombre, apellidos, dorsal, equipo);

                            // Compruebo si existe el jugador
                            boolean existe = false;
                            for (int i = 0; i < numJugadores && !existe; i++) {
                                if (jugadores[i].equals(nuevoJugador)) {
                                    existe = true;
                                }
                            }

                            if (existe) {
                                throw new Exception("El jugador existe en ese equipo");
                            }

                            // Añado el jugador
                            jugadores[numJugadores++] = nuevoJugador;

                            System.out.println("Se ha añadido el jugador al equipo");

                        } else {
                            System.out.println("No se pueden crear mas jugadores");
                        }

                    }
                    case 3 -> {

                        // Sino hay equipos, no podremos realizar este caso
                        if (numEquipos == 0) {
                            System.out.println("No hay equipos, debes crearte al menos uno");
                        } else {

                            // Selecciono un equipo
                            int equipoSeleccionado = -1;
                            do {

                                System.out.println("Elige un equipo: ");
                                for (int i = 0; i < numEquipos; i++) {
                                    System.out.println((i + 1) + ". " + equipos[i].getNombre());
                                }

                                equipoSeleccionado = sn.nextInt() - 1;

                                if (!(equipoSeleccionado >= 0 && equipoSeleccionado < numEquipos)) {
                                    System.out.println("Debes elegir un equipo en el rango");
                                }

                            } while (!(equipoSeleccionado >= 0 && equipoSeleccionado < numEquipos));

                            // Obtengo el equipo
                            Equipo equipo = equipos[equipoSeleccionado];

                            // Muestro los jugadores que coincidan con ese equipo
                            for (int i = 0; i < numJugadores; i++) {
                                if (jugadores[i].getEquipo().equals(equipo)) {
                                    System.out.println(jugadores[i]);
                                }
                            }

                        }

                    }
                    case 4 -> {

                        // Sino hay jugadores, no podremos realizar este caso
                        if (numJugadores == 0) {
                            System.out.println("No hay jugadores, debes crearte al menos uno");
                        } else {

                            // Selecciono un jugador
                            int jugadorSeleccionado = -1;
                            do {

                                System.out.println("Elige un jugador: ");
                                for (int i = 0; i < numJugadores; i++) {
                                    System.out.println((i + 1) + ". " + jugadores[i]);
                                }

                                jugadorSeleccionado = sn.nextInt() - 1;

                                if (!(jugadorSeleccionado >= 0 && jugadorSeleccionado < numEquipos)) {
                                    System.out.println("Debes elegir un juagdor en el rango");
                                }

                            } while (!(jugadorSeleccionado >= 0 && jugadorSeleccionado < numJugadores));

                            // Obtengo el jugador
                            Jugador jugador = jugadores[jugadorSeleccionado];

                            // indico si es el mejor del partido
                            jugador.elegidoMejorPartido();

                            System.out.println("El jugador ha sido elegido el mejor del partido");

                        }

                    }
                    case 5 -> {

                        // Sino hay jugadores, no podremos realizar este caso
                        if (numJugadores == 0) {
                            System.out.println("No hay jugadores, debes crearte al menos uno");
                        } else {

                            // Selecciono un jugador
                            int jugadorSeleccionado = -1;
                            do {

                                System.out.println("Elige un jugador: ");
                                for (int i = 0; i < numJugadores; i++) {
                                    System.out.println((i + 1) + ". " + jugadores[i]);
                                }

                                jugadorSeleccionado = sn.nextInt() - 1;

                                if (!(jugadorSeleccionado >= 0 && jugadorSeleccionado < numEquipos)) {
                                    System.out.println("Debes elegir un juagdor en el rango");
                                }

                            } while (!(jugadorSeleccionado >= 0 && jugadorSeleccionado < numJugadores));

                            // Obtengo el jugador
                            Jugador jugador = jugadores[jugadorSeleccionado];

                            // Obtengo los kms
                            System.out.println("Escribe los kilometros recorridos");
                            double km = sn.nextDouble();

                            if (km < 0) {
                                throw new Exception("Los km deben ser positivos");
                            }

                            // Añado los kms (calculo internamente la media)
                            jugador.anidirKm(km);

                            System.out.println("El jugador tiene una media de km de " + jugador.getMediaKm());

                        }

                    }
                    case 6 -> {
                        // muestro todos los jugadores
                        for (int i = 0; i < numJugadores; i++) {
                            System.out.println(jugadores[i]);
                        }
                    }
                    case 7 -> {
                        salir = true;
                    }
                    default -> {
                        System.out.println("Debes elegir entre 1 y 7");
                    }
                }
            } catch (InputMismatchException e) {
                sn.next();
                System.out.println("Debes insertar un numero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
