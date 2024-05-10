package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainMenuPanel extends JPanel  {

    private ImageIcon image = new ImageIcon("src/resources/menu.jpg");


    public MainMenu mainMenu;

    public MainMenuPanel(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        drawMenu(g);
    }

    private void drawMenu(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image.getImage(),0,0,this);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_ENTER) {
                    mainMenu.dispose();
                    new Game();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_ENTER) {
                    mainMenu.dispose();
                    new Game();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_ENTER) {
                    mainMenu.dispose();
                    new Game();
                }
            }
        });
    }
}
