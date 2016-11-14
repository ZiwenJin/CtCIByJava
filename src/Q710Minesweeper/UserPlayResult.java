package Q710Minesweeper;

/**
 * Created by ziwen on 14/11/2016.
 */
public class UserPlayResult {
    private boolean successful;
    private Game.GameState resultingState;

    public UserPlayResult(boolean success, Game.GameState state) {
        successful = success;
        resultingState = state;
    }

    public boolean successfulMove() {
        return successful;
    }

    public Game.GameState getResultingState() {
        return resultingState;
    }
}
