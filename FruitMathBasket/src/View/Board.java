package View;

import Helper.CalculateHelper;
import Helper.FruitHelper;
import Helper.SoundEffects;
import Model.Fruit;
import Model.Player;
import Model.SoundsEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Timer fruitTimer;

    private Timer countTimer;
    public int currentTime;


    private final int FRUITDELAY = 2000;

    private Player player;

    public ArrayList fruits;

    public ArrayList<Integer> fruitPositions = new ArrayList<Integer>();

    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    private FruitHelper fruitHelper;
    public CountPanel countPanel = new CountPanel();
    public ScorePanel scorePanel = new ScorePanel();

    public Image backgroundImage = new ImageIcon("src/resources/background.jpg").getImage();

    public int score = 0;
    public CalculateHelper calculateHelper;

    public SoundEffects soundEffects;




    public Board(){
        initBoard();
        this.fruitHelper = new FruitHelper(this);
        this.fruitTimer = new Timer(FRUITDELAY, e -> generateFruit());
        countTimer = new Timer(1000,e -> SetCount());
        countTimer.start();
        fruitTimer.start();
        this.setLayout(new BorderLayout());
        calculateHelper = new CalculateHelper();
        calculateHelper.setCalculate();
        soundEffects = new SoundEffects();
        try {
            soundEffects.PlaySoundWithEnum(SoundsEnum.MAIN_MENU, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        countPanel.setBorder(BorderFactory.createEmptyBorder(580, 0, 0, 100));
//        add(countPanel);


//        scorePanel.setBorder(BorderFactory.createEmptyBorder(30,700,0,0));
//        add(scorePanel,BorderLayout.EAST);
    }

    private void SetCount() {
        currentTime +=1;
    }

    private void initBoard() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("test");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);
        ingame = true;

        setSize(800,650);
        player = new Player();

        initFruits();
        //soundTrack= Applet.newAudioClip(getClass().getResource("backsound.wav"));
        //soundTrack.loop();
        timer = new Timer(20, this);
        timer.start();

    }

    private int[][] pos = {
            {89,-30}, {29,-90}, {59,-120},
            {109,-280}, {259,-390}, {150,-590},
            {170,-490}, {70,-510}, {60,-530},
            {90,-540}, {45,-560}, {139,-580},
            {80,-590}, {50,-660}, {239,-680},
            {30,-700}, {180,-740}, {50,-760},
            {109,-780}, {259,-790}, {150,-790},
            {220,-810}, {128,-820}, {20,-860},
            {259,-900}, {200,-920}, {159,-930},
            {59,-940}, {209,-980},  {30,-990},
            {89,-1380}, {29,-1680}, {59,-2000}
    };

    @Override
    public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();
    }

    public final void initFruits() {
        fruits = new ArrayList();
        for (int i=0; i<pos.length; i++ ) {
            //fruits.add(new Fruit(pos[i][0], pos[i][1]));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        if (fruits.isEmpty()) {
//            ingame = false;
//        }
        for (int i = 0; i < fruits.size(); i++) {
            Fruit a = (Fruit) fruits.get(i);
            if (a.isVisible()) {
                a.move();
            }
            else {
                fruits.remove(i);
            }
        }
        player.move();
        checkCollisions();
        repaint();
    }

    public void checkCollisions() {
        Rectangle r3 = player.getBounds();
        for (int j = 0; j<fruits.size(); j++) {
            Fruit fruit = (Fruit) fruits.get(j);
            Rectangle r2 = fruit.getBounds();

            if (r3.intersects(r2)) {
                try {
                    soundEffects.PlaySoundWithEnum(SoundsEnum.EATS, false);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                fruit.setVisible(false);
                switch (fruit.fruitType)
                {
                    case APPLE -> score += 2;
                    case PEAR ->  score += 1;
                    case BANANA ->  score -= 1;
                    case STRAWBERRY ->  score -= 2;
                }

                if (calculateHelper.result == score)
                {
                    calculateHelper.setCalculate();
                    score = 0;
                }

                //sound = Applet.newAudioClip(getClass().getResource("soft-slidertick.wav"));
                //sound.play();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(backgroundImage,0,0,this);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("Luckiest Guy" , Font.PLAIN,30));
            g2d.drawString("Süre: " + Integer.toString(currentTime),650,600);
            g2d.drawString("Skor: " + Integer.toString(score),650,100);
            g2d.drawString("İşlem: "+ calculateHelper.toString(),50,100);
            if (player.isVisible()) {
                g2d.drawImage(player.getImage(), player.getX(), player.getY(),this);
            }

            for (int i = 0; i < fruits.size(); i++) {
                Fruit a = (Fruit)fruits.get(i);
                if (a.isVisible()) {
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
            }
            g2d.setColor(Color.red);
            //g2d.drawString("Target Buah: " + fruits.size(), 5, 15);
        } else {
            String msg = "Permainan Selesai";
            Font small = new Font("Helvetica", Font.BOLD, 30);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.red);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) /2, B_HEIGHT /2);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void generateFruit()
    {
        if (fruits.size() < 10)
        {
            fruitHelper.GenerateFruit();
        }
    }
}
