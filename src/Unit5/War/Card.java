package Unit5.War;

public class Card
{
    public static final String FACES = "ACE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING";

    //instance variables
    //String suit
    //int face
    private int face;
    private String suit;
    //constructor taking a face and suit
    public Card(int face, String suit){
        this.face = face;
        this.suit = suit;
    }
    //accessors-get methods
    // getFace getSuit
    public int getFace(){
        return face;
    }

    public String getSuit(){
        return suit;
    }

    //modifiers-set methods
    // setFace setSuit
    public void setFace(int face){
        this.face = face;
    }

    public void setSuit(String suit){
        this.suit = suit;
    }

    public String toString(){
        String result = output();
        return result;
    }

    public String output(){
        String[] newFaces = new String[FACES.length()];
        int count = 0;
        for (String val: FACES.split(" ")){
            newFaces[count] = val;
            count++;
        }

        String strFace = newFaces[getFace() - 1];
        return strFace + " of " + getSuit();

    }
}
