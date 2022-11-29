package snake.src.main.java.snake;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    public static final int UNIT_SIZE = 20;
    public static final int GRID_WIDTH = GUI.WINDOW_WIDTH / UNIT_SIZE; // Not in pixels, measured in units
    public static final int GRID_HEIGHT = GUI.CONTENT_HEIGHT / UNIT_SIZE; // Not in pixels, measured in units
    private static boolean leftDirection = false;
    private static boolean rightDirection = true;
    private static boolean upDirection = false;
    private static boolean downDirection = false;
    final Snake snake;
    final Apple apple;

    public static boolean isLeftDirection() {
        return leftDirection;
    }

    public static boolean isRightDirection() {
        return rightDirection;
    }

    public static boolean isUpDirection() {
        return upDirection;
    }

    public static boolean isDownDirection() {
        return downDirection;
    }

    public GamePanel(Snake snake, Apple apple){
        this.snake = snake;
        this.apple = apple;
        
        this.setPreferredSize(new Dimension(GUI.WINDOW_WIDTH, GUI.CONTENT_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // for performance, apparently
        this.addKeyListener(new MyKeyAdapter()); // this will add and use the class for moving the snake based on keyboard input
        this.setFocusable(true); // this will make the keyboard be focused on the game window
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
    //this class is needed to use the method kePressed() which will wait for a key to be pressed on the keyboard
    private static class MyKeyAdapter extends KeyAdapter {
        //This is an Override method which should control the snakes movement based on the key pressed! source: internet XD
        @Override
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            //if the UP Arrow key is pressed AND the snake is not moving down then the head will move UP
            if (keyCode == KeyEvent.VK_UP && !downDirection){
                upDirection = true;
                leftDirection = false;
                rightDirection =false;
            }
            //if the DOWN Arrow key is pressed AND the snake is not moving up then the head will move DOWN
            else if (keyCode == KeyEvent.VK_DOWN && !upDirection) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
            //if the RIGHT Arrow key is pressed AND the snake is not moving left then the head will move RIGHT
            else if (keyCode == KeyEvent.VK_RIGHT && !leftDirection) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            //if the LEFT Arrow key is pressed AND the snake is not moving right then the head will move LEFT
            else if (keyCode == KeyEvent.VK_LEFT && !rightDirection){
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
        }
    }
}
