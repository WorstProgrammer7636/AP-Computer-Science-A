package ElevensLab.Acts1to4;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTesterAct2 {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *      @param args is not used.
     */
    public static void main(String[] args) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        String[] ranks = {"a", "b", "c"};
        String[] suits = {"club", "club", "heart"};
        int[] pointValues = {10, 12, 3};
        Deck d1 = new Deck(ranks, suits, pointValues);
        System.out.println("size: " + d1.size());
        System.out.println("deal card: " + d1.deal());
        System.out.println("size: " + d1.size());
        System.out.println("isEmpty? " + d1.isEmpty());
        System.out.println();

        String[] ranks2 = {"bobby"};
        String[] suits2 = {"club"};
        int[] pointValues2 = {51};
        Deck d2 = new Deck(ranks2, suits2, pointValues2);
        System.out.println("size: " + d2.size());
        System.out.println("deal card: " + d2.deal());
        System.out.println("size: " + d2.size());
        System.out.println("isEmpty? " + d2.isEmpty());
        System.out.println();

        String[] ranks3 = {"red", "blue"};
        String[] suits3 = {"club", "hearts"};
        int[] pointValues3 = {13, 51};
        Deck d3 = new Deck(ranks3, suits3, pointValues3);

        System.out.println("size: " + d3.size());
        System.out.println("deal card: " + d3.deal());
        System.out.println("size: " + d3.size());
        System.out.println("isEmpty? " + d3.isEmpty());
    }
}

