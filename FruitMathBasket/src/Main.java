import Helper.FontHelper;
import Helper.SoundEffects;
import View.Game;
import View.MainMenu;

import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FontHelper.loadFont();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            }
        });

    }

    public static class FruitMathBasket{
    }
}