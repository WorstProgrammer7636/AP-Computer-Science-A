package Unit5.War;

public class War {
    //static variables
    //int player1Score
    //int player2Score
    private static int player1Score;
    private static int player2Score;
    //instance variables
    //String player1
    //String player2
    private String player1;
    private String player2;

    //constructor - assign the player names
    //  parameters: String name1, String name2
    public War(String name1, String name2){
        player1 = name1;
        player2 = name2;
    }
    //modifiers-set methods
    public void setPlayer1(String name){
        player1 = name;
    }

    public void setPlayer2(String name){
        player2 = name;
    }

    //accessors-get methods

    //getScore
    //  static method to get the score as a String
    //  use this in toString
    public static String getScore(){
        String result = "War Score - ";
        if (player1Score > player2Score){
            result += "Player 1 Wins - ";
        } else if (player2Score > player1Score){
            result += "Player 2 Wins - ";
        } else {
            result += "Tie - ";
        }

        result += "(player1:" + player1Score + ", player2:" + player2Score + ")";
        return result;
    }

    //reset
    //  static method to reset the score
    public static void resetScore(){
        player1Score = 0;
        player2Score = 0;
    }

    //play method - plays a round of War with cards given as args
    //  parameters: Card card1, Card card2
    //  winner of war based on the following scale highest to lowest value:
    //    - Ace is the highest and beats all other cards followed in order by King, Queen, Jack
    //    - then numeric order 10-2
    //    - If the cards have the same value indiate that it is a tie
    //  prints out the two cards and the result to the console
    //    use Card::toString to print out cards
    public void play(Card card1, Card card2){
        int face1 = card1.getFace();
        int face2 = card2.getFace();
        int[] hierarchy = {2,3,4,5,6,7,8,9,10,11,12,13,1};

        int face1Index = 0;
        int face2Index = 0;

        for (int i = 0; i < hierarchy.length; i++){
            if (hierarchy[i] == face1){
                face1Index = i;
            }

            if (hierarchy[i] == face2){
                face2Index = i;
            }
        }

        if (face1Index > face2Index){
            //player 1 wins
            System.out.println(player1 + " has a " + card1.output()+ " & " + player2 + " has a " + card2.output() + " - " + player1 + " Wins the War!");
            player1Score++;
        } else if (face2Index > face1Index){
            //player 2 wins
            System.out.println(player1 + " has a " + card1.output()+ " & " + player2 + " has a " + card2.output() + " - " + player2 + " Wins the War!");
            player2Score++;
        } else {
            //tie
            System.out.println(player1 + " has a " + card1.output()+ " & " + player2 + " has a " + card2.output() + " - The war ends in a tie!");
        }
    }

    // toString
    //  print out a running total of the score for all games of War using the static method getScore
    public String toString(){
        String result = getScore();
        return result;
    }
}
