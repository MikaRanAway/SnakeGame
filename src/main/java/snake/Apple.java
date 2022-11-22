package snake;

import java.awt.*;
import java.util.Random;

import javax.tools.DocumentationTool.Location;

public class Apple {
    int appleX;
    int appleY;

    public Apple(){

    }

    public void draw (Graphics d){

    }

    public void spawn(){
        int[] location = findEmptyLocation();
    }

    private int[] findEmptyLocation(){
        Random random = new Random();

        while(true) { 
            int x = random.nextInt(21); //tmp hard coded
            int y = random.nextInt(21); //tmp hard coded
            if(isLocationEmpty(x, y)){ //tmp , if location is empty
                return new int[]{x, y};
            }

        }
    }

    private boolean isLocationEmpty(int x, int y){
        if (!isLocationWithinBounds(x, y)){
            return false;
        }

        // get snake position
        return true; 
    }

    private boolean isLocationWithinBounds(int x, int y){
        int gridSizeX = 20; //tmp
        int gridSizeY = 20; //tmp

        return (x <= gridSizeX) && (y <= gridSizeY);
    }
}
