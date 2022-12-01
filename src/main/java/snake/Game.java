package snake.src.main.java.snake;

import snake.src.main.java.snake.components.GUI;
import snake.src.main.java.snake.components.GamePanel;

import java.util.concurrent.TimeUnit;


public class Game implements Runnable{

    //Variables
    private static int TICK_SPEED = 100; // in milliseconds

    private final GUI gui;
    private final GamePanel gamePanel;
    private Snake snake;
    private Apple apple;

    Thread gameThread;
    private boolean runGame = true;

    int score;


    //Constructor
    public Game(){
        gui = new GUI();
        gamePanel = gui.addGamePanel();
    }


    //Methods
    public void start(){
        gui.requestFocus(); //for keyboard listener to work
        apple = new Apple();
        snake = new Snake(GamePanel.GRID_WIDTH/2, GamePanel.GRID_HEIGHT/2);
        gamePanel.initialize(snake, apple);
        apple.moveToEmptySpot(gamePanel);

        runGame = true;
        gameThread = new Thread(this); // Game.java implements Runnable
        gameThread.start();
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
        //the order of these statements matters A LOT, be careful

        snake.move();
        Movement.directionWasUsed();
        if(snake.hasCollided(gamePanel)){
            failGame();
            return;
        }

        if(hasWon()){
            winGame();
            return;
        }

        if(snake.canEat(apple)){
            snake.eat(apple, gamePanel);
        }

        gamePanel.repaint(); //no changes are displayed until this is called
    }

    public boolean hasWon(){
        return snake.getLength() >= GamePanel.GRID_WIDTH * GamePanel.GRID_HEIGHT;
    }

    private void winGame(){
        System.out.println("Won game");
        runGame = false;
        gamePanel.showGameWon(this::restart);
    }

    private void failGame(){
        System.out.println("Failed game");
        runGame = false;
        gamePanel.showGameOver(this::restart);
    }

    public void restart(){
        Movement.resetDirections();
        start();
    }
    

    //Score Calculation
    public int scoreCalc(){
        return 0;
    }
}
