package StarFighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
    private int speed;
    private Color color;

    public Ammo()
    {
        this(0,0,0);
    }

    public Ammo(int x, int y)
    {
        //add code
        this(x, y, 0);
    }

    public Ammo(int x, int y, int s)
    {
        //add cod
        setPos(x, y);
        speed = s;
    }

    public Ammo(int x, int y, int s, Color color)
    {
        //add cod
        setPos(x, y);
        speed = s;
        this.color = color;
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

    @Override
    public void draw(Graphics window)
    {
        //add code to draw the ammo
        window.setColor(Color.YELLOW);
        window.fillRect(super.getX(), super.getY(), 5, 5);
    }

    public void draw(Graphics window, Color color)
    {
        //add code to draw the ammo
        window.setColor(color);
        window.fillRect(super.getX(), super.getY(), 5, 5);
    }


    @Override
    public void move(String direction)
    {
        //add code to draw the ammo
        if (direction.equals("RIGHT")) {
            setX(getX() + speed);
        }
        if (direction.equals("LEFT")) {
            setX(getX() - speed);
        }
        if (direction.equals("UP")) {
            setY(getY() - speed);
        }
        if (direction.equals("DOWN")) {
            setY(getY() + speed);
        }

    }


    public String toString()
    {
        return "Ammo speed: " + getSpeed();
    }
}

