package org.example.components;

import org.example.components.Text.HeaderText;
import org.example.components.Text.NormalText;

import javax.swing.*;

public class GameOverPanel extends GameOverlayPanel {
    Runnable restartGame;
    private NormalText timeDisplay;

    GameOverPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("Game Over");
        timeDisplay = new NormalText("Elapsed time: "); // I have to initialize it as something

        JButton tryAgainBtn = new JButton();
        tryAgainBtn.setText("Try Again");
        tryAgainBtn.addActionListener(e -> doGameOver());  //e is an action event. Choosing  try again, the game will restart

        JButton chooseDifficultyBtn = new JButton();
        chooseDifficultyBtn.setText("Choose Difficulty Level");
        chooseDifficultyBtn.addActionListener(e -> doRestartDifficulty()); //e is an action event.Choosing restart difficulty

        contentContainer.add(headerText);
        contentContainer.add(timeDisplay);
        contentContainer.add(tryAgainBtn);
        contentContainer.add(chooseDifficultyBtn);
        add(contentContainer);
    }

    public void showPanel(Runnable restartGame){
        this.restartGame = restartGame;

        // this needs to be added here since the GameOver panel is final
        double elapsedTime = Stopwatch.getElapsedTimeSeconds();
        timeDisplay.setText("Elapsed time: " + elapsedTime + " seconds");  // end screen elapsed time text

        setVisible(true);
    }

    public void doGameOver(){
        setVisible(false);
        restartGame.run();
    }
    public void doRestartDifficulty(){
        new DifficultyFrame();
    }
}
