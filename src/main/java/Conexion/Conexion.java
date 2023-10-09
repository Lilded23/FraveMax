/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jdbar
 */
public abstract class Conexion {
    public static Connection conn;

        public static void Conectar() throws ClassNotFoundException {
        if (conn == null)
            try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost/fravemax",
            "root",
         "");   
            
            System.out.println("Se conecto con exito");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
