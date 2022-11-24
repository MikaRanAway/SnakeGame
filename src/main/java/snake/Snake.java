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

    public boolean hasCollided(GamePanel gamePanel){
        boolean outOfBounds = !gamePanel.isSpaceWithinBounds(head.getX(), head.getY());
        boolean collidedWithItself = this.doesOccupySpace(head.getX(), head.getY());
        
        return outOfBounds || collidedWithItself;
    }

    public boolean canEat(Apple apple){
        boolean headIsOnApple = (apple.getX() == head.getX()) && (apple.getY() == head.getY());

        return headIsOnApple;
    }

    public void eat(Apple apple, GamePanel gamePanel){
        apple.getEaten(gamePanel);
        grow();
    }

    public void grow(){
        BodyPart lastBodyPart = snakeBody.peek();
        BodyPart newBodyPart = new BodyPart(lastBodyPart.getX(), lastBodyPart.getY()); //Two bodyparts on the same place. Deal with it.
        snakeBody.push(newBodyPart);
    }

    public boolean doesOccupySpace(int x, int y){
        boolean headOccupiesSpace = (x == head.getX()) || (y == head.getY());
        boolean bodyOccupiesSpace = bodyOccupiesSpace(x, y);
        
        return headOccupiesSpace || bodyOccupiesSpace;
    }

    public boolean bodyOccupiesSpace(int x, int y){
        for (BodyPart bodyPart : snakeBody){
            boolean bodyPartOccupiesSpace = (bodyPart.getX() == x) && (bodyPart.getY() == y);
            if(bodyPartOccupiesSpace){
                return true;
            }
        }
        return false;
    }

    public boolean winCondition(){ return true; }
}
