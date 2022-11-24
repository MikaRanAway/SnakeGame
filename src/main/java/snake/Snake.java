package snake;
import java.awt.*;
import java.util.Stack;


public class Snake{
    public static final int STARTING_BODY_LENGTH = 3;

    private final SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>(); 
    private final Color snakeColor = Color.green;
    

    public Snake(int startX, int endX){
        head = new SnakeHead(startX, endX);

        for(int i = 1; i <= STARTING_BODY_LENGTH; i++){
            BodyPart bodyPart = new BodyPart(startX-i, endX);
            snakeBody.push(bodyPart);
        }
    }

    public void draw(Graphics graphics){
        graphics.setColor(snakeColor);
        GamePanel.fillRect(graphics, head.getX(), head.getY(), snakeColor);
        
        for(BodyPart bodyPart : snakeBody){
            GamePanel.fillRect(graphics, bodyPart.getX(), bodyPart.getY(), snakeColor);
        }
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
        boolean collidedWithItself = this.doesBodyOccupySpace(head.getX(), head.getY());
        
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
