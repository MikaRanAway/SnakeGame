package snake.src.main.java.snake;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    private static final Color backgroundColor = new Color(0, 100, 0, 100);


    GameOverPanel(){
        setBounds(0, 0, GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT);
        setOpaque(true);
        setPreferredSize(new Dimension(GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT));
        setBackground(backgroundColor);
    }
}
