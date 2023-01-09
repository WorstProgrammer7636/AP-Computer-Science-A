package FinalProject;

import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.lang.*;
import java.io.File;
import java.io.IOException;

public abstract class Monkey extends Block {
    private Image image;
    private String name;
    private int xPos;
    private int yPos;
    private int width;
    private int height;


    private int price;
    private int range;
    private Timer timer = new Timer();
    //milliseconds
    private int attackFrequency;
    //balloon units
    private int damage;
    private int dartSpeed;
    private int upgradeLevel;
    private DartHorde dartHorde;

    public Monkey(String name, int xPos, int yPos, int width, int height, int price, int range, int attackFrequency, int damage, int dartSpeed){
        super(xPos, yPos, width, height);
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.price = price;
        this.range = range;
        this.attackFrequency = attackFrequency;
        this.damage = damage;
        this.dartSpeed = dartSpeed;
        upgradeLevel = 1;
        dartHorde = new DartHorde();
        schedule();
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getRange(){
        return range;
    }

    public int getUpgradeLevel(){
        return upgradeLevel;
    }

    public int getAttackFrequency(){
        return attackFrequency;
    }

    public ArrayList<Dart> getDartList(){
        return dartHorde.getDartList();
    }

    public int getDamage(){
        return damage;
    }

    public void updateDartHorde(Dart d){
        dartHorde.add(d);
    }

    public void drawDartHorde(Graphics window){
        dartHorde.draw(window);
    }

    public void removeDartAt(int index){
        dartHorde.remove(index);
    }
    public void moveDarts(){
        dartHorde.move();
    }

    // public static void makeNoise(String filepath)
    // {
    //   InputStream music;
    //   try
    //     {
    //       music = new FileInputStream(new File(filepath));
    //       AudioStream audios = new AudioStream(music);
    //       AudioPlayer.player.start(audios);
    //     }
    //   catch(Exception e)
    //     {
    //       System.out.println("error max is bad");
    //     }
    // }


    public abstract void schedule();
    public abstract class TimerHandler{};
    public abstract void defaultAttack();
    public abstract void draw(Graphics window);
    public abstract void setTarget(int x, int y);
    public abstract int getTargetX();
    public abstract int getTargetY();
    public abstract void setAttackingStatus(boolean b);

    public void move(){

    }
}
