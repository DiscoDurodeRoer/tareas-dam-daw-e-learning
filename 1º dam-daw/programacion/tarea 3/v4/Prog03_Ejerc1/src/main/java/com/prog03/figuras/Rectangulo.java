package com.prog03.figuras;

public class Rectangulo {

    private float base;
    private float altura;

    public Rectangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public float getArea(){
        return this.base * this.altura;
    }
    
    @Override
    public String toString(){
        return "Area: " + this.getArea() + ", altura " + this.altura; 
    }
    
    public boolean isCuadrado(){
        return this.base == this.altura;
    }

}
