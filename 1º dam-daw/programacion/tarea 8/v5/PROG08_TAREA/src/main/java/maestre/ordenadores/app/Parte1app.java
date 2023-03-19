package maestre.ordenadores.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import maestre.ordenadores.modelo.Ordenador;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;
import maestre.ordenadores.modelo.TipoDiscoDuro;

public class Parte1app {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion, posicion, minutosBateria;

        try {
            // Ordenadores iniciales
            Ordenador[] ordenadores = {
                new Portatil((short) 24, (short) 300, "1234", "samsumg", "galaxy", (short) 8, "Intel", (byte) 2, TipoDiscoDuro.HDD, false),
                new Portatil((short) 20, (short) 300, "5678", "razer", "blaze", (short) 2, "AMD", (byte) 4, TipoDiscoDuro.SSD, false),
                new Portatil((short) 28, (short) 300, "9123", "msi", "prestige", (short) 4, "Intel", (byte) 8, TipoDiscoDuro.SSD, false),
                new Sobremesa("msi", "nvidia", "4567", "dell", "optiplex", (short) 32, "AMD", (byte) 1, TipoDiscoDuro.SSD, false),
                new Sobremesa("asus", "nvidia", "8912", "asus", "essentials", (short) 16, "Intel", (byte) 4, TipoDiscoDuro.SSD, false),
                new Sobremesa("gigabyte", "nvidia", "3456", "acer", "aspire", (short) 8, "AMD", (byte) 2, TipoDiscoDuro.SSD, false)
            };

            // Mensaje de bienvenida y mostramos el estado de los ordenadores
            System.out.println("bienvenido a nuestra app de ordenadores");
            for (Ordenador ordenador : ordenadores) {
                System.out.println(ordenador);
            }

            while (!salir) {

                try {
                    System.out.println("1. Listar todos los ordenadores mezclados portátiles y sobremesa.");
                    System.out.println("2. Listar sólo los portátiles.");
                    System.out.println("3. Listar sólo los ordenadores de sobremesa.");
                    System.out.println("4. Encender un ordenador.");
                    System.out.println("5. Apagar un ordenador.");
                    System.out.println("6. Dibujar un ordenador.");
                    System.out.println("7. Cargar Portátiles.");
                    System.out.println("8. Descargar Portátiles.");
                    System.out.println("9. Salir.");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:
                            for (Ordenador ordenador : ordenadores) {
                                System.out.println(ordenador);
                            }
                            break;
                        case 2:
                            for (Ordenador ordenador : ordenadores) {
                                // Compruebo si es un portatil
                                if (ordenador instanceof Portatil) {
                                    System.out.println(ordenador);
                                }
                            }
                            break;
                        case 3:
                            for (Ordenador ordenador : ordenadores) {
                                // Compruebo si es un sobremesa
                                if (ordenador instanceof Sobremesa) {
                                    System.out.println(ordenador);
                                }
                            }
                            break;
                        case 4:
                            // pido una posicion
                            System.out.println("Introduce una posicion");
                            posicion = sn.nextInt();
                            // Valido la posicion
                            if (posicion >= 0 && posicion < ordenadores.length) {
                                // Arranco el ordenador
                                ordenadores[posicion].arrancar();
                            } else {
                                System.out.println("La posicion no es valida");
                            }
                            break;
                        case 5:
                            // pido una posicion
                            System.out.println("Introduce una posicion");
                            posicion = sn.nextInt();
                            // Valido la posicion
                            if (posicion >= 0 && posicion < ordenadores.length) {
                                // Apago el ordenador
                                ordenadores[posicion].apagar();
                            } else {
                                System.out.println("La posicion no es valida");
                            }
                            break;
                        case 6:
                            // pido una posicion
                            System.out.println("Introduce una posicion");
                            posicion = sn.nextInt();
                            // Valido la posicion
                            if (posicion >= 0 && posicion < ordenadores.length) {
                                // Dibujo el ordenador
                                ordenadores[posicion].dibujar();
                            } else {
                                System.out.println("La posicion no es valida");
                            }
                            break;
                        case 7:
                            // Pido los minutos de duracion
                            System.out.println("Introduce minutos de duracion");
                            minutosBateria = sn.nextInt();
                            for (Ordenador ordenador : ordenadores) {
                                // Compruebo si es un portatil
                                if (ordenador instanceof Portatil) {
                                    // Casteo un ordenador a portatil
                                    Portatil p = (Portatil) ordenador;
                                    // Ahora si puedo llamar al metodo cargar
                                    p.cargar(minutosBateria);
                                }
                            }
                            break;
                        case 8:
                            // Pido los minutos de duracion
                            System.out.println("Introduce minutos de duracion");
                            minutosBateria = sn.nextInt();
                            for (Ordenador ordenador : ordenadores) {
                                // Compruebo si es un portatil
                                if (ordenador instanceof Portatil) {
                                    // Casteo un ordenador a portatil
                                    Portatil p = (Portatil) ordenador;
                                    // Ahora si puedo llamar al metodo descargar
                                    p.descargar(minutosBateria);
                                }
                            }
                            break;
                        case 9:
                            salir = true;
                            break;
                    }
                } catch (InputMismatchException e) {
                    sn.next();
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
