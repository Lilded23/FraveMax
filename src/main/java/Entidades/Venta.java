/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author jdbar
 */
public class Venta {
    private int idVenta;
    private Date fechaVenta;
    private Cliente cliente;

    public Venta(Cliente cliente, Date fechaVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
