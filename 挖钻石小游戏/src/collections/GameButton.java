package collections;

import Data.Data;
import GUI.GameEndFrame;
import font.ArcFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameButton extends JButton {
    private boolean tag = false;
    private boolean dig = false;
    /**
     * 游戏内每一个单元格
     * @param x
     * @param y
     */
    public GameButton(int x, int y,boolean hasDiamond) {
        this.setSize(50,50);
        this.setIcon(new ImageIcon("assets/img/gameButton.jpg"));

        this.setMargin(new Insets(0,0,0,0));//将边框外的上下左右空间设置为0
        this.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0
        this.setBorderPainted(false);//不打印边框
        this.setBorder(null);//除去边框
        this.setFocusPainted(false);//除去焦点的框
        this.setContentAreaFilled(false);//除去默认的背景填充

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setText(Data.calculateDiamondNum(x, y));
        label.setFont(new ArcFont().getArcaeaFont(14));
        panel.add(label, BorderLayout.CENTER);
        this.add(panel);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (dig) {      //如果钻石存在且已经被挖掘则不能进行任何操作
                    return;
                }
                if (e.getButton() == MouseEvent.BUTTON3) {  //如果点击的是鼠标右键
                    if (!tag) {                     //如果没有处于标记状态
                        setIcon(new ImageIcon("assets/img/gameButtonFoucs.png.jpg"));
                        tag = true;
                    } else {
                        setIcon(new ImageIcon("assets/img/gameButton.jpg"));
                        tag = false;
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON1 && !tag) {      //鼠标左键点击且没有处于标记状态
                    if (hasDiamond) {                       //如果有钻石
                        //替换为有钻石的背景图片，同时不允许再次点击
                        setIcon(new ImageIcon("assets/img/gameDiamondButton.jpg"));
                        dig = true;
                        Data.diamonds--;                    //可挖掘钻石数-1
                        Data.digDiamondsNum++;              //已挖掘钻石数+1
                    } else Data.notFound++;                 //如果没有钻石，则记录一次多余操作
                    //检查钻石数，结束游戏
                    if (Data.digDiamondsNum == 48) {        //已挖掘48个钻石,结束游戏
                        //游戏结束
                        new GameEndFrame();
                        Data.inProgress = false;            //修改游戏状态为结束
                    }
                }
            }
        });
    }
}
