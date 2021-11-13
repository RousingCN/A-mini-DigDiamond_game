package calculate;

import Data.Data;

public class CreateDiamonds {
    int[][] diamondXY = new int[Data.rows][Data.columns];

    /**
     * 创建钻石
     */
    public CreateDiamonds() {
        int diamonds = 0;                                   //已经埋的钻石的数量
        while (diamonds < Data.diamonds) {
            int x, y;                                       //钻石的坐标
            x = (int) (Math.random() * Data.rows);          //钻石生成在哪一行
            y = (int) (Math.random() * Data.columns);       //钻石生成在哪一列

            if (diamondXY[x][y] == 1) continue;             //该地点存在了钻石
            diamondXY[x][y] = 1;                            //标记为有雷
            diamonds++;                                     //已经埋的钻石的数量+1
        }
    }

    /**
     * 返回所有钻石的坐标
     * @return 钻石的坐标
     */
    public int[][] getDiamonds() {
        return diamondXY;
    }

}
