package Conexion;

import Entidades.Cliente;
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
    public static boolean registrarDetalleVenta(int idVenta, int idProducto, int cantidad, double precioVenta) {
        try {
            String sql = "INSERT INTO DetalleVenta (idVenta, idProducto, cantidad, precioVenta) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idVenta);
            pstmt.setInt(2, idProducto);
            pstmt.setInt(3, cantidad);
            pstmt.setDouble(4, precioVenta);

            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// Método para actualizar un detalle de venta existente
    public static boolean actualizarDetalleVenta(int idDetalleVenta, int nuevaCantidad, double nuevoPrecioVenta) {
        try {
            String sql = "UPDATE DetalleVenta SET cantidad = ?, precioVenta = ? WHERE idDetalleVenta = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nuevaCantidad);
            pstmt.setDouble(2, nuevoPrecioVenta);
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
//            pstmt.setInt(1, idVenta);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idDetalleVenta = rs.getInt("idDetalleVenta");
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("cantidad");
                double precioVenta = rs.getDouble("precioVenta");
                int  idVenta= rs.getInt("idVenta");
                Venta venta = VentaData.buscarVenta(idVenta);
                Producto prod = ProductoData.buscarPorId(idProducto);
                detalleVenta dv = new detalleVenta(cantidad, venta, precioVenta, prod);
                listaIdVentas.add(dv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIdVentas;
    }

    //Metodo para detalles de venta por una fecha especifica
    public static List<detalleVenta> ListaPorFecha(LocalDate fecha) {
        List<detalleVenta> listaVentas = new ArrayList();
        try {
            String sql = "SELECT dv.idDetalleVenta, dv.cantidad, dv.precioVenta, c.Nombre AS NombreCliente, "
                    + "c.Apellido AS ApellidoCliente, p.nombreProducto AS NombreProducto, p.precioActual AS PrecioProducto "
                    + "FROM DetalleVenta dv "
                    + "INNER JOIN Venta v ON dv.idVenta = v.idVenta "
                    + "INNER JOIN Cliente c ON v.idCliente = c.idCliente "
                    + "INNER JOIN Producto p ON dv.idProducto = p.idProducto "
                    + "WHERE v.fechaVenta = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            detalleVenta detVenta = null;
            while (rs.next()) {
                int idDetalleVenta = rs.getInt("idDetalleVenta");
                int cantidad = rs.getInt("cantidad");
                double precioVenta = rs.getDouble("precioVenta");
                String nombreCliente = rs.getString("NombreCliente");
                String apellidoCliente = rs.getString("ApellidoCliente");
                String nombreProducto = rs.getString("NombreProducto");
                double precioProducto = rs.getDouble("PrecioProducto");

                detalleVenta dv = null;
                Producto prod = null;
                Venta venta = null;
                Cliente cli = null;

                prod.setNombreProducto(nombreProducto);
//                prod.setPrecioActual(precioVenta);

                cli.setNombre(nombreCliente);
                cli.setApellido(apellidoCliente);

                venta.setCliente(cli);
                venta.setFechaVenta(fecha);

                dv.setCantidad(cantidad);
                dv.setPrecioVenta(precioVenta);
                dv.setProducto(prod);
                dv.setVenta(venta);
                listaVentas.add(dv);
            }
            return listaVentas;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;
    }

    //Metodo para detalles de venta por un Cliente
    public static List<detalleVenta> ListaPorCliente(int idCliente) {
        List<detalleVenta> listaVentasClientes = new ArrayList();
        try {
            String sql = "SELECT dv.idDetalleVenta, dv.cantidad, dv.precioVenta, c.Nombre AS NombreCliente, v.fechaVenta,"
                    + "c.Apellido AS ApellidoCliente, p.nombreProducto AS NombreProducto, p.precioActual AS PrecioProducto "
                    + "FROM DetalleVenta dv "
                    + "INNER JOIN Venta v ON dv.idVenta = v.idVenta "
                    + "INNER JOIN Cliente c ON v.idCliente = c.idCliente "
                    + "INNER JOIN Producto p ON dv.idProducto = p.idProducto "
                    + "WHERE v.idCliente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            detalleVenta detVenta = null;
            while (rs.next()) {
                int idDetalleVenta = rs.getInt("idDetalleVenta");
                int cantidad = rs.getInt("cantidad");
                double precioVenta = rs.getDouble("precioVenta");
                String nombreCliente = rs.getString("NombreCliente");
                String apellidoCliente = rs.getString("ApellidoCliente");
                String nombreProducto = rs.getString("NombreProducto");
                double precioProducto = rs.getDouble("PrecioProducto");
                LocalDate fecha = rs.getDate("fechaVenta").toLocalDate();

                detalleVenta dv = null;
                Producto prod = null;
                Venta venta = null;
                Cliente cli = null;

                prod.setNombreProducto(nombreProducto);
//                prod.setPrecioActual(precioVenta);

                cli.setNombre(nombreCliente);
                cli.setApellido(apellidoCliente);

                venta.setCliente(cli);
                venta.setFechaVenta(fecha);

                dv.setCantidad(cantidad);
                dv.setPrecioVenta(precioVenta);
                dv.setProducto(prod);
                dv.setVenta(venta);
                listaVentasClientes.add(dv);
            }
            return listaVentasClientes;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentasClientes;
    }

}
