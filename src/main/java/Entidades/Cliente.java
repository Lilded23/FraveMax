/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author jdbar
 */
public class Cliente {
    private int idCliente;
    private String apellido ;
    private String nombre;
    private String domiciio;
    private String telefono;
    private int dni;

    public Cliente(String apellido, String nombre, String domiciio, String telefono , int dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.domiciio = domiciio;
        this.telefono = telefono;
        this.dni= dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomiciio() {
        return domiciio;
    }

    public void setDomiciio(String domiciio) {
        this.domiciio = domiciio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return idCliente  + apellido  + nombre + dni +  domiciio + telefono;
    }
    
    
}
