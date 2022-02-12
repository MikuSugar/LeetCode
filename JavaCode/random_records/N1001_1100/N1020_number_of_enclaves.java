package JavaCode.random_records.N1001_1100;

import utils.Parse;

/**
 * @author mikusugar
 */
public class N1020_number_of_enclaves {
    public static void main(String[] args) {
        System.out.println(new N1020_number_of_enclaves().numEnclaves(
                Parse.parseToIntTwoArray("[" +
                        "[0,0,1,1,1,0,1,1,1,0,1]," +
                        "[1,1,1,1,0,1,0,1,1,0,0]," +
                        "[0,1,0,1,1,0,0,0,0,1,0]," +
                        "[1,0,1,1,1,1,1,0,0,0,1]," +
                        "[0,0,1,0,1,1,0,0,1,0,0]," +
                        "[1,0,0,1,1,1,0,0,0,1,1]," +
                        "[0,1,0,1,1,0,0,0,1,0,0]," +
                        "[0,1,1,0,1,0,1,1,1,0,0]," +
                        "[1,1,0,1,1,1,0,0,0,0,0]," +
                        "[1,0,1,1,0,0,0,1,0,0,1]]")
        ));
    }

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][grid[i].length - 1] == 1) dfs(i, grid[i].length - 1, grid);
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid);
            if (grid[grid.length - 1][j] == 1) dfs(grid.length - 1, j, grid);
        }
        int res = 0;
        for (int[] g : grid) {
            for (int i : g) {
                if (i == 1) res++;
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] grid) {
        grid[i][j] = 2;
        for (int[] next : NEXTS) {
            int ii = next[0] + i;
            int jj = next[1] + j;
            if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || grid[ii][jj] != 1) continue;
            dfs(ii, jj, grid);
        }
    }

    private final static int[][] NEXTS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
}
/*
给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。

一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。

返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。

 

示例 1：


输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
输出：3
解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
示例 2：


输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
输出：0
解释：所有 1 都在边界上或可以到达边界。
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] 的值为 0 或 1


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-enclaves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
