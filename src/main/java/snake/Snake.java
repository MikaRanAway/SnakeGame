package snake;

import java.util.Stack;

public class Snake{
    // SnakeHead head;
    private final Stack<BodyPart> snakeBody = new Stack<BodyPart>();

    public Snake(){}

    public void movement(){}

    public void collision(){}        // maybe this is a boolean that triggers the lose screen if true?

    public void grow(){
        BodyPart newBodyPart = new BodyPart();
        snakeBody.push(newBodyPart);
    }

    public boolean winCondition(){ return true; }
}
