package Unit2.Labs.MilesPerHour;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        //System.out.print("Enter the distance :: ");
        int dist = keyboard.nextInt();

        //System.out.print("Enter the hours :: ");
        int hrs = keyboard.nextInt();

        //System.out.print("Enter the minutes :: ");
        int mins = keyboard.nextInt();

        MilesPerHour test = new MilesPerHour(dist, hrs, mins);
        test.calcMPH();

        // call toString to get mph
        System.out.println(dist + " miles in " + hrs + " hour and " + mins + " minutes = " + test.toString() + " MPH.");


    }
}
