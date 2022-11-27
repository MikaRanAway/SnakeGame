package snake.src.main.java.snake;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel{
    public static final int UNIT_SIZE = 20;
    public static final int GRID_WIDTH = GUI.WINDOW_WIDTH / UNIT_SIZE; // Not in pixels, measured in units
    public static final int GRID_HEIGHT = GUI.CONTENT_HEIGHT / UNIT_SIZE; // Not in pixels, measured in units

    final Snake snake;
    final Apple apple;


    public GamePanel(Snake snake, Apple apple){
        this.snake = snake;
        this.apple = apple;
        
        this.setPreferredSize(new Dimension(GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // for performance, apparently
    }

    // Called EVERY TIME JPanel "paints"
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawGridLines(graphics);
        apple.draw(graphics);
        snake.draw(graphics);
    }

    private void drawGridLines(Graphics graphics){
        graphics.setColor(Color.DARK_GRAY);

        // draws vertical lines
        for (int i = 1; i < GRID_WIDTH; i++){
            graphics.drawLine(unitToPx(i), 0, unitToPx(i), GUI.CONTENT_HEIGHT);
        }

        // draws horizontal lines
        for (int i = 1; i < GRID_HEIGHT; i++){
            graphics.drawLine(0, unitToPx(i), GUI.WINDOW_WIDTH, unitToPx(i));
        }
    }


    //========== USED BY COMPONENTS ==========

    public static int unitToPx(int units){
        return units * UNIT_SIZE;
    }

    public boolean isSpaceWithinBounds(int x, int y){
        return (x <= GRID_WIDTH) && (y <= GRID_HEIGHT);
    }

    public boolean isSpaceEmpty(int x, int y){
        boolean snakeOccupiesSpace = snake.doesSnakeOccupySpace(x, y);
        boolean appleOccupiesSpace = (apple.getX() == x) && (apple.getY() == y);

        return !(snakeOccupiesSpace || appleOccupiesSpace);
    }

    public static void fillRect(Graphics graphics, int x, int y, Color color){
        graphics.setColor(color);
        graphics.fillRect(unitToPx(x), unitToPx(y), UNIT_SIZE, UNIT_SIZE);
    }
}
