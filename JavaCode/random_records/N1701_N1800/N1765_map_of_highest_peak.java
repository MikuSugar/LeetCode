package JavaCode.random_records.N1701_N1800;

import utils.Parse;
import utils.Show;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author mikusugar
 */
public class N1765_map_of_highest_peak {

    public static void main(String[] args) {
        final int[][] res = new N1765_map_of_highest_peak().highestPeak(Parse.toIntTwoArr("[[0,1],[0,0]]"));
        Show.show(res);

    }

    public int[][] highestPeak(int[][] isWater) {

        int[][] res = new int[isWater.length][isWater[0].length];
        for (int[] arr : res) Arrays.fill(arr, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
        int high = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                final int[] poll = queue.poll();
                if (res[poll[0]][poll[1]] != -1) continue;
                res[poll[0]][poll[1]] = high;
                for (int[] next : NEXTS) {
                    int ii = next[0] + poll[0];
                    int jj = next[1] + poll[1];
                    if (ii < 0 || jj < 0 || ii >= res.length || jj >= res[0].length || res[ii][jj] != -1) continue;
                    queue.add(new int[]{ii, jj});
                }
            }
            high++;
        }

        return res;
    }

    private final static int[][] NEXTS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
}
/*
给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。

如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
你需要按照如下规则给每个单元格安排高度：

每个格子的高度都必须是非负的。
如果一个格子是是 水域 ，那么它的高度必须为 0 。
任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。

请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。

 

示例 1：



输入：isWater = [[0,1],[0,0]]
输出：[[1,0],[2,1]]
解释：上图展示了给各个格子安排的高度。
蓝色格子是水域格，绿色格子是陆地格。
示例 2：



输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
输出：[[1,1,0],[0,1,1],[1,2,2]]
解释：所有安排方案中，最高可行高度为 2 。
任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
 

提示：

m == isWater.length
n == isWater[i].length
1 <= m, n <= 1000
isWater[i][j] 要么是 0 ，要么是 1 。
至少有 1 个水域格子。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/map-of-highest-peak
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

