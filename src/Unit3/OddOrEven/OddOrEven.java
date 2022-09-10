package Unit3.OddOrEven;

import java.util.Scanner;
import java.lang.*;
public class OddOrEven

{
    public static boolean isOdd(int num)
    {
        int testVar = Math.abs(num);
        if (testVar % 2 == 1){
            System.out.println(num + " is odd :: true");
            System.out.println(num + " is even :: false");
            return true;
        }

        System.out.println(num + " is odd :: false");
        System.out.println(num + " is even :: true");
        return false;
    }

    public static void main(String[] args)
    {
        // call your check function for test cases
        int t1=111, t2=2000, t3=-99, t4=1111, t5=-850;
        boolean b1=isOdd(t1), b2=isOdd(t2), b3=isOdd(t3), b4=isOdd(t4), b5=isOdd(t5);


    }
}
