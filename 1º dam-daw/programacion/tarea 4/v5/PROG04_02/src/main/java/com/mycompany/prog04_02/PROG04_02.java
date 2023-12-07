package com.mycompany.prog04_02;

import java.util.Locale;
import java.util.Scanner;

public class PROG04_02 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        // Introduce las horas y la tarifa
        System.out.println("Introduce el numero de horas");
        int horas = sn.nextInt();

        System.out.println("Introduce la tarifa");
        double tarifa = sn.nextDouble();

        double pago = 0;

        // Controlo las horas
        if (horas > 35) {
            // Resto las horas restantes y lo multiplico por la tarifa por 1.5 veces mas
            double extras = (horas - 35) * (tarifa * 1.5);
            pago = (35 * tarifa) + extras;
        } else {
            pago = horas * tarifa;
        }

        System.out.println("El sueldo bruto es: " + pago);

        // Si el pago es mas de 500
        if (pago > 500) {
            double libreImpuestos75 = 0;
            double libreImpuestos55 = 0;
            // Si el pago esta entre 500 y 900
            if (pago < 900) {
                // Quitamos el 25% de impuestos del resto de 500
                libreImpuestos75 = (pago - 500) * 0.75;
            } else {
                // Quitamos el 25% de impuestos de 400
                libreImpuestos75 = 400 * 0.75;
                // Quitamos el 45% de impuestos del resto
                libreImpuestos55 = (pago - 900) * 0.55;
            }

            // Sumamos todo
            pago = 500 + libreImpuestos75 + libreImpuestos55;
        }

        // mostramos el resultado
        System.out.println("El sueldo neto es: " + pago);

    }
}
