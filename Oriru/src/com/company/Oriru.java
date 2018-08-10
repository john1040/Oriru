package com.company;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Oriru extends JFrame{

    private Game game;
    private GamePanel gp;

    private static final int INTERVAL = 20;
    private Timer t;

    public Oriru(){
        super("Oriru");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new Game();
        gp = new GamePanel(game);
        add(gp);

        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer();
        t.start();



    }
    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    // Set up timer
    // modifies: none
    // effects:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer() {
        t = new Timer(INTERVAL, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
                gp.repaint();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        //we can set the
        JFrame frame = new JFrame("Oriru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Welcome to Oriru");

        JButton startButton = new JButton("start game");

        frame.getContentPane().add(startButton);

        // SET UP THE SIZE OF THE WINDOW FOR OUR GAME
        //label.setPreferredSize(new Dimension(800,600));
        //frame.getContentPane().add(label);




        //Display the window.
        frame.setSize(800,600);
        frame.setVisible(true);
    }


    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e.getKeyCode());
        }
    }

    public static void main(String[] args) {
	// write your code here
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//                // DISPLAY START WINDOW
//                // WHILE GAME IS PLAYING:
//                // RENDER AND UPDATE
//            }
//        });

        new Oriru();
    }
}
