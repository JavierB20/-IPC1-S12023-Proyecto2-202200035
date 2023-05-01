/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Javier
 */
public class JPEGImageHandlerBN extends ImageHandler{
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;

    public JPEGImageHandlerBN(String filename) {
        super(filename);
        File f = new File(filename);
        this.nombreCorto = FilenameUtils.removeExtension(f.getName()); 
    }

    @Override
    public void readFile() throws Exception {
        File file = new File(getFileName());
        jpg = ImageIO.read(file);
        bmpTemporal = new File("./bmpTemporal.bmp");
        ImageIO.write(jpg, "bmp", bmpTemporal);
        bmp = ImageIO.read(bmpTemporal);
    }

    @Override
    public void generateFiles() throws Exception {
        for(int i = 0; i < bmp.getWidth(); i++) {
            for(int j = 0; j < bmp.getHeight(); j++) {
                Color color = new Color(bmp.getRGB(i,j));
                int promedio = (color.getBlue() + color.getGreen() + color.getRed()) / 3;
                Color newColor = new Color(promedio, promedio, promedio);
                bmp.setRGB(i,j,newColor.getRGB());
            }
        }
        ImageIO.write(bmp, "jpg", new File("./BN " + nombreCorto + ".jpg"));
        bmpTemporal.delete();
    }
}
