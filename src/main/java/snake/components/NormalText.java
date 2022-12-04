package snake.src.main.java.snake.components;

import javax.swing.*;
import java.awt.*;

public class NormalText extends JTextField {
    private static final Font normalFont = new Font("SansSerif", Font.BOLD, 15);

    public NormalText(String text){
        setText(text);
        setFont(normalFont);
        setOpaque(false);
        setBorder(null);
        setForeground(Color.decode("#eeeeee"));
    }
}
