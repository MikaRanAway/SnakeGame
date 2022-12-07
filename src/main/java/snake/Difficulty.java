package snake.src.main.java.snake;

public enum Difficulty {
    EASY(200),
    MEDIUM(100),
    HARD(50);

    final int tickDelay;
    Difficulty(int tickDelay){
        this.tickDelay = tickDelay;
    }
}
