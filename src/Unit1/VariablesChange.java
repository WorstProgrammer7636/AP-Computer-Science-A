package Unit1;

import java.util.Scanner;

public class VariablesChange {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);


        int cents = scan.nextInt();

        System.out.println("Total cents is: " + cents);

        // add code to calculate the change for the
        // cents variable
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        while (cents > 0){
            if (cents >= 25){
                quarters += (cents / 25);
                cents = cents % 25;
            } else if (cents >= 10){
                dimes += cents / 10;
                cents = cents % 10;
            } else if (cents >= 5){
                nickels += cents / 5;
                cents = cents % 5;
            } else {
                pennies += cents;
                cents = 0;
            }
        }

        System.out.print("Change: " + quarters + " quarters");
        System.out.print(", " + dimes + " dimes");
        System.out.print(", " + nickels + " nickels");
        System.out.print(", " + pennies + " pennies.");

        // print out the change
    }
}
