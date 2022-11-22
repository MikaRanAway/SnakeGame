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
        graphics.fillRect(GamePanel.unitToPx(this.x), GamePanel.unitToPx(this.y), GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
    }

    public void moveToEmptySpot(GamePanel gamePanel){
        Random random = new Random();
        int x;
        int y;

        do { 
            x = random.nextInt(GamePanel.GRID_WIDTH);
            y = random.nextInt(GamePanel.GRID_HEIGHT);
        } while(!gamePanel.isSpaceEmpty(x, y));

        this.x = x;
        this.y = y;
    }
}
