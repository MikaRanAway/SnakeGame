package org.example;

import org.example.components.GamePanel;

import java.awt.*;

import static org.example.UniversalColor.colorHead;

public class SnakeHead {

    private int x;
    private int y;
    private Color color = colorHead;

    public SnakeHead(int startX, int startY){
        this.x = startX;
        this.y = startY;
    }

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, getX(), getY(), color);
    }


    //========== GETTERS ==========

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    //=========== SETTERS ===========

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}