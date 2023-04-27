/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import javax.swing.ImageIcon;

/**
 *
 * @author Javier
 */
public class Imagen {
    public ImageIcon imageIcon;
    public String nombre;

    public Imagen(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public Imagen(ImageIcon imageIcon, String nombre) {
        this.imageIcon = imageIcon;
        this.nombre = nombre;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
