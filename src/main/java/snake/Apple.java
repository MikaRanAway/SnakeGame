package snake;

import java.awt.*;
import java.util.Random;


public class Apple {
    private int x;
    private int y;
    private Color color = Color.red;

    //========== CONSTRUCTOR ==========

    public Apple(){
    
    }

    //========== GETTERS ==========

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    //========== LOGIC ==========

    public void draw(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillRect(this.x * GamePanel.UNIT_SIZE, this.y * GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
    }

    public void moveToEmptySpot(GamePanel gamePanel){
        Random random = new Random();
        int x;
        int y;

        do { 
            x = random.nextInt(GamePanel.GRID_WIDTH + 1);
            y = random.nextInt(GamePanel.GRID_HEIGHT + 1);
        } while(!isLocationAvailable(x, y, gamePanel));

        this.x = x;
        this.y = y;
    }

    private boolean isLocationAvailable(int x, int y, GamePanel gamePanel){
        return gamePanel.isSpaceEmpty(x, y) && gamePanel.isSpaceWithinBounds(x, y);
    }
}
