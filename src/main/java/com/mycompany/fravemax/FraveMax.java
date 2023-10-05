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
        Cliente cliente = new Cliente(
                "Lopez",
                "Victor",
                "Calle Falsa 123",
                "911",
                    54652);
        cliente.setIdCliente(1);
        
       //ClienteData.crearCliente(cliente);
       
     //  ClienteData.borrarCliente(5);
       
//        System.out.println( ClienteData.BuscarCliente(1));
//        
//        ClienteData.modifocarCliente(cliente, 1);
//        
//        System.out.println( ClienteData.modifocarCliente(cliente,1));

////////////////////////////////////////////////////////////////
//        cliente = ClienteData.BuscarCliente(1);
//        var venta = new Venta(cliente, LocalDate.now());
//        VentaData.guardarVenta(venta);
//        
//        
//        VentaData.eliminarVenta(1);
//        venta = VentaData.buscarVenta(1);
//        System.out.println(venta);

//        VentaData.buscarVentas(cliente)
//                .forEach(System.out::println);
//        
//        VentaData.buscarVentas(LocalDate.of(2023, 10, 4))
//                .forEach(System.out::println);
    }
    
    

}
