package com.mycompany.prog03;

import java.util.Locale;
import java.util.Scanner;

public class Trabajador {

    String nombre;
    int edad;
    float altura;

    public Trabajador() {
        nombre = "Alberto Garcia";
        altura = 1.79f;
        edad = 29;
    }
    
    public Trabajador(String nombre, int edad, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    String consulta_Nombre() {
        return nombre;
    }

    void cambia_Nombre(String nom) {
        nombre = nom;
    }

    int consulta_Edad() {
        return edad;
    }

    void cambia_Edad(int e) {
        edad = e;
    }

    float consulta_Altura() {
        return altura;
    }

    void cambia_Altura(float a) {
        altura = a;
    }

    public void principal() {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);

        System.out.println("Introduce un nombre");
        nombre = sn.next();

        System.out.println("Introduce una edad");
        edad = sn.nextInt();

        System.out.println("Introduce una altura");
        altura = sn.nextFloat();

        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(altura);

    }

}
