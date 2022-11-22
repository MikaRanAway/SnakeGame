package snake;

import java.util.Stack;

public class Snake{
    // SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>();

    public Snake(){}

    public void movement(){

        //...

        int newX = -1; //tmp
        int newY = -1; //tmp
        if(willCollide(newX, newY)){
            //failGame()
        }
    }


    private boolean willCollide(int newX, int newY){
        if(isOutOfBounds(newX, newY)){
            return true;
        }
        
        return false;
    }

    private boolean isOutOfBounds(int x, int y){
        return (x > GamePanel.GRID_WIDTH) || (y > GamePanel.GRID_HEIGHT);
    }

    public void grow(){
        BodyPart newBodyPart = new BodyPart();
        snakeBody.push(newBodyPart);
    }

    public boolean winCondition(){ return true; }
}
