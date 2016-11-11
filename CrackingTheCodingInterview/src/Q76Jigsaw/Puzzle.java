package Q76Jigsaw;

import sun.security.provider.SHA;

import java.util.LinkedList;

/**
 * Created by ziwen on 10/11/2016.
 */
public class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece[][] solution;
    private int size;

    public Puzzle(int size, LinkedList<Piece> pieces) {
        this.size = size;
        this.pieces = pieces;
    }

    public void groupPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces) {
        for (Piece p: pieces) {
            if (p.isCorner()) {
                cornerPieces.add(p);
            } else if (p.isBorder()) {
                borderPieces.add(p);
            } else {
                insidePieces.add(p);
            }
        }
    }

    public void orientTopLeftCorner(Piece piece) {
        if (!piece.isCorner()) {
            return;
        }

        Orientation[] orientations = Orientation.values();
        for (int i=0; i<orientations.length; i++) {
            Edge current = piece.getEdgeWithOrientation(orientations[i]);
            Edge next = piece.getEdgeWithOrientation(orientations[(i+1)%orientations.length]);
            if (current.getShape() == Shape.FLAT && next.getShape() == Shape.FLAT) {
                piece.setEdgeAsOrientation(current, Orientation.LEFT);
                return;
            }
        }
    }

    public boolean isBorderIndex(int location) {
        return location == 0 || location == size-1;
    }

    private Edge getMatchingEdge(Edge targetEdge, LinkedList<Piece> pieces) {
        for (Piece p : pieces) {
            Edge matchingEdge = p.getMatchingEdge(targetEdge);
            if (matchingEdge != null) {
                return matchingEdge;
            }
        }
        return null;
    }

    private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge, int row, int col, Orientation orientation) {
        Piece piece = edge.getParentPiece();
        piece.setEdgeAsOrientation(edge, orientation);
        pieces.remove(piece);
        solution[row][col] = piece;
    }

    private LinkedList<Piece> getPieceListToSearch(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces, int row, int col) {
        if (isBorderIndex(row) && isBorderIndex(col)) {
            return cornerPieces;
        } else if (isBorderIndex(row) || isBorderIndex(col)) {
            return borderPieces;
        } else {
            return insidePieces;
        }
    }

    private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int col) {
        if (row == 0 && col == 0) {
            Piece p = piecesToSearch.remove();
            orientTopLeftCorner(p);
            solution[0][0] = p;
        } else {
            Piece pieceToMathch = col == 0 ? solution[row-1][0] : solution[row][col-1];
            Orientation orientationToMatch = col == 0 ? Orientation.BOTTOM : Orientation.RIGHT;
            Edge edgeToMathch = pieceToMathch.getEdgeWithOrientation(orientationToMatch);

            Edge edge = getMatchingEdge(edgeToMathch, piecesToSearch);
            if (edge == null) {
                return false;
            }

            Orientation orientation = orientationToMatch.getOpposite();
            setEdgeInSolution(piecesToSearch, edge, row, col, orientation);
        }
        return true;
    }

    public boolean solve() {
        LinkedList<Piece> cornerPieces = new LinkedList<>();
        LinkedList<Piece> borderPieces = new LinkedList<>();
        LinkedList<Piece> insidePieces = new LinkedList<>();
        groupPieces(cornerPieces, borderPieces, insidePieces);

        solution = new Piece[size][size];
        for (int row=0; row<size; row++) {
            for (int col=0; col<size; col++) {
                LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, col);
                if (!fitNextEdge(piecesToSearch, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Piece[][] getSolution() {
        return solution;
    }

    public void printSolution() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print(solution[i][j].toString() + " | ");
            }
            System.out.println();
        }
    }
}
