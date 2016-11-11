package Q76Jigsaw;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziwen on 10/11/2016.
 */
public class Piece {
    private final static int NUMBER_OF_EDGES = 4;
    private HashMap<Orientation, Edge> edges = new HashMap<>();

    public Piece(Edge[] edgeList) {
        Orientation[] orientationList = Orientation.values();
        for (int i=0; i<edgeList.length; i++) {
            Edge edge = edgeList[i];
            edge.setParentPiece(this);
            edges.put(orientationList[i], edge);
        }
    }

    public void setEdgeAsOrientation(Edge edge, Orientation orientation) {
        Orientation currentOrientation = getOrientation(edge);
        rotateEdgesBy(orientation.ordinal() - currentOrientation.ordinal());
    }

    private Orientation getOrientation(Edge edge) {
        for (Map.Entry<Orientation, Edge> entry: edges.entrySet()) {
            if (entry.getValue() == edge) {
                return entry.getKey();
            }
        }
        return null;
    }

    // clockwise
    public void rotateEdgesBy(int numberRotations) {
        Orientation[] orientations = Orientation.values();
        HashMap<Orientation, Edge> rotated = new HashMap<>();

        numberRotations = numberRotations % NUMBER_OF_EDGES;
        if (numberRotations < 0) {
            numberRotations += NUMBER_OF_EDGES;
        }

        for (int i=0; i<orientations.length; i++) {
            Orientation oldOrientation = orientations[(i - numberRotations + NUMBER_OF_EDGES) % NUMBER_OF_EDGES];
            rotated.put(orientations[i], edges.get(oldOrientation));
        }
        edges = rotated;
    }

    public boolean isCorner() {
        Orientation[] orientations = Orientation.values();
        for (int i=0; i<orientations.length; i++) {
            Shape current = edges.get(orientations[i]).getShape();
            Shape next = edges.get(orientations[(i+1)%NUMBER_OF_EDGES]).getShape();
            if (current == Shape.FLAT && next == Shape.FLAT) {
                return true;
            }
        }
        return false;
    }

    public boolean isBorder() {
        Orientation[] orientations = Orientation.values();
        for (int i=0; i<orientations.length; i++) {
            if (edges.get(orientations[i]).getShape() == Shape.FLAT) {
                return true;
            }
        }
        return false;
    }

    public Edge getEdgeWithOrientation(Orientation orientation) {
        return edges.get(orientation);
    }

    public Edge getMatchingEdge(Edge targetEdge) {
        for (Edge e: edges.values()) {
            if (e.fitsWith(targetEdge)) {
                return e;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Orientation o: Orientation.values()) {
            sb.append(edges.get(o).toString() + ", ");
        }
        return "[" + sb.toString() + "]";
    }
}
