package Q78Othello;

/**
 * Created by ziwen on 12/11/2016.
 */
public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;

    public Board(int rows, int columns) {
        board = new Piece[rows][columns];
    }

    public void initialize() {
        int middleRow = board.length / 2;
        int middleColumn = board[middleRow].length / 2;
        board[middleRow][middleColumn] = new Piece(Color.White);
        board[middleRow][middleColumn+1] = new Piece(Color.Black);
        board[middleRow+1][middleColumn] = new Piece(Color.Black);
        board[middleRow+1][middleColumn+1] = new Piece(Color.White);
        blackCount = 2;
        whiteCount = 2;
    }

    public boolean placeColor(int row, int column, Color color) {
        if (board[row][column] != null) {
            return false;
        }

        int[] results = new int[4];
        results[0] = flipSection(row-1, column, color, Direction.up);
        results[1] = flipSection(row+1, column, color, Direction.down);
        results[2] = flipSection(row, column-1, color, Direction.left);
        results[3] = flipSection(row, column+1, color, Direction.right);

        int flipped = 0;
        for (int r: results) {
            if (r > 0) {
                flipped += r;
            }
        }

        if (flipped <= 0) {
            return false;
        }
        board[row][column] = new Piece(color);
        updateScore(color, flipped + 1);
        return true;
    }

    private int flipSection(int row, int column, Color color, Direction d) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length || board[row][column] == null) {
            return -1;
        }

        if (board[row][column].getColor() == color) {
            return 0;
        }

        int r = 0;
        int c = 0;
        switch (d) {
            case up:
                r = -1;
                break;
            case down:
                r = 1;
                break;
            case left:
                c = -1;
                break;
            case right:
                c = 1;
                break;
        }

        int flipped = flipSection(row+r, column+c, color, d);
        if (flipped < 0) {
            return -1;
        }

        board[row][column].flip();
        return flipped + 1;
    }

    public int getScoreForColor(Color c) {
        return c == Color.Black ? blackCount : whiteCount;
    }

    public void updateScore(Color newColor, int newPieces) {
        if (newColor == Color.Black) {
            whiteCount -= newPieces - 1;
            blackCount += newPieces;
        } else {
            whiteCount += newPieces;
            blackCount -= newPieces - 1;
        }
    }

    public void printBoard() {
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[r].length; c++) {
                if (board[r][c] == null) {
                    System.out.print("_");
                } else if (board[r][c].getColor() == Color.Black) {
                    System.out.print("B");
                } else {
                    System.out.print("W");
                }
            }
            System.out.println();
        }
    }
}
