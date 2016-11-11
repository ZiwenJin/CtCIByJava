package Q71DeckofCards;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.SystemException;

import java.util.ArrayList;

/**
 * Created by ziwen on 08/11/2016.
 */
public class Test71 {
    public static void main(String[] args) {
        int numHands = 5;

        BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
        automator.initializeDeck();
        boolean success = automator.dealInitial();
        if (!success) {
            System.out.println("Error, out of cards.");
        } else {
            System.out.println("---Initial---");
            automator.printHandsAndScore();
            ArrayList<Integer> blackjacks = automator.getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.print("Blackjack at ");
                for (int i: blackjacks) {
                    System.out.print(i + ", ");
                }
                System.out.println("");
            } else {
                success = automator.playAllHands();
                if (!success) {
                    System.out.println("Error, out of cards.");
                } else {
                    System.out.println("\n---Completed Game---");
                    automator.printHandsAndScore();
                    ArrayList<Integer> winners = automator.getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners: ");
                        for (int i: winners) {
                            System.out.print(i + ", ");
                        }
                        System.out.println("");
                    } else {
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
}
