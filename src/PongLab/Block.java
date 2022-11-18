package PongLab;

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locateable
{
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;
    public Block(){
        color = Color.BLACK;
    }

    public Color getColor(){
        return color;
    }

    public Block(int xPos, int yPos, int width, int height)
    {
        color = Color.BLACK;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public Block(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setX(int x){
        xPos = x;
    }

    public void setY(int y){
        yPos = y;
    }

    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }

    public void setPos(int x, int y){
        xPos = x;
        yPos = y;
    }

    public void setColor(Color col){
        color = col;
    }


    //add other Block constructors - x , y , width, height, color
    public Block(int xPos, int yPos, int width, int height, Color color){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean equals(Object obj)
    {
        Block b = (Block)obj;
        return xPos == b.xPos && yPos == b.yPos && width == b.width && height == b.height && color.equals(b.color);
    }

    public String toString(){
        return xPos + " , " + yPos + " , " + width + " , " + height + " , " + color;
    }

}
