package Estructuras;

import Class.Imagen;
import Class.VariablesGlobales;

/**
 *
 * @author Javier
 */
public class ListaDoble extends EstructuraDeDatos{
    NodoImagen primerNodo;
    NodoImagen ultimoNodo;
    private NodoImagen primero;
    
    public NodoImagen getPrimero() {
        return this.primero;
    }

    
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
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        if (primerNodo == null) {
            return null;
        }
        
        String nombreImagen = e.toString();
        NodoImagen nodoAuxiliar = primerNodo; 
        for (int i = 0; i < getSize(); i++) {
            if (nodoAuxiliar.getImagen().getNombre().equals(nombreImagen)) {
                return nodoAuxiliar.getImagen();
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        NodoImagen nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null && !nodoAuxiliar.getImagen().getNombre().equals(VariablesGlobales.imagenActual)) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        if (nodoAuxiliar != null) {
            // Si se encontró el nodo de la imagen actual
            NodoImagen nodoSiguiente = nodoAuxiliar.getSiguiente();
        if (nodoSiguiente != null) {
            // Si existe un nodo anterior, se devuelve su imagen
            return nodoSiguiente.getImagen().getImageIcon();
            }
        }
        // Si no se encontró el nodo de la imagen actual o no existe un nodo anterior, se devuelve null
        return null;
    }
    
    public Object getBefore() {
        NodoImagen nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null && !nodoAuxiliar.getImagen().getNombre().equals(VariablesGlobales.imagenActual)) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        if (nodoAuxiliar != null) {
            // Si se encontró el nodo de la imagen actual
            NodoImagen nodoAnterior = nodoAuxiliar.getAnterior();
        if (nodoAnterior != null) {
            // Si existe un nodo anterior, se devuelve su imagen
            return nodoAnterior.getImagen().getImageIcon();
            }
        }
        // Si no se encontró el nodo de la imagen actual o no existe un nodo anterior, se devuelve null
        return null;
        
    }


    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > index) {
            return new IndexOutOfBoundsException();
        }
        
        NodoImagen nodoAuxiliar = primerNodo;
        for(int contador = 0; contador < i; contador++){
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getImagen();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        String nombreImagen = e.toString();
        NodoImagen nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null && !nodoAuxiliar.getImagen().getNombre().equals(nombreImagen)) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        
        if (nodoAuxiliar == null) {
            return;
        } else if (nodoAuxiliar == primerNodo) {
            primerNodo = primerNodo.getSiguiente();
            primerNodo.setAnterior(null);
        } else if (nodoAuxiliar == ultimoNodo) {
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        } else {
            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
        }
        index--;
    }
    
}
