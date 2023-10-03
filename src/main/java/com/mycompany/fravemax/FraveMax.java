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
        
//        var venta = new Venta(cliente, LocalDate.now());
//        VentaData.guardarVenta(venta);

          VentaData.buscarVentas(cliente)
                  .forEach(System.out::println);
          
          
//        ClienteData.listaCliente()
//                .forEach(fulano -> {
//                    var venta = new Venta(fulano, LocalDate.now());
//                    VentaData.guardarVenta(venta, fulano);
//                });
//        ClienteData.listaCliente()
//                .forEach(fulano -> {
//                    VentaData.buscarVentas(fulano)
//                            .forEach(System.out::println);
//                });
    }

}
