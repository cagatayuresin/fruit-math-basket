package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainMenu extends JFrame implements KeyListener {


    public MainMenu(){
        initUI();
    }

    private void initUI() {
        setSize(800,650);
        MainMenuPanel mainMenuPanel = new MainMenuPanel(this);
        add(mainMenuPanel);
        setLocationRelativeTo(null);
        setTitle("FruitMathBasket");
        //setResizable(false);
        setUndecorated(true);
        setVisible(true);
        mainMenuPanel.setFocusable(true);
        mainMenuPanel.requestFocusInWindow();

        mainMenuPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose();
                    new Game();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ENTER) {
            this.dispose();
            new Game();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
