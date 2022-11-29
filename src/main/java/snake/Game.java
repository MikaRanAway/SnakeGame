package snake.src.main.java.snake;

import javax.swing.*;
import java.util.concurrent.TimeUnit;


public class Game implements Runnable{

    //Variables
    private static int TICK_SPEED = 400; // in milliseconds

    private final GUI gui;
    private final GamePanel gamePanel;
    private final Snake snake = new Snake(GamePanel.GRID_WIDTH/2, GamePanel.GRID_HEIGHT/2);
    private final Apple apple = new Apple();
    int score;
    private boolean runGame = true;
    

    //Constructor
    public Game(){
        gui = new GUI();
        gui.render();
        gamePanel = gui.addGamePanel(snake, apple);
    }


    //Methods

    public void start(){
        apple.moveToEmptySpot(gamePanel);

        Thread thread = new Thread(this); // Game.java implements Runnable
        thread.start();
    }

    //This method will run in a different thread. The game window will be unresponsive otherwise.
    @Override
    public void run() {
        while(runGame){
            try {
                TimeUnit.MILLISECONDS.sleep(TICK_SPEED);
                doGameTick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGameTick(){
        snake.move();
        if(snake.hasCollided(gamePanel)){
            failGame();
            return;
        }

        if(snake.canEat(apple)){
            snake.eat(apple, gamePanel);
        }

        gamePanel.repaint(); //no changes are displayed until this is called
    }

    private void failGame(){
        runGame = false;
        gamePanel.showGameOver();
    }
    

    //Score Calculation
    public int scoreCalc(){
        return 0;
    }
}
