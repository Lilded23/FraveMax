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
        
       //ClienteData.crearCliente(cliente);
       
     //  ClienteData.borrarCliente(5);
       
        System.out.println( ClienteData.BuscarCliente(1));
        
        ClienteData.modifocarCliente(cliente, 1);
        
        System.out.println( ClienteData.modifocarCliente(cliente,1));
    }
    
    

}
