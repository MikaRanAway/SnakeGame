package snake.src.main.java.snake.components;

public class Stopwatch {
    private final long startTime;

    public Stopwatch(){
        startTime = System.currentTimeMillis();                  // remembers the time when stopwatch is created aka started
    }

    public int elapsedTimeSeconds(){
        long now = System.currentTimeMillis();                    // gets the current time
        double elapsedTime = (now - startTime) / 1000.0;          // calculates elapsed time and converts it to seconds (with decimals)
        return (int) elapsedTime;                                 // truncated time
    }
}
