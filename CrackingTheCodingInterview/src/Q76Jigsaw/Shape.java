package Q76Jigsaw;

/**
 * Created by ziwen on 10/11/2016.
 */
public enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        switch (this) {
            case INNER: return OUTER;
            case OUTER: return INNER;
            default: return null;
        }
    }
}
