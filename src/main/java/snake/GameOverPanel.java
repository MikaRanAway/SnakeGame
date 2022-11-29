package snake.src.main.java.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {
    private static final Color backgroundColor = new Color(0, 100, 0, 100);


    GameOverPanel(){
        setOpaque(true);
        setVisible(false);
        setPreferredSize(new Dimension(GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT));
        setBackground(backgroundColor);

        JTextField textField = new JTextField();
        textField.setText("Game Over");

        JButton button = new JButton();
        button.setText("Want to try again?");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new RuntimeException("Too bad");
            }
        });
        add(button);

        add(textField);
    }

    public void showPanel(){
        setVisible(true);
    }
}
