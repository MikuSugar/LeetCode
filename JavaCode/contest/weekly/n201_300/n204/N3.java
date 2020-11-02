package JavaCode.contest.weekly.n201_300.n204;

import utils.Parse;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/8/30 10:23 上午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().minDays(Parse.parseToIntTwoArray("[[1,0],[1,1]]")));
    }
    public int minDays(int[][] grid) {
        if(check(grid))return 0;
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]!=1)continue;
                grid[i][j]=0;
                if(check(grid))return 1;
                grid[i][j]=1;
            }
        }
        return 2;
    }

    private boolean check(int[][] grid) {
        boolean[][] book=new boolean[grid.length][grid[0].length];
        f:for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(i,j,grid,book);
                    break f;
                }
            }
        }
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1&&!book[i][j])return true;
            }
        }
        return false;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] book) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1||book[i][j])return;
        book[i][j]=true;
        for (int[] next:NEXTS)
        {
            dfs(i+next[0],j+next[1],grid,book);
        }
    }

    private final static int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};
}
/*
给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。

如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。

一天内，可以将任何单个陆地单元（1）更改为水单元（0）。

返回使陆地分离的最少天数。



示例 1：



输入：grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
输出：2
解释：至少需要 2 天才能得到分离的陆地。
将陆地 grid[1][1] 和 grid[0][2] 更改为水，得到两个分离的岛屿。
示例 2：

输入：grid = [[1,1]]
输出：2
解释：如果网格中都是水，也认为是分离的 ([[1,1]] -> [[0,0]])，0 岛屿。
示例 3：

输入：grid = [[1,0,1,0]]
输出：0
示例 4：

输入：grid = [[1,1,0,1,1],
             [1,1,1,1,1],
             [1,1,0,1,1],
             [1,1,0,1,1]]
输出：1
示例 5：

输入：grid = [[1,1,0,1,1],
             [1,1,1,1,1],
             [1,1,0,1,1],
             [1,1,1,1,1]]
输出：2


提示：

1 <= grid.length, grid[i].length <= 30
grid[i][j] 为 0 或 1
 */
