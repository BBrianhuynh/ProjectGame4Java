package dev.ProjDisplay;

/*
The purpose of the Display class is to project images from what is given onto the screen
 */

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width;
    private int height;


    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
    }
    // Creates Display Panel (AKA Window)
    private void createDisplay(){
        //Sets title of the window
        frame=new JFrame(title);
        //Sets the dimensions of the window
        frame.setSize(width,height);
        //Sets the ability to close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets the ability to full screen or minimize the window
        frame.setResizable(false);
        //Sets the window to the center of the screen instead of being off to the side
        frame.setLocationRelativeTo(null);
        //Sets the window so that you can see it(By default, JFrame sets it to false meaning that you get the window but you do not see it.)
        frame.setVisible(true);

        //Creates a Canvas object so that images appear on it
        canvas=new Canvas();
        //Sets the size of the canvas and uses a Dimension object to take and set the width and height
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        //Adds canvas object with images on it to the frame
        frame.add(canvas);
        //Resizes the window so that you can see the canvas fully
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

}
