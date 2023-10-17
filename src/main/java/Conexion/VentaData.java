package Conexion;

import static Conexion.Conexion.conn;
import Entidades.Venta;
import Entidades.Cliente;
import java.sql.Date;
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

    public static void guardarVenta(Venta venta) {
        Conectar();
        try {
            String sql = "insert into venta (idCliente, fechaVenta) values (?, ?);";
            var ps = conn.prepareStatement(sql, 1);
            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ps.executeUpdate();

            var rs = ps.getGeneratedKeys();
            rs.next();
            int idVenta = rs.getInt(1);
            venta.setIdVenta(idVenta);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void eliminarVenta(int id) {
        Conectar();
        try {
            DetalleVentaData.eliminarDetalleVenta(id);
            String sql = "delete from venta where idVenta = ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate(); 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     *
     * @param id De venta
     * @return Venta
     */
    public static Venta buscarVenta(int id) {
        Venta venta = null;
        Conectar();
        try {
            String sql = "select * from venta where idVenta = ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                var fechaVenta = rs.getDate("fechaVenta").toLocalDate();
                var cliente = ClienteData.BuscarCliente(idCliente);
                venta = new Venta(id, cliente, fechaVenta);
                rs.close();
            }

            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venta;
    }

    public static List<Venta> listarVentas() {
        List<Venta> lista = new ArrayList<>();
        Conectar();
        try {
            String sql = "select * from venta";
            var ps = conn.prepareStatement(sql);
            var rs = ps.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                var cliente = ClienteData.BuscarCliente(idCliente);
                int idVenta = rs.getInt("idVenta");
                var date = rs.getDate("fechaVenta").toLocalDate();
                lista.add(new Venta(idVenta, cliente, date));
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public static List<Venta> buscarVentas(Cliente cliente) {
        Conectar();
        List<Venta> lista = new ArrayList<>();
        try {
            String sql = "select * from venta where idCliente = ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            var rs = ps.executeQuery();

            while (rs.next()) {
                int idVenta = rs.getInt("idVenta");
                var date = rs.getDate("fechaVenta").toLocalDate();
                lista.add(new Venta(idVenta, cliente, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public static List<Venta> buscarVentas(LocalDate date) {
        Conectar();
        List<Venta> lista = new ArrayList<>();
        try {
            String sql = "select * from venta where fechaVenta = ?";
            var ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(date));
            var rs = ps.executeQuery();

            while (rs.next()) {
                int idVenta = rs.getInt("idVenta");
                int idCliente = rs.getInt("idCliente");
                Cliente cliente = ClienteData.BuscarCliente(idCliente);
                lista.add(new Venta(idVenta, cliente, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public static List<Venta> buscarVentas(LocalDate dateA, LocalDate dateB) {
        List<Venta> lista = new ArrayList<>();
        LocalDate date;
        Conectar();
        try {
            String sql = "select * from venta where fechaVenta between ? and ?";
            var ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(dateA));
            ps.setDate(2, Date.valueOf(dateB));
            var rs = ps.executeQuery();

            while (rs.next()) {
                int idVenta = rs.getInt("idVenta");
                int idCliente = rs.getInt("idCliente");
                date = rs.getDate("fechaVenta").toLocalDate();
                Cliente cliente = ClienteData.BuscarCliente(idCliente);
                lista.add(new Venta(idVenta, cliente, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public static List<Venta> buscarVentas(Cliente cliente, LocalDate dateA, LocalDate dateB) {
        List<Venta> lista = new ArrayList<>();
        LocalDate date;
        Conectar();
        try {
            String sql = "select * from venta where idCliente = ? and fechaVenta between ? and ?";
            var ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.setDate(2, Date.valueOf(dateA));
            ps.setDate(3, Date.valueOf(dateB));
            var rs = ps.executeQuery();

            while (rs.next()) {
                int idVenta = rs.getInt("idVenta");
                int idCliente = rs.getInt("idCliente");
                date = rs.getDate("fechaVenta").toLocalDate();
                lista.add(new Venta(idVenta, cliente, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
