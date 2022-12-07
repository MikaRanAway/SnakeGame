package snake.src.main.java.snake.components;

import snake.src.main.java.snake.Game;
import snake.src.main.java.snake.components.Text.HeaderText;
import snake.src.main.java.snake.components.Text.NormalText;

import javax.swing.*;

public class GameWonPanel extends GameOverlayPanel {
    public GameWonPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("You Won");
        NormalText time = new NormalText("Elapsed time: "); // end screen elapsed time text

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

    public void showPanel(){
        setVisible(true);
    }

    public void doGameOver(){
        setVisible(false);
        Game.getInstance().start();
    }

    public void doRestartDifficulty(){
        setVisible(false);
        DifficultyFrame gameOverRestartDifficulty = new DifficultyFrame();
    }
}
