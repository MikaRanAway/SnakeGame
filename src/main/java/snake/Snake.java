package snake;

import java.util.Stack;

public class Snake{
    // SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>();

    public Snake(){}

    public void movement(GamePanel gamePanel){

        //...

        int newX = -1; //tmp
        int newY = -1; //tmp
        if(willCollide(newX, newY, gamePanel)){
            //TODO: failGame()
        }
    }


    private boolean willCollide(int newX, int newY, GamePanel gamePanel){
        if(!gamePanel.isSpaceWithinBounds(newX, newY)){
            return true;
        }

        // TODO: add collision with itself
        
        return false;
    }

    public void grow(){
        BodyPart newBodyPart = new BodyPart();
        snakeBody.push(newBodyPart);
    }

    public boolean doesOccupySpace(int x, int y){
        return false; // TODO calculate based on positions of Snake's BodyParts
    }

    public boolean winCondition(){ return true; }
}
