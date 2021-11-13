package collections;

import Data.Data;
import font.ArcFont;

import javax.swing.*;
import java.awt.*;


public class GameTitle extends JPanel {
    JLabel time;

    public GameTitle() {
        this.setSize(new Dimension(850, 40));
        this.setLocation(0, 0);
        //this.setBackground(new Color(227, 227, 227));
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        time = new JLabel();
        time.setFont(new ArcFont().getArcaeaFont(26));
        time.setHorizontalAlignment(SwingConstants.CENTER);
        time.setText(Data.hour + ":" + Data.min + ":" + Data.sec);
        panel.add(time);
        this.add(panel);

        Thread t = new TimeThread();
        t.start();

    }

    class TimeThread extends Thread {
        @Override
        public void run() {
            while (Data.inProgress) {
                Data.sec++;
                if (Data.sec == 60) {       //60秒进一分钟
                    Data.sec = 0;
                    Data.min++;
                    if (Data.min == 60) {   //60分钟进一小时
                        Data.min = 0;
                        Data.hour++;
                    }
                }
                time.setText(Data.hour + ":" + Data.min + ":" + Data.sec);

                try {
                    sleep(1000);        //睡眠一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
