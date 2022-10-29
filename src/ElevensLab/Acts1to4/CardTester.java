package ElevensLab.Acts1to4;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *    @param args is not used.
     */
    public static void main(String[] args) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
        Card c1 = new Card("jack", "clubs", 11);
        Card c2 = new Card("queen", "hearts", 12);
        Card c3 = new Card("king", "spades", 13);

        System.out.println(c1.rank());
        System.out.println(c1.suit());
        System.out.println(c1.pointValue());

        System.out.println();

        System.out.println(c2.rank());
        System.out.println(c2.suit());
        System.out.println(c2.pointValue());

        System.out.println();

        System.out.println(c3.rank());
        System.out.println(c3.suit());
        System.out.println(c3.pointValue());

    }
}

