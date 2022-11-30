package snake.src.main.java.snake.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameWonPanel extends GameOverlayPanel{
    Runnable restartGame;

    GameWonPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("You Won");

        JButton button = new JButton();
        button.setText("Play Again");
        button.addActionListener(e -> {
            doGameOver();
        });

        contentContainer.add(headerText);
        contentContainer.add(button);
        add(contentContainer);
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
