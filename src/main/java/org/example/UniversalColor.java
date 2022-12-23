package org.example;

import java.awt.*;

public class UniversalColor {
    // The default colour of the snake if the user did not choose the customization optiob
    static Color colorHead = Color.decode("#00ff00");
    static Color colorBody = Color.decode("#00dd00");

public void setColorHead(Color head, Color body) {
    colorHead = head;
    colorBody = body;
    }
}


