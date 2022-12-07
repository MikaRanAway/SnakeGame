package snake.src.main.java.snake.components;

import snake.src.main.java.snake.Difficulty;
import snake.src.main.java.snake.components.Text.HeaderText;
import snake.src.main.java.snake.components.Text.NormalText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeFrame implements ActionListener {
    private final JFrame welcomeWindow = new JFrame();
    private final JButton difficultyLevel = new JButton("Difficulty Level");

    public WelcomeFrame(){
        welcomeWindow.setSize(600,600);
        welcomeWindow.getContentPane().setBackground(Color.decode("#333333"));
        welcomeWindow.setLayout(null);
        welcomeWindow.setLocationRelativeTo(null);
        welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeWindow.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 0));
        contentPanel.setBounds(50, 200, 500, 200);
        contentPanel.setOpaque(false);

        NormalText welcomeTo = new NormalText("Welcome to");
        welcomeTo.setForeground(Color.white);
        contentPanel.add(welcomeTo);

        HeaderText welcomeMessage = new HeaderText("Wild Snake Game");
        welcomeMessage.setForeground(Color.white);
        contentPanel.add(welcomeMessage);

        difficultyLevel.addActionListener(this);
        contentPanel.add(difficultyLevel);

        welcomeWindow.add(contentPanel);
        welcomeWindow.setVisible(true);
        welcomeWindow.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==difficultyLevel){
            welcomeWindow.dispose();
            DifficultyFrame frame = new DifficultyFrame();
        }
    }
}
