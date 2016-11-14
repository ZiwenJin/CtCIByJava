package Q78Othello;

/**
 * Created by ziwen on 12/11/2016.
 */
public class Player {
    private Color color;

    public Player(Color c) {
        color = c;
    }

    public int getScore() {
        return Game.getInstance().getBoard().getScoreForColor(color);
    }

    public boolean playPiece(int row, int column) {
        return Game.getInstance().getBoard().placeColor(row, column, color);
    }

    public Color getColor() {
        return color;
    }
}
