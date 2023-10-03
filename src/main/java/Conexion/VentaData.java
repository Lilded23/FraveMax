/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Entidades.Venta;
import Entidades.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cisco
 */
public abstract class VentaData extends Conexion {
    
    public static void guardarVenta(Venta venta, Cliente cliente) {
        try {
            String sql = "insert into venta (idCliente, fechaVenta) values (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void eliminarVenta(int id) {
        try {
            String sql = "delete from venta where idVenta = ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param id de venta
     * @return Venta
     */
    public static Venta buscarVenta(int id) {
        Venta venta = null;
        try {
            String sql = "select * from venta where idVenta = ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            int idCliente;
            Date date = null;
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
                date = rs.getDate("fechaVenta");
            }   
            var cliente = ClienteData.BuscarCliente(idCliente);
            venta = new Venta(cliente, date);
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venta;
    }
    
    public static List<Venta> buscarVentas(Cliente cliente) {
        List<Venta> lista = new ArrayList<>();
        try {
            String sql = "select * from venta where idCliente = ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            var rs = ps.executeQuery();
            while (rs.next()) {
                var date = rs.getDate("fechaVenta").toLocalDate();
                lista.add(new Venta(cliente, date));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
        public static List<Venta> buscarVentas(LocalDate date) {
        List<Venta> lista = new ArrayList<>();
        try {
            String sql = "select * from venta where fechaVenta = ?";
            var ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(date));
            var rs = ps.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                Cliente cliente = ClienteData.buscarCliente(idCliente);
                lista.add(new Venta(cliente, date));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}