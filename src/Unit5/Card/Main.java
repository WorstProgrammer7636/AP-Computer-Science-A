package Unit5.Card;

public class Main {

    public static void main(String[] args)
    {
        // Instantiate the cards needed for the test and print each object
        Card c1 = new Card(9, "SPADES");
        c1.output();
        System.out.println(c1);

        c1.setFace(1);
        c1.setSuit("DIAMONDS");
        c1.output();
        System.out.println(c1);

        c1.setFace(4);
        c1.setSuit("CLUBS");
        c1.output();
        System.out.println(c1);

        c1.setFace(11);
        c1.setSuit("SPADES");
        c1.output();
        System.out.println(c1);

        c1.setFace(12);
        c1.setSuit("HEARTS");
        c1.output();
        System.out.println(c1);

        c1.setFace(13);
        c1.setSuit("CLUBS");
        c1.output();
        System.out.println(c1);
    }

}
