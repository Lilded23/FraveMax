/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jdbar
 */
public abstract class Conexion {

    public static Connection conn;

    public static void Conectar() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            if (conn == null || !conn.isValid(5)) {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost/fravemax",
                        "root",
                        "");
                System.out.println("Conectado =)");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "No se pudo establecer una conexión a la base de datos."
            );
            System.exit(0);
        }

    }

    public static void Desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
