/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Javier
 */
public class BMPtoJPEGImage extends ImageHandler{
    String nombreCorto;
    BufferedImage bmp;

    public BMPtoJPEGImage(String filename) {
        super(filename);
        File f = new File(filename);
        this.nombreCorto = FilenameUtils.removeExtension(f.getName()); 
    }

    @Override
    public void readFile() throws Exception {
        try {
            File file = new File(getFileName());
            bmp = ImageIO.read(file);
            System.out.println("Imagen BMP leída correctamente");
        } catch (IOException ex) {
            System.err.println("Error al leer la imagen BMP: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void generateFiles() throws Exception {
        try {
            ImageIO.write(bmp, "JPEG", new File("./ConvertirJPG " + nombreCorto + ".jpg"));
        } catch (IOException ex) {
            System.err.println("Error al generar el archivo JPEG: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
