/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import static Conexion.Conexion.conn;
import Entidades.Cliente;
import Entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Albornoz
 */
public abstract class ProductoData extends Conexion {

    public ProductoData() {
        try {
            Conectar();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
    }

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

            PreparedStatement sqlPD = conn.prepareStatement(sql);

            sqlPD.setString(0, producto.getNombreProducto());
            sqlPD.setString(1, producto.getDescripcion());
            sqlPD.setDouble(2, producto.getPrecioActual());
            sqlPD.setInt(3, producto.getStock());
            sqlPD.setBoolean(4, true);

            sqlPD.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear PRODUCTO" + e.getMessage());

        }
        return false;
    }

    public static boolean ActualizarStock(int stock, int idProducto) {
        try {
            String sql = "update `producto` set `stock`=? where `idProducto`=?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);
            sqlPD.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar PRODUCTO" + e.getMessage());
        }
        return false;
    }
    
    public static boolean ActualizarEstado(boolean estado, int idProducto)    {
        try {
            String sql = "update `producto` set `estado`=? where `idProducto`=?";
            PreparedStatement sqlPD = conn.prepareStatement(sql);
            
            sqlPD.setBoolean(0, estado);
            sqlPD.setInt(1, idProducto);
        
            sqlPD.execute();
            return true;
        }
        
        catch(Exception e) {
              System.out.println("Error al modifificar PRODUCTO " + e.getMessage());
        }
    return false;
    
        }
    }

