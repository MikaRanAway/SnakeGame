package snake.src.main.java.snake.components;

import snake.src.main.java.snake.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyFrame extends JFrame implements ActionListener {
    private static final Color backgroundColor = Color.decode("#3333");

    private final JButton easyBtn = new JButton("Easy");
    private final JButton mediumBtn = new JButton("Medium");
    private final JButton hardBtn = new JButton("Hard");

    DifficultyFrame(){
        setSize(600,600);
        getContentPane().setBackground(backgroundColor);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        easyBtn.setBounds(225,100,150,50);
        mediumBtn.setBounds(225,250,150,50);
        hardBtn.setBounds(225,400,150,50);

        easyBtn.addActionListener(this);
        mediumBtn.addActionListener(this);
        hardBtn.addActionListener(this);

        add(easyBtn);
        add(mediumBtn);
        add(hardBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyBtn){
            dispose();
            Game.setTickSpeed(200);
        }else if (e.getSource() == mediumBtn){
            dispose();
            Game.setTickSpeed(100);
        }else if (e.getSource() == hardBtn){
            dispose();
            Game.setTickSpeed(50);
        }
        Game game = new Game();
        game.start();
    }
}
