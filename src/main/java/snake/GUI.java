package snake;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
    public static final int gridSizeX = 20;
    public static final int gridSizeY = 20;

    public void start(){
        JFrame jFrame = new JFrame("Wild Snake");
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);

        jFrame.setVisible(true);
    }
}