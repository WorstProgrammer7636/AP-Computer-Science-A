package Unit8.FancyWord;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main( String args[] ) throws IOException
    {

        Scanner file = new Scanner(new File ("fancyword"));
        int size = file.nextInt();
        file.nextLine();
        for(int i = 0; i<size; i++)
        {
            String word = file.next();
            FancyWord fw = new FancyWord(word);
            System.out.println(fw);
        }

    }

}
