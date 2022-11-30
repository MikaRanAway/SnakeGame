package snake.src.main.java.snake.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameWonPanel extends GameOverlayPanel{
    Runnable restartGame;

    GameWonPanel(){
        JPanel optionsGroup = new JPanel();
        optionsGroup.setPreferredSize(new Dimension(240, 140));
        optionsGroup.setBackground(Color.decode("#333333"));
        int optionsGroupPadding = 40;
        optionsGroup.setBorder(new EmptyBorder(optionsGroupPadding, optionsGroupPadding, optionsGroupPadding, optionsGroupPadding));

        HeaderText headerText = new HeaderText("You Won");

        JButton button = new JButton();
        button.setText("Play Again");
        button.addActionListener(e -> {
            doGameOver();
        });

        optionsGroup.add(headerText);
        optionsGroup.add(button);
        add(optionsGroup);
    }

    public void showPanel(Runnable restartGame){
        this.restartGame = restartGame;
        setVisible(true);
    }

    public void doGameOver(){
        setVisible(false);
        restartGame.run();
    }
}
