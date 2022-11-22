package snake;

public final class Main{
    public static void main(String[] args) {
        System.out.println("~~~~<  *");

        final GUI gui = new GUI();
        gui.render();
        GamePanel gamePanel = gui.addGamePanel();
        
        Game game = new Game(gamePanel);
        game.start();
    }

}