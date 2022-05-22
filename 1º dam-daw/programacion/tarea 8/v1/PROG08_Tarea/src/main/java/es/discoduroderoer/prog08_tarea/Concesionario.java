
package es.discoduroderoer.prog08_tarea;

import java.util.ArrayList;
import java.util.Collections;

public class Concesionario {
 
    private ArrayList<Vehiculo> vehiculos;
    
    public Concesionario(){
        this.vehiculos = new ArrayList<>();
    }
    
    public Vehiculo buscaVehiculo(String matricula){
        
        for (Vehiculo v:this.vehiculos) {
            if(v.getMatricula().equals(matricula)){
                return v;
            }
        }
        return null;
    }
    
    public int insertarVehiculo(Vehiculo v){
        
        if(this.buscaVehiculo(v.getMatricula()) != null){
            return -2;
        }else{
            
            this.vehiculos.add(v);
            
            Collections.sort(vehiculos);
            
            return 0;
        }
        
        
    }
    
    public void listarVehiculos(){
        for (Vehiculo v:this.vehiculos) {
            System.out.println(v.toString());
        }
    }
    
    public boolean actualizaKms(String matricula, int kms){
            
        for (Vehiculo v:this.vehiculos) {
            
            if(v.getMatricula().equals(matricula)){
                v.setNumKM(kms);
                return true;
            }
        }
        return false;
        
    }
    
    public boolean eliminarVehiculo(String matricula){
            
        for (Vehiculo v:this.vehiculos) {
            
            if(v.getMatricula().equals(matricula)){
                this.vehiculos.remove(v);
                return true;
            }
            
        }
        return false;
    }
    
    
}
