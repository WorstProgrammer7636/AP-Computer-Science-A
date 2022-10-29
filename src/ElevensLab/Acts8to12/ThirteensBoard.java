package ElevensLab.Acts8to12;

import java.util.*;
public class ThirteensBoard extends Board{
    private static final int BOARD_SIZE = 10;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    private static final boolean I_AM_DEBUGGING = true;

    public ThirteensBoard()
    {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {

        return containsKing(selectedCards) || containsPairSum13(selectedCards);
    }


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
                if (valOne + valTwo == 13){
                    return true;
                }
            }
        }

        ArrayList<String> ranks = new ArrayList<>();
        for (int i = 0; i < cardIndexes.size(); i++){
            String rank = super.cardAt(cardIndexes.get(i)).rank();
            ranks.add(rank);
        }
        if (ranks.contains("king")){
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
    private boolean containsPairSum13(List<Integer> selectedCards)
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        return selectedCards.size() == 2 && super.cardAt(selectedCards.get(0)).pointValue() + super.cardAt(selectedCards.get(1)).pointValue() == 13;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsKing(List<Integer> selectedCards)
    {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        return selectedCards.size() == 1 && super.cardAt(selectedCards.get(0)).pointValue() == 13;
    }
}

