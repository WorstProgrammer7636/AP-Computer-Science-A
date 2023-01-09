package FinalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.net.URL;
public class Dart extends Block
{
    private int xSpeed;
    private int ySpeed;
    private int damage;
    private int width;
    private int height;
    private Image image;

    public Dart(int x, int y, int xSpeed, int ySpeed, int damage, int width, int height){
        super(x,y,width,height);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.damage = damage;
        this.width = width;
        this.height = height;
        try {
            URL url = getClass().getResource("JPGs/Dart.png");
            image = ImageIO.read(url);
        } catch (Exception e){
            System.out.println("Dart exception");
        }
    }

    public void draw(Graphics window)
    {

        window.drawImage(image, super.getX(), super.getY(), super.getWidth(), super.getHeight() ,null);

    }
    public void setNinja(){
        try {
            URL url = getClass().getResource("JPGs/ninjaDart.png");
            image = ImageIO.read(url);
        } catch (Exception e){
            System.out.println("Dart exception");
        }
    }

    public void move(){
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    public int getDamage(){
        return damage;
    }



}





