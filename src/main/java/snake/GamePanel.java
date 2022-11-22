package snake;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel{
    public static final int UNIT_SIZE = 20;
    public static final int GRID_WIDTH = GUI.WINDOW_WIDTH / UNIT_SIZE;
    public static final int GRID_HEIGHT = GUI.WINDOW_HEIGHT / UNIT_SIZE;

    final Apple apple = new Apple();


    public GamePanel(int windowWidth, int windowHeight){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawGrid(graphics);
        apple.draw(graphics);
    }

    private void drawGrid(Graphics graphics){
        graphics.setColor(Color.DARK_GRAY);

        // draws vertical lines
        for (int i = 0; i < GRID_WIDTH; i++){
            graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, GUI.WINDOW_HEIGHT);
        }

        // draws horizontal lines
        for (int i = 0; i < GRID_HEIGHT; i++){
            graphics.drawLine(0, i * UNIT_SIZE, GUI.WINDOW_WIDTH, i * UNIT_SIZE);
        }
    }
}
