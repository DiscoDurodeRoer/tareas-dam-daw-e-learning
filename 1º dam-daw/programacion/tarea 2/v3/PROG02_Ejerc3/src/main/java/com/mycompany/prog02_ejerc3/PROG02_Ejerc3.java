package com.mycompany.prog02_ejerc3;

public class PROG02_Ejerc3 {

    public static void main(String[] args) {
        
        boolean var1 = true, var2 = true, var3 = false;
        byte X = 5, Y = -8, Z = 10;
        
        // true, && tiene mas preferencia que ||
        System.out.println(  var1 || var2 && var3 );
        // false
        System.out.println(  (var1 || var3) && (var2 && !var1) );
        // true
        System.out.println(  (var2 || !var1 || !var3) && var1 );
        // false
        System.out.println(  (X>3 || Y>3) && Z<-3 );
        // true
        System.out.println(  (X+Z == 15) && (Y != 2) );
        
        
    }
}
