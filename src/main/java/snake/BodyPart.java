package snake.src.main.java.snake;

public class BodyPart {
    private int x;
    private int y;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Follow(){

    }
}
