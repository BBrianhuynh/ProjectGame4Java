package dev.States;

import dev.Creatures.Player;
import dev.Proj4Java.Game;
import dev.gfx.Assets;

import java.awt.*;
import java.awt.Graphics;


public class GameState extends State{
    //initializing character into the game
    private Player player;
    public GameState(Game game) {
        super(game);
        player=new Player(100,100);
    }
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
