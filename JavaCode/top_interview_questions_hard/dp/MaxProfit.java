package JavaCode.top_interview_questions_hard.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {

        if(prices.length==0) return 0;

        int[] sell_dp=new int[prices.length];//第i天未持股的最大值
        int[] buy_dp=new int[prices.length];//第i天持股的最大值
        sell_dp[0]=0;
        buy_dp[0]=-prices[0];
        for (int i=1;i<prices.length;i++)
        {
            sell_dp[i]=Math.max(sell_dp[i-1],buy_dp[i-1]+prices[i]);
            buy_dp[i]=Math.max(buy_dp[i-1],(i>1?sell_dp[i-2]:0)-prices[i]);
        }
        return sell_dp[prices.length-1];
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/155/
 * Best Time to Buy and Sell Stock with Cooldown
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
