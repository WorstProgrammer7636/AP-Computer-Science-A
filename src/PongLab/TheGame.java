package PongLab;

import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;

public class TheGame extends JFrame
{

    public TheGame(int mode, int width, int height)
    {
        super("PONG");
        setSize(width,height);

        Pong game = new Pong(mode, width, height);

        ((Component)game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Pong!\nChoose a ball, 0-regular, 1-blinky, 2-speedup: ");
        int mode = s.nextInt();

        System.out.println("Enter width: (0-default): ");
        int width = s.nextInt();
        if (width == 0){
            width = 700;
        }

        System.out.println("Enter height: (0-default): ");
        int height = s.nextInt();
        if (height == 0){
            height = 500;
        }

        TheGame run = new TheGame(mode, width, height);
    }
}
