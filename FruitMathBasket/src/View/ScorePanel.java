package View;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {


    public int score = 0;

    public JLabel scoreLabel = new JLabel();
    public ScorePanel(){

        add(scoreLabel);
        scoreLabel.setForeground(Color.blue);
        this.setPreferredSize(new Dimension(100,100));
        this.setOpaque(false);
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score ,boolean isAdd){

        if (isAdd)
        {
            this.score += score;
            scoreLabel.setText("Skor: " + Integer.toString(score));
        }
        else
        {
            this.score -= score;
            scoreLabel.setText("Skor: " + Integer.toString(score));
        }

    }
}
