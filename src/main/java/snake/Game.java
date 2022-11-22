package snake;

import java.util.concurrent.TimeUnit;


public class Game implements Runnable{

    //Variables
    private static int TICK_SPEED = 20; // in milliseconds
    private final GamePanel gamePanel;
    int Score;
    

    //Constructor
    public Game(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }


    //Methods

    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }

    //This method will run in a different thread. The game window will be unresponsive otherwise.
    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(TICK_SPEED);;
                gamePanel.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

    //Score Calculation
    public int scoreCalc(){
        return 0;
    }
}
