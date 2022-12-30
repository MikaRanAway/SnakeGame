package org.example.components;

import org.example.components.Text.HeaderText;
import org.example.components.Text.NormalText;

import javax.swing.*;

public class GameWonPanel extends GameOverlayPanel{
    Runnable restartGame;
    private final NormalText time;

    GameWonPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("You Won");
        time = new NormalText("Elapsed time: 0");

        JButton TryAgain = new JButton();
        TryAgain.setText("Try Again");
        TryAgain.addActionListener(e -> {
            doGameOver();
        });

        JButton ChooseDifficulty = new JButton();
        ChooseDifficulty.setText("Choose Difficulty Level");
        ChooseDifficulty.addActionListener(e -> doRestartDifficulty());

        contentContainer.add(headerText);
        contentContainer.add(time);
        contentContainer.add(TryAgain);
        contentContainer.add(ChooseDifficulty);
        add(contentContainer);
    }

    public void showPanel(Runnable restartGame){
        this.restartGame = restartGame;

        // this needs to be added here since the GameOver panel is final
        double elapsedTime = Stopwatch.getElapsedTimeSeconds();
        time.setText("Elapsed time: " + elapsedTime + " seconds");  // end screen elapsed time text

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
