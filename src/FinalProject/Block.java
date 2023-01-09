package FinalProject;

import java.util.*;
import java.awt.*;
public abstract class Block implements Collideable {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    public Block()
    {
        xPos = 10;
        yPos = 10;
        width = 10;
        height = 10;
    }

    public Block(int x, int y)
    {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public Block(int x, int y, int w, int h)
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
    public int getCenterX(){
        return xPos + width/2;
    }
    public int getCenterY(){
        return yPos + height/2;
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
    public int getBLY(){
        return yPos + height;
    }
    public int getTRX(){
        return xPos + width;
    }



    public abstract void move();
    public abstract void draw(Graphics window);

    public boolean inRange(Object o){
        Monkey obj = (Monkey)o;
        int x1 = xPos;
        int y1 = yPos;
        int x2 = obj.getX();
        int y2 = obj.getY();
        int distance = (int)Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));

        return distance < obj.getRange();
    }
    /*
    public boolean didCollide(Object o){
      Block obj = (Block)o;
      return xPos < obj.xPos + obj.width && xPos + width > obj.xPos && yPos < obj.yPos + obj.height && yPos + height > obj.yPos;
    }
    */
    public boolean didCollide(Object o)
    {
        Block other = (Block)o;
        if ((this.getY() < other.getBLY() && this.getBLY() > other.getY()) &&(this.getTRX() > other.getX() && this.getX() < other.getTRX())) {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}
