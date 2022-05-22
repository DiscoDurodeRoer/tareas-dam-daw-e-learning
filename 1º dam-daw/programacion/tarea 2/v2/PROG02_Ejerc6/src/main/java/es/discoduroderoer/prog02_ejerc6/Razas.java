
package es.discoduroderoer.prog02_ejerc6;

public enum Razas {
    Mastin(0), Terrier(1), Bulldog(2), Pekines(3), Caniche(4), Galgo(5);
    
    private int index;
    
    private Razas(int index){
        this.index = index;
    }
    
    public int getIndex(){
        return this.index;
    }
    
}
