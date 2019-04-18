package JavaCode.random_records.N601_700;

public class N695_max_area_of_island {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0)return 0;
        int res=0;
        boolean[][] book=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                res=Math.max(res,dfs(i,j,book,grid));
            }
        }
        return res;
    }

    private static int[] cul={-1,0,0,1};
    private static int[] row={0,-1,1,0};
    private int dfs(int i, int j, boolean[][] book, int[][] grid) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||book[i][j]||grid[i][j]==0)return 0;
        book[i][j]=true;
        int cnt=1;
        for (int k=0;k<4;k++)
        {
            cnt+=dfs(i+cul[k],j+row[k],book,grid);
        }
        return cnt;
    }

}
/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
