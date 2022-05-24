package tarea03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {

        try {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vuelos", "123456");

            boolean salir = false;
            int opcion;
            Statement statement;
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            String codVuelo, horaSalida, destino, procedencia, codVueloAnterior = null;
            int plazasFumador, plazasNoFumador, plazasTurista, plazasPrimera;
            int filas;

            while (!salir) {

                System.out.println("1. Mostrar y pedir información de la base de datos en general.");
                System.out.println("2. Mostrar la información de la tabla pasajeros.");
                System.out.println("3. Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.");
                System.out.println("4. Insertar un vuelo cuyos valores se pasan como parámetros.");
                System.out.println("5. Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.");
                System.out.println("6. Modificar los vuelos de fumadores a no fumadores.");
                System.out.println("7. Salir");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        statement = conexion.createStatement();
                        resultSet = statement.executeQuery("select * from pasajeros");
                        ResultSetMetaData rsmd = resultSet.getMetaData();

                        int columnas = rsmd.getColumnCount();
                        for (int i = 1; i <= columnas; i++) {
                            System.out.println("Información acerca de la columna " + rsmd.getColumnName(i));
                            System.out.println("Tipo de la columna: " + rsmd.getColumnTypeName(i));
                            System.out.println("Precisión: " + rsmd.getPrecision(i));
                        }

                        resultSet = statement.executeQuery("select * from vuelos");
                        rsmd = resultSet.getMetaData();

                        columnas = rsmd.getColumnCount();
                        for (int i = 1; i <= columnas; i++) {
                            System.out.println("Información acerca de la columna " + rsmd.getColumnName(i));
                            System.out.println("Tipo de la columna: " + rsmd.getColumnTypeName(i));
                            System.out.println("Precisión: " + rsmd.getPrecision(i));
                        }

                        resultSet.close();
                        statement.close();
                        break;
                    case 2:

                        statement = conexion.createStatement();
                        resultSet = statement.executeQuery("select * from pasajeros");

                        System.out.println("NUM\tCOD_VUELO\tTIPO_PLAZA\tFUMADOR\t");

                        while (resultSet.next()) {
                            System.out.print(resultSet.getInt("NUM") + "\t");
                            System.out.print(resultSet.getString("COD_VUELO") + "\t");
                            System.out.print(resultSet.getString("TIPO_PLAZA") + "\t\t");
                            System.out.print(resultSet.getString("FUMADOR") + "\t");
                            System.out.println("");

                        }

                        resultSet.close();
                        statement.close();

                        break;
                    case 3:

                        preparedStatement = conexion.prepareStatement("select * from pasajeros where cod_vuelo = ?");

                        System.out.println("Inserta el codigo vuelo");
                        codVuelo = sn.next();

                        preparedStatement.setString(1, codVuelo);

                        resultSet = preparedStatement.executeQuery();

                        System.out.println("NUM\tCOD_VUELO\tTIPO_PLAZA\tFUMADOR\t");

                        while (resultSet.next()) {
                            System.out.print(resultSet.getInt("NUM") + "\t");
                            System.out.print(resultSet.getString("COD_VUELO") + "\t");
                            System.out.print(resultSet.getString("TIPO_PLAZA") + "\t\t");
                            System.out.print(resultSet.getString("FUMADOR") + "\t");
                            System.out.println("");
                        }

                        resultSet.close();
                        preparedStatement.close();

                        break;
                    case 4:

                        preparedStatement = conexion.prepareStatement("insert into vuelos values(?,?,?,?,?,?,?,?)");

                        System.out.println("Inserta el codigo vuelo");
                        codVuelo = sn.next();

                        System.out.println("Inserta la hora de salida");
                        horaSalida = sn.next();

                        System.out.println("Inserta el destino");
                        destino = sn.next();

                        System.out.println("Inserta el destino");
                        procedencia = sn.next();

                        System.out.println("Inserta el numero de plazas de fumador");
                        plazasFumador = sn.nextInt();

                        System.out.println("Inserta el numero de plazas de no fumador");
                        plazasNoFumador = sn.nextInt();

                        System.out.println("Inserta el numero de plazas de turista");
                        plazasTurista = sn.nextInt();

                        System.out.println("Inserta el numero de plazas de primera");
                        plazasPrimera = sn.nextInt();

                        preparedStatement.setString(1, codVuelo);
                        preparedStatement.setString(2, horaSalida);
                        preparedStatement.setString(3, destino);
                        preparedStatement.setString(4, procedencia);
                        preparedStatement.setInt(5, plazasFumador);
                        preparedStatement.setInt(6, plazasNoFumador);
                        preparedStatement.setInt(7, plazasTurista);
                        preparedStatement.setInt(8, plazasPrimera);

                        filas = preparedStatement.executeUpdate();

                        if (filas > 0) {
                            System.out.println("Se ha insertado el vuelo");
                            codVueloAnterior = codVuelo;
                        }

                        preparedStatement.close();

                        break;
                    case 5:

                        if (codVueloAnterior != null) {

                            preparedStatement = conexion.prepareStatement("DELETE FROM vuelos WHERE cod_vuelo = ?");

                            preparedStatement.setString(1, codVueloAnterior);

                            filas = preparedStatement.executeUpdate();

                            if (filas > 0) {
                                System.out.println("Se ha borrado el vuelo");
                            }

                            preparedStatement.close();
                        } else {
                            System.out.println("Debes insertar un nuevo vuelo antes");
                        }

                        break;
                    case 6:

                        statement = conexion.createStatement();

                        filas = statement.executeUpdate("UPDATE pasajeros SET FUMADOR = 'NO'");

                        if(filas > 0){
                            System.out.println("se ha actualizado los pasajeros de fumadores a no fumadores");
                        }
                        
                        filas = statement.executeUpdate("UPDATE vuelos SET PLAZAS_NO_FUMADOR = PLAZAS_NO_FUMADOR + PLAZAS_FUMADOR, PLAZAS_FUMADOR = 0");

                        if(filas > 0){
                            System.out.println("se ha actualizado los vuelos de fumadores a no fumadores");
                        }
                        
                        statement.close();
                        
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opción debe estar entre 1 y 7");
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
