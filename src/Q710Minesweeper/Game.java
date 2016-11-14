package Q710Minesweeper;

import java.util.Scanner;

/**
 * Created by ziwen on 14/11/2016.
 */
public class Game {
    public enum GameState {
        WON, LOST, RUNNING
    }

    private Board board;
    private int rows;
    private int columns;
    private int bombs;
    private GameState state;

    public Game(int r, int c, int b) {
        rows = r;
        columns = c;
        bombs = b;
        state = GameState.RUNNING;
    }

    public boolean initialize() {
        if (board == null) {
            board = new Board(rows, columns, bombs);
            return true;
        } else {
            System.out.println("Game has already been initialized");
            return false;
        }
    }

    public boolean start() {
        if (board == null) {
            initialize();
        }
        return playGame();
    }

    public void printGameState() {
        if (state == GameState.LOST) {
            board.printBoard(true);
            System.out.println("FAIL");
        } else if (state == GameState.WON) {
            board.printBoard(true);
            System.out.println("WON");
        } else {
            board.printBoard(false);
            System.out.println("Number remaining: " + board.getNumRemaining());
        }
    }

    public boolean playGame() {
        Scanner scanner = new Scanner(System.in);
        printGameState();

        while (state == GameState.RUNNING) {
            System.out.print("enter a location in format: _ _: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                scanner.close();
                System.out.println("exit the game");
                return false;
            }

            UserPlay play = UserPlay.fromString(input);
            if (play == null) {
                continue;
            }

            UserPlayResult result = board.playFlip(play);
            if (result.successfulMove()) {
                state = result.getResultingState();
            } else {
                System.out.println("Could not flip cell (" + play.getRow() + ", " + play.getColumn() + ")");
            }
            printGameState();
        }
        scanner.close();
        return true;
    }
}
