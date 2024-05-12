package principal;

import clases.GestionConciertos;
import java.time.LocalDate;
import java.time.Month;

public class Examen_PROG_2 {
    
    public static void main(String[] args) {
        
        GestionConciertos gestion = new GestionConciertos();
        
        gestion.aniadirArtista(5, "rock", 100, 5, "artista1");
        gestion.aniadirArtista(2, "jazz", 20, 2, "artista2");
        gestion.aniadirArtista(5, "reguaeton", 60, 3, "artista3");
        
        gestion.aniadirAsistente("1234A", LocalDate.of(1990, Month.FEBRUARY, 5), 1, "asistente1");
        gestion.aniadirAsistente("6789B", LocalDate.of(2000, Month.AUGUST, 15), 10, "asistente1");
        gestion.aniadirAsistente("159753C", LocalDate.of(1995, Month.MARCH, 25), 7, "asistente1");
        
        gestion.aniadirConcierto("concierto1", LocalDate.of(2024, Month.JANUARY, 1), 2, "jazz");
        gestion.aniadirConcierto("concierto2", LocalDate.of(2024, Month.AUGUST, 1), 3, "jazz");
        gestion.aniadirConcierto("concierto3", LocalDate.of(2023, Month.DECEMBER, 1), 5, "rock");
        gestion.aniadirConcierto("concierto4", LocalDate.of(2025, Month.JANUARY, 1), 2, "jazz");
        
        gestion.listarArtistas();
        gestion.listarAsistentes();
        gestion.listarConciertos();
        
        gestion.listarConciertosByEstilo("jazz");
        gestion.listarConciertosByArtista(5);
        
        gestion.aniadirAsistenteConcierto("concierto1", 1);
        gestion.aniadirAsistenteConcierto("concierto3", 1);
        gestion.aniadirAsistenteConcierto("concierto1", 11);
        gestion.aniadirAsistenteConcierto("concierto11", 1);
        
        gestion.listarConciertos();
        
        System.out.println("Num conciertos asistente 1 -> " + gestion.numConciertosAsistente(1));
        
        gestion.guardarDatos("conciertos.txt");
        
    }
}
