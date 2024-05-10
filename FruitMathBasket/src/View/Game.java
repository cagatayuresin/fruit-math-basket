package View;

import Model.Player;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public Game(){
        initBoard();
    }

    private void initBoard() {
        setSize(800,650);
        Board board = new Board();
        add(board);
        setLocationRelativeTo(null);
        setTitle("FruitMathBasket");
        //setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

}
