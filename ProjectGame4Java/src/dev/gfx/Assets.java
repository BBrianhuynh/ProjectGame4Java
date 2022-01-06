package dev.gfx;

import java.awt.image.BufferedImage;

public class Assets {

private static final int width=32;
private static final int height=32;
public static BufferedImage player,dirt,grass,stone,tree;


    public static void init(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/Hello.png"));
        player=sheet.Crop(0,0,width,height);
        dirt=sheet.Crop(width,0,width,height);
        grass=sheet.Crop(width*2,0,width,height);
        stone=sheet.Crop(width*3,0,width,height);
        tree=sheet.Crop(0,height,width,height);

    }

}
