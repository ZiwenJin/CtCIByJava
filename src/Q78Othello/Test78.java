package Q78Othello;

/**
 * Created by ziwen on 12/11/2016.
 */
public class Test78 {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.getBoard().initialize();
        game.getBoard().printBoard();
        System.out.println();
        Automator automator = Automator.getInstance();
        while (!automator.isOver() && automator.playRandom()) {}
        automator.printScores();
    }
}
