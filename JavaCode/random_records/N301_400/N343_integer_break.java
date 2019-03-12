package JavaCode.random_records.N301_400;

public class N343_integer_break
{
    public int integerBreak(int n) {
        int[] dp=new int[58];
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;

        for (int i=4;i<=n;i++)
        {
            dp[i]=dp[i-1];
            for (int j=1;j<i;j++)
            {
                dp[i]=Math.max(dp[i],Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }
}
/**
 * https://leetcode-cn.com/problems/integer-break/
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
