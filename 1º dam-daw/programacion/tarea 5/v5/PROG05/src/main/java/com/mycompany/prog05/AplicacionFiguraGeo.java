package com.mycompany.prog05;

import java.util.Scanner;

public class AplicacionFiguraGeo {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        // Variables necesarias
        FiguraGeo figura = null;
        Figuras tipo = null;
        Coordenada[] coordenadas = null;

        // Valido el tipo
        boolean tipoCorrecto;
        do {
            tipoCorrecto = true;

            try {
                System.out.println("Introduce el tipo de la figura (circunferencia, triangulo o rectangulo)");
                String tipoFigura = sn.next();
                tipo = Figuras.valueOf(tipoFigura.toUpperCase());

            } catch (IllegalArgumentException e) {
                tipoCorrecto = false;
            }

        } while (!tipoCorrecto);

        // Creo la figura
        figura = new FiguraGeo(tipo);

        // Pido las coordenadas
        figura.pedirCoordenadas();

        // menu
        boolean salir = false;
        while (!salir) {

            System.out.println("1. Ver el tipo de figura");
            System.out.println("2. Calcular área");
            System.out.println("3. Calcular perímetro");
            System.out.println("4. Mover coordenada");
            System.out.println("5. Convertir figura");
            System.out.println("6. Ver lista de coordenadas");
            System.out.println("7. Ver figuras en el plano");
            System.out.println("8. Salir");
            int opcion = sn.nextInt();

            switch (opcion) {
                case 1 -> {
                    // Comprobamos si es un cuadrado
                    if (figura.esCuadrado()) {
                        System.out.println("Es un cuadrado");
                    } else {
                        System.out.println(figura.getTipo().name().toLowerCase());
                    }
                }
                case 2 ->
                    System.out.println("El area es " + figura.area());
                case 3 ->
                    System.out.println("El area es " + figura.perimetro());
                case 4 ->
                    figura.moverCoordenada();
                case 5 -> {
                    if (figura.getTipo() == Figuras.TRIANGULO) {
                        System.out.println("No se puede cambiar");
                    } else {
                        // Cambio el tipo y pido las coordenadas de nuevo
                        if (figura.getTipo() == Figuras.CIRCUNFERENCIA) {
                            figura.setTipo(Figuras.RECTANGULO);
                            figura.pedirCoordenadas();
                        } else {
                            figura.setTipo(Figuras.CIRCUNFERENCIA);
                            figura.pedirCoordenadas();
                        }

                    }
                }
                case 6 -> {
                    coordenadas = figura.getCoordenadas();
                    // Muestro las coordenadas
                    for (Coordenada coordenada : coordenadas) {
                        System.out.println(coordenada);
                    }
                }
                case 7 -> {

                    // Solo rectangulos
                    if (figura.getTipo() == Figuras.RECTANGULO) {

                        // Matriz
                        int filaCentro = 5;
                        int columnaCentro = 5;

                        char[][] matriz = {
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', 'X', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        };

                        // Obtengo las coordenadas
                        coordenadas = figura.getCoordenadas();

                        // Empiezo en la segunda coordenada hasta la primera coordenada
                        for (int i = filaCentro - coordenadas[1].getY();
                                i <= filaCentro - coordenadas[0].getY(); i++) {
                            for (int j = columnaCentro + coordenadas[1].getX();
                                    j >= columnaCentro + coordenadas[0].getX(); j--) {
                                matriz[i][j] = 'O';
                            }
                        }

                        // muestro la matriz
                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[0].length; j++) {
                                System.out.print(matriz[i][j] + " ");
                            }
                            System.out.println("");
                        }
                    } else {
                        System.out.println("No puedes pintar esta figura");
                    }

                }
                case 8 -> {
                    salir = true;
                }
                default -> {
                    System.out.println("La opcion debe estar entre 1 y 8");
                }
            }

        }

    }
}
