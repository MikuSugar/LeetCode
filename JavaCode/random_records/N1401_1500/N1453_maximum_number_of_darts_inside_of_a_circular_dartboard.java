package JavaCode.random_records.N1401_1500;

/**
 * @Author: fangjie
 * @Date: 2020/6/30 5:40 下午
 */
public class N1453_maximum_number_of_darts_inside_of_a_circular_dartboard {
    public int numPoints(int[][] points, int r) {
        return -1;
    }
    private static double getDist(int[] p1,int[] p2) {
        return Math.sqrt(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2));
    }
}
/*
墙壁上挂着一个圆形的飞镖靶。现在请你蒙着眼睛向靶上投掷飞镖。

投掷到墙上的飞镖用二维平面上的点坐标数组表示。飞镖靶的半径为 r 。

请返回能够落在 任意 半径为 r 的圆形靶内或靶上的最大飞镖数。

 

示例 1：



输入：points = [[-2,0],[2,0],[0,2],[0,-2]], r = 2
输出：4
解释：如果圆形的飞镖靶的圆心为 (0,0) ，半径为 2 ，所有的飞镖都落在靶上，此时落在靶上的飞镖数最大，值为 4 。
示例 2：



输入：points = [[-3,0],[3,0],[2,6],[5,4],[0,9],[7,8]], r = 5
输出：5
解释：如果圆形的飞镖靶的圆心为 (0,4) ，半径为 5 ，则除了 (7,8) 之外的飞镖都落在靶上，此时落在靶上的飞镖数最大，值为 5 。
示例 3：

输入：points = [[-2,0],[2,0],[0,2],[0,-2]], r = 1
输出：1
示例 4：

输入：points = [[1,2],[3,5],[1,-1],[2,3],[4,1],[1,3]], r = 2
输出：4
 

提示：

1 <= points.length <= 100
points[i].length == 2
-10^4 <= points[i][0], points[i][1] <= 10^4
1 <= r <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
