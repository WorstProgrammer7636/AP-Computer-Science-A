package PongLab;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collideable
{
    private int xSpeed;
    private int ySpeed;

    public Ball()
    {
        super(200,200, 10, 10);
        xSpeed = 3;
        ySpeed = 1;
    }

    //add the other Ball constructors
    public Ball(int xPos, int yPos){
        super(xPos, yPos, 10, 10, Color.BLACK);

        xSpeed = 3;
        ySpeed = 1;

    }



    public Ball(int xPos, int yPos, int width, int height){
        super(xPos, yPos, width, height, Color.BLACK);
        xSpeed = 3;
        ySpeed = 1;

    }

    public Ball(int xPos, int yPos, int width, int height, Color col){
        super(xPos, yPos, width, height, col);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int xPos, int yPos, int width, int height, Color col, int xSpeed, int ySpeed){
        super(xPos, yPos, width, height, col);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    //add the set methods
    public void setXSpeed(int x){
        xSpeed = x;
    }

    public void setYSpeed(int y){
        ySpeed = y;
    }


    public void moveAndDraw(Graphics window)
    {
        //draw a white ball at old ball location
        super.draw(window, Color.WHITE);
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);

        super.draw(window);
        //draw the ball at its new location
    }

    public void moveAndDraw(Graphics window, Color color)
    {
        //draw a white ball at old ball location
        super.draw(window, Color.WHITE);
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);

        super.draw(window, color);
        //draw the ball at its new location
    }

    public boolean equals(Object obj)
    {
        Ball b = (Ball)obj;
        return super.equals(b) && xSpeed == b.xSpeed && ySpeed == b.ySpeed;
    }

    //add the get methods
    public int getXSpeed(){
        return xSpeed;
    }

    public int getYSpeed(){
        return ySpeed;
    }

    public boolean didCollideBottom(int height){
        return !(getY() <= height - 50);
    }

    public boolean didCollideTop(int height){
        return !(getY()>=10);
    }

    public boolean didCollideLeft(int width){
        return !(getX()>=10 && getX() <= width - 20) && getX() < 10;
    }

    public boolean didCollideRight(int width){
        return !(getX()>=10 && getX() <= width - 20) && getX() > width - 20;
    }

    public boolean didCollideRightPaddle(Object obj){
        Paddle rightPaddle = (Paddle)obj;
        return (getX() >= rightPaddle.getX() - rightPaddle.getWidth() - Math.abs(getXSpeed()) && (getY() + getHeight() >= rightPaddle.getY() && getY() <= rightPaddle.getY() + rightPaddle.getHeight()));
    }

    public boolean didCollideLeftPaddle(Object obj){
        Paddle leftPaddle = (Paddle)obj;
        //see if the ball hits the left paddle
        return (getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(getXSpeed()) &&  getY() + getHeight() >= leftPaddle.getY() && (getY() + getHeight() <= leftPaddle.getY() + leftPaddle.getHeight()));
    }

    public void serveRandomBall(int width, int height){
        xSpeed = 1;
        ySpeed = 1;
        int centerWidth = (int)(width / 2);
        int centerHeight = (int)(height / 2);

        setX(centerWidth);
        setY(centerHeight);

        int randomXSpeed = getXSpeed();
        int randomYSpeed = getYSpeed();

        int randomFlip = (int)(Math.random() * 2);
        if (randomFlip == 0){
            randomXSpeed = -randomXSpeed;
        }

        int anotherRandomFlip = (int)(Math.random() * 2);
        if (anotherRandomFlip == 0){
            randomYSpeed = -randomYSpeed;
        }

        setXSpeed(randomXSpeed);
        setYSpeed(randomYSpeed);
    }

    //add a toString() method
    public String toString(){
        return super.getX() + " , " + super.getY() + " , " + super.getWidth() + " , " + super.getHeight() + " , " + super.getColor() + " , " + xSpeed + " , " + ySpeed;
    }


}
