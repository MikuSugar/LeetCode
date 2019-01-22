package JavaCode.top_interview_questions_medium.dp;

import java.util.Arrays;

public class CoinChange {

    //测试
    public static void main(String[] args) {
        int[] coins={186,419,83,408};
        System.out.println(new CoinChange().new Solution().coinChange(coins,84));
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            if(coins.length==0||(amount<coins[0]&&amount!=0)) return -1;
            int[] dp=new int[amount+1];
            for(int i=1;i<dp.length;i++)
            {
                dp[i]=Integer.MAX_VALUE>>1;
            }

            for(int i=1;i<=amount;i++)
            {
                for(int j=coins.length-1;j>=0;j--)
                {
                    if(coins[j]>i) continue;
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);

                }
            }
            if(dp[amount]==Integer.MAX_VALUE>>1) return -1;
            return dp[amount];
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/106/
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */