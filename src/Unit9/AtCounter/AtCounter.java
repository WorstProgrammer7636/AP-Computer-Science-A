package Unit9.AtCounter;

public class AtCounter
{
    private char[][] atMat;
    private boolean[][] checked;
    private int counter;

    /**
     * Create a matrix of size given and each element containing randomly
     * either an @ or - symbol
     */
    public AtCounter(int rows, int cols)
    {
        //size the matrix
        //use nested loops to randomly load the matrix
        //you will need to use Math.random()
        atMat = new char[rows][cols];
        checked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int random = (int)(Math.random() * 2);
                if (random == 0){
                    atMat[i][j] = '@';
                } else {
                    atMat[i][j] = '-';
                }
            }
        }
    }

    /**
     * Use a matrix which is given
     * @param - rectangular matrix consisting of @ and - characters
     */
    public AtCounter(char[][] atMat)
    {
        this.atMat = atMat;
        checked = new boolean[atMat.length][atMat[0].length];
    }

    public boolean inBounds(int r, int c){
        return r >= 0 && r < atMat.length && c >= 0 && c < atMat[0].length;
    }

    public int countAts(int r, int c)
    {
        // add in recursive code to count up the # of @s connected
        // start checking at spot [r,c]
        // hint - you can use the array itself to mark progress
        if (atMat[r][c] == '-' || !inBounds(r, c)){
            return 0;
        }

        if (checked[r][c] == false){
            checked[r][c] = true;
            if (atMat[r][c] == '@'){
                counter++;
                if (inBounds(r - 1, c)){
                    countAts(r-1, c);
                }

                if (inBounds(r + 1, c)){
                    countAts(r + 1, c);
                }

                if (inBounds(r, c + 1)){
                    countAts(r, c + 1);
                }

                if (inBounds(r, c - 1)){
                    countAts(r, c - 1);
                }
            }
        }

        return counter;
    }

    /**
     * This method will return all values in the matrix in String form seperated by spaces
     * e.g.
     * @ - @ -
     * @ - @ @
     * - - @ -
     * @ - - -
     */
    public String toString()
    {
        String str = "";
        for (int i = 0; i < atMat.length; i++){
            for (int j = 0; j < atMat[0].length; j++){
                str += atMat[i][j];
            }
            str += "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}
