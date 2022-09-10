package Unit5.Card;

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


    //toString - use the int face value, a scanner of the FACES string,
    public String toString(){
        String result = output();
        return result;
    }
    //  and a loop & counter to find the correct string to represent the value
    //
    //Algorithm Help
    //while scan.hasNext()
    //  scan.next()   // gets each item in the string
    //if the counter equals the face value set the string output to the appropriate string e.g.
    //  face value 1 -> ACE
    //The toString method should return "FACE of Suit" with correct values substituted for FACE and Suit

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
