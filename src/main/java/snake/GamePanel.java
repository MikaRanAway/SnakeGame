package snake;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel{
    final int windowWidth;
    final int windowHeight;
    final int UNIT_SIZE = 20;


    public GamePanel(int windowWidth, int windowHeight){
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g);
    }

    void drawGrid(Graphics g){
        for (int i = 0; i < (windowHeight / UNIT_SIZE); i = i + 1) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, windowHeight);
            g.drawLine(0, i * UNIT_SIZE, windowWidth, i * UNIT_SIZE);
        }
    }
}
