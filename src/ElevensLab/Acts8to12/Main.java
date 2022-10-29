package ElevensLab.Acts8to12;


import java.util.*;
public class Main {

    public static void console(Scanner s){
        System.out.println("Welcome to the game\n===============\n\nChoose a game to play:\n1) Thirteens, 2) Elevens, 0) quit");

        try {
            int temporaryInput = s.nextInt();
            if (temporaryInput == 1){
                playThirteensConsole();
            } else if (temporaryInput == 2){
                playElevensConsole();
            } else {
                System.out.println("Not a valid input");
            }
        } catch (Exception e){
            System.out.println("not a valid input");
        }
    }

    public static void playThirteensConsole(){
        System.out.println("Welcome to Thirteens Board. Press q to quit at any time. Use a number separated by spaces to select cards.");
        Board board = new ThirteensBoard();
        CardGameConsole cs = new CardGameConsole(board);
        cs.playGame();
    }

    public static void playElevensConsole(){
        System.out.println("Welcome to Elevens Board. Press q to quit at any time. Use a number separated by spaces to select cards.");
        Board board = new ElevensBoard();
        CardGameConsole cs = new CardGameConsole(board);
        cs.playGame();
    }

    public static void main(String[] args)
    {
        // start GUI version of the game
        //ElevensGUIRunner.main(args);

        //ThirteensGUIRunner.main(args);

        /* Act 10 - add console UI to ask user which game they would like to play */
        System.out.println("How do you want to play? Console or GUI? Enter 1 for console and 2 for GUI");
        Scanner s = new Scanner(System.in);
        try {
            int answer = s.nextInt();
            if (answer == 1){
                System.out.println("You chose console");
                console(s);
            } else if (answer == 2){
                System.out.println("You chose GUI. Do you want to play Elevens or Thirteens? Choose 1 for Elevens and 2 for Thirteens");
                if (s.nextInt() == 1){
                    ElevensGUIRunner.main(args);
                } else if (s.nextInt() == 2){
                    ThirteensGUIRunner.main(args);
                } else {
                    System.out.println("That isn't a valid answer");
                }

            } else {
                System.out.println("That isn't a valid answer");
            }
        } catch (Exception e){
            System.out.println("Not a valid answer");
        }
    }

}
