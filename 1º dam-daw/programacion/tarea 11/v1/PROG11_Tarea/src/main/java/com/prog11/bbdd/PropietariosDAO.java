package com.prog11.bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PropietariosDAO {
    
    public static int insertarPropietario(ConnectionDB conexion, int id_prop, String nombre_prop, String dni_prop) {
        
        try {
            conexion.openConnection();
            
            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "INSERT INTO propietario(id_prop, nombre_prop, dni_prop) "
                            + "VALUES (?,?,?)");
            statement.setInt(1, id_prop);
            statement.setString(2, nombre_prop);
            statement.setString(3, dni_prop);
            
            statement.executeUpdate();
            
            statement.close();
            conexion.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    
    public static ArrayList<String> recuperarVehiculos(ConnectionDB conexion, String dni_prop) {
        
        try {
            ArrayList<String> datos = new ArrayList<>();
            
            conexion.openConnection();
            
            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "SELECT v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh, v.desc_veh, p.id_prop, p.nombre_prop, p.dni_prop "
                            + "FROM vehiculo v, propietario p "
                            + "WHERE v.id_prop = p.id_prop "
                            + "AND p.dni_prop = ?"
                    );
            
            statement.setString(1, dni_prop);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                datos.add("Matricula: " + rs.getString("mat_veh") + ", marca: " + rs.getString("marca_veh") + ", km: " + rs.getInt("kms_veh") + ", precio " + rs.getInt("precio_veh") + ", Descripcion: " + rs.getString("desc_veh") + ", id propietario: " + rs.getInt("id_prop") + ", nombre propietario: " + rs.getString("nombre_prop") + ", dni propietario: " + rs.getString("dni_prop"));
            }
            
            conexion.closeConnection();
            return datos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    public static int eliminarPropietario(ConnectionDB conexion, String dni_prop) {
        
        try {
            conexion.openConnection();
            
            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement("DELETE FROM propietario WHERE dni_prop = ?");
            statement.setString(1, dni_prop);
            
            int eliminados = statement.executeUpdate();
            
            statement.close();
            conexion.closeConnection();
            return eliminados;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
}
