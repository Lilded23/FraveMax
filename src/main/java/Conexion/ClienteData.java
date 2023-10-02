/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Conexion.Conexion;
import Conexion.ClienteData;
import Entidades.Cliente;
/**
 *
 * @author cisco
 */
public abstract class ClienteData extends Conexion {
    
    
    public static void guardarCliente(Cliente cliente) {
        if (conn != null)
            System.out.println("Todo ok");
    }
    
}
