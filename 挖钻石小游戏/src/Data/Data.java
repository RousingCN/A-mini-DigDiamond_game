package Data;

import calculate.CreateDiamonds;

public class Data {

    public static final int rows = 12;          //游戏界面为12行
    public static final int columns = 16;       //游戏界面为16列
    public static boolean inProgress = true;    //游戏是否进行中
    public static int hour = 0;                 //游戏小时
    public static int min = 0;                  //游戏分钟
    public static int sec = 0;                  //游戏秒
    public static int diamonds = 48;            //钻石剩余数量
    public static int digDiamondsNum = 0;       //钻石挖掘数量
    public static int notFound = 0;             //无效点击次数
    public static final int[][] diamondsXY = new CreateDiamonds().getDiamonds(); //带有钻石的所有格子坐标

    public Data() {
    }

    /**
     * 检测是否为钻石格
     * @return
     */
    public boolean checkDiamond(int x, int y) {
        if (diamondsXY[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static final String calculateDiamondNum(int x, int y) {
        int num;
        //获得数组下标
        int row = rows - 1;                     //行
        int column = columns - 1;               //列

        if (x == 0 && y == 0) {                                         //diamondsXY[0][0]
            num = diamondsXY[0][1] + diamondsXY[1][0] + diamondsXY[1][1];                                       //左上角
        } else if (x == 0 && y == column) {                             //diamondsXY[0][15]
            num = diamondsXY[0][column - 1] + diamondsXY[1][column - 1] + diamondsXY[1][column];                //右上角
        } else if (x == row && y == 0) {                                //diamondsXY[11][0]
            num = diamondsXY[row - 1][0] + diamondsXY[row - 1][1] + diamondsXY[row][1];                         //左下角
        } else if (x == row && y == column) {                           //diamondsXY[11][15]
            num = diamondsXY[row - 1][column - 1] + diamondsXY[row - 1][column] + diamondsXY[row][column - 1];  //右下角
        } else if (x == 0 && y > 0 && y < column) {                     //diamondsXY[0][1-14]   (排除0,0和0,15)
            num = diamondsXY[0][y - 1] + diamondsXY[0][y + 1] + diamondsXY[1][y - 1] +
                    diamondsXY[1][y] + diamondsXY[1][y + 1];                                                    //第一行   (不包括左上角和右上角)
        } else if (x == row && y > 0 && y < column) {                   //diamondsXY[11][1-14]  (排除11,0和11,15)
            num = diamondsXY[x - 1][y - 1] + diamondsXY[x - 1][y] + diamondsXY[x - 1][y + 1] +
                    diamondsXY[x][y - 1] + diamondsXY[x][y + 1];                                                //最后一行  (不包括左下角和右下角)
        } else if (x > 0 && x < row && y == 0) {                        //diamondsXY[1-10][0]   (排除0,0和11,0)
            num = diamondsXY[x - 1][0] + diamondsXY[x - 1][1] + diamondsXY[x][1] +
                    diamondsXY[x + 1][0] + diamondsXY[x + 1][1];                                                //第一列   (不包括左上角和左下角)
        } else if (x > 0 && x < row && y == column) {                   //diamondsXY[1-10][15]  (排除0,15和11,15)
            num = diamondsXY[x - 1][y - 1] + diamondsXY[x - 1][y] + diamondsXY[x][y - 1] +
                    diamondsXY[x + 1][y - 1] + diamondsXY[x + 1][y];                                            //最后一列  (不包括右上角和右下角)
        } else {
            num = diamondsXY[x - 1][y - 1] + diamondsXY[x - 1][y] + diamondsXY[x - 1][y + 1] +
                    diamondsXY[x][y - 1] + diamondsXY[x][y + 1] + diamondsXY[x + 1][y - 1] +
                    diamondsXY[x + 1][y] + diamondsXY[x + 1][y + 1];                                            //区域中心  (不包括上述几种情况)
        }

        if (num == 0) {
            return "";
        }
        return num + "";
    }

}
