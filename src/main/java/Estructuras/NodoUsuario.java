/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Class.Usuarios;

/**
 *
 * @author Javier
 */
public class NodoUsuario {
    private Usuarios usuario;
    private NodoUsuario siguiente;

    public NodoUsuario(Usuarios usuario) {
        this.usuario = usuario;
        this.siguiente = null;
    }
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public NodoUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUsuario siguiente) {
        this.siguiente = siguiente;
    }



    
    
}
