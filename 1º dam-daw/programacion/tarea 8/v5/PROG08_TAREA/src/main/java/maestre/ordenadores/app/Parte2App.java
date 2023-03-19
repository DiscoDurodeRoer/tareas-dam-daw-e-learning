package maestre.ordenadores.app;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import maestre.electrodomesticos.Aspirador;
import maestre.general.interfaces.Reparable;
import maestre.ordenadores.modelo.Ordenador;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;
import maestre.ordenadores.modelo.TipoDiscoDuro;

public class Parte2App {

    public static void main(String[] args) {

        try {
            Reparable[] cosas = {
                new Portatil((short) 24, (short) 300, "1234", "samsumg", "galaxy", (short) 8, "Intel", (byte) 2, TipoDiscoDuro.HDD, false),
                new Portatil((short) 20, (short) 300, "5678", "razer", "blaze", (short) 2, "AMD", (byte) 4, TipoDiscoDuro.SSD, false),
                new Sobremesa("msi", "nvidia", "4567", "dell", "optiplex", (short) 32, "AMD", (byte) 1, TipoDiscoDuro.SSD, false),
                new Sobremesa("asus", "nvidia", "8912", "asus", "essentials", (short) 16, "Intel", (byte) 4, TipoDiscoDuro.SSD, false),
                new Aspirador(500),
                new Aspirador(1000)
            };

            reparaTodo(cosas);

            Portatil[] portatiles = {
                new Portatil((short) 24, (short) 300, "1234", "samsumg", "galaxy", (short) 8, "Intel", (byte) 2, TipoDiscoDuro.HDD, false),
                new Portatil((short) 20, (short) 300, "5678", "razer", "blaze", (short) 2, "AMD", (byte) 4, TipoDiscoDuro.SSD, false),
                new Portatil((short) 28, (short) 300, "9123", "msi", "prestige", (short) 4, "Intel", (byte) 8, TipoDiscoDuro.SSD, false),};

            System.out.println("Portatiles desordenados");
            for (Portatil portatil : portatiles) {
                System.out.println(portatil);
            }
            Arrays.sort(portatiles);
            
            System.out.println("Portatiles ordenados");
            for (Portatil portatil : portatiles) {
                System.out.println(portatil);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void reparaTodo(Reparable cosas[]) {
        for (Reparable cosa : cosas) {
            cosa.reparar();
        }
    }

}
