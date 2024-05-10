package View;

import javax.swing.*;
import java.awt.*;

public class CountPanel extends JPanel {

    private Timer countTimer;
    public int time;
    public JLabel countLabel = new JLabel();
    public CountPanel(){
        countTimer = new Timer(1000,e -> SetCount());
        countTimer.start();
        add(countLabel);
        countLabel.setForeground(Color.blue);
        this.setPreferredSize(new Dimension(100,100));
        this.setOpaque(false);
    }

    private void SetCount() {
        time +=1;
        countLabel.setText("Süre: " + Integer.toString(time));
    }
}
