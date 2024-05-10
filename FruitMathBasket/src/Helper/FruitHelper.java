package Helper;

import Model.Fruit;
import View.Board;

import java.util.Random;
import javax.swing.Timer;
public class FruitHelper{
    private Timer timer;
    private final int DELAY = 1000;
    public Board board;

    public Random random;
    public FruitHelper(Board board)
    {
        this.board = board;
        this.random = new Random();
    }

    public void GenerateFruit() {
        int x = 0;
        do {
            x = this.random.nextInt(800);
        }
        while (board.fruitPositions.contains(x));

        board.fruits.add(new Fruit(x,100,board));
        board.fruitPositions.add(x);
    }
}
