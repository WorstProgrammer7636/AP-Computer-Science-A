package Unit8.TicTacToe;

public class TicTacToe
{
    private char[][] mat;

    /**
     * An empty game
     */
    public TicTacToe()
    {
        mat = new char[3][3];

    }

    /**
     * Create a game based on the string
     * @param game 9 character string representing a game e.g. XOXOOOXXO
     */
    public TicTacToe(String game)
    {
        mat = new char[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                mat[i][j] = game.charAt(count);
                count++;
            }
        }
    }

    /**
     * Given the current game, calculates the winner
     * @return X|Y wins diagonally|vertically|horizontally!
     *         cat's game - no winner!
     */
    public String getWinner()
    {
        //check horizontal
        for (int i = 0; i < 3; i++){
            if (mat[i][0] == (mat[i][1]) && mat[i][1] == (mat[i][2])){
                return mat[i][0] + " wins horizontally!";
            }
        }

        //check vertical
        for (int i = 0; i < 3; i++){
            if (mat[0][i] == (mat[1][i]) && mat[1][i] == (mat[2][i])){
                return mat[0][i] + " wins vertically!";
            }
        }

        //check descending diagonal
        if (mat[0][0] == (mat[1][1]) && mat[1][1] == (mat[2][2])){
            return mat[0][0]+ " wins diagonally!";
        }

        //check ascending diagonal
        if (mat[2][0] == (mat[1][1]) && mat[1][1] == (mat[0][2])){
            return mat[2][0] + " wins diagonally!";
        }

        return "cat's game - no winner!";
    }

    /**
     * Returns string rep of the game
     */
    public String toString()
    {
        String output="";
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                output += mat[i][j];
                output += " ";
            }
            output += "\n";
        }

        output += "\n";


        output += getWinner();



        return output;
    }
}
