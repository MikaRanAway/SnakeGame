package snake;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel{
    final int windowWidth;
    final int windowHeight;
    final int UNIT_SIZE = 20;
    final int gridWidth;
    final int gridHeight;


    public GamePanel(int windowWidth, int windowHeight){
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.gridWidth = windowWidth / UNIT_SIZE;
        this.gridHeight = windowHeight / UNIT_SIZE;

        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawGrid(graphics);
    }

    private void drawGrid(Graphics graphics){
        graphics.setColor(Color.GRAY);

        for (int i = 0; i < gridWidth; i++){
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, windowHeight);
        }

        for (int i = 0; i < gridHeight; i++){
            graphics.drawLine(0, i * UNIT_SIZE, windowWidth, i * UNIT_SIZE);
        }
    }
}
