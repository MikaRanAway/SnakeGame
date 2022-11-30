package snake.src.main.java.snake.components;

import snake.src.main.java.snake.GUI;
import snake.src.main.java.snake.Movement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {
    private static final Color backgroundColor = new Color(30, 30, 30, 140);


    GameOverPanel(){
        ((FlowLayout) getLayout()).setVgap(0);
        setVisible(false);
        setPreferredSize(new Dimension(GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT));
        setBackground(backgroundColor);
        setLayout(new GridBagLayout());
        setFocusable(false);


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;


        JPanel optionsGroup = new JPanel();
        optionsGroup.setPreferredSize(new Dimension(240, 140));
        optionsGroup.setBackground(Color.decode("#333333"));
        int optionsGroupPadding = 40;
        optionsGroup.setBorder(new EmptyBorder(optionsGroupPadding, optionsGroupPadding, optionsGroupPadding, optionsGroupPadding));


        Font textFieldFont = new Font("SansSerif", Font.BOLD, 30);
        JTextField textField = new JTextField();
        textField.setText("Game Over");
        textField.setFont(textFieldFont);
        textField.setOpaque(false);
        textField.setBorder(null);
        textField.setForeground(Color.decode("#eeeeee"));


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
