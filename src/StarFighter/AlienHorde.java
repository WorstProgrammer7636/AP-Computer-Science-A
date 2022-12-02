package StarFighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
    private boolean right = true;
    private boolean left = false;
    private boolean down = true;
    private List<Alien> aliens;
    private int size;

    public AlienHorde(int size)
    {
        aliens = new ArrayList<Alien>();
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public List<Alien> getAliens(){
        return aliens;
    }

    public void add(Alien al)
    {
        aliens.add(al);
    }

    public void draw(Graphics window)
    {
        for (Alien alien : aliens){
            alien.draw(window);
        }
    }

    public void move(String direction)
    {
        for (Alien a : aliens) {
            if (a.getX() == 740) {
                a.setBool(true);
                a.move("DOWN");
            }
            if (a.getX() == 0) {
                a.setBool(false);
                a.move("DOWN");
            }
            if (a.getBool()) {
                a.move("LEFT");
            } else {
                a.move("RIGHT");
            }
        }
    }


    // calculate if Aliens are hit by shots, if so remove the shot and alien and return the number of hits
    public int calcHits(List<Ammo> shots)
    {
        for (int i = 0; i < aliens.size(); i++){
            for (int j = 0; j < shots.size(); j++){
                if (aliens.get(i).didCollide(shots.get(j))){
                    aliens.remove(i);
                    return j;
                }
            }
        }
        return -1;
    }

    public String toString()
    {
        return "";
    }
}

