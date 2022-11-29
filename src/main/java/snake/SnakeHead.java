package snake.src.main.java.snake;

import java.awt.*;

public class SnakeHead {

    private int x;
    private int y;
    private final Color color = Color.decode("#00ff00");

    //sad and empty

    public SnakeHead(int startX, int startY){
        this.x = startX;
        this.y = startY;
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

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, getX(), getY(), color);
    }

}
