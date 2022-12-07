package snake.src.main.java.snake.components;

import snake.src.main.java.snake.Game;
import snake.src.main.java.snake.components.Text.HeaderText;
import snake.src.main.java.snake.components.Text.NormalText;

import javax.swing.*;

public class GameOverPanel extends GameOverlayPanel {

    public GameOverPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("Game Over");
        NormalText time = new NormalText("Elapsed time: "); // end screen elapsed time text

        JButton tryAgain = new JButton();
        tryAgain.setText("Try Again");
        tryAgain.addActionListener(e -> {
            setVisible(false);
            Game.getInstance().start();
        });

        JButton chooseDifficulty = new JButton();
        chooseDifficulty.setText("Choose Difficulty Level");
        chooseDifficulty.addActionListener(e -> {
            setVisible(false);
            new DifficultyFrame();
        });

        contentContainer.add(headerText);
        contentContainer.add(time);
        contentContainer.add(tryAgain);
        contentContainer.add(chooseDifficulty);

        add(contentContainer);
    }

    public void showPanel(){
        setVisible(true);
    }
}
