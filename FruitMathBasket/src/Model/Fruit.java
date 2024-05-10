package Model;

import View.Board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Fruit {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    private Random random;

    private Board board;
    public FruitEnum fruitType;

    public int speed;

    public Fruit(int x , int y , Board board){
        random = new Random();
        speed = random.nextInt(1,10);
        this.board = board;
        //image = new ImageIcon("src/resources/banana.png").getImage();
        SetImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;

    }

    public void move() {
        if (y > 600) {
            visible = false;
            board.fruitPositions.remove(board.fruitPositions.indexOf(x));
            board.fruits.remove(board.fruits.indexOf(this));
        }
        y += speed;
    }
    public void SetImage(){

        FruitEnum currentEnum = FruitEnum.values()[random.nextInt(0,4)];
        fruitType = currentEnum;
        switch (currentEnum)
        {
            case APPLE -> image = new ImageIcon("src/resources/apple.png").getImage();
            case PEAR -> image = new ImageIcon("src/resources/pear.png").getImage();
            case BANANA -> image = new ImageIcon("src/resources/banana.png").getImage();
            case STRAWBERRY -> image = new ImageIcon("src/resources/strawberry.png").getImage();

        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
