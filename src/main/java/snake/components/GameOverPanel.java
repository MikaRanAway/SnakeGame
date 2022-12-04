package snake.src.main.java.snake.components;

import javax.swing.*;

public class GameOverPanel extends GameOverlayPanel {
    Runnable restartGame;

    GameOverPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("Game Over");

        JButton TryAgain = new JButton();
        TryAgain.setText("Try Again");
        TryAgain.addActionListener(e -> {
            doGameOver();
        });
        JButton ChooseDifficulty = new JButton();
        ChooseDifficulty.setText("Choose Difficulty Level");
        ChooseDifficulty.addActionListener(e -> doRestartDifficulty());
        contentContainer.add(headerText);
        contentContainer.add(TryAgain);
        contentContainer.add(ChooseDifficulty);
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
    public void doRestartDifficulty(){
        DifficultyFrame gameOverRestartDifficulty = new DifficultyFrame();
    }
}
