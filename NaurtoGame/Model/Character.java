package Model;

import javax.swing.*;
import java.awt.*;

public class Character extends JPanel{
    private Image character;

    public Character(){
        character = new ImageIcon(" ").getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(character,0,0,getWidth(),getHeight(),this);
    }
}
