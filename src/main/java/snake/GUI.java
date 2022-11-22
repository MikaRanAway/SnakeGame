package snake;

import javax.swing.JFrame;

public class GUI {
    public static final int WINDOW_HEIGHT = 800;
    public static final int WINDOW_WIDTH = 800;


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