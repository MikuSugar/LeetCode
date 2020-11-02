package JavaCode.contest.weekly.n0_200.n162;

/**
 * author:fangjie
 * time:2019/11/10
 */
public class N3 {
    public int closedIsland(int[][] grid) {
        int res=0;
        boolean[][] book=new boolean[grid.length][grid[0].length];
        help(grid,book);
        for (int i=1;i<grid.length-1;i++)
        {
            for (int j=1;j<grid[0].length-1;j++)
            {
                if(grid[i][j]==0&&!book[i][j])
                {
                    res+=1;
                    dfs(i,j,grid,book);
                }
            }
        }
        return res;
    }

    private void help(int[][] grid, boolean[][] book) {
        for (int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==0&&!book[i][0])
            {
                dfs(i,0,grid,book);
            }
            if(grid[i][grid[0].length-1]==0&&!book[i][grid[0].length-1])
            {
                dfs(i,grid[0].length-1,grid,book);
            }
        }
        for (int i=0;i<grid[0].length;i++)
        {
            int j=0;
            if(grid[j][i]==0&&!book[j][i])dfs(j,i,grid,book);
            j=grid.length-1;
            if(grid[j][i]==0&&!book[j][i])dfs(j,i,grid,book);
        }
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] book) {
        book[i][j]=true;
        for (int[] next:NEXTS)
        {
            int ii=i+next[0];
            int jj=j+next[1];
            if(ii<0||ii>=grid.length||jj<0||jj>=grid[0].length||book[ii][jj]||grid[ii][jj]==1)continue;
            dfs(ii,jj,grid,book);
        }
    }
    private final static int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};
}
/*
有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。

我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。

如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。

请返回封闭岛屿的数目。



示例 1：



输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
输出：2
解释：
灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
示例 2：



输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
输出：1
示例 3：

输入：grid = [[1,1,1,1,1,1,1],
             [1,0,0,0,0,0,1],
             [1,0,1,1,1,0,1],
             [1,0,1,0,1,0,1],
             [1,0,1,1,1,0,1],
             [1,0,0,0,0,0,1],
             [1,1,1,1,1,1,1]]
输出：2


提示：

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

 */
