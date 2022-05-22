package tarea_3_dam_daw_elearning;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class EntradaArticulos {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);

        try {

            // Articulo 1
            Articulo art1 = new Articulo();

            System.out.println("Introduce el codigo de barras");
            art1.setCodigo_barra(sn.next());

            System.out.println("Introduce el denominacion");
            art1.setDenominacion(sn.next());

            System.out.println("Introduce el unidades");
            art1.setUnidades(sn.nextInt());

            System.out.println("Introduce el precio compra");
            art1.setPrecio_compra(sn.nextDouble());

            System.out.println("Introduce el beneficio");
            art1.setBeneficio(sn.nextInt());

            art1.calcularPVP();

            // Articulo 2
            System.out.println("Introduce el codigo de barras");
            String codigo_barras = sn.next();

            System.out.println("Introduce el denominacion");
            String denominacion = sn.next();

            System.out.println("Introduce el unidades");
            int unidades = sn.nextInt();

            System.out.println("Introduce el precio compra");
            double precio_compra = sn.nextDouble();

            System.out.println("Introduce el beneficio");
            int beneficio = sn.nextInt();

            Articulo art2 = new Articulo(codigo_barras,
                    denominacion,
                    unidades,
                    precio_compra,
                    beneficio);

            // Articulo 3
            System.out.println("Introduce el codigo de barras");
            codigo_barras = sn.next();

            System.out.println("Introduce el denominacion");
            denominacion = sn.next();

            System.out.println("Introduce el unidades");
            unidades = sn.nextInt();

            System.out.println("Introduce el precio compra");
            precio_compra = sn.nextDouble();

            System.out.println("Introduce el beneficio");
            beneficio = sn.nextInt();

            Articulo art3 = new Articulo();

            art3.setCodigo_barra(codigo_barras);
            art3.setDenominacion(denominacion);
            art3.setUnidades(unidades);
            art3.setPrecio_compra(precio_compra);
            art3.setBeneficio(beneficio);

            art3.calcularPVP();

            // mostrar datos
            System.out.println("Articulo 1");
            System.out.println("Cod barras " + art1.getCodigo_barra());
            System.out.println("Denominacion " + art1.getDenominacion());
            System.out.println("Unidades " + art1.getUnidades());
            System.out.println("Precio compra " + art1.getPrecio_compra());
            System.out.println("Beneficio " + art1.getBeneficio());
            System.out.println("PVP "+ art1.getPvp());
            System.out.println("");

            System.out.println("Articulo 2");
            System.out.println("Cod barras " + art2.getCodigo_barra());
            System.out.println("Denominacion " + art2.getDenominacion());
            System.out.println("Unidades " + art2.getUnidades());
            System.out.println("Precio compra " + art2.getPrecio_compra());
            System.out.println("Beneficio " + art2.getBeneficio());
            System.out.println("PVP "+ art2.getPvp());
            System.out.println("");

            System.out.println("Articulo 3");
            System.out.println("Cod barras " + art3.getCodigo_barra());
            System.out.println("Denominacion " + art3.getDenominacion());
            System.out.println("Unidades " + art3.getUnidades());
            System.out.println("Precio compra " + art3.getPrecio_compra());
            System.out.println("Beneficio " + art3.getBeneficio());
            System.out.println("PVP "+ art3.getPvp());
            System.out.println("");

        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
