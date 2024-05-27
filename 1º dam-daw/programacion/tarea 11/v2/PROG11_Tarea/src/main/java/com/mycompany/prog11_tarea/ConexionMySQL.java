package com.mycompany.prog11_tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySQL {

    private Connection conexion;

    public ConexionMySQL(String host, String puerto, String baseDatos, String usuario, String password) {

        // Creo la conexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos, usuario, password);
            conexion.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object[][] executeQuery(String query) throws SQLException {

        // Creo la sentencia
        Statement sentence = conexion.createStatement();
        // Creo el resultset a partir de la sentencia
        ResultSet resultSet = sentence.executeQuery(query);
        // Obtiene los metadatos del resultset
        ResultSetMetaData rsmd = resultSet.getMetaData();

        // Numero de columnas
        int numColumns = rsmd.getColumnCount();

        // Numero de registros
        int numRegisters = numberRegisters(query);

        // Estructura de datos
        Object[][] data = new Object[numRegisters][numColumns];

        // Recorro los datos y añado
        while (resultSet.next()) {
            for (int i = 0; i < numColumns; i++) {
                data[resultSet.getRow() - 1][i] = resultSet.getObject(i + 1);
            }
        }

        // Cierro el resultset y la sentencia
        resultSet.close();
        sentence.close();

        return data;

    }

    private int numberRegisters(String query) throws SQLException {
        // Creo la sentencia
        Statement sentence = conexion.createStatement();
         // Creo el resultset a partir de la sentencia
        ResultSet resultSet = sentence.executeQuery(query);
        
        // Recorro el numero de registros
        int numberRegisters = 0;
        while (resultSet.next()) {
            numberRegisters++;
        }
         // Cierro el resultset y la sentencia
        resultSet.close();
        sentence.close();
        return numberRegisters;
    }

    public int executeInstruction(String instruction) throws SQLException {
         // Creo la sentencia
        Statement sentence = conexion.createStatement();
        // Ejecuto la instruccion (INSERT, UPDATE o DELETE)
        int rows = sentence.executeUpdate(instruction);
        return rows;
    }

}
