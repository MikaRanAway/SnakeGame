package snake.src.main.java.snake;

import snake.src.main.java.snake.components.GamePanel;

import javax.swing.*;

public class GUI {
    public static final int CONTENT_HEIGHT = 500; // Must be divisible with GamePanel.UNIT_SIZE
    private static final int VERTICAL_MARGIN = 30; // This exists because otherwise the GamePanel will not have enough room. Not sure why.
    public static final int WINDOW_HEIGHT = CONTENT_HEIGHT + VERTICAL_MARGIN;
    public static final int WINDOW_WIDTH = 500; // Must be divisible with GamePanel.UNIT_SIZE
    private JFrame jFrame;


    public void render(){
        jFrame = new JFrame("Wild Snake");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // The program will quit if you close the window
        jFrame.setResizable(true);
        jFrame.setVisible(true);
        jFrame.addKeyListener(new Movement());
    }


    // Seperate method because Game.java needs a reference to the GamePanel and it wouldn't make sense to return it in render()
    public GamePanel addGamePanel(){
        GamePanel gamePanel = new GamePanel();
        
        jFrame.add(gamePanel);
        jFrame.revalidate();
        jFrame.repaint();

        return gamePanel;
    }

    void requestFocus(){
        jFrame.requestFocus();
    }
}