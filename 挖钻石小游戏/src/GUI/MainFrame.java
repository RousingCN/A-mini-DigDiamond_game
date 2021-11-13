package GUI;

import calculate.CalculateMiddle;
import collections.GamePanel;
import collections.GameTips;
import collections.GameTitle;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String str) {
        this.setTitle(str);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(new Dimension(850,750));
        this.setLocation(new CalculateMiddle(this).getMiddle());
        this.setLayout(null);

        //添加图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image icon = tk.getImage("assets/img/Diamond.png");
        this.setIconImage(icon);

        JPanel gameTitle = new GameTitle();
        JPanel gamePanel = new GamePanel();
        JPanel gameTips = new GameTips();

        this.getContentPane().add(gameTitle);
        this.getContentPane().add(gamePanel);
        this.getContentPane().add(gameTips);

    }

}
