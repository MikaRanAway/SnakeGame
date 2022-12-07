package snake.src.main.java.snake.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OverlayContentContainer extends JPanel {
    public OverlayContentContainer(){
        setPreferredSize(new Dimension(270, 200));
        setBackground(Color.decode("#333333"));
        int padding = 40;
        EmptyBorder emptyBorder = new EmptyBorder(padding, padding, padding, padding);
        setBorder(emptyBorder);
    }
}
