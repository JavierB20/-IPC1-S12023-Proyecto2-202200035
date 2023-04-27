package Estructuras;

import Class.Imagen;

/**
 *
 * @author Javier
 */
public class ListaDoble extends EstructuraDeDatos{
    NodoImagen primerNodo;
    NodoImagen ultimoNodo;
    
    
    
    public void imprimir(){
        if(primerNodo == null) {
            System.out.println("null");
            return;
        }
        
        
        NodoImagen nodoAuxiliar = primerNodo;
        while(nodoAuxiliar != null) {
            System.out.print(nodoAuxiliar.getImagen().getImageIcon() + "<-->");
            System.out.print(nodoAuxiliar.getImagen().getNombre() + "<-->");
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        
        System.out.print("null");
        
    }
    
    @Override
    public void add(Object e) {
        Imagen imagen = (Imagen)e;
        if(primerNodo == null) {
            primerNodo = ultimoNodo = new NodoImagen(imagen);
        }
        else {
            //ver si es asi o cambiar orden
            NodoImagen nuevoNodo = new NodoImagen(imagen, null, ultimoNodo);
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
