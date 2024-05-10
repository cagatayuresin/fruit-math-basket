package Helper;

import java.awt.*;
import java.io.*;

public class FontHelper {
    public static void loadFont() {
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/LuckiestGuy-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
