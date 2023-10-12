/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Conexion.Conexion;
import Conexion.ClienteData;
import Entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cisco
 */
public abstract class ClienteData extends Conexion {

    public static List<Cliente> listaCliente() {
        Conectar();
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "select * from cliente";

            PreparedStatement sqlPD = conn.prepareStatement(sql);

            ResultSet res = sqlPD.executeQuery();

            while (res.next()) {
                Cliente cliente = new Cliente();

                cliente.setApellido(res.getString("Apellido"));
                cliente.setNombre(res.getString("Nombre"));
                cliente.setDni(res.getInt("DNI"));
                cliente.setDomiciio(res.getString("Domicilio"));
                cliente.setTelefono(res.getString("Telefono"));
                cliente.setIdCliente(Integer.parseInt(res.getString("idCliente")));

                clientes.add(cliente);

            }
            return clientes;

        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error al cargar la lista de CLIENTES" + e.getMessage());
        }

        return clientes;
    }

    public static boolean crearCliente(Cliente cliente) {
        Conectar();
        try {
            String sql = "insert into `cliente`(Apellido,Nombre,DNI,Domicilio,Telefono) values (?,?,?,?,?)";

            PreparedStatement sqlPD = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            sqlPD.setString(1, cliente.getApellido());
            sqlPD.setString(2, cliente.getNombre());
            sqlPD.setInt(3, cliente.getDni());
            sqlPD.setString(4, cliente.getDomiciio());
            sqlPD.setString(5, cliente.getTelefono());

            sqlPD.execute();

            ResultSet res = sqlPD.getGeneratedKeys();
            if (res.next()) {
                cliente.setIdCliente(res.getInt(1));
                return true;
            } else {
                System.out.println("Error al generar ID ");
            }

            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear CLIENTE" + e.getMessage());

        }

        return false;
    }

    public static boolean borrarCliente(int idCliente) {
        Conectar();
        try {

//            String sqlEliminarVentas = "ALTER TABLE venta DROP FOREIGN KEY venta_ibfk_1";
//            PreparedStatement stmtEliminarVentas = conn.prepareStatement(sqlEliminarVentas);
//            stmtEliminarVentas.setInt(1, idCliente);
//            stmtEliminarVentas.execute();

            String sqlEliminarDetallesVentas = "ALTER TABLE detalleventa DROP FOREIGN KEY detalleventa_ibfk_1";
            PreparedStatement stmtEliminarDetallesVentas = conn.prepareStatement(sqlEliminarDetallesVentas);
            stmtEliminarDetallesVentas.setInt(1, idCliente);
            stmtEliminarDetallesVentas.execute();

            String sql = "delete from `cliente` where idCliente=?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setInt(1, idCliente);

            sqlPD.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al borrar CLIENTE " + e.getMessage());
            return false;
        }

    }

    public static boolean modifocarCliente(Cliente cliente, int idCliente) {
        Conectar();
        try {
            String sql = "update `cliente` set `Apellido`=? , `Nombre`=? , `Domicilio`=?,`Telefono`=? where idCliente = ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(1, cliente.getApellido());
            sqlPD.setString(2, cliente.getNombre());
            sqlPD.setInt(3, cliente.getDni());
            sqlPD.setString(4, cliente.getDomiciio());
            sqlPD.setString(5, cliente.getTelefono());
            sqlPD.setInt(6, idCliente);

            sqlPD.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("Error al modifificar CLIENTE " + e.getMessage());
        }

        return false;

    }

    public static Cliente BuscarCliente(int idCliente) {
        Conectar();
        Cliente clienteBuscado = null;
        try {
            String sql = "Select * from cliente where idCliente=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                clienteBuscado = new Cliente();
                clienteBuscado.setApellido(rs.getString("Apellido"));
                clienteBuscado.setNombre(rs.getString("Nombre"));
                clienteBuscado.setDni(rs.getInt("DNI"));
                clienteBuscado.setDomiciio(rs.getString("Domicilio"));
                clienteBuscado.setTelefono(rs.getString("Telefono"));
                clienteBuscado.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
            }

            return clienteBuscado;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clienteBuscado;
    }

    public static List<Cliente> listaClientePorDNI(int dni) {
        Conectar();
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "select * from `cliente` where dni like ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(1, dni + "%");

            ResultSet res = sqlPD.executeQuery();

            while (res.next()) {
                Cliente cliente = new Cliente();

                cliente.setApellido(res.getString("Apellido"));
                cliente.setNombre(res.getString("Nombre"));
                cliente.setDni(res.getInt("DNI"));
                cliente.setDomiciio(res.getString("Domicilio"));
                cliente.setTelefono(res.getString("Telefono"));
                cliente.setIdCliente(Integer.parseInt(res.getString("idCliente")));

                clientes.add(cliente);

                return clientes;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Erro al buscar por dni" + e.getMessage());
        }

        return clientes;
    }
    
    
    public static Cliente BuscarClienteDNI (int dni) {
        Conectar();
        Cliente clienteBuscado = null;
        try {
            String sql = "Select * from cliente where DNI=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, dni);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                clienteBuscado = new Cliente();
                clienteBuscado.setApellido(rs.getString("Apellido"));
                clienteBuscado.setNombre(rs.getString("Nombre"));
                clienteBuscado.setDni(rs.getInt("DNI"));
                clienteBuscado.setDomiciio(rs.getString("Domicilio"));
                clienteBuscado.setTelefono(rs.getString("Telefono"));
                clienteBuscado.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
            }
            
            return clienteBuscado;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clienteBuscado;
    }

}
