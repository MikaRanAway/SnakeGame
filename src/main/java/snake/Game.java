package snake;

import java.util.concurrent.TimeUnit;


public class Game implements Runnable{

    //Variables
    private static int TICK_SPEED = 200; // in milliseconds

    int Score;
    private final GamePanel gamePanel;

    //Constructor
    public Game(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    //Methods
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }


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
