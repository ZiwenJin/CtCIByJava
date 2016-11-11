package Q76Jigsaw;

/**
 * Created by ziwen on 11/11/2016.
 */
public class Edge {
    private Shape shape;
    private String code;
    private Piece parentPiece;

    public Edge(Shape shape, String code) {
        this.shape = shape;
        this.code = code;
    }

    public boolean fitsWith(Edge edge) {
        return code.equals(edge.getCode());
    }

    public Edge _createMatchingEdge() {
        if (shape == Shape.FLAT) {
            return null;
        }
        return new Edge(shape.getOpposite(), code);
    }

    public String getCode() {
        return code;
    }

    public Piece getParentPiece() {
        return parentPiece;
    }

    public void setParentPiece(Piece parentPiece) {
        this.parentPiece = parentPiece;
    }

    public Shape getShape() {
        return shape;
    }

    public String toString() {
        return code;
    }
}
