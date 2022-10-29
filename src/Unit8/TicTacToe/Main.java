package Unit8.TicTacToe;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main
{

    public static void main(String[] args) throws IOException
    {
        // tic tac toe test here, read in the data from the file and output getWinner
        String fileLocationCustomized = "/Users/5kyle/IdeaProjects/APCSA/src/Unit8/TicTacToe/tictactoe";
        Scanner s = new Scanner(new File(fileLocationCustomized));
        int count = s.nextInt();
        for (int i = 0; i < count; i++){
            String str = s.next();
            TicTacToe tc = new TicTacToe(str);
            System.out.println(tc);

            if (i != count - 1){
                System.out.println();
                System.out.println();
            }

        }
    }

}
