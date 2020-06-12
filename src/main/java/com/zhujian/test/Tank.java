package com.zhujian.test;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    private static final int WIDTH = 50;
    private static final int HIGHT = 50;

    private Boolean fire = false;
    private boolean moving = false;
    public boolean isMoving() {
        return moving;
    }

    private TankFrame frame = null;

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Boolean getFire() {
        return fire;
    }

    public void setFire(Boolean fire) {
        this.fire = fire;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,TankFrame frame) {
        super();
        System.out.println("-----");
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.frame=frame;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HIGHT);
        g.setColor(Color.BLUE);
        move();
    }

    private void move() {
        if(!moving){return;}
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire(){
        int x1 = x;
        int y1 = y;
        // 修正子弹位置
        switch (dir) {
            case LEFT:
                y1 = y+HIGHT/2;
                break;
            case UP:
                x1 = x+WIDTH/2;
                break;
            case RIGHT:
                y1 = y+HIGHT/2;
                x1 = x+WIDTH ;
                break;
            case DOWN:
                x1 = x+WIDTH/2;
                y1 = y+HIGHT;
                break;
        }
       frame.bullet = new Bullet(x1,y1,dir);

    }

}
