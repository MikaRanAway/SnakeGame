package org.example;
import org.example.components.GamePanel;

import java.awt.*;
import java.util.Stack;

import static org.example.components.CustomizationFrame.colorRandom;
import static org.example.components.CustomizationFrame.randomColor;


public class Snake{
    public static final int STARTING_BODY_LENGTH = 3;

    private final SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>();

    //Constructor
    public Snake(int startX, int endX){
        if(colorRandom){
            randomColor();
        }
        head = new SnakeHead(startX, endX);

        //creates initial body parts
        for(int i = 1; i <= STARTING_BODY_LENGTH; i++){
            if(colorRandom){
                randomColor();
            }
            BodyPart bodyPart = new BodyPart(startX-i, endX);
            snakeBody.push(bodyPart);

        }
    }

    public void draw(Graphics graphics){
        for(BodyPart bodyPart : snakeBody){
            bodyPart.draw(graphics);
        }

        head.draw(graphics); //after body to look better after collision
    }

    //========== MOVEMENT ==========

    public void move(){
        // this for loop makes the BodyParts to actually follow the head and each other
        for(int i = snakeBody.size() -1; i >= 0; i--){
            if (i != 0){
                followBody(i);
            }else {
                followHead(i);
            }
        }

        // these 4 if clauses handle the Direction of the snake
        if (Movement.isUpDirection()){
            head.setY(head.getY() - 1);
        }
        if (Movement.isDownDirection()){
            head.setY(head.getY() + 1);
        }
        if (Movement.isRightDirection()){
            head.setX(head.getX() + 1);
        }
        if (Movement.isLeftDirection()){
            head.setX(head.getX() - 1);
        }
    }
    public void followHead(int i){
        // the last body part is index = 0 in the stack<BodyPart> and this part is the one exactly before the head
        BodyPart lastBodyPart = snakeBody.get(i);
        lastBodyPart.setX(head.getX());
        lastBodyPart.setY(head.getY());
    }
    public void followBody( int i){
        BodyPart firsBodyPart = snakeBody.get(i); // the first body part is the last index in the stack<BodyPart>
        BodyPart secondBodyPart = snakeBody.get(i -1); // the second body part is the second tp last index in the stack<BodyPart>
        firsBodyPart.setX(secondBodyPart.getX());
        firsBodyPart.setY(secondBodyPart.getY());
    }



    //========== GROWTH ==========

    public boolean canEat(Apple apple){
        return
            (apple.getX() == head.getX()) &&
            (apple.getY() == head.getY());
    }

    public void eat(Apple apple, GamePanel gamePanel){
        apple.getEaten(gamePanel);
        grow();
    }

    public void eatRandomColor(Apple apple, GamePanel gamePanel){
        apple.getEaten(gamePanel);
        grow();
        randomColor();
    }

    private void grow(){
        BodyPart lastBodyPart = snakeBody.peek();
        BodyPart newBodyPart = new BodyPart(lastBodyPart.getX(), lastBodyPart.getY()); //To bodyParts at same place (until snake moves)
        snakeBody.push(newBodyPart);
    }

    public int getLength(){
        return snakeBody.size() + 1; // body + head
    }


    //========== COLLISION ==========

    public boolean hasCollided(GamePanel gamePanel){
        boolean withinBounds = gamePanel.isSpaceWithinBounds(head.getX(), head.getY());
        boolean collidedWithItself = this.doesBodyOccupySpace(head.getX(), head.getY());
        
        return !withinBounds || collidedWithItself;
    }

    //also used by Apple class
    public boolean doesSnakeOccupySpace(int x, int y){
        return doesHeadOccupySpace(x, y) || doesBodyOccupySpace(x, y);
    }

    public boolean doesHeadOccupySpace(int x, int y){
        return (x == head.getX()) &&
                (y == head.getY());
    }

    public boolean doesBodyOccupySpace(int x, int y){
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
