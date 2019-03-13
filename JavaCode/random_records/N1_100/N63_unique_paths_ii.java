package JavaCode.random_records.N1_100;

public class N63_unique_paths_ii {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0||obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<dp.length;i++)
        {
            for (int j=0;j<dp[0].length;j++)
            {
                if(obstacleGrid[i][j]==1) dp[i][j]=-1;
                else if(i==0||j==0)
                {
                    if(i==0&&j==0) dp[i][j]=1;
                    else if(i==0&&dp[i][j-1]==-1) dp[i][j]=-1;
                    else if(j==0&&dp[i-1][j]==-1) dp[i][j]=-1;
                    else dp[i][j]=1;
                }
                else
                {
                    int a=dp[i-1][j];
                    int b=dp[i][j-1];
                    if(a==-1&&b==-1)dp[i][j]=-1;
                    else
                    {
                        a=a==-1?0:a;
                        b=b==-1?0:b;
                        dp[i][j]=a+b;
                    }
                }
            }
        }
        int res=dp[dp.length-1][dp[0].length-1];
        return res==-1?0:res;
    }

}
/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
