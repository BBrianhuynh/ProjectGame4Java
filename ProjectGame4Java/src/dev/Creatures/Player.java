package dev.Creatures;

import dev.Entity.Entity;
import dev.gfx.Assets;

import java.awt.*;

public class Player extends Entity {
    public Player(float x,float y){
        super(x,y);
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
    graphics.drawImage(Assets.player,(int)x,(int)y,null);

    }
}
