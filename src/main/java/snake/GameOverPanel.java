package snake.src.main.java.snake;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {
    private static final Color backgroundColor = new Color(30, 30, 30, 100);


    GameOverPanel(){
        ((FlowLayout) getLayout()).setVgap(0);
        setVisible(false);
        setPreferredSize(new Dimension(GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT));
        setBackground(backgroundColor);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;

        JPanel optionsGroup = new JPanel();
        optionsGroup.setPreferredSize(new Dimension(180, 80));
        optionsGroup.setOpaque(false);

        Font textFieldFont = new Font("SansSerif", Font.BOLD, 25);
        JTextField textField = new JTextField();
        textField.setText("Game Over");
        textField.setFont(textFieldFont);

        JButton button = new JButton();
        button.setText("Want to try again?");
        button.addActionListener(e -> {
            throw new RuntimeException("Too bad");
        });

        optionsGroup.add(textField);
        optionsGroup.add(button);

        add(optionsGroup);
    }

    public void showPanel(){
        setVisible(true);
    }
}
