package snake.src.main.java.snake;

import java.awt.*;

public class BodyPart {
    private int x;
    private int y;
    private final Color color = Color.decode("#00dd00");

    public BodyPart(int x, int y){
        this.x = x;
        this.y = y;
    }


    //========== GETTERS ==========

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }


    //========== SETTERS ==========

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, getX(), getY(), color);
    }
}
