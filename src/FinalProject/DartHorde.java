package FinalProject;

import java.util.ArrayList;
import java.awt.*;
import java.util.*;
public class DartHorde{
    private ArrayList<Dart> dartList;
    public DartHorde(){
        dartList = new ArrayList<Dart>();
    }

    public ArrayList<Dart> getDartList (){
        return dartList;
    }

    public void add(Dart d){
        dartList.add(d);
    }

    public void remove(int index){
        dartList.remove(index);
    }

    public void clear(){
        dartList.clear();
    }

    public void move(){
        if(dartList.size()>0){
            for (Dart d : dartList){
                d.move();
            }
        }
    }

    public void draw(Graphics window){
        if(dartList.size()>0){
            for (Dart d : dartList){
                d.draw(window);
            }
        }
    }

}
