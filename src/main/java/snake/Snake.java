package snake;

import java.util.Stack;

public class Snake{
    SnakeHead head = new SnakeHead(0, 0); //TODO remove hard coded values
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

    public boolean canEat(Apple apple){
        int headX = 4; //TODO
        int headY = 4; //TODO

        return (apple.getX() == headX) && (apple.getY() == headY);
    }

    public void eat(Apple apple, GamePanel gamePanel){
        apple.getEaten(gamePanel);
        grow();
    }

    public void grow(){
        BodyPart newBodyPart = new BodyPart(0, 0); //TODO remove hard coded values
        snakeBody.push(newBodyPart);
    }

    public boolean doesOccupySpace(int x, int y){
        boolean headOccupiesSpace = (x == head.getX()) || (y == head.getY());
        if(headOccupiesSpace){
            return true;
        }

        for (BodyPart bodyPart : snakeBody){

        }
        return false; // TODO calculate based on positions of Snake's BodyParts
    }

    public boolean winCondition(){ return true; }
}
