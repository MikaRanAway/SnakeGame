package snake;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel{
    final int SCREEN_HEIGHT = 400;
    final int SCREEN_WIDTH = 400;
    final int UNIT_SIZE = 75;


    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* 
         * for (int i = 0; i < (SCREEN_HEIGHT / UNIT_SIZE); i = i + 1) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
         * 
        */

    }
}
