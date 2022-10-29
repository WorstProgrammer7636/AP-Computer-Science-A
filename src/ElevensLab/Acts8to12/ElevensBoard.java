package ElevensLab.Acts8to12;

import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = true;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard()
    {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        return containsJQK(selectedCards) || containsPairSum11(selectedCards);
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible()
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        List<Integer> cardIndexes = super.cardIndexes();
        for (int i = 0; i < cardIndexes.size() - 1; i++){
            for (int j = i+1; j < cardIndexes.size(); j++){
                int indexOne = cardIndexes.get(i);
                int indexTwo = cardIndexes.get(j);

                int valOne = super.cardAt(indexOne).pointValue();
                int valTwo = super.cardAt(indexTwo).pointValue();
                if (valOne + valTwo == 11){
                    return true;
                }
            }
        }

        ArrayList<String> ranks = new ArrayList<>();
        for (int i = 0; i < cardIndexes.size(); i++){
            String rank = super.cardAt(cardIndexes.get(i)).rank();
            ranks.add(rank);
        }
        if (ranks.contains("jack") && ranks.contains("queen") && ranks.contains("king")){
            return true;
        }

        return false;
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards)
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        return selectedCards.size() == 2 && super.cardAt(selectedCards.get(0)).pointValue() + super.cardAt(selectedCards.get(1)).pointValue() == 11;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards)
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        if (selectedCards.size() == 3){
            int[] arr = new int[3];
            String c1 = super.cardAt(selectedCards.get(0)).rank();
            String c2 = super.cardAt(selectedCards.get(1)).rank();
            String c3 = super.cardAt(selectedCards.get(2)).rank();

            arr[0] = super.cardAt(selectedCards.get(0)).pointValue();
            arr[1] = super.cardAt(selectedCards.get(1)).pointValue();
            arr[2] = super.cardAt(selectedCards.get(2)).pointValue();

            Arrays.sort(arr);
            return arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && !c1.equals(c2) && !c2.equals(c3) && !c1.equals(c3);
        }
        return false;
    }
}

