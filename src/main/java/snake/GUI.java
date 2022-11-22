package snake;

import java.io.IOException;

import javax.swing.JFrame;

public class GUI {
    public static final int gridSizeX = 20;
    public static final int gridSizeY = 20;

    public void start(){
        JFrame jFrame = new JFrame("Wild Snake");
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
    }
}