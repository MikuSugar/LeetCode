package JavaCode.top_interview_questions_hard.dp;

public class MaxCoins {
    public int maxCoins(int[] nums) {

        //为了方便计算，给🎈两头添加各添加一个数字为1的🎈，也就是help数组
        int[] help=new int[nums.length+2];
        help[0]=1;
        help[help.length-1]=1;
        System.arraycopy(nums,0,help,1,nums.length);

        int[][] dp=new int[help.length][help.length];//dp[i][j]表示第i个和第j个🎈之间（不含i和j）的🎈戳烂，最大能得到的分值。

        for (int i=2;i<help.length;i++)
        {
            for(int j=i-2;j>=0;j--)
            {
                for (int k=i-1;k>j;k--)
                {
                    dp[j][i]=Math.max(dp[j][i],dp[j][k]+help[j]*help[k]*help[i]+dp[k][i]);
                }
            }
        }
        return dp[0][help.length-1];
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/159/
 * 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
