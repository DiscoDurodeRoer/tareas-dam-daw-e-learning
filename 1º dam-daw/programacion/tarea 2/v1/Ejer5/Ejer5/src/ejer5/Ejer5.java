
package ejer5;

import java.util.Scanner;

public class Ejer5 {

    /**
     * Diseña un programa Java que pida dos números por teclado, 
     * determine si el primero es múltiplo del segundo y muestre el resultado.
     */
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dame el primer numero");
        int num1=sc.nextInt();
        System.out.println("Dame el segundo numero");
        int num2=sc.nextInt();
    
        if(num1%num2 == 0){
            System.out.println("Es multiplo");
        }else{
            System.out.println("No es multiplo");
        }
    
    }
    
}
