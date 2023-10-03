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

    public ClienteData() {
        try {
            Conectar();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
    }

    public static List<Cliente> listaCliente() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "select * from cliente";

            PreparedStatement sqlPD = conn.prepareStatement(sql);

            ResultSet res = sqlPD.executeQuery();

            while (res.next()) {
                Cliente cliente = new Cliente();

                cliente.setApellido(res.getString("Apellido"));
                cliente.setNombre(res.getString("Nombre"));
                cliente.setDomiciio(res.getString("Domicilio"));
                cliente.setTelefono(res.getString("Telefono"));
                cliente.setIdCliente(Integer.parseInt(res.getString("idCliente")));

                clientes.add(cliente);

            }

            return clientes;

        } catch (Exception e) {
            System.out.println("Error al cargar la lista de CLIENTES" + e.getMessage());
        }
        return clientes;
    }

    public static boolean crearCliente(Cliente cliente) {

        try {
            String sql = "insert into `cliente`(Apellido,Nombre,Domicilio,Telefono) values (?,?,?,?)";

            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(1, cliente.getApellido());
            sqlPD.setString(2, cliente.getNombre());
            sqlPD.setString(3, cliente.getDomiciio());
            sqlPD.setString(4, cliente.getTelefono());

            sqlPD.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear CLIENTE" + e.getMessage());

        }
        return false;
    }

    public static boolean borrarCliente(int idCliente) {
        try {
            String sql = "delete from `cliente` where idCliente=?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setInt(0, idCliente);

            sqlPD.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al borrar CLIENTE " + e.getMessage());
        }
        return false;
    }

    public static boolean modifocarCliente(Cliente cliente, int idCliente) {
        try {
            String sql = "update `cliente` set `Apellido`=? , `Nombre`=? , `Domicilio`=?,`Telefono`=? where idCliente = ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(0, cliente.getApellido());
            sqlPD.setString(1, cliente.getNombre());
            sqlPD.setString(2, cliente.getDomiciio());
            sqlPD.setString(3, cliente.getTelefono());
            sqlPD.setInt(4, idCliente);

            sqlPD.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modifificar CLIENTE " + e.getMessage());
        }
        return false;

    }
    
        
    public static Cliente BuscarCliente(int idCliente){
        Cliente clienteBuscado=null;
        try {
            String sql="Select * into cliente where idCliente=?";
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            ResultSet rs= pstm.executeQuery();
            while (rs.next()) {
              clienteBuscado.setApellido(rs.getString("Apellido"));
                clienteBuscado.setNombre(rs.getString("Nombre"));
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
