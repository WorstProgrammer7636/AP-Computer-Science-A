package Unit2.Labs.AverageLength;

import java.util.Scanner;
class Main {

    public static void main(String[] args) {
        // write test code here to call average
        Scanner s = new Scanner(System.in);

        String str1 = s.nextLine();
        String[] words = str1.split("\\s+");
        if (words.length == 2){
            StrMath strmath = new StrMath(words[0], words[1]);
            System.out.println(strmath.average(words[0], words[1]));
        } else {
            StrMath strmath = new StrMath(words[0], words[1], words[2]);
            System.out.println(strmath.average(words[0], words[1], words[2]));
        }


    }

}
