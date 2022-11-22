package snake;

import java.awt.*;
import java.util.Random;


public class Apple {
    private int x;
    private int y;

    //========== CONSTRUCTOR ==========

    public Apple(){
        moveToEmptySpot();
    }

    //========== GETTERS ==========

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    //========== LOGIC ==========

    public void draw (Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fillRect(this.x * GamePanel.UNIT_SIZE, this.y * GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
    }


    private void moveToEmptySpot(){
        Random random = new Random();
        int x;
        int y;

        do { 
            x = random.nextInt(GamePanel.GRID_WIDTH+ 1);
            y = random.nextInt(GamePanel.GRID_HEIGHT + 1);
        } while(!isLocationAvailable(x, y));

        this.x = x;
        this.y = y;
    }

    private boolean isLocationAvailable(int x, int y){
        if (!isLocationWithinBounds(x, y)){
            return false;
        }

        // get snake position
        return true; 
    }

    private boolean isLocationWithinBounds(int x, int y){
        return (x <= GamePanel.GRID_WIDTH) && (y <= GamePanel.GRID_HEIGHT);
    }
}
