package snake.src.main.java.snake.components;

import javax.swing.*;
import java.awt.*;

public class GameplayUI extends JPanel {

    private static final Color sectionColor = new Color(255, 26, 102, 100);
    private NormalText stopwatchDisplay;
    public GameplayUI(){
        setBackground(sectionColor);
        setPreferredSize(new Dimension(500, 60));
        setVisible(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;


        // stopwatch display initialization
        stopwatchDisplay = new NormalText(" seconds");

        add(stopwatchDisplay);
    }

    public void showPanel(){
        // updates the time
        double elapsedTime = Stopwatch.elapsedTimeSeconds();
        stopwatchDisplay.setText(elapsedTime + " seconds");

        setVisible(true);
    }
    public void updatePanel(){
        double elapsedTime = Stopwatch.elapsedTimeSeconds();
        stopwatchDisplay.setText(elapsedTime + " seconds");
    }
}
