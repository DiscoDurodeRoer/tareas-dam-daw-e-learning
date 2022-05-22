package proyectopersonajes;

import java.util.Scanner;

/**
 * Tema 3
 *
 * @author DDR
 */
public class Personaje {

    final int MAX_FUERZA = 100;
    final int MAX_INTELIGENCIA = 100;

    static int numeroPersonajes = 0;

    String nombre;
    int edad;
    int altura;
    int inteligencia;
    int fuerza;

    public Personaje() {
        this.nombre = "Desconocido";
        this.edad = 0;
        this.altura = 0;
        this.inteligencia = 0;
        this.fuerza = 0;
        numeroPersonajes++;
    }

    public Personaje(String nombre, int edad, int altura, int inteligencia, int fuerza) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.inteligencia = inteligencia;
        this.fuerza = fuerza;
        numeroPersonajes++;
    }

    String consultaNombre() {
        return this.nombre;
    }

    void cambiaNombre(String nombre) {
        this.nombre = nombre;
    }

    int consultaEdad() {
        return this.edad;
    }

    void cambiaEdad(int edad) {
        this.edad = edad;
    }

    int consultaAltura() {
        return this.altura;
    }

    void cambiaAltura(int altura) {
        this.altura = altura;
    }

    int consultaInteligencia() {
        return this.inteligencia;
    }

    void cambiaInteligencia(int inteligencia) {
        // Si la inteligencia pasada es mayor que 100, el valor de inteligencia es 100
        if(inteligencia > this.MAX_INTELIGENCIA){
            this.inteligencia = this.MAX_INTELIGENCIA;
        }else{
            this.inteligencia = inteligencia;
        }
    }

    void cambiaFuerza(int fuerza) {
        // Si la fuerza pasada es mayor que 100, el valor de fuerza es 100
        if(fuerza > this.MAX_FUERZA){
            this.fuerza = this.MAX_FUERZA;
        }else{
            this.fuerza = fuerza;
        }
    }

    int consultaFuerza() {
        return this.fuerza;
    }

    // apartado 6
    public int sumarFuerza(Personaje p){
        // p1.sumarFuerza(p2)
        // p1 => this.fuerza
        // p2 => p.consultaFuerza()
        return this.fuerza + p.consultaFuerza();
    }
    
    public String toString() {
        return "Nombre: " + nombre + "; Edad: " + edad + " años; Altura: " + altura + " cm; Inteligencia:" + inteligencia + "; Fuerza: " + fuerza;
    }

    public static void main(String[] args) {

        // apartado 1
        System.out.println("Apartado 1");
        // Creamos un Scanner para pedir datos
        // useDelimiter es para evitar problemas de espacios
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        System.out.println("Escribe un nombre");
        String nombre = sn.next();

        Personaje p1 = new Personaje();
        p1.cambiaNombre(nombre);

        System.out.println("Nombre: " + p1.consultaNombre());

        // apartado 2
        System.out.println("Apartado 2");
        p1.cambiaEdad(50);
        p1.cambiaAltura(100);
        p1.cambiaFuerza(200);
        p1.cambiaInteligencia(150);

        System.out.println("Edad: " + p1.consultaEdad());
        System.out.println("Altura: " + p1.consultaAltura());
        System.out.println("Fuerza: " + p1.consultaFuerza());
        System.out.println("Inteligencia: " + p1.consultaInteligencia());

        // apartado 3
        System.out.println("Apartado 3");
        Personaje p2 = new Personaje();

        System.out.println("El valor de la fuerza es: " + p2.fuerza);
        System.out.println("El valor de la fuerza es: " + p2.consultaFuerza());

        System.out.println("El valor del nombre es: " + p2.consultaNombre());
        System.out.println("El valor de la edad es: " + p2.consultaEdad());
        System.out.println("El valor de la altura es: " + p2.consultaAltura());
        System.out.println("El valor de la inteligencia es: " + p2.consultaInteligencia());

        // Apartado 4
        System.out.println("Apartado 4");
        Personaje p3 = new Personaje("Frodo", 33, 126, 98, 38);
        
        // Apartado 5
        System.out.println("Apartado 5");
        System.out.println(p3.toString());
        
        // Apartado 7
        System.out.println("Apartado 7");
        Personaje p4 = new Personaje();
        System.out.println(p4.toString());
        
        Personaje p5 = new Personaje("Frodo", 33, 126, 98, 38);
        Personaje p6 = new Personaje("Aragorn", 45, 185, 88, 92);
        Personaje p7 = new Personaje("Legolas", 2931, 178, 93, 84);
        
        // Muestra los datos de los personajes después de crearlos utilizando el toString().
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println(p7.toString());
        
        // Ahora cambia varias de sus propiedades utilizando los métodos que creaste en el apartado 2.
        p5.cambiaEdad(30);
        p6.cambiaAltura(180);
        p7.cambiaInteligencia(90);
        
        // Vuelve a mostrar los datos de los personajes para comprobar que han cambiado. (con toString())
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println(p7.toString());
    
        // Crea un nuevo personaje inventado, y muestra sus datos. (con toString())
        Personaje p8 = new Personaje("Isildur", 40, 175, 70, 80);
        System.out.println(p8.toString());
        
        // Cambia sus datos y vuélvelo a mostrar. (con toString())
        p8.cambiaAltura(190);
        System.out.println(p8.toString());
        
        // Muestra por pantalla la suma de fuerzas de dos objetos, usando el método sumarFuerzas de alguno de ellos ( y pasarás el otro objeto como parámetro). Se visualizará algo como: “La suma de la fuerza de Frodo y Legolas es: XXX” (dónde XXX, es el valor que devuelve el método, y los nombres serán los de los objetos elegidos)
        System.out.println("La suma de la fuerza de " +p5.consultaNombre()+ " y " +p7.consultaNombre()+ " es: " + p5.sumarFuerza(p7));
        
        // Antes de terminar, muestra el total de personajes que se llevan creados (mostrando el valor de la variable estática)
        System.out.println("numero de personajes: " + Personaje.numeroPersonajes);
        
        // Antes de terminar, muestra el valor de la constante MAX_FUERZA
        System.out.println("Max fuerza: " + p1.MAX_FUERZA);
    
    }

}
