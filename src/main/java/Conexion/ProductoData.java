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
        try {
            String sql = "insert into `producto`(nombreProducto, descripcion, precioActual, stock, estado) values (?,?,?,?,?)";
            PreparedStatement sqlPD;
            sqlPD = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sqlPD.setString(1, producto.getNombreProducto());
            sqlPD.setString(2, producto.getDescripcion());
            sqlPD.setDouble(3, producto.getPrecioActual());
            sqlPD.setInt(4, producto.getStock());
            sqlPD.setBoolean(5, true);
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

    public static boolean ActualizarEstado(boolean estado, int idProducto) {
        try {
            String sql = "update `producto` set `estado`=? where `idProducto`=?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setBoolean(1, estado);
            sqlPD.setInt(2, idProducto);

            sqlPD.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modifificar PRODUCTO " + e.getMessage());
        }
        return false;

    }

    public static Producto buscarPorId(int idProd) {
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
}

