package PongLab;

import javax.swing.JFrame;
import java.awt.Component;

public class Tester extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Tester()
    {
        super("PONG TESTER");
        setSize(WIDTH,HEIGHT);

        // Uncomment below to test

        // 1 - test block
        //getContentPane().add(new BlockTestTwo());

        // 2 - test ball
        //getContentPane().add(new BallTestTwo());

        // 3 - test paddle
        //PaddleTestTwo padTest = new PaddleTestTwo();
        //((Component)padTest).setFocusable(true);
        //getContentPane().add(padTest);

        //setVisible(true);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        Tester run = new Tester();
    }
}
