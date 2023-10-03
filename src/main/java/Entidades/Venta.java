/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jdbar
 */
public class Venta {
    private int idVenta;
    private LocalDate fechaVenta;
    private Cliente cliente;

    public Venta(Cliente cliente, LocalDate fechaVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
