/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.prog06_tarea;

public class Concesionario {
 
    private Vehiculo[] vehiculos;
    private int numVehiculos;
    
    public Concesionario(){
        this.numVehiculos = 0;
        this.vehiculos = new Vehiculo[50];
    }
    
    public Vehiculo buscaVehiculo(String matricula){
        
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.vehiculos[i];
            
            if(v.getMatricula().equals(matricula)){
                return v;
            }
        }
        return null;
    }
    
    public int insertarVehiculo(Vehiculo v){
        
        if(this.numVehiculos == this.vehiculos.length){
            return -1;
        }
        
        if(this.buscaVehiculo(v.getMatricula()) != null){
            return -2;
        }else{
            
            this.vehiculos[this.numVehiculos] = v;
            this.numVehiculos++;
            return 0;
        }
        
        
    }
    
    public void listarVehiculos(){
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.vehiculos[i];
            System.out.println(v.toString());
        }
    }
    
    public boolean actualizaKms(String matricula, int kms){
            
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.vehiculos[i];
            
            if(v.getMatricula().equals(matricula)){
                v.setNumKM(kms);
                return true;
            }
        }
        return false;
        
    }
    
}
