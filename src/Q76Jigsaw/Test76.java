package Q76Jigsaw;

import java.util.LinkedList;

/**
 * Created by ziwen on 11/11/2016.
 */
public class Test76 {
    public static void main(String[] args) {
        Edge edge11 = new Edge(Shape.FLAT, "1");
        Edge edge12 = new Edge(Shape.OUTER, "4");
        Edge edge13 = new Edge(Shape.INNER, "6");
        Edge edge14 = new Edge(Shape.FLAT, "3");
        Edge[] edges1 = {edge11, edge12, edge13, edge14};
        Piece piece1 = new Piece(edges1);

        Edge edge21 = new Edge(Shape.FLAT, "2");
        Edge edge22 = new Edge(Shape.FLAT, "5");
        Edge edge23 = new Edge(Shape.INNER, "7");
        Edge edge24 = new Edge(Shape.INNER, "4");
        Edge[] edges2 = {edge21, edge22, edge23, edge24};
        Piece piece2 = new Piece(edges2);

        Edge edge31 = new Edge(Shape.FLAT, "11");
        Edge edge32 = new Edge(Shape.FLAT, "8");
        Edge edge33 = new Edge(Shape.OUTER, "6");
        Edge edge34 = new Edge(Shape.INNER, "9");
        Edge[] edges3 = {edge31, edge32, edge33, edge34};
        Piece piece3 = new Piece(edges3);

        Edge edge41 = new Edge(Shape.OUTER, "9");
        Edge edge42 = new Edge(Shape.OUTER, "7");
        Edge edge43 = new Edge(Shape.FLAT, "10");
        Edge edge44 = new Edge(Shape.FLAT, "12");
        Edge[] edges4 = {edge41, edge42, edge43, edge44};
        Piece piece4 = new Piece(edges4);

        LinkedList<Piece> pieces = new LinkedList<>();
        pieces.add(piece1);
        pieces.add(piece2);
        pieces.add(piece3);
        pieces.add(piece4);

        Puzzle puzzle = new Puzzle(2, pieces);
        System.out.println(puzzle.solve());
        puzzle.printSolution();
    }
}
