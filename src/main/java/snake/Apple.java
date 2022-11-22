package snake;

import java.awt.*;
import java.util.Random;


public class Apple {
    private int x;
    private int y;

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

    public void draw (Graphics d){

    }


    public void spawn(){
        int[] location = findAvailableLocation();


    }

    private int[] findAvailableLocation(){
        Random random = new Random();

        while(true) { 
            int x = random.nextInt(GUI.gridSizeX + 1);
            int y = random.nextInt(GUI.gridSizeY + 1);
            if(isLocationAvailable(x, y)){
                return new int[]{x, y};
            }

        }
    }

    private boolean isLocationAvailable(int x, int y){
        if (!isLocationWithinBounds(x, y)){
            return false;
        }

        // get snake position
        return true; 
    }

    private boolean isLocationWithinBounds(int x, int y){
        return (x <= GUI.gridSizeX) && (y <= GUI.gridSizeY);
    }
}
