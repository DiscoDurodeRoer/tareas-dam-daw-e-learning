package prog04;

import java.util.Scanner;

public class Prog04Ejer05 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        
        String clave = "eureka";
        
        System.out.println("Escribe una clave");
        String claveUsuario = sn.next();
        
        if(clave.equals(claveUsuario)){
            System.out.println("Has acertado");
        }else{
            System.out.println("No has acertado");
        }
    }
    
}
