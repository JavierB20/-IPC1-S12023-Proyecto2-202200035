package Class;

import Estructuras.ListaDoble;
import Estructuras.ListaSimple;
import java.util.LinkedList;

/**
 *
 * @author Javier
 */
public class VariablesGlobales {
    public static ListaSimple listaSimple = new ListaSimple();
    public static ListaDoble listaDoble = new ListaDoble();
    public static String usuarioActual;
    public static LinkedList<Categoria> categorias = new LinkedList<Categoria>();
    public static String imagenActual;
    public static String imgRuta;
    public static LinkedList<String> lstImagenesUrl = new LinkedList<String>();
    public static LinkedList<String> lstImagenesNombre = new LinkedList<String>();

}
