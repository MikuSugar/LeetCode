package JavaCode.contest.n159;

import java.util.Arrays;
import java.util.Comparator;

/**
 * author:fangjie
 * time:2019/10/20
 */
public class N1 {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2)return true;
        //(x2-x1)/(y2-y1)=(x3-x2)/(y3-y2)
        for (int i=2;i<coordinates.length;i++)
        {
            int sum1=(coordinates[i-1][0]-coordinates[i-2][0])*(coordinates[i][1]-coordinates[i-1][1]);
            int sum2=(coordinates[i][0]-coordinates[i-1][0])*(coordinates[i-1][1]-coordinates[i-2][1]);
            if(sum1!=sum2)return false;
        }
        return true;
    }
}
/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">true</font>，否则请返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">false</font>。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */
