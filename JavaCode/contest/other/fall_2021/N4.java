package JavaCode.contest.other.fall_2021;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author mikusugar
 */
public class N4 {
    public int circleGame(int[][] toys, int[][] circles, int r) {

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int[] c : circles) {
            if (!map.containsKey(c[0])) map.put(c[0], new TreeSet<>());
            map.get(c[0]).add(c[1]);
        }

        int res = 0;
        for (int[] toy : toys) {
            if (r < toy[2]) continue;
            for (int x = toy[0] - r; x <= toy[0] + r; x++) {
                if (!map.containsKey(x)) continue;
                final TreeSet<Integer> treeY = map.get(x);
                final Integer floorY = treeY.floor(toy[1]);
                if (floorY != null) {
                    final long dist = getDist(toy, x, floorY);
                    if (check(dist, r, toy[2])) {
                        res++;
                        break;
                    }
                }
                final Integer ceilingY = treeY.ceiling(toy[1]);
                if (ceilingY != null) {
                    final long dist = getDist(toy, x, ceilingY);
                    if (check(dist, r, toy[2])) {
                        res++;
                        break;
                    }
                }
            }

        }
        return res;
    }

    private boolean check(long d, int r1, int r2) {
        return d <= (long) (r1 - r2) * (r1 - r2);
    }

    private long getDist(int[] toy, int x, int y) {
        return (long) (toy[0] - x) * (toy[0] - x) + (long) (toy[1] - y) * (toy[1] - y);
    }
}
/*
力扣挑战赛」场地外，小力组织了一个套玩具的游戏。所有的玩具摆在平地上，toys[i] 以 [xi,yi,ri] 的形式记录了第 i 个玩具的坐标 (xi,yi) 和半径 ri。小扣试玩了一下，他扔了若干个半径均为 r 的圈，circles[j] 记录了第 j 个圈的坐标 (xj,yj)。套圈的规则如下：

若一个玩具被某个圈完整覆盖了（即玩具的任意部分均在圈内或者圈上），则该玩具被套中。
若一个玩具被多个圈同时套中，最终仅计算为套中一个玩具
请帮助小扣计算，他成功套中了多少玩具。

注意：

输入数据保证任意两个玩具的圆心不会重合，但玩具之间可能存在重叠。
示例 1：

输入：toys = [[3,3,1],[3,2,1]], circles = [[4,3]], r = 2

输出：1

解释： 如图所示，仅套中一个玩具


示例 2：

输入：toys = [[1,3,2],[4,3,1],[7,1,2]], circles = [[1,0],[3,3]], r = 4

输出：2

解释： 如图所示，套中两个玩具


提示：

1 <= toys.length <= 10^4
0 <= toys[i][0], toys[i][1] <= 10^9
1 <= circles.length <= 10^4
0 <= circles[i][0], circles[i][1] <= 10^9
1 <= toys[i][2], r <= 10


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/vFjcfV
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
