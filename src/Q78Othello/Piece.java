package Q78Othello;

/**
 * Created by ziwen on 12/11/2016.
 */
public class Piece {
    private Color color;

    public Piece(Color c) {
        color = c;
    }

    public void flip() {
        color = color == Color.Black ? Color.White : Color.Black;
    }

    public Color getColor() {
        return color;
    }
}
