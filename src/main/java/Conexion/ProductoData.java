/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import static Conexion.Conexion.conn;
import Entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albornoz
 */
public abstract class ProductoData extends Conexion {

    public static List<Producto> listaProducto() {
        Conectar();
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "select * from producto";

            PreparedStatement sqlPD = conn.prepareStatement(sql);

            ResultSet res = sqlPD.executeQuery();

            while (res.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(res.getInt("idProducto"));
                producto.setNombreProducto(res.getString("nombreProducto"));
                producto.setDescripcion(res.getString("Descripcion"));
                producto.setPrecioActual(res.getDouble("precioActual"));
                producto.setStock(res.getInt("stock"));
                producto.setEstado(res.getBoolean("estado"));

                productos.add(producto);

            }
            return productos;

        } catch (Exception e) {
            System.out.println("Error al cargar la lista de PRODUCTOS" + e.getMessage());
        }
        return productos;
    }

    public static boolean IngresarNuevoProducto(Producto producto) {
        Conectar();
        try {
            String sql = "insert into `producto`(nombreProducto, descripcion, precioActual, stock, estado) values (?,?,?,?,?)";
            PreparedStatement sqlPD;
            sqlPD = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sqlPD.setString(1, producto.getNombreProducto());
            sqlPD.setString(2, producto.getDescripcion());
            sqlPD.setDouble(3, producto.getPrecioActual());
            sqlPD.setInt(4, producto.getStock());
            sqlPD.setBoolean(5, producto.isEstado());
            sqlPD.executeQuery();
            ResultSet rs = sqlPD.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                return true;
            } else {
                System.out.println("Error al crear PRODUCTO");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al crear PRODUCTO" + e.getMessage());
        }
        return false;
    }

    public static boolean ActualizarStock(int stock, int idProducto) {
        Conectar();
        try {
            String sql = "update `producto` set `stock`=? where `idProducto`=?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setInt(1, stock);
            sqlPD.setInt(2, idProducto);
            sqlPD.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar PRODUCTO" + e.getMessage());
        }
        return false;
    }

    public static boolean ActualizarProducto(Producto producto, int idProducto) {
        Conectar();
        try {
            String sql = "UPDATE `producto` SET `nombreProducto`=?, `descripcion`=?, `precioActual`=?, `stock`=?, `estado`=? WHERE idProducto = ?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(1, producto.getNombreProducto());
            sqlPD.setString(2, producto.getDescripcion());
            sqlPD.setDouble(3, producto.getPrecioActual());
            sqlPD.setInt(4, producto.getStock());
            sqlPD.setBoolean(5, producto.isEstado());
            sqlPD.setInt(6, idProducto);

            int filasModificadas = sqlPD.executeUpdate();

            return filasModificadas > 0;
        } catch (Exception e) {
            System.out.println("Error al modificar PRODUCTO " + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }

    public static Producto buscarPorId(int idProd) {
        Conectar();
        Producto prodBuscado = null;
        try {
            String sql = "Select * from producto where idProducto=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idProd);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prodBuscado = new Producto();
                prodBuscado.setDescripcion(rs.getNString("descripcion"));
                prodBuscado.setEstado(rs.getBoolean("estado"));
                prodBuscado.setNombreProducto(rs.getString("nombreProducto"));
                prodBuscado.setPrecioActual(rs.getDouble("precioActual"));
                prodBuscado.setStock(rs.getInt("stock"));
                prodBuscado.setIdProducto(rs.getInt("idProducto"));
            }
            return prodBuscado;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prodBuscado;
    }

//    public static boolean borrarProducto(int idProducto) {
//        String sql = "DELETE FROM `producto` WHERE idProducto = ?";
//
//        try {
//             Desactivar temporalmente la restricción de clave externa
//            Statement stmt = conn.createStatement();
//            stmt.execute("SET FOREIGN_KEY_CHECKS=0");
//
//             Preparar la consulta de eliminación
//            PreparedStatement sqlPD = conn.prepareStatement(sql);
//            sqlPD.setInt(1, idProducto);
//
//             Ejecutar la consulta de eliminación
//            int filaBorrada = sqlPD.executeUpdate();
//
//             Reactivar la restricción de clave externa
//            stmt.execute("SET FOREIGN_KEY_CHECKS=1");
//
//            return filaBorrada > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

        public static boolean borrarProducto(int idProducto) {
        String sql = "update producto set estado=0 WHERE idProducto = ?";
        try {
            PreparedStatement sqlPD = conn.prepareStatement(sql);
            sqlPD.setInt(1, idProducto);
            int filaBorrada = sqlPD.executeUpdate();
            return filaBorrada > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
