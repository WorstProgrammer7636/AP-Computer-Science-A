package StarFighter;

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
    private int speed;
    private Image image;
    private boolean bool;

    public Alien()
    {
        this(0,0,30,30,0);
    }

    public Alien(int x, int y)
    {
        //add code here
        super(x, y);
    }

    public Alien(int x, int y, int s)
    {
        super(x, y);
        speed = s;
    }

    // all ctors call this ctor
    public Alien(int x, int y, int w, int h, int s)
    {
        super(x, y, w,h);
        speed=s;
        try
        {
            URL url = getClass().getResource("alien.jpg");
            image = ImageIO.read(url);
        }
        catch(Exception e)
        {
            //feel free to do something here
            System.out.println("Alien exception");
        }
    }

    public void setSpeed(int s)
    {
        //add code
        speed = s;
    }

    public int getSpeed()
    {
        return speed;
    }
    public void setBool(Boolean b) {
        bool = b;
    }

    public boolean getBool(){
        return bool;
    }

    public void move(String direction)
    {
        //add code here
        if (direction.equals("LEFT")){
            super.setX(super.getX() - speed);
        }

        if (direction.equals("RIGHT")){
            super.setX(super.getX() + speed);
        }

        if (direction.equals("UP")){
            super.setY(super.getY() - speed);
        }

        if (direction.equals("DOWN")){
            super.setY(super.getY() + 35);
        }
    }

    public void draw( Graphics window )
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString()
    {
        return "";
    }
}

