package Model;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x;
    private int y ;
    private int width;
    private int height;
    private Image image;

    public Enemy(int x , int y, int width, int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        ImageIcon image = new ImageIcon(" ");
        this.image = image.getImage();
        this.image = this.image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
    }
    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
}
