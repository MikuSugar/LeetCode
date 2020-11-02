package JavaCode.contest.weekly.n0_200.n134;


public class N2 {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] book=new boolean[grid.length][grid[0].length];
        dfs(r0,c0,book,grid,color,grid[r0][c0]);
        return grid;
    }

    private static int[] r={-1,0,0,1};
    private static int[] c={0,-1,1,0};
    private void dfs(int i, int j, boolean[][] book, int[][] grid, int color,int tar) {
        if(grid[i][j]==tar)
        {
            book[i][j]=true;
            for (int k=0;k<4;k++)
            {
                int ii=i+r[k];
                int jj=j+c[k];
                if(ii>=0&&jj>=0&&ii<grid.length&&jj<grid[0].length&&!book[ii][jj])
                {
                    dfs(ii,jj,book,grid,color,tar);
                }
            }
            if(!check(i,j,book,grid,tar))grid[i][j]=color;
        }
    }

    private boolean check(int i, int j, boolean[][] book, int[][] grid, int tar) {
        for (int k=0;k<4;k++)
        {
            int ii=i+r[k];
            int jj=j+c[k];
            if(ii>=0&&jj>=0&&ii<grid.length&&jj<grid[0].length)
            {
                if(!book[ii][jj])return false;
            }
            else return false;
        }
        return true;
    }
}
/**
 *  5040. 边框着色  显示英文描述
 * 用户通过次数 10
 * 用户尝试次数 30
 * 通过次数 10
 * 提交次数 51
 * 题目难度 Medium
 * 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 *
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 *
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 *
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 *
 *
 * 提示：
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 */
