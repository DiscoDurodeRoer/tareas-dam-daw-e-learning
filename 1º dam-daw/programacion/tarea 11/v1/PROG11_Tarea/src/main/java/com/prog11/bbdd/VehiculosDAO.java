package com.prog11.bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculosDAO {

    public static int insertarNuevoVehiculo(ConnectionDB conexion, String mat_veh, String marca_veh, int kms_veh, int precio_veh, String desc_veh, int id_prop) {

        try {
            conexion.openConnection();

            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "INSERT INTO vehiculo "
                            + "VALUES (?,?,?,?,?,?)");
            statement.setString(1, mat_veh);
            statement.setString(2, marca_veh);
            statement.setInt(3, kms_veh);
            statement.setInt(4, precio_veh);
            statement.setString(5, desc_veh);
            statement.setInt(6, id_prop);

            statement.executeUpdate();

            statement.close();
            conexion.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;

    }

    public static int actualizarVehiculo(ConnectionDB conexion, String mat_veh, int id_prop) {

        try {
            conexion.openConnection();

            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "UPDATE vehiculo "
                            + "SET id_prop = ? "
                            + "WHERE mat_veh = ?");
            statement.setInt(1, id_prop);
            statement.setString(2, mat_veh);

            int actualizados = statement.executeUpdate();

            if(actualizados == 0){
                return -1;
            }
            
            statement.close();
            conexion.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;

    }

    
    public static int eliminarVehiculo(ConnectionDB conexion, String mat_veh) {

        try {
            conexion.openConnection();

            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "DELETE FROM vehiculo WHERE mat_veh = ?");
            statement.setString(1, mat_veh);

            int borrados = statement.executeUpdate();

            if(borrados == 0){
                return -1;
            }
            
            statement.close();
            conexion.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;

    }

    
    public static ArrayList<String> recuperarTodosVehiculos(ConnectionDB conexion) {
        
        try {
            ArrayList<String> datos = new ArrayList<>();
            
            conexion.openConnection();
            
            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "SELECT v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh, v.desc_veh, p.id_prop, p.nombre_prop, p.dni_prop "
                            + "FROM vehiculo v, propietario p "
                            + "WHERE v.id_prop = p.id_prop "
                    );
            
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
    
    public static ArrayList<String> recuperarTodosVehiculosPorMarca(ConnectionDB conexion, String marca_veh) {
        
        try {
            ArrayList<String> datos = new ArrayList<>();
            
            conexion.openConnection();
            
            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "SELECT v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh, v.desc_veh, p.id_prop, p.nombre_prop, p.dni_prop "
                            + "FROM vehiculo v, propietario p "
                            + "WHERE v.id_prop = p.id_prop "
                            + "AND v.marca_veh = ?"
                    );
            
            statement.setString(1, marca_veh);
            
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
    
    public static ArrayList<String> recuperarVehiculos(ConnectionDB conexion) {
        
        try {
            ArrayList<String> datos = new ArrayList<>();
            
            conexion.openConnection();
            
            PreparedStatement statement = conexion
                    .getConnection()
                    .prepareStatement(
                            "SELECT v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh, v.desc_veh, v.id_prop "
                            + "FROM vehiculo v "
                    );
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                datos.add("Matricula: " + rs.getString("mat_veh") + ", marca: " + rs.getString("marca_veh") + ", km: " + rs.getInt("kms_veh") + ", precio " + rs.getInt("precio_veh") + ", Descripcion: " + rs.getString("desc_veh") + ", id propietario: " + rs.getInt("id_prop"));
            }
            
            conexion.closeConnection();
            return datos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
