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
public class JPEGImageHandlerColors extends ImageHandler{
    String nombreCorto;
    BufferedImage jpg;
    BufferedImage bmp;
    File bmpTemporal;

    public JPEGImageHandlerColors(String filename) {
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
        int redBluePercentage = 80; 
        BufferedImage original = bmp;

        
        //Rojo
        BufferedImage redImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int j = 0; j < original.getHeight(); j++) {
                Color color = new Color(original.getRGB(i,j));
                int r = color.getRed();
                int g = 0;
                int b = 0;
                Color newColor = new Color(r, g, b);
                redImage.setRGB(i,j,newColor.getRGB());
            }
        }
        ImageIO.write(redImage, "jpg", new File("./Rojo " + nombreCorto + ".jpg"));

        // Transformación Verde
        BufferedImage greenImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int j = 0; j < original.getHeight(); j++) {
                Color color = new Color(original.getRGB(i,j));
                int newGreen = color.getGreen();
                int newRed = (int) (color.getRed() * (1 - (redBluePercentage / 100.0)));
                int newBlue = (int) (color.getBlue() * (1 - (redBluePercentage / 100.0)));
                Color newColor = new Color(newRed, newGreen, newBlue);
                greenImage.setRGB(i,j,newColor.getRGB());
            }
        }
        ImageIO.write(greenImage, "jpg", new File("./Verde " + nombreCorto + ".jpg"));

        // Transformación Azul
        BufferedImage blueImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int j = 0; j < original.getHeight(); j++) {
                Color color = new Color(original.getRGB(i,j));
                int r = 0;
                int g = 0;
                int b = color.getBlue();
                Color newColor = new Color(r, g, b);
                blueImage.setRGB(i,j,newColor.getRGB());
            }
        }
        ImageIO.write(blueImage, "jpg", new File("./Azul " + nombreCorto + ".jpg"));

        //Transformando a Sepia
        BufferedImage sepiaImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < original.getWidth(); i++) {
            for(int j = 0; j < original.getHeight(); j++) {
                Color color = new Color(original.getRGB(i,j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int rNew = (int) (r * 0.393 + g * 0.769 + b * 0.189);
                int gNew = (int) (r * 0.349 + g * 0.686 + b * 0.168);
                int bNew = (int) (r * 0.272 + g * 0.534 + b * 0.131);
                r = Math.min(rNew, 255);
                g = Math.min(gNew, 255);
                b = Math.min(bNew, 255);
                Color newColor = new Color(r, g, b);
                sepiaImage.setRGB(i,j,newColor.getRGB());
            }
        }
        ImageIO.write(sepiaImage, "jpg", new File("./Sepia " + nombreCorto + ".jpg"));
        bmpTemporal.delete();
    }
    
}
