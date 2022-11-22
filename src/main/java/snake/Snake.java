package snake;

import java.util.Stack;

public class Snake{
    // SnakeHead head;

    //Doesn't really matter which type of collection as we are only adding to it
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

    //Called "WILLcollide" because it it probably best to check that we can move to a space BEFORE moving there
    private boolean willCollide(int newX, int newY, GamePanel gamePanel){
        boolean outOfBounds = !gamePanel.isSpaceWithinBounds(newX, newY);
        boolean collidedWithItself = this.doesOccupySpace(newX, newY);
        
        return outOfBounds || collidedWithItself;
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
