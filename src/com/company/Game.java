package com.company;

// Represents the game


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Game extends Observable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final Random RANDOM = new Random();

    private List<Sprite> sprites;

    Game(){
        sprites = new ArrayList<Sprite>();


    }

    private void init(){

    }

    public void update(){

    }

    public void keyPressed(int keyCode){

    }

    public void draw(Graphics g){

    }

    // restarts the entire game
    private void reset(){

    }


}
