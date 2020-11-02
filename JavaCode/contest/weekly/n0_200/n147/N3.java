package JavaCode.contest.weekly.n0_200.n147;

public class N3 {
    public int largest1BorderedSquare(int[][] grid) {
        //右边有多少个连续1
        int[][] right=new int[grid.length][grid[0].length];
        //下边有多少个连续1
        int[][] down=new int[grid.length][grid[0].length];
        help(grid,right,down);
        for (int i=Math.min(grid.length,grid[0].length);i>0;i--)
        {
            if(check(i,right,down))
            {
                return i*i;
            }
        }
        return 0;
    }
    private static boolean check(int size, int[][] right, int[][] down) {
        int rows=right.length;
        int cols=right[0].length;
        for(int i=0;i<=right.length-size;i++)
        {
            for(int j=0;j<=right[0].length-size;j++)
            {
                if(right[i][j]>=size&&down[i][j]>=size&&right[i+size-1][j]>=size&&down[i][j+size-1]>=size) return true;
            }
        }
        return false;
    }

    private static void help(int[][] grid, int[][] right, int[][] down) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(grid[rows-1][cols-1] == 1)
        {
            right[rows-1][cols-1]=1;
            down[rows-1][cols-1]=1;
        }
        for(int i=rows-2;i>=0;i--)
        {
            if(grid[i][cols-1] == 1)
            {
                right[i][cols-1]=1;
                down[i][cols-1]=down[i+1][cols-1]+1;
            }
        }
        for(int j=cols-2;j>=0;j--)
        {
            if(grid[rows-1][j] == 1)
            {
                down[rows-1][j]=1;
                right[rows-1][j]=right[rows-1][j+1]+1;
            }
        }
        for(int i=rows-2;i>=0;i--)
        {
            for(int j=cols-2;j>=0;j--)
            {
                if(grid[i][j] == 1)
                {
                    right[i][j]=right[i][j+1]+1;
                    down[i][j]=down[i+1][j]+1;
                }
            }
        }
    }
}
/**
 *给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 示例 2：
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */
