package Q78Othello;

/**
 * Created by ziwen on 12/11/2016.
 */
public class Location {
    private int row;
    private int column;

    public Location(int r, int c) {
        row = r;
        column = c;
    }

    public boolean isSameAs(int r, int c) {
        return row == r && column == c;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
