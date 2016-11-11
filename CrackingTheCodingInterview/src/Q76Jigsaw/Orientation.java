package Q76Jigsaw;

/**
 * Created by ziwen on 10/11/2016.
 */
public enum Orientation {
    LEFT, TOP, RIGHT, BOTTOM;

    public Orientation getOpposite() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case TOP: return BOTTOM;
            case BOTTOM: return TOP;
            default: return null;
        }
    }
}
