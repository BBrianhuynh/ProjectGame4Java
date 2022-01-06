package dev.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    //Loads in the image from the path of origin
    public static BufferedImage loadImage(String path){
        try {
            //returns the image of where the image is stored
            return ImageIO.read(ImageLoader.class.getResource(path));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
