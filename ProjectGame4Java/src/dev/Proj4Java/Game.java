package dev.Proj4Java;

import dev.States.GameState;
import dev.States.State;
import dev.States.menuState;
import dev.gfx.Assets;
import dev.gfx.ImageLoader;
import dev.ProjDisplay.Display;
import dev.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


//Having "implements Runnable" in the class is a way for the class to run a separate mini program in the main program(Class Game)
public class Game implements Runnable{
private Display display;
public int width;
public int height;
public String title;
private boolean running=false;
private BufferStrategy bs;
private Graphics graphics;
//States
private State gameState,menuState;


//Thread is like a mini program under the main program to run on its own while the other program runs and thus can utilize all cpu on pc to run faster
//requires a thread object for a thread to run on
private Thread thread;

    public Game(String title,int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
    }
    //What runs when a thread is open
    public void run(){
        init();
        int fps=60;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        //returns the amount of time in nanoseconds that the computer is running and stores it into lastTime variable
        long lastTime=System.nanoTime();
        //time it takes to 1 second
        long timer=0;
        long ticks=0;
        //Game Loop
        while (running) {
            now = System.nanoTime();
            //delta variable is the new change in fps of how fast the fps should be depending on which computer
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime=now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            //After 1 second or 1000000000 nanoseconds it will print out the current fps;
            if(timer>=1000000000){
                System.out.println("Fps:"+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();
    }
    //Updates the game

    private void tick(){
    //Renders the game or essentially draws things on screen
    if(State.getState()!=null){
        State.getState().tick();
    }
    }

    private void render(){
        //Calls a method from BufferStrategy Class to tell the computer how to print the canvas onto the screen with the canvas
        //A buffer is a linear sequence in which a process will occur in respect to the speed of time given
        //Gets the number of buffers the canvas is going to use if already given
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            //If # of buffers is not initialized, then we use this method to give it the amount of buffers for the canvas
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //In order to put the image onto the canvas, you need to transport the image onto the canvas and that is the purpose of this object.  Like a paint brush
        graphics=bs.getDrawGraphics();
        //Clear screen
        graphics.clearRect(0,0,width,height);
        //Draws the canvas onto the buffered screen(A screen to be shown after the present screen is shown) for it to be processed onto the present screen
        /*Draw here **/
        if(State.getState()!=null){
            State.getState().render(graphics);
        }
        //graphics.drawImage(Assets.grass,10,10,null);
        //draws the image obtained from init() method whereas it pulls a desired image
        //graphics.drawImage(testImage,0,0,null);
        //graphics.drawImage(sheet.Crop(0,0,32,32),5,5,null);
        //graphics.setColor(Color.red);
        //graphics.fillRect(0,0,width,height);
        //Done drawing and calls to display on screen
        /*End draw **/
        bs.show();
        graphics.dispose();
    }

    private void init(){
        display=new Display(title,width,height);
        Assets.init();
        gameState=new GameState(this);
        menuState=new menuState(this);
        State.setState(gameState);
    }
    //Starts a thread and initializes the process of one
    //You would use "Synchronized" in start and stop methods if you are working with the thread directly
    public synchronized void start(){
        //Checks if the game is already running.  If game is running, it returns so that anything below that code will not run or otherwise will cause problems.
        if (running)
            return;
        running=true;
        //"this" in the new Thread() is actually a class and specifically talking about Game Class
        thread=new Thread(this);
        //thread.start() will call the run method above
        thread.start();
    }
    //Stops a thread and ends the process of one
    public synchronized void stop(){
        //Checks if the game is already running. If game is running, it returns so that anything below that code will not run or otherwise will cause problems.
        if (!running)
            return;
        running=false;
        try {
            //To stop the thread safely
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
