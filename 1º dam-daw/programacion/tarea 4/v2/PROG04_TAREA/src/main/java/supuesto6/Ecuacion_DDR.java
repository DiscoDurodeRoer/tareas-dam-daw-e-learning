package supuesto6;

/**
 * Supuesto 6
 * @author DDR
 */
public class Ecuacion_DDR {

    /*Atributos*/
    private int a;
    private int b;
    private int c;

    /**
     * Ecuacion de 2º grado
     */
    public Ecuacion_DDR() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    
    /**
     * Ecuacion de 2º grado
     *
     * @param a
     * @param b
     * @param c
     */
    public Ecuacion_DDR(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /* Getters and setters */
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    /**
     * Calcula la primera solucion valida
     * @param a
     * @param b
     * @param c
     * @return
     * @throws ExcepcionDiscriminanteNegativo 
     */
    public double calcularX1(int a, int b, int c) throws ExcepcionDiscriminanteNegativo {
        double x1 = (-b + Math.sqrt(this.comprobarDiscriminante(a, b, c))) / (2 * a);
        return x1;
    }

    
    /**
     * Calcula la segunda solucion valida
     * @param a
     * @param b
     * @param c
     * @return
     * @throws ExcepcionDiscriminanteNegativo 
     */
    public double calcularX2(int a, int b, int c) throws ExcepcionDiscriminanteNegativo {
        double x2 = (-b - Math.sqrt(this.comprobarDiscriminante(a, b, c))) / (2 * a);
        return x2;
    }

    /**
     * Calcula el valor del discriminante
     * @param a
     * @param b
     * @param c
     * @return
     * @throws ExcepcionDiscriminanteNegativo 
     */
    public int comprobarDiscriminante(int a, int b, int c) throws ExcepcionDiscriminanteNegativo {

        int discriminante = (int) Math.pow(b, 2) - (4 * a * c);

        if (discriminante >= 0) {
            return discriminante;
        } else {
            throw new ExcepcionDiscriminanteNegativo("EL DISCRIMINANTE ES NEGATIVO: NO HAY SOLUCIONES REALES");
        }

    }

    public static void main(String[] args) {
        int a, b, c;
        a = 3;
        b = 2;
        c = 5;
        try {
            Ecuacion_DDR miEcuacion = new Ecuacion_DDR(a, b, c);
            double x1 = miEcuacion.calcularX1(a, b, c);
            double x2 = miEcuacion.calcularX2(a, b, c);

            System.out.println("La primera solución de la ecuación de segundo grado a=" + a + ", b=" + b + " c=" + c + " es: " + x1);
            System.out.println("La segunda solución de la ecuación de segundo grado a=" + a + ", b=" + b + " c=" + c + " es: " + x2);

        } catch (ExcepcionDiscriminanteNegativo ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
