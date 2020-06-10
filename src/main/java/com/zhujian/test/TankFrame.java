package com.zhujian.test;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    final int GAME_WIDTH = 800;
    final int GAME_HEIGHT = 800;

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("坦克大战");
        setVisible(true);
        this.addKeyListener(new KeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics graphics){
    }

    class KeyListener extends KeyAdapter{
        Boolean leftB = false;
        Boolean rightB = false;
        Boolean upB = false;
        Boolean downB = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    leftB = true;
                    break;
                case KeyEvent.VK_UP:
                    upB = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightB = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downB = true;
                    break;
                case KeyEvent.VK_0:
                    break;
                default:
                    break;
            }
            System.out.printf("keyPressed");
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    leftB = false;
                    break;
                case KeyEvent.VK_UP:
                    upB = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightB = false;
                    break;
                case KeyEvent.VK_DOWN:
                    downB = false;
                    break;
                default:
                    break;
            }
            System.out.println("keyReleased");
        }



    }

}
