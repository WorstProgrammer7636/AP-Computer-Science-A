package Unit2.Labs;

import java.util.Scanner;

public class MathDistance {
    // given two integers x and y. returns the difference x-y
    public static int difference(int x, int y)
    {
        return x-y;
    }

    // given an integer x returns the square
    //  do not use multiplication - use Math.pow
    public static int square(int x)
    {

        return (int)Math.pow(x,2);
    }

    // given two points on a plane, returns the distance between them
    //  You MUST call the methods difference and square above
    //  You CANNOT use subtraction and multiplication in this mehthod
    public static double distance(int x1, int y1, int x2, int y2)
    {
        double xDifference=Math.pow(x1 - x2, 2);
        double yDifference = Math.pow(y1 - y2, 2);
        double ans = Math.pow(xDifference + yDifference, 0.5);
        return ans;
    }


    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter x1");
        int x1 = s.nextInt();
        System.out.println("Enter y1");
        int y1 = s.nextInt();
        System.out.println("Enter x2");
        int x2 = s.nextInt();
        System.out.println("Enter y2");
        int y2 = s.nextInt();
        double distance = distance(x1, y1, x2, y2);
        System.out.println("The distance between (" + x1 +","+y1+") and ("+x2+","+y2+") is " + distance);
        // create a simple UI to ask the user for the two points x1,y1 and x2,y2
        // call the distance method and diaply the result
    }
}
