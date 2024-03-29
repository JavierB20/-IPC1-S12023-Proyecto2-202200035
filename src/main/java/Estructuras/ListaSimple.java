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
public class ListaSimple extends EstructuraDeDatos{
    private NodoUsuario cabeza;
    
    public void Imprimir() {
        NodoUsuario nodoUsuario = cabeza;
        while (nodoUsuario != null) {
            System.out.print(nodoUsuario.getUsuario().nombreUsuario + "->");
            nodoUsuario = nodoUsuario.getSiguiente();
        }
        System.out.println("\n");
    }
        
    public String recorrerLista() {
        NodoUsuario nodoUsuario = cabeza;
        String nombres = "";
        
        while (nodoUsuario != null) {
            nombres += nodoUsuario.getUsuario().getNombreUsuario() + ", ";
            nodoUsuario = nodoUsuario.getSiguiente();
        }
        if (nombres.length() > 0) {
            nombres = nombres.substring(0, nombres.length() - 2);
        }
        return nombres;
    }
    
    
    @Override
    public void add(Object e) {
        Usuarios usuario = (Usuarios)e;
        
        if(find(usuario.nombreUsuario) != null) {
            return;
        }
        
        NodoUsuario nodoUsuario = new NodoUsuario(usuario);
        if(cabeza == null) {
            cabeza = nodoUsuario;
        }
        else {
            NodoUsuario nodoAuxiliar = cabeza;
            while(nodoAuxiliar.getSiguiente() != null) {
                nodoAuxiliar = nodoAuxiliar.getSiguiente();
            }
            
            nodoAuxiliar.setSiguiente(nodoUsuario);
        }
        index++;
        
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        String nombreUsuario = e.toString();
        
        NodoUsuario nodoAuxiliar = cabeza;
        for (int i = 0; i < index; i++) {
            if(nodoAuxiliar.getUsuario().nombreUsuario.equals(nombreUsuario)) {
                return nodoAuxiliar.getUsuario();
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        
        return null;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int i) {
        if (cabeza == null || i < 0) {
            return null;
        }
        
        NodoUsuario nodoActual = cabeza;
        int contador = 0;
        
        while(contador < i && nodoActual != null) {
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }
        
        if(nodoActual == null) {
            return null;
        }
        else {
            return nodoActual;
        }
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
