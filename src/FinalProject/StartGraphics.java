package FinalProject;

import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;

public class StartGraphics extends JFrame
{

    public StartGraphics(int width, int height)
    {
        super("BTD");
        setSize(width,height);

        Game game = new Game(width, height);

        ((Component)game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        int width = 800;
        int height = 600;

        StartGraphics run = new StartGraphics(width, height);
    }
}
