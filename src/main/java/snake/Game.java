package snake;

import java.util.concurrent.TimeUnit;

import javax.management.monitor.GaugeMonitor;

public class Game implements Runnable{

    //Variables
    int Score;
    private final GamePanel gamePanel;

    //Constructor
    public Game(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    //Methods
    //run
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(200);;
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
