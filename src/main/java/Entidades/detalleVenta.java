/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author jdbar
 */
public class detalleVenta {

    private int idDetalleVenta;
    private int cantidad;
    private Venta venta;
    private double precioVenta;
    private Producto producto;

    public detalleVenta(int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public detalleVenta() {
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "\n  ID de Detalle de Venta: " + idDetalleVenta
                + "\n  Cliente: " + venta.getCliente().getNombre() + " " + venta.getCliente().getApellido()
                + "\n  Fecha de Venta: " + venta.getFechaVenta()
                + "\n  Producto: " + producto.getNombreProducto()
                + "\n  Cantidad: " + cantidad
                + "\n  Precio Unitario: " + producto.getPrecioActual()
                + "\n  Importe: $ " + precioVenta;
    }
}
