package apartado_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 {

    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado(1, "Alfredo", "Calle falsa 1", 1200, 100));
        empleados.add(new Empleado(2, "Alberto", "Calle falsa 2", 1500, 200));
        empleados.add(new Empleado(3, "Jose", "Calle falsa 3", 1700, 300));
        empleados.add(new Empleado(4, "Fernando", "Calle falsa 4", 2200, 400));
        empleados.add(new Empleado(5, "Manuel", "Calle falsa 5", 2700, 500));
        
        
        try {
            RandomAccessFile raf = new RandomAccessFile("EMPLEADOS.DAT", "rw");
            
            for(Empleado e: empleados){
                
                raf.writeInt(e.getCodigo());
                
                StringBuffer sb = new StringBuffer(e.getNombre());
                sb.setLength(20);
                
                raf.writeChars(sb.toString());
                
                sb = new StringBuffer(e.getDireccion());
                sb.setLength(20);
                
                raf.writeChars(sb.toString());
                
                raf.writeFloat(e.getSalario());
                raf.writeFloat(e.getComision());
                
            }
            
            
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
