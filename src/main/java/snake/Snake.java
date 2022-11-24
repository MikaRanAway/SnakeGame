package snake;

import java.util.Stack;

public class Snake{
    private final SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>(); 

    public Snake(int startX, int endX){
        head = new SnakeHead(startX, endX);
    }

    public void movement(){
    }


    //========== GROWTH ==========

    public boolean canEat(Apple apple){
        boolean headIsOnApple = 
            (apple.getX() == head.getX()) &&
            (apple.getY() == head.getY());

        return headIsOnApple;
    }

    public void eat(Apple apple, GamePanel gamePanel){
        apple.getEaten(gamePanel);
        grow();
    }

    private void grow(){
        BodyPart lastBodyPart = snakeBody.peek();
        BodyPart newBodyPart = new BodyPart(lastBodyPart.getX(), lastBodyPart.getY()); //Two bodyparts on the same place. Deal with it.
        snakeBody.push(newBodyPart);
    }


    //========== COLLISION ==========

    public boolean hasCollided(GamePanel gamePanel){
        boolean withinBounds = gamePanel.isSpaceWithinBounds(head.getX(), head.getY());
        boolean collidedWithItself = this.doesSnakeOccupySpace(head.getX(), head.getY());
        
        return !withinBounds || collidedWithItself;
    }

    //also used by Apple class
    public boolean doesSnakeOccupySpace(int x, int y){
        boolean headOccupiesSpace = (x == head.getX()) || (y == head.getY());
        boolean bodyOccupiesSpace = doesBodyOccupySpace(x, y);
        
        return headOccupiesSpace || bodyOccupiesSpace;
    }

    private boolean doesBodyOccupySpace(int x, int y){
        for (BodyPart bodyPart : snakeBody){
            boolean bodyPartOccupiesSpace = 
                (bodyPart.getX() == x) && 
                (bodyPart.getY() == y);
                
            if(bodyPartOccupiesSpace){
                return true;
            }
        }
        return false;
    }
}
