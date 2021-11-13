package GUI;

import Data.Data;
import calculate.CalculateMiddle;
import font.ArcFont;

import javax.swing.*;
import java.awt.*;

public class GameEndFrame extends JFrame {
    /**
     * 结算面板
     */
    public GameEndFrame() {
        this.setSize(new Dimension(300, 400));
        this.setLocation(new CalculateMiddle(this).getMiddle());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("游戏结束");
        this.setVisible(true);
        this.setResizable(false);

        //添加图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image icon = tk.getImage("assets/img/Diamond.png");
        this.setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setLayout(new GridLayout(3, 1));
        JLabel label = new JLabel("游戏结束", SwingConstants.CENTER);
        label.setFont(new ArcFont().getUIFont(30));
        JLabel label01 = new JLabel("游戏时间：" + Data.hour + ":" + Data.min + ":" + Data.sec, SwingConstants.CENTER);   //时间
        label01.setFont(new ArcFont().getUIFont(20));
        JLabel label02 = new JLabel("无效开采：" + Data.notFound + "次", SwingConstants.CENTER);                          //次数
        label02.setFont(new ArcFont().getUIFont(20));
        panel.add(label);
        panel.add(label01);
        panel.add(label02);

        this.getContentPane().add(panel);

    }
}
