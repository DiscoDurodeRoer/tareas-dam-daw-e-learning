
package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    private Connection conexion;
    
    public void openConnection() throws SQLException{
        this.conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3316/concesionario", "root", "root");
    }
    
    public void closeConnection() throws SQLException{
        this.conexion.close();
    }
    
    public Connection getConnection(){
        return this.conexion;
    }
    
}
