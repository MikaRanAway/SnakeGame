package snake.src.main.java.snake;
import java.awt.*;
import java.util.Stack;


public class Snake{
    public static final int STARTING_BODY_LENGTH = 3;

    private final SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>(); 
    private final Color snakeColor = Color.green;
    

    public Snake(int startX, int endX){
        head = new SnakeHead(startX, endX);

        //creates initial body parts
        for(int i = 1; i <= STARTING_BODY_LENGTH; i++){
            BodyPart bodyPart = new BodyPart(startX-i, endX);
            snakeBody.push(bodyPart);
        }
    }

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, head.getX(), head.getY(), snakeColor);
        
        for(BodyPart bodyPart : snakeBody){
            GamePanel.fillRect(graphics, bodyPart.getX(), bodyPart.getY(), snakeColor);
        }
    }

    public void movement(){

        for(int i = snakeBody.size() -1; i > 0; i--){
            followBody();
        }

        if (GamePanel.isUpDirection()){
            head.setY(head.getY() - 1);
        }
        if (GamePanel.isDownDirection()){
            head.setY(head.getY() + 1);
        }
        if (GamePanel.isRightDirection()){
            head.setX(head.getX() + 1);
        }
        if (GamePanel.isLeftDirection()){
            head.setX(head.getX() - 1);
        }
    }
    public void followHead(BodyPart lastBodyPart){
        lastBodyPart.setX(head.getX());
        lastBodyPart.setY(head.getY());
    }
    public void followBody(BodyPart previousBodyPart, int i){
        previousBodyPart.setX();
        previousBodyPart.setY();
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
        BodyPart newBodyPart = new BodyPart(lastBodyPart.getX(), lastBodyPart.getY()); //To bodyParts at same place (until snake moves)
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
        boolean headOccupiesSpace = 
            (x == head.getX()) || 
            (y == head.getY());
            
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
