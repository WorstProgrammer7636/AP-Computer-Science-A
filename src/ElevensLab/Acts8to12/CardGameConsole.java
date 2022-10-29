package ElevensLab.Acts8to12;


/**
 * This class provides a console based UI for solitaire games related to Elevens.
 */
import java.util.*;
public class CardGameConsole
{
    private Board board;

    public CardGameConsole(Board gameBoard)
    {
        /* TO BE IMPLEMENTED IN ACT 12 */
        board = gameBoard;
    }

    /**
     * Given a board (in the ctor), play a game via the console
     */
    public void playGame()
    {
        /* TO BE IMPLEMENTED IN ACT 12 */
        Scanner s = new Scanner(System.in);
        Scanner inputReader;
        while (!board.isEmpty()){
            displayBoard();
            if (!board.anotherPlayIsPossible()){
                System.out.println("You lose. No more legal plays left");
                System.exit(1);
            }

            System.out.println("\n\nSelect your cards:");
            try {
                List<Integer> selectedCards = new ArrayList<Integer>();
                String input = s.nextLine();
                if (input.equals("q")){
                    System.out.println("You quit");
                    System.exit(1);
                }
                String numberOnly= input.replaceAll("[^0-9]", "");
                for (int i = 0; i < numberOnly.length(); i++){
                    String tempNum = String.valueOf(numberOnly.charAt(i));
                    selectedCards.add(Integer.parseInt(tempNum));
                }

                if (validSelection(selectedCards)){
                    System.out.println("Good selection, replacing cards...");
                    board.replaceSelectedCards(selectedCards);
                } else {
                    System.out.println("Bad selection - try again");
                }

            } catch (Exception e){
                System.out.println("Bad selection - try again");
            }
        }

        System.out.println("You cleared all the cards. You win!");


    }

    /**
     * Called by playGame to display the current board state including:
     *  - the cards on the board and their indexes
     *  - the number of cards remaining in the deck
     */
    private void displayBoard()
    {
        /* TO BE IMPLEMENTED IN ACT 12 */
        int undealtCards = board.deckSize();
        System.out.println("\n\n------------- Cards ----------- (" + undealtCards + ")\n");
        System.out.println(board);
    }

    /**
     * Called by playGame to checks if selectedCards indexes are within
     * bounds and do not reference a null card
     */

    private boolean validSelection(List<Integer> selectedCards)
    {
        /* TO BE IMPLEMENTED IN ACT 12 */
        return board.isLegal(selectedCards);

    }

}
