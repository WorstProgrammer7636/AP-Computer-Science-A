package PongLab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
    private int mode;
    private int width;
    private int height;

    private Wall leftWall;
    private Wall rightWall;
    private Wall topWall;
    private Wall bottomWall;

    private Score score;
    private BufferedImage back;
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;               //keeps track of what keys are pressed

    public Pong(int mode, int width, int height)
    {

        //set up walls
        this.mode = mode;
        this.width = width;
        this.height = height;
        leftWall = new Wall(10, 10, 10, height);
        rightWall = new Wall(width - 20, 0, 10, height);
        topWall = new Wall(10, 10, width, 5);
        bottomWall = new Wall(10, height - 50, width, 5);


        //set up ball and paddle
        if (mode == 0){
            ball = new Ball();
        } else if (mode == 1){
            ball = new BlinkyBall();
        } else if (mode == 2){
            ball = new SpeedUpBall();
        } else {
            System.out.println("Invalid input");
            System.exit(1);
        }
        ball.setXSpeed(1);
        ball.setYSpeed(1);
        leftPaddle = new Paddle();
        rightPaddle = new Paddle(width - 20, 10);
        rightPaddle.setColor(Color.RED);
        leftPaddle.setHeight(65);
        rightPaddle.setHeight(65);

        keys = new boolean[5];
        score = new Score();


        //set up the Canvas
        setBackground(Color.WHITE);
        setVisible(true);

        this.addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window)
    {

        paint(window);
    }

    public void paint(Graphics window)
    {
        Graphics2D twoDGraph = (Graphics2D)window;
        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back==null)
            back = (BufferedImage)(createImage(getWidth(),getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        leftWall.draw(graphToBack);
        rightWall.draw(graphToBack);
        topWall.draw(graphToBack);
        bottomWall.draw(graphToBack);

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(30, 30 - 10, 150, 15);
        graphToBack.setColor(Color.BLACK);
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(width - 150, 30 - 10, 130, 15);
        graphToBack.setColor(Color.BLACK);
        graphToBack.drawString(String.valueOf("Left player score: " + score.getLeftScore()), 30, 30);
        graphToBack.drawString(String.valueOf("Right player score: " + score.getRightScore()), width - 150, 30);

        //see if ball hits left wall or right wall
        if (ball.didCollideLeft(width)){
            score.addRightScore();
            ball.serveRandomBall(width, height);
        }

        if (ball.didCollideRight(width)){
            score.addLeftScore();
            ball.serveRandomBall(width, height);
        }

        //see if the ball hits the top or bottom wall
        if (ball.didCollideTop(height) || ball.didCollideBottom(height)){
            ball.setYSpeed(-ball.getYSpeed());
        }

        //see if the ball hits the left paddle
        if (ball.didCollideLeftPaddle(leftPaddle)){
            ball.setXSpeed(-ball.getXSpeed());
        }
        //see if the ball hits the right paddle
        if (ball.didCollideRightPaddle(rightPaddle)){
            ball.setXSpeed(-ball.getXSpeed());
        }

        //see if the paddles need to be moved

        if (keys[0])
        {
            //move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(graphToBack, height);
        }
        if (keys[1])
        {
            //move left paddle down and draw it on the window
            leftPaddle.moveDownAndDraw(graphToBack, height);

        }
        if (keys[2])
        {
            rightPaddle.moveUpAndDraw(graphToBack, height);
        }
        if (keys[3])
        {
            rightPaddle.moveDownAndDraw(graphToBack, height);
        }

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e)
    {
        switch (toUpperCase(e.getKeyChar()))
        {
            case 'W' : keys[0]=true; break;
            case 'S' : keys[1]=true; break;
            case 'I' : keys[2]=true; break;
            case 'M' : keys[3]=true; break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch(toUpperCase(e.getKeyChar()))
        {
            case 'W' : keys[0]=false; break;
            case 'S' : keys[1]=false; break;
            case 'I' : keys[2]=false; break;
            case 'M' : keys[3]=false; break;
        }
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(8);
                repaint();
            }
        }catch(Exception e)
        {
        }
    }
}
