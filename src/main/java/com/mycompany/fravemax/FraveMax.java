/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fravemax;

import Conexion.ClienteData;
import Entidades.*;
import Conexion.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
//        Cliente cliente = new Cliente(
//                "Lopez",
//                "Victor",
//                "Calle Falsa 123",
//                "911",
//                54652);
//        cliente.setIdCliente(1);

//        ClienteData.crearCliente(cliente);
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
//        System.out.println(venta.getIdVenta());
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
//        Producto prod = new Producto("Tv 32", "Tv 32 pulgadas led", 2000, 15, true);
//        ProductoData.IngresarNuevoProducto(prod);
//        System.out.println(prod.getIdProducto());
//
//        System.out.println(venta);
//        System.out.println(prod);
//        detalleVenta dv = new detalleVenta(2, venta, 600, prod);
//        System.out.println(DetalleVentaConexion.registrarDetalleVenta(dv));
//        venta.setIdVenta(3);
//        prod.setIdProducto(6);
//        detalleVenta dvMod = new detalleVenta(3, venta, 0, prod);
//        if (DetalleVentaConexion.actualizarDetalleVenta(12, dvMod)) {
//            System.out.println("Exito al Modificar detalle venta");
//        } else {
//            System.out.println("ERROR al Modificar detalle venta");
//        }
//        System.out.println("Lista Completa");
//        List<detalleVenta> dvlist = new ArrayList();
//        dvlist = DetalleVentaConexion.listarDetallesDeVenta();
//        for (detalleVenta venta1 : dvlist) {
//            System.out.println(venta1);
//        }
//        System.out.println("Lista Por fecha");
//        List<detalleVenta> dvlist1 = new ArrayList();
//        LocalDate fecha = LocalDate.of(2023, 10, 04);
//        dvlist1 = DetalleVentaConexion.ListaPorFecha(fecha);
//        for (detalleVenta venta1 : dvlist1) {
//            System.out.println(venta1);
//        }
//
//        System.out.println("Lista Por IdCliente");
//        List<detalleVenta> dvlist2 = new ArrayList();
//        dvlist2 = DetalleVentaConexion.ListaPorCliente(6);
//        for (detalleVenta venta1 : dvlist2) {
//            System.out.println(venta1);
//        }
//        
//           System.out.println("Lista dealles de venta con multiples productos");
//        List<detalleVenta> dvlist2 = new ArrayList();
//        dvlist2 = DetalleVentaData.listarDetallesVentaPorID(1);
//        for (detalleVenta venta1 : dvlist2) {
//            System.out.println(venta1);
//        }
       
//        Cliente cliente = new Cliente(
//                "Lopez",
//                "Victor",
//                "Calle Falsa 123",
//                "911",
//                    54652);
        //ClienteData.crearCliente(cliente);
        //  ClienteData.borrarCliente(5);
//        System.out.println( ClienteData.BuscarCliente(1));
//
//        ClienteData.modifocarCliente(cliente, 1);
//
//        System.out.println( ClienteData.modifocarCliente(cliente,1));
        List<Cliente> clientes = ClienteData.listaClientePorDNI(0);

        clientes.forEach(i -> {
            System.out.println(i.getNombre() + " " + i.getDni());

        });
    }

}
