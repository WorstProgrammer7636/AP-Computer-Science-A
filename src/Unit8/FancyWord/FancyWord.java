package Unit8.FancyWord;

import java.util.*;
public class FancyWord
{
    private String[][] mat;

    public FancyWord(String s)
    {
        //size the matrix

        mat = new String[s.length()][s.length()];
        int length = mat[0].length;

        //use Arrays.fill() to fill in the matrix with spaces
        for (int i = 0; i < mat[0].length; i++){
            Arrays.fill(mat[i], " ");
        }
        //use a for loop to load in the letters into the matrix

        //top line
        for (int i = 0; i < mat[0].length; i++){
            mat[0][i] = String.valueOf(s.charAt(i));
        }

        //top middle triangle
        for (int i = 1; i < (mat[0].length)/2; i++){
            String letter = mat[0][i];
            String secondLetter = mat[0][length - 1 - i];
            mat[i][i] = letter;
            mat[i][length - 1 - i] = secondLetter;
        }

        //middle
        if (length % 2 == 1){
            mat[length/2][length/2] = mat[0][length / 2];
        } else {
            mat[length/2][length/2 - 1] = mat[0][length/2 - 1];
            mat[length/2][length/2] = mat[0][length/2];
        }

        //bottom middle triangle
        int cnt = 1;
        if (length % 2 == 1){
            cnt = 0;
        }
        for (int i = length / 2 + 1; i < length - 1; i++){
            String firstLetter = mat[0][length/2 - cnt - 1];
            String secondLetter = mat[0][length - 1 - (length/2 - cnt - 1)];
            mat[i][length/2 - cnt - 1] = firstLetter;
            mat[i][length - (length/2 - cnt - 1) - 1] = secondLetter;
            cnt++;
        }

        //bottom
        for (int i = 0; i < length; i++){
            mat[length - 1][i] = mat[0][i];
        }

    }

    public String toString()
    {
        String output = "";
        for (int i = 0; i < mat[0].length; i++){
            for (int j = 0; j < mat[0].length; j++){
                output += mat[i][j];
            }
            output += "\n";
        }
        return output;
    }
}
