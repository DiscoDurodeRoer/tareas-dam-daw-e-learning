package com.mycompany.prog05;

import static com.mycompany.prog05.Figuras.CIRCUNFERENCIA;
import static com.mycompany.prog05.Figuras.RECTANGULO;
import static com.mycompany.prog05.Figuras.TRIANGULO;
import java.util.Scanner;

public class FiguraGeo implements Coordenable {

    // Atributos
    private Figuras tipo;
    private Coordenada[] coordenadas;

    // Constructores
    
    public FiguraGeo(Figuras tipo) {
        this.tipo = tipo;
        crearCoordenadas();
    }

    // Getters and setters
    
    public Figuras getTipo() {
        return tipo;
    }

    public void setTipo(Figuras tipo) {
        this.tipo = tipo;
    }
    
    
    @Override
    public Coordenada[] getCoordenadas() {
        return this.coordenadas;
    }

    /**
     * Creo las coordenadas segun el tipo de la figura
     */
    private void crearCoordenadas() {

        int numCoordenadas = 0;
        switch (this.tipo) {
            case RECTANGULO, CIRCUNFERENCIA ->
                numCoordenadas = 2;
            case TRIANGULO ->
                numCoordenadas = 3;
        }
        this.coordenadas = new Coordenada[numCoordenadas];

    }

    /**
     * Mueve una coordenada
     */
    @Override
    public void moverCoordenada() {

        Scanner sn = new Scanner(System.in);

        // Pido un indice de una coordenada
        int indiceCoordenada;
        do {

            System.out.println("Que coordenada quieres mover");
            indiceCoordenada = sn.nextInt();

            if (!(indiceCoordenada >= 0 && indiceCoordenada < this.coordenadas.length)) {
                System.out.println("Introduce el indice de la coordenada entre 0 y " + (this.coordenadas.length - 1));
            }

        } while (!(indiceCoordenada >= 0 && indiceCoordenada < this.coordenadas.length));

        int x = 0, y = 0;
        boolean figuraCorrecta;

        boolean coordenadaCorrecta;
        do {
            figuraCorrecta = true;

            do {
                coordenadaCorrecta = true;

                // Pedimos la coordenada
                try {
                    System.out.println("Introduce X");
                    x = sn.nextInt();

                    if (x > 5 || x < -5) {
                        throw new Exception("X debe estar entre -5 y 5");
                    }

                    System.out.println("Introduce Y");
                    y = sn.nextInt();

                    if (y > 5 || y < -5) {
                        throw new Exception("Y debe estar entre -5 y 5");
                    }
                } catch (Exception e) {
                    coordenadaCorrecta = false;
                    System.out.println(e.getMessage());
                }
            } while (!coordenadaCorrecta);

            // Insertamos la coordenada
            this.coordenadas[indiceCoordenada] = new Coordenada(x, y);

            // Validamos la figura
            try {
                validar();
            } catch (Exception ex) {
                figuraCorrecta = false;
                System.out.println(ex.getMessage());
            }

        } while (!figuraCorrecta);

    }

    /**
     * 
     */
    @Override
    public void pedirCoordenadas() {

        Scanner sn = new Scanner(System.in);

        // Recorro las coordenadas
        boolean figuraCorrecta, coordenadaCorrecta;
        int x = 0, y = 0;
        do {
            figuraCorrecta = true;
            for (int i = 0; i < this.coordenadas.length; i++) {

                do {
                    coordenadaCorrecta = true;

                    // Pido una coordenada
                    try {
                        System.out.println("Introduce X");
                        x = sn.nextInt();

                        if (x > 5 || x < -5) {
                            throw new Exception("X debe estar entre -5 y 5");
                        }

                        System.out.println("Introduce Y");
                        y = sn.nextInt();

                        if (y > 5 || y < -5) {
                            throw new Exception("Y debe estar entre -5 y 5");
                        }
                    } catch (Exception e) {
                        coordenadaCorrecta = false;
                        System.out.println(e.getMessage());
                    }
                } while (!coordenadaCorrecta);

                // Inserto una coordenada
                this.coordenadas[i] = new Coordenada(x, y);

            }

            // Validamos
            try {
                this.validar();
            } catch (Exception ex) {
                figuraCorrecta = false;
                System.out.println(ex.getMessage());
            }

        } while (!figuraCorrecta);

    }

    /**
     * Validamos que la figura se inserte correctamente
     * @throws Exception 
     */
    private void validar() throws Exception {
        switch (this.tipo) {
            case RECTANGULO -> {

                if (this.coordenadas[0].getX() > this.coordenadas[1].getX()
                        || this.coordenadas[0].getY() > this.coordenadas[1].getY()) {
                    throw new Exception("Coordenadas Rectangulo invalidas");
                }

            }
            case CIRCUNFERENCIA -> {

                if (coordenadas[0].getY() != coordenadas[1].getY() || coordenadas[0].getX() > coordenadas[1].getX()) {
                    throw new Exception("Coordenadas Circunferencia invalidas");
                }

            }
            case TRIANGULO -> {

                if (coordenadas[0].getY() != coordenadas[1].getY()
                        || coordenadas[0].getX() > coordenadas[1].getX()
                        || coordenadas[2].getX() < coordenadas[0].getX() 
                        || coordenadas[2].getX() > coordenadas[1].getX()
                        || coordenadas[2].getY() < coordenadas[0].getY()) {
                    throw new Exception("Coordenadas Triangulo invalidas");
                }

            }
        }
    }

    /**
     * Calcula el area de la figura
     * @return 
     */
    public double area() {
        double area = 0;
        switch (this.tipo) {
            case RECTANGULO -> {

                int ancho = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;
                int alto = Math.abs(this.coordenadas[0].getY() - this.coordenadas[1].getY()) + 1;

                area = ancho * alto;
            }
            case CIRCUNFERENCIA -> {
                int radio = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;

                area = Math.PI * Math.pow(radio, 2);
            }
            case TRIANGULO -> {

                int base = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;
                int altura = Math.abs(this.coordenadas[2].getY() - this.coordenadas[0].getY()) + 1;

                area = base * altura / 2;
            }
        }
        return area;
    }

    /**
     * Calcula el perimetro
     * @return 
     */
    public double perimetro() {
        double perimetro = 0;
        switch (this.tipo) {
            case RECTANGULO -> {

                int ancho = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;
                int alto = Math.abs(this.coordenadas[0].getY() - this.coordenadas[1].getY()) + 1;

                perimetro = (2 * ancho) + (2 * alto);

            }
            case CIRCUNFERENCIA -> {
                int radio = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;

                perimetro = Math.PI * 2 * radio;

            }
            case TRIANGULO -> {
                int base = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;
                int ladoIzq = Math.abs(this.coordenadas[2].getY() - this.coordenadas[0].getY()) + 1;
                int ladoDer = Math.abs(this.coordenadas[2].getY() - this.coordenadas[1].getY()) + 1;

                perimetro = base + ladoIzq + ladoDer;

            }
        }
        return perimetro;
    }

    /**
     * Indica si es cuadrado, solo si el tipo es RECTANGULO
     * @return 
     */
    public boolean esCuadrado() {
        if (this.tipo == RECTANGULO) {
            int ancho = Math.abs(this.coordenadas[0].getX() - this.coordenadas[1].getX()) + 1;
            int alto = Math.abs(this.coordenadas[0].getY() - this.coordenadas[1].getY()) + 1;
            return ancho == alto;
        }
        return false;

    }

}
