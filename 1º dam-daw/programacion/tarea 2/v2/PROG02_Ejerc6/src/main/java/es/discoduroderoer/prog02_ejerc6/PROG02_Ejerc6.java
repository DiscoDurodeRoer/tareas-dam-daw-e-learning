
package es.discoduroderoer.prog02_ejerc6;

public class PROG02_Ejerc6 {

    public static void main(String[] args) {
        
        Razas var1 = Razas.Caniche;
        Razas var2 = Razas.Mastin;
        
        System.out.println(var1 == var2);
        System.out.println(var1.getIndex());
        System.out.println(var2.getIndex());
        System.out.println(Razas.values().length);
        
        
    }
    
}
