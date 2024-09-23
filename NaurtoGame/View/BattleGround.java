package View;

import Model.BackGround;
import Model.Character;
import Model.Enemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BattleGround extends JFrame {
    private Image backgroundImage;
    private Character character;
    private Timer gameTimer;
    private Enemy enemy;

    public BattleGround(){
        setTitle("Shibbutan Battle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);

        backgroundImage = new ImageIcon("photo.jpeg").getImage();

        BackgroundPanel backGround = new BackgroundPanel();
        backGround.setLayout(null);

        Character character = new Character();
        int X = 50;
        int Y = 50;
        int width = 100;
        int height = 100;
        int position = X;
        character.setBounds(position,Y,width,height);

        backGround.add(character);
        setContentPane(backGround);

        enemy = new Enemy(600,Y,width,height);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch(key){
                    case KeyEvent.VK_LEFT :
                        moveLeft();
                    case KeyEvent.VK_RIGHT:
                        moveRight();
                        break;
                    case KeyEvent.VK_UP:
                        jump();
                        break;
                    case KeyEvent.VK_SPACE:
                        attack();
                        break;
                }
            }

            private void attack(){

            }

            private void jump() {
            }

            private void moveRight() {
                int x = character.getX();
                int moveAmount = 10;
                if (x + moveAmount + character.getWidth() <= getWidth()) {
                    character.setLocation(x + moveAmount, character.getY());
                }
            }

            private void moveLeft() {
                int x = character.getX();
                int moveAmount = 10;
                if (x - moveAmount >= 0) {
                    character.setLocation(x - moveAmount, character.getY());
                }
            }

        });
        setFocusable(true);

    }
    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            enemy.draw(g);
        }
    }
}
