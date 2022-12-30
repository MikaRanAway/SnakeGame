package org.example;

import java.awt.*;
import java.util.Random;

public class UniversalColor {
    // The default colour of the snake if the user did not choose the customization optiob
    static Color colorHead = Color.decode("#00ff00");
    static Color colorBody = Color.decode("#00dd00");

    public static boolean isRandomColor = false;


    public static void setColors(Color head, Color body) {
        colorHead = head;
        colorBody = body;
    }

    public static void randomizeColors(){
        Random random = new Random();
        double r = random.nextFloat();
        double g = random.nextFloat();
        double b = random.nextFloat();
        Color randomColor = new Color((float) r, (float) g, (float) b);
        UniversalColor universalColor = new UniversalColor();
        universalColor.setColors(randomColor, randomColor);
    }
}


