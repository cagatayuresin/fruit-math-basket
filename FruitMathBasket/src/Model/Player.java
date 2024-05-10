package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

public class Player {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;

    private int speed = 5;


    public Player(){
        image = new ImageIcon("src/resources/bunny.png").getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = 400;
        y = 480;
    }

    public void move() {

        x += dx;
        if (x < 1) {
            x = 1;
        }
        if(x > 750){
            x = 750;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -speed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = +speed;
        }

        if (key == KeyEvent.VK_UP)
        {
            speed += 5;
        }

        if (key == KeyEvent.VK_DOWN)
        {
            speed -= 5;
            if (speed <=0)
            {
                speed = 5;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }

}
