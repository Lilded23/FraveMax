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
                cliente.setCorreo(res.getString("Correo"));

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
            String sql = "insert into `cliente`(Apellido,Nombre,DNI,Domicilio,Telefono,Correo) values (?,?,?,?,?,?)";

            PreparedStatement sqlPD = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            sqlPD.setString(1, cliente.getApellido());
            sqlPD.setString(2, cliente.getNombre());
            sqlPD.setInt(3, cliente.getDni());
            sqlPD.setString(4, cliente.getDomiciio());
            sqlPD.setString(5, cliente.getTelefono());
            sqlPD.setString(6, cliente.getCorreo());
            int filaMod = sqlPD.executeUpdate();
            if (filaMod > 0) {
                ResultSet res = sqlPD.getGeneratedKeys();
                if (res.next()) {
                    System.out.println("Se ejecuto");
                    cliente.setIdCliente(res.getInt(1));
                    return true;
                } else {
                    System.out.println("Error al generar ID ");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al crear CLIENTE" + e.getMessage());

        }

        return false;
    }

    public static boolean borrarCliente(int idCliente) {
        Conectar();
        try {

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
            String sql = "UPDATE `cliente` SET `Apellido`=?,`Nombre`=?,`DNI`=?,`Domicilio`=?,`Telefono`=?, Correo=? WHERE idCliente = ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(1, cliente.getApellido());
            sqlPD.setString(2, cliente.getNombre());
            sqlPD.setInt(3, cliente.getDni());
            sqlPD.setString(4, cliente.getDomiciio());
            sqlPD.setString(5, cliente.getTelefono());
            sqlPD.setString(6, cliente.getCorreo());
            sqlPD.setInt(7, idCliente);

            int res = sqlPD.executeUpdate();
            System.out.println(res);
            if (res > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error al modifificar CLIENTE " + e.getMessage());
            return false;
        }

    }

    public static void agregaCorreo(String correo, int idCliente) {
        Conectar();
        try {
            String sql = "UPDATE cliente SET  Correo=? WHERE idCliente = ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);
            sqlPD.setString(1, correo);
            sqlPD.setInt(2, idCliente);
            sqlPD.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modifificar CLIENTE " + e.getMessage());
        }

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
                clienteBuscado.setCorreo(rs.getString("Correo"));
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
                cliente.setCorreo(res.getString("Correo"));
                cliente.setIdCliente(Integer.parseInt(res.getString("idCliente")));

                clientes.add(cliente);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Erro al buscar por dni" + e.getMessage());
        }

        return clientes;
    }

    public static Cliente BuscarClienteDNI(int dni) {
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
                clienteBuscado.setCorreo(rs.getString("Correo"));
                clienteBuscado.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
            }

            return clienteBuscado;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clienteBuscado;
    }

    public static List<Cliente> ClientesPorNombreApellido(String name) {
        Conectar();
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "select * from `cliente` where Nombre like ? or Apellido like ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(1, name + "%");
            sqlPD.setString(2, name + "%");

            ResultSet res = sqlPD.executeQuery();

            while (res.next()) {
                Cliente cliente = new Cliente();

                cliente.setApellido(res.getString("Apellido"));
                cliente.setNombre(res.getString("Nombre"));
                cliente.setDni(res.getInt("DNI"));
                cliente.setDomiciio(res.getString("Domicilio"));
                cliente.setTelefono(res.getString("Telefono"));
                cliente.setCorreo(res.getString("Correo"));
                cliente.setIdCliente(Integer.parseInt(res.getString("idCliente")));

                clientes.add(cliente);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Erro al buscar por dni" + e.getMessage());
        }

        return clientes;
    }

}

