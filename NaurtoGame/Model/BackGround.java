package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGround extends JFrame {
    private BufferedImage image;

    public BackGround(String imgaePath){
        try{
            image = ImageIO.read(new File(imgaePath));
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        if(image!= null){
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        }
    }
}
