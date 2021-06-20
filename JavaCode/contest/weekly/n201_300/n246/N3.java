package JavaCode.contest.weekly.n201_300.n246;

public class N3 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] book = new boolean[grid2.length][grid2[0].length];
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (book[i][j] || grid2[i][j] == 0) continue;
                if (dfs(i, j, grid1, grid2, book)) res++;
            }
        }
        return res;
    }

    private boolean dfs(int i, int j, int[][] grid1, int[][] grid2, boolean[][] book) {
        if (book[i][j]) return true;
        book[i][j] = true;
        boolean res = grid1[i][j] == grid2[i][j];
        for (int[] next : NEXTS) {
            int ii = i + next[0];
            int jj = j + next[1];
            if (ii < 0 || jj < 0 || ii >= grid1.length || jj >= grid1[0].length || grid2[ii][jj] == 0) continue;
            res &= dfs(ii, jj, grid1, grid2, book);
        }
        return res;
    }

    private final static int[][] NEXTS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
}
/*
给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。

如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。

请你返回 grid2 中 子岛屿 的 数目 。



示例 1：


输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
输出：3
解释：如上图所示，左边为 grid1 ，右边为 grid2 。
grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
示例 2：


输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
输出：2
解释：如上图所示，左边为 grid1 ，右边为 grid2 。
grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。


提示：

m == grid1.length == grid2.length
n == grid1[i].length == grid2[i].length
1 <= m, n <= 500
grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。
 */
