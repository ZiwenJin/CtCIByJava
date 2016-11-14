package Q710Minesweeper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;



/**
 * Created by ziwen on 14/11/2016.
 */
public class Board {
    private int nRows;
    private int nColumns;
    private int nBombs = 0;
    private Cell[][] cells;
    private Cell[] bombs;
    private int numUnexposedRemaining;

    public Board(int r, int c, int b) {
        nRows = r;
        nColumns = c;
        nBombs = b;

        initializeBoard();
        shuffleBoard();
        setNumberedCells();

        numUnexposedRemaining = nRows * nColumns - nBombs;
    }

    private void initializeBoard() {
        cells = new Cell[nRows][nColumns];
        bombs = new Cell[nBombs];
        for (int r=0; r<nRows; r++) {
            for (int c=0; c<nColumns; c++) {
                cells[r][c] = new Cell(r, c);
            }
        }

        for (int i=0; i<nBombs; i++) {
            int r = i / nColumns;
            int c = i % nColumns;
            bombs[i] = cells[r][c];
            bombs[i].setBomb(true);
        }
    }

    private void shuffleBoard() {
        int nCells = nRows * nColumns;
        Random random = new Random();
        for (int i1=0; i1<nCells-1; i1++) {
            int i2 = i1 + random.nextInt(nCells - i1 - 1) + 1;

            int row1 = i1 / nColumns;
            int column1 = i1 % nColumns;
            Cell cell1 = cells[row1][column1];

            int row2 = i2 / nColumns;
            int column2 = i2 % nColumns;
            Cell cell2 = cells[row2][column2];

            cells[row1][column1] = cell2;
            cell1.setRowAndColumn(row2, column2);
            cells[row2][column2] = cell1;
            cell2.setRowAndColumn(row1, column1);
        }
    }

    private boolean inBounds(int row, int column) {
        return row >= 0 && row < nRows && column >= 0 && column < nColumns;
    }

    private void setNumberedCells() {
        int [][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (Cell bomb: bombs) {
            int row = bomb.getRow();
            int column = bomb.getColumn();
            for (int[] delta: deltas) {
                int r = row + delta[0];
                int c = column + delta[1];
                if (inBounds(r, c)) {
                    cells[r][c].incrementNumber();
                }
            }
        }
    }

    public void printBoard(boolean showUnderside) {
        System.out.println();
        System.out.print("  ");
        for (int i=0; i<nColumns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i=0; i<nColumns; i++) {
            System.out.print("--");
        }
        System.out.println("---");
        for (int r=0; r<nRows; r++) {
            System.out.print(r + "|");
            for (int c=0; c<nColumns; c++) {
                if (showUnderside) {
                    System.out.print(cells[r][c].getUndersideState());
                } else {
                    System.out.print(cells[r][c].getSurfaceState());
                }
            }
            System.out.println("|");
        }
    }

    private boolean flipCell(Cell cell) {
        if (!cell.isExposed() && !cell.isGuess()) {
            cell.flip();
            numUnexposedRemaining--;
            return true;
        }
        return false;
    }

    public void expandBlank(Cell cell) {
        int [][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<Cell> toExplore = new LinkedList<>();
        toExplore.add(cell);

        while (!toExplore.isEmpty()) {
            Cell current = toExplore.remove();

            for (int[] delta: deltas) {
                int r = current.getRow() + delta[0];
                int c = current.getColumn() + delta[1];

                if (inBounds(r, c)) {
                    Cell neighbor = cells[r][c];
                    if (flipCell(neighbor) && neighbor.isBlank()) {
                        toExplore.add(neighbor);
                    }
                }
            }
        }
    }

    public UserPlayResult playFlip(UserPlay play) {
        Cell cell = getCellAtLocation(play);
        if (cell == null) {
            return new UserPlayResult(false, Game.GameState.RUNNING);
        }

        if (play.isGuess()) {
            boolean guessResult = cell.toggleGuess();
            return new UserPlayResult(guessResult, Game.GameState.RUNNING);
        }

        boolean result = flipCell(cell);

        if (cell.isBomb()) {
            return new UserPlayResult(result, Game.GameState.LOST);
        }

        if (cell.isBlank()) {
            expandBlank(cell);
        }

        if (numUnexposedRemaining == 0) {
            return new UserPlayResult(result, Game.GameState.WON);
        }

        return new UserPlayResult(result, Game.GameState.RUNNING);
    }

    public Cell getCellAtLocation(UserPlay play) {
        int row = play.getRow();
        int column = play.getColumn();
        if (!inBounds(row, column)) {
            return null;
        }
        return cells[row][column];
    }

    public int getNumRemaining() {
        return numUnexposedRemaining;
    }
}
