package calculate;

import javax.swing.*;
import java.awt.*;

public class CalculateMiddle {
    Toolkit kit = Toolkit.getDefaultToolkit();  //定义工具包
    Dimension screenSize = kit.getScreenSize(); //获取屏幕尺寸
    int screenWidth = screenSize.width;         //获取屏幕的宽
    int screenHeight = screenSize.height;       //获取屏幕的高
    int x, y;                                   //待计算的窗口坐标
    public CalculateMiddle(JFrame frame) {
        int windowsWidth = frame.getWidth();   //获得窗口的宽
        int windowsHeight = frame.getHeight(); //获得窗口的高
        x = screenWidth / 2 - windowsWidth / 2;
        y = screenHeight / 2 - windowsHeight / 2;

    }

    public CalculateMiddle(JDialog dialog) {
        int windowsWidth = dialog.getWidth();   //获得窗口的宽
        int windowsHeight = dialog.getHeight(); //获得窗口的高
        x = screenWidth / 2 - windowsWidth / 2;
        y = screenHeight / 2 - windowsHeight / 2;
    }

    public Point getMiddle() {
        return new Point(x, y);
    }
}
