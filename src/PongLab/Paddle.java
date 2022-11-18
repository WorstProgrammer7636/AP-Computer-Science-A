package PongLab;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
    //instance variables
    private int speed;

    public Paddle()
    {
        super(10 , 10, 10, 10, Color.BLACK);
        speed = 5;
    }

    public Paddle(int x, int y){
        super(x, y, 10, 10, Color.BLACK);
        speed = 5;
    }

    public Paddle(int x, int y, int speed){
        super(x, y, 10, 10, Color.BLACK);
        this.speed = speed;
    }

    public Paddle(int x, int y, int width, int height, int speed){
        super(x, y, width, height, Color.BLACK);
        this.speed = speed;
    }

    public Paddle(int x, int y, int width, int height, Color color, int speed){
        super(x, y, width, height, color);
        this.speed = speed;
    }


    public void moveUpAndDraw(Graphics window, int height)
    {
        super.draw(window, Color.WHITE);
        if (getY() >= 10){
            setY(getY()-speed);
        } else {
            setY(10);
        }

        super.draw(window);

    }

    public void moveDownAndDraw(Graphics window, int height)
    {
        super.draw(window, Color.WHITE);

        if (getY() <= height - 115){
            setY(getY()+speed);
        } else {
            setY(height - 115);
        }

        super.draw(window);

    }

    //add get methods
    public int getSpeed(){
        return speed;
    }


    //add a toString() method
    public String toString(){
        return super.toString() + " " + speed;
    }
}
