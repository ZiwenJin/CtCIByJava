package Q71DeckofCards;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ziwen on 08/11/2016.
 */
public class BlackJackHand extends Hand<BlackJackCard> {
    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score: scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver: maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        if (cards.size() == 0) {
            return scores;
        }
        for (BlackJackCard card: cards) {
            addCardToScoreList(card, scores);
        }
        return scores;

        /*
        int numOfAce = 0;
        int minValue = 0;
        for (BlackJackCard card: cards) {
            if (card.isAce()) numOfAce++;
            minValue += card.value();
        }

        ArrayList<Integer> possScores = new ArrayList<>();
        for (int i=0; i<numOfAce; i++) {
            possScores.add(minValue);
            minValue += 10;
        }
        return possScores;
        */
    }

    private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            scores.add(0);
        }
        int length = scores.size();
        for (int i=0; i<length; i++) {
            int score = scores.get(i);
            scores.set(i, score + card.minValue());
            if (card.minValue() != card.maxValue()) {
                scores.add(score + card.maxValue());
            }
        }
    }

    public boolean busted() { return score() > 21; }

    public boolean is21() { return score() == 21; }

    public boolean isBlackJack() {
        return cards.size() == 2 && ((cards.get(0).isAce() && cards.get(1).value() == 10) || (cards.get(1).isAce() && cards.get(0).value() == 10));
    }
}
