package org.example;

import java.awt.*;
import java.util.Random;

public class SnakeColorSettings {
    // The default colour of the snake if the user did not choose the customization optiob
    static Color headColor = Color.decode("#00ff00");
    static Color bodyColor = Color.decode("#00dd00");
    public static boolean isRandomColor = false;

    public static void setColors(Color head, Color body) {
        headColor = head;
        bodyColor = body;
    }

    public static void randomizeColors(){
        Random random = new Random();
        double r = random.nextFloat();
        double g = random.nextFloat();
        double b = random.nextFloat();
        Color randomColor = new Color((float) r, (float) g, (float) b);
        SnakeColorSettings snakeColorSettings = new SnakeColorSettings();
        snakeColorSettings.setColors(randomColor, randomColor);
    }
}


