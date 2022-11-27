package snake.src.main.java.snake;

public class SnakeHead {

    private int x;
    private int y;

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

    public void movement(){}
    public void eating(){}
}
