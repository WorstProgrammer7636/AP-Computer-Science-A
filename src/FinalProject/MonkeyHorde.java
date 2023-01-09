package FinalProject;

import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;

public class MonkeyHorde {
    private ArrayList<Monkey> monkeyList;
    public MonkeyHorde(){
        monkeyList = new ArrayList<Monkey>();
    }

    public ArrayList<Monkey> getMonkeyList(){
        return monkeyList;
    }

    public void add(Monkey monkey){
        monkeyList.add(monkey);
    }


    public void clear(){
        if (monkeyList.size()>0){
            for (int i = 0; i<monkeyList.size(); i++){
                monkeyList.get(i).setAttackingStatus(false);
            }
        }
        monkeyList.clear();
    }

    public void move(){

    }

    public void draw(Graphics window){
        for (Monkey monkey : monkeyList){
            monkey.draw(window);
        }
    }

}
