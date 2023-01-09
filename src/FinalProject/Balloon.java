package FinalProject;

import PongLab.Block;

import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.net.*;
import java.io.*;
public class Balloon extends Block {
    private Color color;
    private int health;
    private Image image;
    private int speed;


    public Balloon(int xPos, int yPos, int health)
    {
        //initial x and y pos of the balloon.
        super(xPos,yPos,30,30);

        if (health == 1){
            color = Color.RED;
            this.health = health;
            speed = 1;
            try {
                URL url = getClass().getResource("JPGs/redballoon.jpg");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("exception with red balloon");
            }

        }

        else if (health == 2){
            color = Color.BLUE;
            this.health = health;
            speed = 1;
            try {
                URL url = getClass().getResource("JPGs/blueballoon.jpg");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("Blue balloon exception");
            }

        }

        else if (health == 3){
            color = Color.GREEN;
            this.health = health;
            speed = 1;

            try {
                URL url = getClass().getResource("JPGs/greenballoon.png");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("Green balloon exception");
            }
        }
        else if (health == 4){
            color = Color.YELLOW;
            this.health = health;
            speed = 2;
            try {
                URL url = getClass().getResource("JPGs/yellowballoon.png");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("Yellow balloon exception");
            }
        }
        else if (health == 5){
            double random = Math.random();
            this.health = health;
            speed = 2;
            try {
                if (random >= 0.50){
                    color = Color.BLACK;
                    URL url = getClass().getResource("JPGs/blackballoon.png");
                    image = ImageIO.read(url);
                }
                else{
                    color = Color.white;
                    URL url = getClass().getResource("JPGs/whiteballoon.png");
                    image = ImageIO.read(url);
                }
            } catch (Exception e){
                System.out.println("Black/White balloon exception");
            }
        }
    }


    public void damage(int dmg){
        health -= dmg;

        if(health == 1){
            color = color.RED;
            speed = 1;
            try {
                URL url = getClass().getResource("JPGs/redballoon.jpg");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("bruh");
            }

        }
        if(health == 2){
            color = color.BLUE;
            speed = 1;
            try{
                URL url = getClass().getResource("JPGs/blueballoon.jpg");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("bruh");
            }
        }
        if (health == 3){
            color = color.GREEN;
            speed = 1;
            try {
                URL url = getClass().getResource("JPGs/greenballoon.png");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("bruh");
            }
        }
        if (health == 4){
            color = color.YELLOW;
            speed = 2;
            try {
                URL url = getClass().getResource("JPGs/yellowballoon.png");
                image = ImageIO.read(url);
            } catch (Exception e){
                System.out.println("bruh");
            }
        }
    }


    public void move()
    {

    }
    public int getSpeed(){
        return speed;
    }


    public int getHealth(){
        return health;
    }

    public void draw( Graphics window )
    {
        window.drawImage(image, super.getX(), super.getY(), super.getWidth(), super.getHeight() ,null);
    }

    public String toString()
    {
        return "";
    }









}
