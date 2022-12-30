package org.example;
import org.example.components.GamePanel;

import java.awt.*;
import java.util.Stack;

import static org.example.SnakeColorSettings.isRandomColor;
import static org.example.SnakeColorSettings.randomizeColors;


public class Snake{
    public static final int STARTING_BODY_LENGTH = 3;

    private final SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>();

    //Constructor
    public Snake(int startX, int startY){
        if(isRandomColor){
            randomizeColors();
        }
        head = new SnakeHead(startX, startY);

        //creates initial body parts
        for(int i = 1; i <= STARTING_BODY_LENGTH; i++){
            if(isRandomColor){
                randomizeColors();
            }
            BodyPart bodyPart = new BodyPart(startX-i, startY);
            snakeBody.push(bodyPart);
        }
    }

    public void draw(Graphics graphics){
        for(BodyPart bodyPart : snakeBody){
            bodyPart.draw(graphics);
        }

        head.draw(graphics);
    }

    //========== MOVEMENT ==========

    public void move(){
        // this for loop makes the BodyParts to actually follow the head and each other
        for(int i = snakeBody.size() -1; i > 0; i--){
            followBody(i);
        }

        followHead();

        // these 4 if clauses handle the Direction of the snake
        if (Movement.isUpDirection()){
            head.setY(head.getY() - 1);
        } else if (Movement.isDownDirection()){
            head.setY(head.getY() + 1);
        } else if (Movement.isRightDirection()){
            head.setX(head.getX() + 1);
        } else if (Movement.isLeftDirection()){
            head.setX(head.getX() - 1);
        }
    }
    public void followHead(){
        BodyPart bodyPartClosestToHead = snakeBody.get(0);
        bodyPartClosestToHead.setX(head.getX());
        bodyPartClosestToHead.setY(head.getY());
    }
    public void followBody(int i){
        BodyPart bodyPart1 = snakeBody.get(i);
        BodyPart bodyPart2 = snakeBody.get(i -1);
        bodyPart1.setX(bodyPart2.getX());
        bodyPart1.setY(bodyPart2.getY());
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
        randomizeColors();
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
