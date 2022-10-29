package Unit8.Forest;

import java.util.*;
import java.lang.*;
import java.text.*;
import java.io.*;
public class Thing{
    private String type;
    private String name;
    private double size;

    public Thing(String type, String name, double size){
        this.type = type;
        this.name = name;
        this.size = size;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSize(double size){
        this.size = size;
    }

    public String getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public double getSize(){
        return size;
    }

    public boolean isSame(Thing thing){
        return type.equals(thing.getType()) && name.equals(thing.getName()) && size == thing.getSize();
    }

    public String toString(){

        return type + " " + name + " " + String.format("%.2f", size);
    }
}


//make a Thing class that stores the following 3 instance variables
// make a String to store type
// make a String to store name
// make a double to store size

//add a constrcutor which initializes a Thing with type, name and size

//add set methods

//add get methods

//add an isSame method which compares this to another Thing

//add a toString returning "type name size" - size should be to two decimal places





