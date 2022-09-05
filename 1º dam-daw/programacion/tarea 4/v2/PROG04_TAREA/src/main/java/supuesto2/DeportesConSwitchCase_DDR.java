
package supuesto2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Supuesto 2
 * @author DDR
 */
public class DeportesConSwitchCase_DDR {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        
        boolean correcto = false;
        int temp = 0;
        // Validamos la temperatura
        do{
            try {
                System.out.println("Escribe una temperatura");
                temp = sn.nextInt();
                // Si llego aqui es que se ha insertado un número
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                correcto = false;
                sn.next();
            }
        }while(!correcto);
        
        System.out.println("El deporte mas apropiado es: ");
        
        // Con switch case, no se puede mostrar todos los casos, ya que no se pueden indicar rangos mayores o menorea a X
        if(temp > 30){
            System.out.println("Natación");
        }else {
            
            switch(temp){
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                    System.out.println("Golf");
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    System.out.println("Tenis");
                    break;
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                case -3:
                case -2:
                case -1:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Esquí");
                    break;
                // Menor que -10
                default:
                    System.out.println("Damas");
            }
            
        }
        
    }
    
}
