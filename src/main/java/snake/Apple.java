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
        GamePanel.fillRect(graphics, this.x, this.y, this.color);
    }

    //used because Snake class should not "know" anything specific about apple
    public void getEaten(GamePanel gamePanel){
        moveToEmptySpot(gamePanel);
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
