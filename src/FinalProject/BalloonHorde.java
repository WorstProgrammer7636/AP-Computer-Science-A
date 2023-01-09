package FinalProject;

import PongLab.Block;

import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;

public class BalloonHorde extends Block {
    private ArrayList<Balloon> balloonList;
    private ArrayList<Integer> spaceBetweenBalloons;

    public BalloonHorde(){
        balloonList = new ArrayList<Balloon>();
    }

    public ArrayList<Balloon> getBalloonList(){
        return balloonList;
    }

    public void add(Balloon b){
        balloonList.add(b);
    }

    public void remove(int b)
    {
        balloonList.remove(b);
    }


    public void clear(){
        balloonList.clear();
    }

    public void move(){
        for (int i = 0; i < balloonList.size(); i++){
            int xPos = balloonList.get(i).getX();
            int yPos = balloonList.get(i).getY();
            int speed = balloonList.get(i).getSpeed();

            if (xPos < 200){
                balloonList.get(i).setX(xPos + speed);
            } else if (xPos >= 199 && xPos <= 201 && yPos < 400){
                balloonList.get(i).setY(yPos + speed);
            } else if (yPos >= 400 && yPos <= 402 && xPos < 400){
                balloonList.get(i).setX(xPos + speed);
            } else if ( xPos >= 399 && xPos <= 401 && yPos > 30){
                balloonList.get(i).setY(yPos - speed);
            } else if (xPos >= 399 && xPos < 550 && yPos == 30){
                balloonList.get(i).setX(xPos + speed);
            } else if (xPos >= 549 && xPos <= 551 && yPos >= 30 && yPos <= 230){
                balloonList.get(i).setY(yPos + speed);
            } else {
                balloonList.get(i).setX(xPos + speed);
            }
        }
    }

    @Override
    public void draw(Graphics window){
        for (Balloon b : balloonList){
            b.draw(window);
        }
    }

}
