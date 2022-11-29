package snake.src.main.java.snake;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public static final int CONTENT_HEIGHT = 500; // Must be divisible with GamePanel.UNIT_SIZE
    private static final int VERTICAL_MARGIN = 30; // This exists because otherwise the GamePanel will not have enough room. Not sure why.
    public static final int WINDOW_HEIGHT = CONTENT_HEIGHT + VERTICAL_MARGIN;
    public static final int WINDOW_WIDTH = 500; // Must be divisible with GamePanel.UNIT_SIZE
    private JFrame jFrame;
    private JLayeredPane layeredPane;


    public void render(){
        jFrame = new JFrame("Wild Snake");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // The program will quit if you close the window
        jFrame.setResizable(true);

        /*
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(WINDOW_WIDTH, CONTENT_HEIGHT));
        layeredPane.setBounds(0, 0, 100, 100);
        jFrame.add(layeredPane); */

        jFrame.setVisible(true);
    }


    // Seperate method because Game.java needs a reference to the GamePanel and it wouldn't make sense to return it in render()
    public GamePanel addGamePanel(Snake snake, Apple apple){
        GamePanel gamePanel = new GamePanel(snake, apple);
        
        jFrame.add(gamePanel);
        jFrame.revalidate();
        jFrame.repaint();

        return gamePanel;
    }
}