package com.company;

import javax.swing.*;
import java.awt.*;



// panel where game is rendered
public class GamePanel extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private static final String OVER = "Game Over!";
    private static final String REPLAY = "press to replay";

    private Game game;

    public GamePanel(Game g) {
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.white);
        this.game = g;

    }

    // Draws the game
    // modifies: g
    // effects:  the game is drawn onto the Graphics object g
    private void drawGame(Graphics g) {
        game.draw(g);
    }

    // Draws the "game over" message and replay instructions
    // modifies: g
    // effects:  draws "game over" and replay instructions onto g
    private void gameOver(Graphics g){
        Color saved = g.getColor();
        g.setColor(new Color( 0, 0, 0));
        g.setFont(new Font("Arial", 20, 20));
        FontMetrics fm = g.getFontMetrics();
        centreString(OVER, g, fm, Game.HEIGHT / 2);
        centreString(REPLAY, g, fm, Game.HEIGHT / 2 + 50);
        g.setColor(saved);
    }

    // Centres a string on the screen
    // modifies: g
    // effects:  centres the string str horizontally onto g at vertical position yPos
    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.WIDTH - width) / 2, yPos);
    }
}
