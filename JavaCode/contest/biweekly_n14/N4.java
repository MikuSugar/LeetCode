package JavaCode.contest.biweekly_n14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/11/30
 */
public class N4 {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (topRight[0]==bottomLeft[0]&&topRight[1]==bottomLeft[1])return 1;
        int x=(bottomLeft[0]+topRight[0])/2;
        int y=(bottomLeft[1]+topRight[1])/2;
        return countShips(sea,topRight,new int[]{x+1,y+1})
                +countShips(sea,new int[]{topRight[0], y},new int[]{x+1,bottomLeft[1]})
                +countShips(sea,new int[]{x,topRight[1]},new int[]{bottomLeft[0],y+1})
                +countShips(sea, new int[]{x, y}, bottomLeft);
    }
}
//方便代码编写
interface Sea {
    boolean hasShips(int[] topRight, int[] bottomLeft);
}
/*
在用笛卡尔坐标系表示的二维海平面上，有一些船。每一艘船都在一个整数点上，且每一个整数点最多只有 1 艘船。

有一个函数 Sea.hasShips(topRight, bottomLeft) ，输入参数为右上角和左下角两个点的坐标，当且仅当这两个点所表示的矩形区域（包含边界）内至少有一艘船时，这个函数才返回 true ，否则返回 false 。

给你矩形的右上角 topRight 和左下角 bottomLeft 的坐标，请你返回此矩形内船只的数目。题目保证矩形内 至多只有 10 艘船。

调用函数 hasShips 超过400次 的提交将被判为 错误答案（Wrong Answer） 。同时，任何尝试绕过评测系统的行为都将被取消比赛资格。



示例：



输入：
ships = [[1,1],[2,2],[3,3],[5,5]], topRight = [4,4], bottomLeft = [0,0]
输出：3
解释：在 [0,0] 到 [4,4] 的范围内总共有 3 艘船。


提示：

ships 数组只用于评测系统内部初始化。你无法得知 ships 的信息，所以只能通过调用 hasShips 接口来求解。
0 <= bottomLeft[0] <= topRight[0] <= 1000
0 <= bottomLeft[1] <= topRight[1] <= 1000
 */
