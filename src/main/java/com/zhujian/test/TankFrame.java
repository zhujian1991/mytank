package com.zhujian.test;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    // 初始值
    final int GAME_WIDTH = 800;
    final int GAME_HEIGHT = 800;

    Tank tank = new Tank(300,200, Dir.DOWN,this);
    Bullet bullet = new Bullet(50,50, Dir.DOWN);
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
    public void paint(Graphics g){
       tank.paint(g);
       bullet.paint(g);
    }

    class KeyListener extends KeyAdapter{
        Boolean leftB = false;
        Boolean rightB = false;
        Boolean upB = false;
        Boolean downB = false;

        Boolean fireB = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    leftB = true;
                    setTankPoint();
                    break;
                case KeyEvent.VK_UP:
                    upB = true;
                    setTankPoint();
                    break;
                case KeyEvent.VK_RIGHT:
                    rightB = true;
                    setTankPoint();
                    break;
                case KeyEvent.VK_DOWN:
                    downB = true;
                    setTankPoint();
                    break;
                case KeyEvent.VK_C:
                    tank.fire();
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
                    setTankPoint();
                    break;
                case KeyEvent.VK_UP:
                    upB = false;
                    setTankPoint();
                    break;
                case KeyEvent.VK_RIGHT:
                    rightB = false;
                    setTankPoint();
                    break;
                case KeyEvent.VK_DOWN:
                    downB = false;
                    setTankPoint();
                    break;
                default:
                    break;
            }
            System.out.println("keyReleased");
        }
        // 设置坦克的移动位置
        private void setTankPoint() {
            tank.setMoving(false);
                if (rightB) {
                    tank.setDir(Dir.RIGHT);
                    tank.setMoving(true);
                }
                if (leftB) {
                    tank.setDir(Dir.LEFT);
                    tank.setMoving(true);
                }
                if (upB) {
                    tank.setDir(Dir.UP);
                    tank.setMoving(true);
                }
                if (downB) {
                    tank.setDir(Dir.DOWN);
                    tank.setMoving(true);
                }
                if (fireB) {
                    tank.setFire(true);
                }
            }
        }

}
