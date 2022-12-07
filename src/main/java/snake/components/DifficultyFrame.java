package snake.src.main.java.snake.components;

import snake.src.main.java.snake.Difficulty;
import snake.src.main.java.snake.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyFrame extends JFrame implements ActionListener {
    private static final Color backgroundColor = Color.decode("#333333");

    private final JButton easyBtn = new JButton("Easy");
    private final JButton mediumBtn = new JButton("Medium");
    private final JButton hardBtn = new JButton("Hard");

    public DifficultyFrame(){
        setSize(600,600);
        getContentPane().setBackground(backgroundColor);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        easyBtn.setBounds(225,180,150,50);
        mediumBtn.setBounds(225,250,150,50);
        hardBtn.setBounds(225,320,150,50);

        easyBtn.addActionListener(this);
        mediumBtn.addActionListener(this);
        hardBtn.addActionListener(this);

        add(easyBtn);
        add(mediumBtn);
        add(hardBtn);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game game = Game.getInstance();

        if (e.getSource() == easyBtn){
            game.setDifficulty(Difficulty.EASY);
        }else if (e.getSource() == mediumBtn){
            game.setDifficulty(Difficulty.MEDIUM);
        }else if (e.getSource() == hardBtn){
            game.setDifficulty(Difficulty.HARD);
        }

        dispose();
        Game.getInstance().start();
    }
}
