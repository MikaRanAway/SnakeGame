package snake;

import java.awt.*;
import java.util.Random;


public class Apple {
    private int appleX;
    private int appleY;

    //========== CONSTRUCTOR ==========

    public Apple(){

    }

    //========== GETTERS ==========

    public int getAppleX(){
        return appleX;
    }

    public int getAppleY(){
        return appleY;
    }


    //========== LOGIC ==========

    public void draw (Graphics d){

    }


    public void spawn(){
        int[] location = findEmptyLocation();


    }

    private int[] findEmptyLocation(){
        Random random = new Random();

        while(true) { 
            int x = random.nextInt(GUI.gridSizeX + 1); //tmp hard coded
            int y = random.nextInt(GUI.gridSizeY + 1); //tmp hard coded
            if(isLocationAvailable(x, y)){ //tmp , if location is empty
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
