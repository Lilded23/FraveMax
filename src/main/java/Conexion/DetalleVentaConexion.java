package Conexion;

import Entidades.Producto;
import Entidades.Venta;
import Entidades.detalleVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Angel
 */
public abstract class DetalleVentaConexion extends Conexion {

// Método para registrar un nuevo detalle de venta
    public static boolean registrarDetalleVenta(detalleVenta nuevodv) {
        try {
            String sql = "INSERT INTO DetalleVenta ( idProducto, cantidad, precioVenta,idVenta) VALUES (?, ?, ?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nuevodv.getProducto().getIdProducto());
            pstmt.setInt(2, nuevodv.getCantidad());
            pstmt.setDouble(3, nuevodv.getPrecioVenta());
            pstmt.setInt(4, nuevodv.getVenta().getIdVenta());

            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// Método para actualizar un detalle de venta existente
    public static boolean actualizarDetalleVenta(int idDetalleVenta, detalleVenta dv) {
        try {
            String sql = "UPDATE DetalleVenta SET cantidad = ?, precioVenta = ? WHERE idDetalleVenta = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dv.getCantidad());
            pstmt.setDouble(2, dv.getPrecioVenta());
            pstmt.setInt(3, idDetalleVenta);

            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// Método para listar detalles de venta de una venta específica
    public static List<detalleVenta> listarDetallesDeVenta() {
        List<detalleVenta> listaIdVentas = new ArrayList();
        try {
            String sql = "SELECT * FROM DetalleVenta";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idDetalleVenta = rs.getInt("idDetalleVenta");
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("cantidad");
                int idVenta = rs.getInt("idVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
                double precioVenta = prod.getPrecioActual() * cantidad;
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                dv.setIdDetalleVenta(idDetalleVenta);
                listaIdVentas.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIdVentas;
    }

    //Metodo para detalles de venta por una fecha especifica
    // Pendiente PrecioVenta
    public static List<detalleVenta> ListaPorFecha(LocalDate fecha) {
        List<detalleVenta> listaVentasFecha = new ArrayList();
        try {
            String sql = "SELECT dv.* "
                    + "FROM DetalleVenta dv "
                    + "JOIN Venta v ON dv.idVenta = v.idVenta "
                    + "WHERE v.fechaVenta = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDetalleVenta = rs.getInt("idDetalleVenta");
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("cantidad");
                int idVenta = rs.getInt("idVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
                double precioVenta = prod.getPrecioActual() * cantidad;
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                dv.setIdDetalleVenta(idDetalleVenta);
                listaVentasFecha.add(dv);
            }
            return listaVentasFecha;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentasFecha;
    }

    //Metodo para detalles de venta por un Cliente
    // Pendiente PrecioVenta
    public static List<detalleVenta> ListaPorCliente(int idCliente) {
        List<detalleVenta> listaVentasClientes = new ArrayList();
        try {
            String sql = "SELECT dv.* "
                    + "FROM DetalleVenta dv "
                    + "JOIN Venta v ON dv.idVenta = v.idVenta "
                    + "JOIN Cliente c ON v.idCliente = c.idCliente "
                    + "WHERE c.idCliente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDetalleVenta = rs.getInt("idDetalleVenta");
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("cantidad");
                int idVenta = rs.getInt("idVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
                double precioVenta = prod.getPrecioActual() * cantidad;
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                dv.setIdDetalleVenta(idDetalleVenta);
                listaVentasClientes.add(dv);
            }
            return listaVentasClientes;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentasClientes;
    }

}
