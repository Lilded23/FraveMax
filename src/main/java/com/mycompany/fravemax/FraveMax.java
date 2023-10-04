/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fravemax;

import Conexion.ClienteData;
import Entidades.*;
import Conexion.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jdbar
 */
public class FraveMax {

    public static void main(String[] args) {
        try {
            Conexion.Conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FraveMax.class.getName()).log(Level.SEVERE, null, ex);
        }
        var cliente = new Cliente(
                "Pruebas",
                "Ramiro",
                "Calle Falsa 123",
                "911");
        cliente.setIdCliente(1);
//        ClienteData.crearCliente(cliente);
        var venta = new Venta(cliente, LocalDate.now());
        VentaData.guardarVenta(venta);
        System.out.println(venta.getIdVenta());
//        ClienteData.listaCliente()
//                .forEach(System.out::println);
//        var producto = new Producto(
//                "Licuadora",
//                "A tu vieja le va a encantar",
//                22000, 40, true);
//        ProductoData.IngresarNuevoProducto(producto);
//        System.out.println( ProductoData.buscarPorId(1));
    }

}
