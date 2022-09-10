package Unit5.War;

class Main {

    public static void main(String[] args)
    {
        War war = new War("Mike", "Dan");
        Card c1 = new Card(13, "HEARTS");
        Card c2 = new Card(3, "CLUBS");
        war.play(c1, c2);
        c1.setFace(2);
        c1.setSuit("SPADES");
        c2.setFace(11);
        c2.setSuit("DIAMONDS");
        war.play(c1, c2);
        c1.setFace(1);
        c1.setSuit("SPADES");
        c2.setFace(1);
        c2.setSuit("DIAMONDS");
        war.play(c1, c2);

        War war2= new War("Tom", "Jenny");
        c1.setFace(2);
        c1.setSuit("CLUBS");
        c2.setFace(3);
        c2.setSuit("HEARTS");
        war2.play(c1, c2);
        System.out.println(war2);

    }

}
