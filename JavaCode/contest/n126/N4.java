package JavaCode.contest.n126;

/**
 * 比赛期间没有做出
 * 补题
 */
public class N4
{

    public static void main(String[] args)
    {
        int[] stones={3,5,1,2,6};
        System.out.println(new N4().mergeStones(stones,3));
    }

    final static int MAX=Integer.MAX_VALUE>>1;
    public int mergeStones(int[] stones, int K)
    {
        int n=stones.length;
        int[] sum =new int[n+1];//前缀和
        int[][] dp=new int[n+1][n+1];//dp[i][j]表示第i个石头到第j个石头合并之后的花费
        int[][][] f=new int[n+1][n+1][n+1];//辅助数组，f[i][j][k]表示第i个石头到第j个石头通过k堆合并，未加上最后一次合并值之前的花费
        //初始化
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                for (int k=1;k<=n;k++)
                {
                    f[i][j][k]= MAX;
                    dp[i][j]= MAX;
                }
            }
        }
        for (int i=1;i<=n;i++)
        {
            f[i][i][1]=dp[i][i]=0;
            sum[i]=sum[i-1]+stones[i-1];
        }

        //区间DP
        for (int len=2;len<=n;len++)//区间长度
        {
            for (int l=1;l+len-1<=n;l++)//枚举起点l
            {
                int r=l+len-1;//枚举尾巴r
                for (int k=1;k<len&&k<=K;k++)//枚举分割次数
                {
                    for (int i=l;i<r;i++)//枚举分割点
                    {
                        if (k==1)
                        {
                            f[l][r][k+1]=Math.min(f[l][r][k+1],dp[l][i]+dp[i+1][r]);
                        }
                        else
                        {
                            f[l][r][k+1]=Math.min(f[l][r][k+1],f[l][i][k]+dp[i+1][r]);
                        }
                    }
                }
                if(len>=K)
                {
                    dp[l][r]=Math.min(dp[l][r],f[l][r][K]+sum[r]-sum[l-1]);
                }
                else
                {
                    dp[l][r]= MAX;
                }
            }
        }
        return dp[1][n]== MAX ?-1:dp[1][n];
    }

}
/**
 *https://leetcode-cn.com/contest/weekly-contest-126/problems/minimum-cost-to-merge-stones/
 * 1000. 合并石头的最低成本
 * 题目难度 Hard
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 * 示例 1：
 * 输入：stones = [3,2,4,1], K = 2
 * 输出：20
 * 解释：
 * 从 [3, 2, 4, 1] 开始。
 * 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
 * 合并 [4, 1]，成本为 5，剩下 [5, 5]。
 * 合并 [5, 5]，成本为 10，剩下 [10]。
 * 总成本 20，这是可能的最小值。
 * 示例 2：
 *
 * 输入：stones = [3,2,4,1], K = 3
 * 输出：-1
 * 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
 * 示例 3：
 *
 * 输入：stones = [3,5,1,2,6], K = 3
 * 输出：25
 * 解释：
 * 从 [3, 5, 1, 2, 6] 开始。
 * 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
 * 合并 [3, 8, 6]，成本为 17，剩下 [17]。
 * 总成本 25，这是可能的最小值。
 *
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 */
