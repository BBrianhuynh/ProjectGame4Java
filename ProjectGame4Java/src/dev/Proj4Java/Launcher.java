package dev.Proj4Java;
/*
The purpose of the launcher class is to start the game similar to how to start a car in which you would need to turn on the ignition key to start the car.
 */

public class Launcher {

    public static void main(String[] args){
        Game game=new Game("ProjectGame4Dev",1600,900);
        game.start();
    }
}
