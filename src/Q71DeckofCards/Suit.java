package Q71DeckofCards;

/**
 * Created by ziwen on 08/11/2016.
 */
public enum Suit {
    Club (0), Diamond (1), Heart (2), Spade (3);
    private int value;

    private Suit(int v) { value = v; }

    public int getValue() { return value; }

    public static Suit getSuitFromValue(int value) {
        if (value == 0) { return Club; }
        else if (value == 1) { return Diamond; }
        else if (value == 2) { return Heart; }
        else if (value == 3) { return Spade; }
        return null;
    }
}
