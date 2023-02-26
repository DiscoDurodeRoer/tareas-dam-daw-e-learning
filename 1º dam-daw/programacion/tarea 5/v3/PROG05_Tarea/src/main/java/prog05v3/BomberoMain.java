package prog05v3;

import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BomberoMain {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        try {

            /* 
                a) Cree 3 objetos Puesto, uno de cada categoría, pidiendo los datos a usuario por pantalla
                    (excepto la categoría que debe ser una de cada).
            */
            System.out.println("Escribe el nombre del puesto 1");
            String nombrePuesto1 = sn.next();

            System.out.println("Escribe la descripción del puesto 1");
            String descripcionPuesto1 = sn.next();

            System.out.println("Escribe el nombre del puesto 2");
            String nombrePuesto2 = sn.next();

            System.out.println("Escribe la descripción del puesto 2");
            String descripcionPuesto2 = sn.next();

            System.out.println("Escribe el nombre del puesto 3");
            String nombrePuesto3 = sn.next();

            System.out.println("Escribe la descripción del puesto 3");
            String descripcionPuesto3 = sn.next();

            Puesto p1 = new Puesto(nombrePuesto1, descripcionPuesto1, CategoriaPuesto.PEON);
            Puesto p2 = new Puesto(nombrePuesto2, descripcionPuesto2, CategoriaPuesto.CABO);
            Puesto p3 = new Puesto(nombrePuesto3, descripcionPuesto3, CategoriaPuesto.ESPECIALISTA);

            /* b) Cree 3 objetos bombero con sus parámetros (solicitando los datos por pantalla, 
                excepto la categoría que será uno de cada) y muestre su información por pantalla. 
            */
            System.out.println("Escribe el nombre del bombero 1");
            String nombreBombero1 = sn.next();

            System.out.println("Escribe los apellidos del bombero 1");
            String apellidosBombero1 = sn.next();

            System.out.println("Escribe la edad del bombero 1");
            int edadBombero1 = sn.nextInt();

            System.out.println("Escribe el parque del bombero 1");
            String parqueBombero1 = sn.next();

            System.out.println("Escribe el nombre del bombero 2");
            String nombreBombero2 = sn.next();

            System.out.println("Escribe los apellidos del bombero 2");
            String apellidosBombero2 = sn.next();

            System.out.println("Escribe la edad del bombero 2");
            int edadBombero2 = sn.nextInt();

            System.out.println("Escribe el parque del bombero 2");
            String parqueBombero2 = sn.next();

            System.out.println("Escribe el nombre del bombero 3");
            String nombreBombero3 = sn.next();

            System.out.println("Escribe los apellidos del bombero 3");
            String apellidosBombero3 = sn.next();

            System.out.println("Escribe la edad del bombero 3");
            int edadBombero3 = sn.nextInt();

            System.out.println("Escribe el parque del bombero 3");
            String parqueBombero3 = sn.next();

            Bombero b1 = new Bombero(p1, parqueBombero1, nombreBombero1, apellidosBombero1, edadBombero1, LocalDate.now());
            Bombero b2 = new Bombero(p2, parqueBombero2, nombreBombero2, apellidosBombero2, edadBombero2, LocalDate.now());
            Bombero b3 = new Bombero(p3, parqueBombero3, nombreBombero3, apellidosBombero3, edadBombero3, LocalDate.now());

            System.out.println(b1.getInfo());
            System.out.println(b2.getInfo());
            System.out.println(b3.getInfo());

            // c) Muestre el número de bomberos creados.
            System.out.println("Bomberos creados: " + Bombero.getNumBomberos());

            /* d) Establezca la fecha de ingreso del bombero 1 a más de un año, 
                    la del bombero 2 a más de 5 años y la del bombero 3 a más de 10 años, 
                    calcule su antigüedad y muestre el sueldo nuevo por pantalla. 
            */
            b1.setFechaIngreso(LocalDate.of(2022, Month.JANUARY, 1));
            b2.setFechaIngreso(LocalDate.of(2017, Month.JANUARY, 1));
            b3.setFechaIngreso(LocalDate.of(2010, Month.JANUARY, 1));

            b1.calculoAntiguedad();
            b2.calculoAntiguedad();
            b3.calculoAntiguedad();

            System.out.println(b1.getPuesto().getSueldo());
            System.out.println(b2.getPuesto().getSueldo());
            System.out.println(b3.getPuesto().getSueldo());

            /* e) Solicite al usuario el puesto del bombero1 y lo asigne al objeto, 
                    recalcule su antigüedad y muestre su sueldo por pantalla.
            */
            System.out.println("Escribe el nombre del nuevo puesto 1");
            nombrePuesto1 = sn.next();

            System.out.println("Escribe la descripción del nuevo puesto 1");
            descripcionPuesto1 = sn.next();

            System.out.println("Escribe la categoria del nuevo puesto 1");
            System.out.println("1. PEON");
            System.out.println("2. CABO");
            System.out.println("3. ESPECIALISTA");
            int categoria = sn.nextInt();

            Puesto p4 = new Puesto(nombrePuesto1, descripcionPuesto1, CategoriaPuesto.values()[categoria - 1]);
            b1.setPuesto(p4);
            b1.calculoAntiguedad();
            System.out.println(b1.getPuesto().getSueldo());

            // f) Asigna al bombero 1 el Puesto del bombero 2 y al bombero 3 el Parque del bombero 1.
            b1.setPuesto(b2.getPuesto());
            b3.setParque(b1.getParque());
            
            System.out.println(b1.getInfo());
            System.out.println(b3.getInfo());

        } catch (InputMismatchException e) {
            sn.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
