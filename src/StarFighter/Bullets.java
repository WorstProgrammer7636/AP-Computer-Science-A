package StarFighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
    private List<Ammo> ammo;

    public Bullets()
    {
        ammo = new ArrayList<Ammo>();
    }

    public void add(Ammo al)
    {
        ammo.add(al);
    }

    //post - draw each Ammo
    public void draw(Graphics window)
    {
        for (Ammo a : ammo){
            a.draw(window);
        }
    }

    public void remove(int index){
        ammo.remove(index);
    }

    public void clear(){
        ammo.clear();
    }

    public void move()
    {
    }

    // remove any Ammo which has reached the edge of the screen
    public void cleanUpEdges()
    {
        for (int i = 0; i < ammo.size(); i++){
            if (ammo.get(i).getY() < 0 || ammo.get(i).getY() > 560){
                ammo.remove(i);
                i--;
            }
        }
    }

    public List<Ammo> getList()
    {
        return ammo;
    }

    public String toString()
    {
        return "";
    }
}

