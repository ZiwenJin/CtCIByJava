package Q72CallCenter;

/**
 * Created by ziwen on 08/11/2016.
 */
public enum Rank {
    Respondent (0), Manager (1), Director (2);

    private int value;

    private Rank(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
