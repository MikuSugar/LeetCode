package JavaCode.random_records.N501_600;

public class N576_out_of_boundary_paths
{

    public static void main(String[] args)
    {
        System.out.println(new N576_out_of_boundary_paths().findPaths(3 ,2 ,5,1,1));
    }

    public int findPaths(int m, int n, int N, int i, int j) {

        int mod=1000000007;
        int[][][] dp=new int[N+1][m][n];
        for (int k=1;k<=N;k++)
        {
            for (int ii=0;ii<m;ii++)
            {
                for (int jj=0;jj<n;jj++)
                {
                    long a=ii==0?1:dp[k-1][ii-1][jj];
                    long b=jj==0?1:dp[k-1][ii][jj-1];
                    long c=ii==m-1?1:dp[k-1][ii+1][jj];
                    long d=jj==n-1?1:dp[k-1][ii][jj+1];

                    dp[k][ii][jj]=(int) ((a+b+c+d)%mod);
                }
            }
        }
        return dp[N][i][j];
    }
}
/**
 * https://leetcode-cn.com/problems/out-of-boundary-paths/
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 * 解释:
 *
 * 示例 2：
 *
 * 输入: m = 1, n = 3, N = 3, i = 0, j = 1
 * 输出: 12
 * 解释:
 *
 *
 *
 * 说明:
 *
 * 球一旦出界，就不能再被移动回网格内。
 * 网格的长度和高度在 [1,50] 的范围内。
 * N 在 [0,50] 的范围内。
 */
