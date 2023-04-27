/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Estructuras.ListaDoble;

/**
 *
 * @author Javier
 */
public class Categoria {
    private String usuario;
    private String categoria;
    private ListaDoble listaDoble;

    public Categoria(String usuario, String categoria) {
        this.usuario = usuario;
        this.categoria = categoria;
    }

    
    public Categoria(String usuario, String categoria, ListaDoble listaDoble) {
        this.usuario = usuario;
        this.categoria = categoria;
        this.listaDoble = listaDoble;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ListaDoble getListaDoble() {
        return listaDoble;
    }

    public void setListaDoble(ListaDoble listaDoble) {
        this.listaDoble = listaDoble;
    }

   
    public static boolean existeCategoriaGeneral() {
        for (Categoria c : VariablesGlobales.categorias) {
            if (c.getUsuario().equals(VariablesGlobales.usuarioActual) && c.getCategoria().equals("General")) {
                return true;
            }
        }
        return false;
    }
    


    
}
