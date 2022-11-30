package snake.src.main.java.snake.components;

import javax.swing.*;

public class GameOverPanel extends GameOverlayPanel {
    Runnable restartGame;

    GameOverPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("Game Over");

        JButton button = new JButton();
        button.setText("Try Again");
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
