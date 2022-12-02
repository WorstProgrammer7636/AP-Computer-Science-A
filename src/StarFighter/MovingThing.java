package StarFighter;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable, Collideable
{
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public MovingThing()
    {
        xPos = 10;
        yPos = 10;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y)
    {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y, int w, int h)
    {
        //add code here
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public void setPos( int x, int y)
    {
        //add code here
        xPos = x;
        yPos = y;
    }

    public void setX(int x)
    {
        //add code here
        xPos = x;
    }

    public void setY(int y)
    {
        //add code here
        yPos = y;
    }

    public int getX()
    {
        return xPos;
    }

    public int getY()
    {
        return yPos;
    }

    public void setWidth(int w)
    {
        width = w;
    }

    public void setHeight(int h)
    {
        height = h;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public abstract void move(String direction);
    public abstract void draw(Graphics window);

    public boolean didCollide(Object o){
        MovingThing obj = (MovingThing)o;
        return xPos < obj.xPos + obj.width && xPos + width > obj.xPos && yPos < obj.yPos + obj.height && yPos + height > obj.yPos;
    }

    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}

