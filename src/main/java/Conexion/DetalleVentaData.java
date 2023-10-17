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
public abstract class DetalleVentaData extends Conexion {

// Método para registrar un nuevo detalle de venta
    public static boolean registrarDetalleVenta(detalleVenta nuevodv) {
        double precio = nuevodv.getProducto().getPrecioActual() * nuevodv.getCantidad();
        try {
            String sql = "INSERT INTO DetalleVenta ( idProducto, cantidad, precioVenta,idVenta) VALUES (?, ?, ?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nuevodv.getProducto().getIdProducto());
            pstmt.setInt(2, nuevodv.getCantidad());
            pstmt.setDouble(3, precio);
            pstmt.setInt(4, nuevodv.getVenta().getIdVenta());

            int rs = pstmt.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// Método para eliminar un detalle de venta existente
    
    public static boolean eliminarDetalleVenta(int idVenta) {
        try {
            String sql = "delete from DetalleVenta WHERE idVenta = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idVenta);

            int rs = pstmt.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean eliminarDetalleVenta(int idVenta, int idProd) {
        try {
            String sql = "delete from DetalleVenta WHERE idVenta = ? and idProducto=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idVenta);
            pstmt.setInt(2, idProd);

            int rs = pstmt.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
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
                double precioVenta = rs.getDouble("precioVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
//                double precioVenta = prod.getPrecioActual() * cantidad;
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                dv.setIdDetalleVenta(idDetalleVenta);
                listaIdVentas.add(dv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
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
                double precioVenta = rs.getDouble("precioVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
//                double precioVenta = prod.getPrecioActual() * cantidad;
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                dv.setIdDetalleVenta(idDetalleVenta);
                listaVentasFecha.add(dv);
            }
            return listaVentasFecha;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
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
                double precioVenta = rs.getDouble("precioVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
//                double precioVenta = prod.getPrecioActual() * cantidad;
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                dv.setIdDetalleVenta(idDetalleVenta);
                listaVentasClientes.add(dv);
            }
            return listaVentasClientes;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentasClientes;
    }

    // Método para listar detalles de venta con multiples products
    public static List<detalleVenta> listaProductosPorIdVenta(int idVenta) {
        List<detalleVenta> prodVendidos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DetalleVenta where idVenta=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idVenta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("Cantidad");
                double precio = rs.getDouble("precioVenta");
                Producto prod = ProductoData.buscarPorId(idProducto);
                detalleVenta dv = new detalleVenta(cantidad, precio, prod);
                prodVendidos.add(dv);
            }
            return prodVendidos;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

// Método para obtener todas las idProducto por idCliente y fechaVenta
    public static List<Integer> obtenerIdProductosPorClienteYFecha(int idCliente, LocalDate fechaVenta) {
        List<Integer> idProductos = new ArrayList<>();
        try {
            String sql = "SELECT dv.idProducto "
                    + "FROM DetalleVenta dv "
                    + "JOIN Venta v ON dv.idVenta = v.idVenta "
                    + "WHERE v.idCliente = ? AND v.fechaVenta = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCliente);
            pstmt.setDate(2, Date.valueOf(fechaVenta));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                idProductos.add(idProducto);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar las idProductos de las ventas");
        }
        return idProductos;
    }

    public static detalleVenta buscaVentaPorID(int idVenta, int idProd) {
        detalleVenta dv=null;
        try {
            String sql = "SELECT * FROM DetalleVenta where idVenta=? and idProducto=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idVenta);
            pstmt.setInt(2, idProd);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt("Cantidad");
                dv.setCantidad(cantidad);
                System.out.println("Ventas data" + cantidad);
            }
            return dv;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
