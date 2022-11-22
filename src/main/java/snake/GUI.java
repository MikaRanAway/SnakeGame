package snake;

import javax.swing.JFrame;

public class GUI {
    public static final int CONTENT_HEIGHT = 800;
    private static final int VERTICAL_MARGIN = 30;
    private static final int WINDOW_HEIGHT = CONTENT_HEIGHT + VERTICAL_MARGIN;
    public static final int WINDOW_WIDTH = 800;
    private JFrame jFrame;


    public void render(){
        jFrame = new JFrame("Wild Snake");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        jFrame.setVisible(true);
    }

    public GamePanel addGamePanel(){
        GamePanel gamePanel = new GamePanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.add(gamePanel);
        
        jFrame.revalidate();
        jFrame.repaint();

        return gamePanel;
    }
}