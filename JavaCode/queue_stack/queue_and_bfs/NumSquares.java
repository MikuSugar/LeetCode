package JavaCode.queue_stack.queue_and_bfs;

public class NumSquares {

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(13));
    }

    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i]=Integer.MAX_VALUE>>1;
        }
        for(int i=1;i*i<=n;i++)
        {
            dp[i*i]=1;
        }
        //dp[i]表示i需要的最少完全平方数 dp[i+j*j]=Math.min(dp[i]+1,dp[i+j*j])
        for(int i=1;i<=n;i++)
        {
            for(int j=1;i+j*j<=n;j++)
            {
                dp[i+j*j]=Math.min(dp[i+j*j],dp[i]+1);
            }
        }
        return dp[n];
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 *   完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
