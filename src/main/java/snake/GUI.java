package snake;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
    public static final int gridSizeX = 20;
    public static final int gridSizeY = 20;

    private final int WINDOW_HEIGHT = 700;
    private final int WINDOW_WIDTH = 500;


    public void start(){
        JFrame jFrame = new JFrame("Wild Snake");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        GamePanel gamePanel = new GamePanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.add(gamePanel);

        jFrame.setVisible(true);
    }
}