package dev.Entity;

import java.awt.*;

//This class will be using "abstract" because don't want anyone to make a random entity instead we want them to create a specific entity such as item or player
public abstract class Entity {

    protected float x,y;
    public Entity(float x,float y){
        this.x=x;
        this.y=y;
    }
    public abstract void tick();

    public abstract void render(Graphics graphics);


}
