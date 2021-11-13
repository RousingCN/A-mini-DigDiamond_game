package collections;

import Data.Data;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        this.setLayout(new GridLayout(Data.rows, Data.columns,0,0));        //行数定义为0，则列数生效
        this.setSize(800, 600);
        this.setLocation(new Point(25, 50));
        //添加游戏按钮
        for (int i = 0; i < Data.rows; i++) {
            for (int j = 0; j < Data.columns; j++) {
                this.add(new GameButton(i, j,new Data().checkDiamond(i,j)));
            }
        }
    }
}
