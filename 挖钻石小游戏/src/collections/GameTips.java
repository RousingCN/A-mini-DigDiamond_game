package collections;

import Data.Data;
import font.ArcFont;

import javax.swing.*;
import java.awt.*;

public class GameTips extends JPanel {
    JLabel label, label1;
    public GameTips() {
        this.setSize(new Dimension(850, 90));
        this.setLocation(0, 660);
        this.setBackground(new Color(205, 205, 205));
        this.setLayout(new GridLayout(1, 3));
        JPanel panel01 = new JPanel();
        panel01.setOpaque(false);
        label = new JLabel("获得钻石数：" + Data.digDiamondsNum, SwingConstants.CENTER);
        label.setFont(new ArcFont().getUIFont(26));
        panel01.add(label);
        this.add(panel01);

        JPanel panel02 = new JPanel();
        panel02.setOpaque(false);
        this.add(panel02);

        JPanel panel03 = new JPanel();
        panel03.setOpaque(false);
        label1 = new JLabel("剩余钻石数：" + Data.diamonds, SwingConstants.CENTER);
        label1.setFont(new ArcFont().getUIFont(26));
        panel03.add(label1);
        this.add(panel03);

        Thread t = new TipsThread();
        t.start();

    }

    class TipsThread extends Thread {
        @Override
        public void run() {
            while (Data.inProgress) {
                label.setText("获得钻石数：" + Data.digDiamondsNum);
                label1.setText("剩余钻石数：" + Data.diamonds);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

}
