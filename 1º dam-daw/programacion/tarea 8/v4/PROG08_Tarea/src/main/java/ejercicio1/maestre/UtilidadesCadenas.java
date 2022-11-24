package ejercicio1.maestre;

public class UtilidadesCadenas {
    
    public static String uneCadenas(String cad1, String cad2){
        return cad1.concat(cad2);
    }

    public static int numLetras(String cad, char letra){
        
        int contador = 0;
        char c;
        for (int i = 0; i < cad.length(); i++) {
            c = cad.charAt(i);
            if(c == letra){
                contador++;
            }
        }
        return contador;
    }
    
    public static boolean palindromo(String cad){
        
        cad = cad.trim().toLowerCase();
        
        String invertida = invertir(cad);
        
        return cad.equals(invertida);
        
    }
    
    public static String invertir(String cad){
        String invertida = "";
        char c;
        for (int i = cad.length() - 1; i >= 0; i--) {
            c = cad.charAt(i);
            invertida += c;
        }
        return invertida;
    }
}
